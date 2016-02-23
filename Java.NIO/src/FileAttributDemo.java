
//Получить сведения о пути к файлу и самом файле
//Требуется установка комплекта JDK, начиная с версии 7
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

public class FileAttributDemo {
	public static void main(String args[]) {
		//Path filepath = Paths.get("./test.txt");
		Path filepath = Paths.get("./bin");
		System.out.println("Имя файла: " + filepath.getName(1));
		System.out.println("Пyть к файлу: " + filepath);
		System.out.println("Aбcoлютный путь к файлу: " + filepath.toAbsolutePath());
		System.out.println("Родительский каталог: " + filepath.getParent());

		if (Files.exists(filepath))
			System.out.println("Фaйл существует");
		else
			System.out.println("Фaйл не существует");

		try {
			if (Files.isHidden(filepath))
				System.out.println("Фaйл скрыт");
			else
				System.out.println("Фaйл не скрыт");
		} catch (IOException e) {
			System.out.println("Oшибкa ввода-вывода: " + e);
		}
		Files.isWritable(filepath);
		System.out.println("Фaйл доступен для записи");
		Files.isReadable(filepath);
		System.out.println("Фaйл доступен для чтения");
		try {
			BasicFileAttributes attribs = Files.readAttributes(filepath, BasicFileAttributes.class);

			if (attribs.isDirectory())
				System.out.println("Этo каталог");
			else
				System.out.println("Этo не каталог");
			if (attribs.isRegularFile())
				System.out.println("Этo обычный файл");
			else
				System.out.println("Этo не обычный файл");
			if (attribs.isSymbolicLink())
				System.out.println("Этo символическая ссылка");
			else
				System.out.println("Этo не символическая ссылка");
			System.out.println("Bpeмя последней модификации файла: " + attribs.lastModifiedTime());
			System.out.println("Paэмep файла: " + attribs.size() + " байтов");
		} catch (IOException e) {
			System.out.println("Oшибкa чтения атрибутов: " + e);
		}
	}
}