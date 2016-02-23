
//Продемонстрировать применение класса CharArrayReader
//В этой программе используется оператор try с ресурсами.
//Требуется установка комплекта JDK, начиная с версии 7
import java.io.*;

public class CharArrayReaderDemo {
	public static void main(String args[]) {
		String tmp = "abcdefghijklrnnopqrstuvwxyz";
		int length = tmp.length();
		char c[] = new char[length];
		tmp.getChars(0, length, c, 0);
		int i;
		try (CharArrayReader inputl = new CharArrayReader(c)) {
			System.out.println("inputl: ");
			while ((i = inputl.read()) != -1)
				System.out.print((char) i);

			System.out.println();
		} catch (IOException е) {
			System.out.println("Oшибкa ввода-вывода: " + е);
		}
		try (CharArrayReader input2 = new CharArrayReader(c, 0, 5)) {
			System.out.println("input2: ");
			while ((i = input2.read()) != -1)
				System.out.print((char) i);

			System.out.println();
		} catch (IOException e) {
			System.out.println("Oшибкa ввода-вывода: " + e);
		}
	}

}
