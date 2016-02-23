//Реализовать простую фабрику классов, используя ссылку на конструктор
interface MyFunction<R, T> {
	R func(T n);
}

// Простой обобщенный класс
class MyClass<T> {
	private T val;

	// Конструктор, принимающий один параметр
	MyClass(T v) {
		val = v;
	}

	// Конструктор по умолчанию.Этот конструктор в данной программе НЕ
	// используется
	MyClass() {
		val = null;
	}

	// ...
	T getVal() {
		return val;
	};
}

// Простой не обобщенный класс
class MyClass2 {
	String str;

	// Конструктор, принимающий один аргумент
	MyClass2(String s) {
		str = s;
	}

	// Конструктор поумолчанию. Этот конструктор в данной программе НЕ
	// используется
	MyClass2() {
		str = "";
	}

	// ...
	String getVal() {
		return str;
	};
}

class ConstructorRefDemo3 {
	// Фабричный метод для объектов разных классов.
	// У каждого класса должен быть свой конструктор, принимающий один параметр
	// типаT.
	// А параметр R обозначает тип создаваемого объекта
	static <R, T> R myClassFactory(MyFunction<R, T> cons, T v) {
		return cons.func(v);
	}

	public static void main(String args[]) {
		// Создать ссылку на конструктор класса МyClass.
		// В данном случае оператор new обращается к конструктору,
		// принимающему аргумент
		MyFunction<MyClass<Double>, Double> myClassCons = MyClass<Double>::new;
		// создать экземпляр типа класса МyClass, используя фабричный метод
		MyClass<Double> mc = myClassFactory(myClassCons, 100.1);
		// использовать только что созданный экземпляр класса МyClass
		System.out.println("Значение val в объектеmе равно " + mc.getVal());
		// А теперь создать экземпляр другого класса,
		// используя метод JDY ClassFactory()
		MyFunction<MyClass2, String> myClassCoпs2 = MyClass2::new;
		// создать экземпляр класса МyClass2, используя фабричный метод
		MyClass2 mc2 = myClassFactory(myClassCoпs2, "Лямбда");
		// использовать только что созданный экземпляр класса МyClass
		System.out.println("Значение str в объекте mc2 равно " + mc2.getVal());
	}
}