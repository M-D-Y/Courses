
class GenericFunctionalinterfaceDemo {
	public static void main(String args[]) {
		// использоватьстроковыйвариантинтерфейсаSomeFunc
		SomeFunc<String> reverse = (str) -> {
			String result = "";
			int i;
			for (i = str.length() - 1; i >= 0; i--)
				result += str.charAt(i);
			return result;
		};

		System.out.println("Лямбдa обращается на " + reverse.func("Лямбдa"));
		System.out.println("Bыpaжeниe обращается на " + reverse.func("Bыpaжeниe"));

		// атеперьиспользоватьцелочисленныйвариантинтерфейсаSomeFunc
		SomeFunc<Integer> factorial = (n) -> {
			int result = 1;
			for (int i = 1; i <= n; i++)
				result = i * result;
			return result;
		};

		System.out.println("Фaктopиaл числа 3 равен " + factorial.func(3));
		System.out.println("Фaктopиaл числа 5 равен " + factorial.func(5));
	}
}


//Применить обобщенный функциональный интерфейс
//с разнотипными лямбда-выражениями
//Обобщенный функциональный интерфейс
interface SomeFunc<T> {
	T func(T t);
}
