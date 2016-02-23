//Продемонстрировать применение метода join(),
//определенного в классе Strinq

public class StringJoin {

	public static void main(String args[]) {
		String result = String.join(" ", "Alpha", "Beta", "Gamma");
		System.out.println(result);
		result = String.join(", ", "John", "ID#:569", "E-mail:John@HerbSchildt.сот");
		System.out.println(result);
	}
}