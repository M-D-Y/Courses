
//Продемонстрировать применение класса ВyteArrayOutputStream
//В этой программе применяется оператор try с ресурсами.
//Требуется установка комплекта JDK, начиная с версии 7
import java.io.*;

class ByteArrayOutputStreamDemo {
	public static void main(String args[]) {
		ByteArrayOutputStream f = new ByteArrayOutputStream();
		String s = "Эти данные должны быть выведены в массив";
		byte buf[] = s.getBytes();
		try {
			f.write(buf);
		} catch (IOException е) {
			System.out.println("Oшибкa записи в буфер");
			return;
		}
		System.out.println("Бyфep в виде символьной строки");
		System.out.println(f.toString());
		
		System.out.println("B массив");
		byte b[] = f.toByteArray();
		for (int i = 0; i < b.length; i++)
			System.out.print((char) b[i]);
		
		System.out.println("\nB массив win2utf");
		System.out.println(win2utf(b.toString()));
		
		System.out.println("\nB поток вывода типа OutputStream()");
		// использовать оператор try с ресурсами для управления
		// потоком ввода-вывода в файл
		try (FileOutputStream f2 = new FileOutputStream("test.txt")) {
			f.writeTo(f2);
		} catch (IOException е) {
			System.out.println("Oшибкa ввода-вывода: " + е);
			return;
		}
		System.out.println("Ycтaнoвкa в исходное состояние");
		f.reset();
		for (int i = 0; i < 3; i++)
			f.write('Х');
		System.out.println(f.toString());
	}

	public static String win2utf(String s) {
		StringBuffer buff = new StringBuffer();
		int i = s.length(), j;
		for (int k = 0; k < i; k++) {
			j = s.charAt(k);
			if (j > 128)
				j += 1104;
			switch (j) {
			// CP1251 код + 66384 = код UTF-8
			case 66534: {
				j = 45;
				break;
			} // -
			case 66544: {
				j = 32;
				break;
			} // Пробел вроде
			case 66575: {
				j = 1111;
				break;
			} // ï
			case 66570: {
				j = 1108;
				break;
			} // є
			case 66554: {
				j = 1028;
				break;
			} // Є
			case 66559: {
				j = 1031;
				break;
			} // Ї
			case 66560: {
				j = 176;
				break;
			} // °
			case 1143: {
				j = 96;
				break;
			} // `
			case 66530: {
				j = 96;
				break;
			} // `
			case 66549: {
				j = 1168;
				break;
			} // Ґ
			case 66564: {
				j = 1169;
				break;
			} // ґ
			case 66568: {
				j = 1105;
				break;
			} // ё
			case 66552: {
				j = 1025;
				break;
			} // Ё
			case 66555: {
				j = 34;
				break;
			} // Открыть "
			case 66571: {
				j = 34;
				break;
			} // Закрыть "
			case 66562: {
				j = 1030;
				break;
			} // I
			case 66563: {
				j = 1110;
				break;
			} // i
			case 66545: {
				j = 1038;
				break;
			} // Ў
			case 66546: {
				j = 1118;
				break;
			} // ў
			case 66561: {
				j = 177;
				break;
			} // ±
			case 66553: {
				j = 169;
				break;
			} // (c)
			case 66558: {
				j = 174;
				break;
			} // (R)
			case 66569: {
				j = 8470;
				break;
			} // №
			}
			buff.append(String.valueOf((char) j));
		}
		return buff.toString();
	}

}