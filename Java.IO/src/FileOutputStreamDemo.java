import java.io.FileOutputStream;

//Продемонстрировать применение класса FileOutputStream.
//В этой программе используется традиционный способ закрытия файла
import java.io.*;

class FileOutputStreamDemo {
	public static void main(String args[]) {
		String source = "Now is the time for all good men\n" + "to соmе to the aid of their country\n"
				+ "and рау their due taxes.";
		byte buf[] = source.getBytes();
		FileOutputStream f0 = null;
		FileOutputStream f1 = null;
		FileOutputStream f2 = null;

		try {
			f0 = new FileOutputStream("filel.txt");
			f1 = new FileOutputStream("file2.txt");
			f2 = new FileOutputStream("fileЗ.txt");
			// записать данные в первый файл
			for (int i = 0; i < buf.length; i += 2)
				f0.write(buf[i]);
			// записать данные во второй файл
			f1.write(buf);
			// записать данные в третий файл
			f2.write(buf, buf.length - buf.length / 4, buf.length / 4);
		} catch (IOException е) {
			System.out.println("Пpoизoшлa ошибка ввода-вывода");
		} finally {
			try {
				if (f0 != null)
					f0.close();
			} catch (IOException е) {
				System.out.println("Oшибкa закрытия файла file1.txt");
			}
			try {
				if (f1 != null)
					f1.close();
			} catch (IOException е) {
				System.out.println("Oшибкa закрытия файла file2.txt");
			}
			try {
				if (f2 != null)
					f2.close();
			} catch (IOException е) {
				System.out.println("Oшибкa закрытия файла fileЗ.txt");
			}
		}
	}
}