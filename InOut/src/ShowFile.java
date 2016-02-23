import java.io.*;

public class ShowFile {

	public static void main(String[] args) {
		String fileName = args[0];
		
		if (args[0].equals("")) {
			System.out.println("Нет аргументов");
			return;
		}
		
		FileInputStream fi;
		int i = -1;
		
		//ClassLoader cl = ShowFile.class.getClassLoader();
		//cl.
		try {
			fi = new FileInputStream(fileName);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Невозможно открыть файл: " + fileName);
			return;
		}
		do {
			try {
				i = fi.read();
				if (i != -1) System.out.println((char) i );
				
 			} catch (IOException e) {
				System.out.println("Ошибка чтения файла: " + fileName);
			}

		} while (i != -1);

		try {
			fi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Ошибка закрытия файла: " + fileName);
		}

	}

}
