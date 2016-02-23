
//Продемонстрировать применение класса FileWriter
//В этой программе используется оператор try с ресурсами.
//Требуется установка комплекта JDK, начиная с версии 7
import java.io.*;

class FileWriterDemo {
	public static void main(String args[]) throws IOException {
		String source = "Now is the time for all good men\n" + "to соmе to the aid of their country\n"
				+ "and рау their due taxes.";
		char buffer[] = new char[source.length()];
		source.getChars(0, source.length(), buffer, 0);
		try (FileWriter f0 = new FileWriter("filel.txt");
				FileWriter fl = new FileWriter("file2.txt");
				FileWriter f2 = new FileWriter("file3.txt")) {
			// вывести символы в первый файл
			for (int i = 0; i < buffer.length; i += 2) {
				f0.write(buffer[i]);
				// вывести символы во второй файл
				fl.write(buffer);
				// вывести символы в третий файл
				f2.write(buffer, buffer.length - buffer.length / 4, buffer.length / 4);
			}
		} catch (IOException е) {
			System.out.println("Пpoизoшлa ошибка ввода-вывода");
		}
	}
}