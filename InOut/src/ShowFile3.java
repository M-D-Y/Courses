import java.io.*;

public class ShowFile3 {

	public static void main(String[] args) throws IOException {

		
		if (args.length<2) {
			System.out.println("Наберите откуда копировать файл и куда.");
			return;
		}
		
		int i = -1;
		
		//ClassLoader cl = ShowFile.class.getClassLoader();
		//cl.
		try (FileInputStream fi = new FileInputStream(args[0]);
				FileOutputStream fo = new FileOutputStream(args[1])) {
			do {
					i = fi.read();
					if (i != -1) fo.write((char)i);
			} while (i != -1);

		} catch (FileNotFoundException e) {
			System.out.println("Ошибка ввода вывода: " + e);
			return;
		}


	}

}
