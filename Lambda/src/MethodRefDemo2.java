//Продемонстрировать применение ссылки на метод экземпляра
//Функциональный интерфейс для операций с символьными строками
interface StringFunc2 {
	String func(String n);
}

// Теперь в этом классе определяется метод экземпляра strReverse()
class MyStringOps1 {

	String strReverse(String str) {
		String result = "";
		int i;
		for (i = str.length() - 1; i >= 0; i--)
			result += str.charAt(i);
		return result;
	}
}

class MethodRefDemo2 {

	// В этом методе функциональный интерфейс указывается в качестве
	// типа первого его параметра. Следовательно, ему может быть передан
	// любой экземпляр этого интерфейса, включая и ссылку на метод
	static String stringOp(StringFunc2 sf, String s) {
		return sf.func(s);
	}

	public static void main(String args[]) {

		String inStr = "Лямбда-выражения повышают эффективность Java";
		String outStr;
		// создать объект типа МyStringOps
		MyStringOps1 strOps = new MyStringOps1();
		// А теперь ссылка на метод экземпляра strReverse()
		// передается методу stringOp()
		outStr = stringOp(strOps::strReverse, inStr);
		System.out.println("Иcxoднaя строка: " + inStr);
		System.out.println("Oбpaщeннaя строка: " + outStr);
	}
}