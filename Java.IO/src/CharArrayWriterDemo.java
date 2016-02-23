
//Продемонстрировать применение класса CharArrayWriter
//в этой программе используется оператор try с ресурсами.
//Требуется установка комплекта JDK, начиная с версии 7
import java.io.*;

class CharArrayWriterDemo {
	public static void main(String args[]) throws IOException {
		CharArrayWriter f = new CharArrayWriter();
		String s = "Эти данные должны быть выведены в массив";
		char buf[] = new char[s.length()];
		s.getChars(0, s.length(), buf, 0);
		try {
			f.write(buf);
		} catch (IOException е) {
			System.out.println("Oшибкa записи в буфер");
			return;
		}
		System.out.println("Бyфep в виде символьной строки");
		System.out.println(f.toString());
		System.out.println("B массив");
		char c[] = f.toCharArray();
		for (int i = 0; i < c.length; i++)
			System.out.print(c[i]);
		System.out.println("\nB поток вывода типа FileWriter()");

		// использовать оператор try с ресурсами для управления
		// потоком ввода-вывода в файл
		try (FileWriter f2 = new FileWriter("test.txt")) {
			f.writeTo(f2);
		} catch (IOException e) {
			System.out.println("Oшибкa ввода-вывода: " + e);
		}
		System.out.println("Ycтaнoвкa в исходное состояние");
		f.reset();
		for (int i = 0; i < 3; i++)
			f.write('Х');
		System.out.println(f.toString());
	}

}