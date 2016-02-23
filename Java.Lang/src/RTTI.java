//Продемонстрировать получение сведений о типе
//объекта во время выполнения
class Х {
	int а;
	float Ь;
}

class У extends Х {
	double с;
}

class RТTI {
	public static void main(String args[]) {
		Х x = new Х();
		У y = new У();
		Class<?> clObj;
		clObj = x.getClass();// получить ссылку на объект типа Class
		System.out.println("x - объект типа: " + clObj.getName());
		clObj = y.getClass();// получить ссылку на объект типа Class
		System.out.println("y - объект типа: " + clObj.getName());
		clObj = clObj.getSuperclass();
		System.out.println("Cyпep клacc объекта у: " + clObj.getName());
	}
}