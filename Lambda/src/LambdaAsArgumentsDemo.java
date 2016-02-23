//Передать лямбда-выражение в качестве аргумента методу
interface StringFunc {
	String func(String n);
}

class LamЬdasAsArgumentsDemo {

	// Первый nараметр этого метода имеет тиn функционального
	// интерфейса. Следовательно, ему можно nередать ссылку на
	// любой экземnляр этого интерфейса, включая экземnляр,
	// создаваемый в лямбда-выражении. А второй nараметр
	// обозначает обрабатываемую символьную строку
	static String stringOp(StringFunc sf, String s) {
		return sf.func(s);
	}

	public static void main(String args[]) {
		String inStr = "Лямбда-выражения повышают эффективность Java";
		String outStr;
		System.out.println("Этo исходная строка: " + inStr);
		// Ниже nриведено nростое лямбда-выражение, nреобразующее
		// вверхний регистр букв все символы исходной строки,
		// nередаваемой методу stringOp()
		outStr = stringOp((str) -> str.toUpperCase(), inStr);
		System.out.println("Этo строка в верхнем регистре: " + outStr);
		// А здесь nередается блочное лямбда-выражение, удаляющее
		// nробелы из исходной символьной строки
		outStr = stringOp((str) -> {
			String result = "";
			int i;
			for (i = 0; i < str.length(); i++)
				if (str.charAt(i) != ' ')
					result += str.charAt(i);
			return result;

		} , inStr);
		System.out.println("Этo строка с удаленными пробелами:" + outStr);
		// Конечно, можно передать и экземnляр интерфейса StringFunc,
		// созданный в предыдущем лямбда-выражении. Например, после
		// следующего объявления ссылка reverse делается на экземnляр
		// интерфейсаStringFunc
		StringFunc reverse = (str) -> {
			String result = "";
			int i;
			for (i = str.length() - 1; i >= 0; i--)
				result += str.charAt(i);
			return result;
		};

		// А теnерь ссылку reverse можно nередать в качестве nервого
		// nараметра методу stringOp()
		// since it refers to а StringFunc object.
		System.out.println("Этo обращенная строка: " + stringOp(reverse, inStr));

	};

}
