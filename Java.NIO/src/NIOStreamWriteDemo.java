
//Продемонстрировать потоковый вывод на основе системы NIO
//Требуется установка комплекта JDK, начиная с версии 7
import java.io.*;
import java.nio.file.*;

class NIOStreamWriteDemo {
	public static void main(String args[]) {
		// открыть файл и получить связанный с ним поток вывода
		try (OutputStream fout = new BufferedOutputStream(Files.newOutputStream(Paths.get("NIOStreamWriteDemo.txt")))) {
			// вывести в поток заданное количество байтов
			for (int i = 0; i < 26; i++)
				fout.write((byte) ('А' + i));
		} catch (InvalidPathException e) {
			System.out.println("Oшибкa указания пути: " + e);
		} catch (IOException e) {
			System.out.println("Oшибкa ввода-вывода: " + e);
		}
	}
}
