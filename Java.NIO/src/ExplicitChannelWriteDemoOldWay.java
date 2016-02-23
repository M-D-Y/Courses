
//Записать данные в файл средствами системы ввода-вывода NIO. Версия до JDK7.
import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class ExplicitChannelWriteDemoOldWay {
	public static void main(String args[]) {
		FileOutputStream fOut = null;
		FileChannel fChan = null;
		ByteBuffer mBuf;
		try {
			// сначала открыть файл для вывода данных
			fOut = new FileOutputStream("ExplicitChannelWriteDemoOldWay.txt");
			// затем получить канал к файлу для вывода данных
			fChan = fOut.getChannel();
			// создать буфер
			mBuf = ByteBuffer.allocate(26);
			// записать некоторое количество байтов в буфер
			for (int i = 0; i < 26; i++)
				mBuf.put((byte) ('A' + i));
			// подготовить буфер к записи данных
			mBuf.rewind();
			// записать данные из буфера в выходной файл
			fChan.write(mBuf);
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
			} catch (IOException е) {
				System.out.println("Oшибкa закрытия файла.");
			}
		}
	}
}
