
//Простой пример применения метода WalkPileTree() для вывода дерева каталогов.
//Требуется установка комплекта JDK, начиная с версии 7
import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.*;

//создать специальную версию класса SimpleFileVisitor, в которой переопределяется метод visitFile()
class MyFileVisitor extends SimpleFileVisitor<Path> {
	public FileVisitResult visitFile(Path path, BasicFileAttributes attribs) throws IOException {
		System.out.println(path);
		return FileVisitResult.CONTINUE;
	};
}

class DirTreeListDemo {
	public static void main(String args[]) {
		String dirname = "../Java.NIO";
		System.out.println("Дepeвo каталогов, начиная с каталога " + dirname + ":\n");
		try {
			Files.walkFileTree(Paths.get(dirname), new MyFileVisitor());
		} catch (IOException exc) {
			System.out.println("Oшибкa ввода-вывода: " + exc);
		}
		;
	}
}
