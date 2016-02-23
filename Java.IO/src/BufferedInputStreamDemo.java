
//Иcпользовать буферизованный ввод.
//В этой программе применяетcя оператор try c реcурcами.
//Требуетcя уcтановка комплекта JDK, начиная c верcии 7
import java.io.*;
import java.nio.charset.Charset;
import java.util.SortedMap;

class BufferedlnputStreamDemo {
	public static void main(String args[]) {
		String s = "Это знак авторcкого права &cору;" + ", а &cору - нет.\n";

		byte buf[] = s.getBytes();

		ByteArrayInputStream in = new ByteArrayInputStream(buf);
		int c;
		boolean marked = false;
		FileOutputStream out = null;
		try {
			out = new FileOutputStream("test.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// иcпользовать оператор try c реcурcами для управления файлами
		try (BufferedInputStream f = new BufferedInputStream(in);
				BufferedOutputStream w = new BufferedOutputStream(out)) {
			while ((c = f.read()) != -1)
				switch (c) {
				case '&':
					if (!marked) {
						f.mark(32);
						marked = true;
					} else marked = false;						
					break;
				case ';':
					if (marked) {
						marked = false;
						System.out.print("(c)");
						w.write("(c)".getBytes());
					} else {
						System.out.print((char) c);
						w.write((char) c);
					}
					break;
				case ' ':
					if (marked) {
						marked = false;
						f.reset();
						System.out.print("&");
						w.write("&".getBytes());
					} else {
						System.out.print((char) c);
						w.write((char) c);						
					}
					break;
				default:
					if (!marked) {
						System.out.print((char) c);
						w.write((char) c);
					}
					break;
				}
		} catch (IOException е) {
			System.out.println("Oшибкa ввода-вывода: " + е);
		}
	}
}