
//Использовать канал ввода-вывода для чтения файла.
//Требуется установка комплекта JDK, начиная с версии 7
import java.io.*;
import java.nio.*;
import java.nio.channels.*;
import java.nio.file.*;

public class ExplicitChannelRead {
	public static void main(String args[]) {

		int count;
		Path filepath = null;
		// сначала получить путь к файлу
		try {
			filepath = Paths.get("test.txt");
		} catch (InvalidPathException е) {
			System.out.println("Path Error " + е);
			return;
		}
		// затем получить канал к этому файлу в блоке оператора try с ресурсами
		try (SeekableByteChannel fChan = Files.newByteChannel(filepath)) {
			// выделить память под буфер
			ByteBuffer mВuf = ByteBuffer.allocate(128);
			do {
				// читать данные из файла в буфер
				count = fChan.read(mВuf);
				// прекратить чтение по достижении конца файла
				if (count != -1) {
					// подготовить буфер к чтению из него данных
					mВuf.rewind();
					// читать байты данных из буфера и выводить их на экран как
					// символы
					for (int i = 0; i < count; i++)
						System.out.print((char) mВuf.get());
				}
			} while (count != -1);
			System.out.println();
		} catch (IOException е) {
			System.out.println("Oшибкa ввода-вывода " + е);
		}
	}
}
