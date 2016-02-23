
//Использовать каналы для чтения данных из файла.
//Версия до JDK7
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class ExplicitChaппelReadDemoOldWay {

	public static void main(String args[]) {
		FileInputStream fIn = null;
		FileChannel fChan = null;
		ByteBuffer mBuf;
		int count;
		try {
			// сначала открыть файл для ввода
			fIn = new FileInputStream("test.txt");
			// затем получить канал к этому файлу
			fChan = fIn.getChannel();
			// выделить оперативную память под буфер
			mBuf = ByteBuffer.allocate(128);
			do {
				// читать данные в буфер
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
		} catch (IOException e) {
			System.out.println("Oшибкa ввода-вывода: " + e);
		} finally {
			try {
				if (fChan != null)
					fChan.close();// закрыть канал
			} catch (IOException e) {
				System.out.println("Oшибкa закрытия канала.");
			}

			try {
				if (fIn != null)
					fIn.close();// закрытьфайл
			} catch (IOException e) {
				System.out.println("Oшибкa закрытия файла.");
			}
		}
	}
}