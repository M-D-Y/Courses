//Переопределить метод clone()
class TestClone1 implements Cloneable {
	int a;
	double b;

	// метод clone() переопределяется теперь как public
	public Object clone() {
		try {
			// вызвать метод clone() из класса OЬject
			return super.clone();
		} catch (CloneNotSupportedException е) {
			System.out.println("Клoниpoвaниe невозможно.");
			return this;
		}
	}
}

class CloneDemo2 {
	public static void main(String args[]) {
		TestClone1 x1 = new TestClone1();
		TestClone1 х2;
		x1.a = 10;
		x1.b = 20.98;
		// здесь метод clone() вызывается непосредственно
		х2 = (TestClone1) x1.clone();
		System.out.println("xl: " + x1.a + "  " + x1.b);
		System.out.println("x2:" + х2.a + " " + х2.b);
	}
}