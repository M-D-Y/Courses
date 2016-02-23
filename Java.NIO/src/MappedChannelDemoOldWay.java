
//Записать данные в сопоставленный файл. Версия до JDK7.
import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class MappedChannelDemoOldWay {

	public static void main(String args[]) {
		RandomAccessFile fOut = null;
		FileChannel fChan = null;
		ByteBuffer mBuf;
		try {
			fOut = new RandomAccessFile("MappedChannelDemoOldWay.txt", "rw");
			// получить канал к открытому файлу
			fChan = fOut.getChannel();
			// затем сопоставить файл с буфером
			mBuf = fChan.map(FileChannel.MapMode.READ_WRITE, 0, 26);
			// записать некоторое количество байтов в буфер
			for (int i = 0; i < 26; i++)
				mBuf.put((byte) ('А' + i));
		} catch (IOException е) {
			System.out.println("Oшибкa ввода-вывода: " + е);
		} finally {
			try {
				if (fChan != null)
					fChan.close();// закрыть канал
			} catch (IOException е) {
				System.out.println("Oшибкa закрытия канала.");
			}
			try {
				if (fOut != null)
					fOut.close();// закрыть файл
			} catch (IOException e) {
				System.out.println("Omибкa закрытия файла.");
			}
		}
	}
}
