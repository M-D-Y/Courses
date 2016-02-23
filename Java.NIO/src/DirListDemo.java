
//Вывести содержимое каталога. Требуется установка комплекта JDK, начиная с версии 7
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

class DirListDemo {
	public static void main(String args[]) {
		String dirName = "../Java.NIO/";
		System.out.println(new File("").getAbsolutePath());
		// получить и обработать поток ввода каталога в блоке оператора try
		try (DirectoryStream<Path> dirStrm = Files.newDirectoryStream(Paths.get(dirName), "*.{txt,classpath}")){
			System.out.println("Kaтaлoг: " + dirName);
			// Класс DirectoryStream реализует интерфейс Iterable, поэтому для
			// вывода содержимого каталога можно организовать цикл for в стиле for each
			for (Path entry : dirStrm) {
				BasicFileAttributes attribs = Files.readAttributes(entry, BasicFileAttributes.class);

				if (attribs.isDirectory())
					System.out.print("<DIR>");
				else
					System.out.print("<FILE>");

				System.out.println(entry.getFileName());
			}
		} catch (InvalidPathException e) {
			System.out.println("Oшибкa указания пути: " + e);
		} catch (NotDirectoryException е) {
			System.out.println(dirName + " не является каталогом.");
		} catch (IOException e) {
			System.out.println("Oшибкa ввода-вывода: " + e);
		}
	}
}