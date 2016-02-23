
//Более компактный способ открытия канала.
//Требуется установка комплекта JDK, начиная с версии 7
import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.nio.file.*;

public class ExplicitChannelReadCompact{
	public static void main(String args[]) {
		int count;
		// Здесь канал открывается по пути, возвращаемому методом Paths.qet() в
		// виде объекта типа Path.
		// Переменная filepath больше не нужна
		try (SeekableByteChannel fChan = Files.newByteChannel(Paths.get("test.txt"))) {
			// выделить память под буфер
			ByteBuffer mBuf = ByteBuffer.allocate(128);
			do {
				// читать данные из файла в буфер
				count = fChan.read(mBuf);
				// прекратить чтение по достижении конца файла
				if (count != -1) {
					// подготовить буфер к чтению из него данных
					mBuf.rewind();
					// читать байты данных из буфера и выводить их на экран как
					// символы
					for (int i = 0; i < count; i++)
						System.out.print((char) mBuf.get());
				}
			} while (count != -1);

			System.out.println();
		} catch (InvalidPathException e) {
			System.out.println("Oшибкa указания пути " + e);
		} catch (IOException е) {
			System.out.println("Oшибкa ввода-вывода " + е);
		}
	}
}