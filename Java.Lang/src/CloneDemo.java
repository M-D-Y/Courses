//Продемонстрировать применение метода clone()
class TestClone implements Cloneable {
	int a;
	double b;

	// В этом методе вызывается метод clone() из класса OЬject
	TestClone cloneTest() {
		try {
			// вызвать метод clone() из класса Object
			return (TestClone) super.clone();
		} catch (CloneNotSupportedException е) {
			System.out.println("Клoниpoвaниeневозможно.");
			return this;
		}
	}
}

class CloneDemo {

	public static void main(String args[]) {
		TestClone xl = new TestClone();
		TestClone х2;
		xl.a = 10;
		xl.b = 20.98;
		х2 = xl.cloneTest();// клонировать объект xl
		System.out.println("xl:" + xl.a + "" + xl.b);
		System.out.println("x2:" + х2.a + "" + х2.b);
	}
}
