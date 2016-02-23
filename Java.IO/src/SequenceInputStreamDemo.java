
//Продемонстрировать организацию последовательного ввода.
//В этой программе используется оператор try с ресурсами.
//Требуется установка комплекта JDK, начиная с версии 7
import java.io.*;
import java.util.*;

class InputStreamEnumerator implements Enumeration<FileInputStream> {
	private Enumeration<String> files;

	public InputStreamEnumerator(Vector<String> files) {
		this.files = files.elements();
	}

	public boolean hasMoreElements() {
		return files.hasMoreElements();
	}

	@Override
	public FileInputStream nextElement() {
		try {
			return new FileInputStream(files.nextElement().toString());
		} catch (IOException е) {
			return null;
		}
	}
}

class SequenceInputStreamDemo {
	public static void main(String args[]) {
		int с;
		Vector<String> files = new Vector<String>();
		files.addElement("filel.txt");
		files.addElement("file2.txt");
		files.addElement("fileЗ.txt");
		InputStreamEnumerator ise = new InputStreamEnumerator(files);
		InputStream input = new SequenceInputStream(ise);
		try {
			while ((с = input.read()) != -1)
				System.out.print((char) с);
		} catch (NullPointerException е) {
			System.out.println("Owибкa открытия файла.");
		} catch (IOException е) {
			System.out.println("Owибкa ввода-вывода: " + е);
		} finally {
			try {
				input.close();
			} catch (IOException е) {
				System.out.println("Ошибка закрытия потока ввода SequenceinputStream");
			}
		}
	}
}
