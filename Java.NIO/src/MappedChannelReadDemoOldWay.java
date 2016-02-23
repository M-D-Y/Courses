
//Использовать сопоставление для чтения данных из файла. Версия до JDK7
import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class MappedChannelReadDemoOldWay {
	public static void main(String args[]) {
		FileInputStream fIn = null;
		FileChannel fChan = null;
		long fSize;
		MappedByteBuffer mBuf;
		try {
			// сначала открыть файл для ввода
			fIn = new FileInputStream("test.txt");
			// затем получить канал к этому файлу
			fChan = fIn.getChannel();
			// получить размер файла
			fSize = fChan.size();
			// а теперь сопоставить файл с буфером
			mBuf = fChan.map(FileChannel.MapMode.READ_ONLY, 0, fSize);
			// читать байты из буфера и выводить их на экран
			for (int i = 0; i < fSize; i++)
				System.out.print((char) mBuf.get());
		} catch (IOException е) {
			System.out.println("Oшибкa ввода-вывода " + е);
		} finally {
			try {
				if (fChan != null)
					fChan.close(); // закрыть канал
			} catch (IOException е) {
				System.out.println("Oшибкa закрытия канала.");
			}
			try {
				if (fIn != null)
					fIn.close();// закрыть файл
			} catch (IOException е) {
				System.out.println("Ошибка закрытия файла.");
			}
		}
	}
}