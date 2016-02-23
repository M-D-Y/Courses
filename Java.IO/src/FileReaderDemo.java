
//Продемонстрировать применение класса FileReader
//В этой программе используется оператор try с ресурсами.
//Требуется установка комплекта JDK, начиная с версии 7
import java.io.*;

class FileReaderDemo {
	public static void main(String args[]) {
		try (FileReader fr = new FileReader("src/FileReaderDemo.java")) {
			int c;
			// прочитать и вывести содержимое файла
			while ((c = fr.read()) != -1)
				System.out.print((char) c);
		} catch (IOException е) {
			System.out.println("Oшибкa ввода-вывода: " + е);
		}
	}
}