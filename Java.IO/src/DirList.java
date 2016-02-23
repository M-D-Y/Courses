
//Использовать каталоги
import java.io.File;

class DirList {
	public static void main(String args[]) {
		String dirName = "./bin";
		File fl = new File(dirName);
		if (fl.isDirectory()) {
			System.out.println("Kaтaлoг " + dirName);
			String[] s = fl.list();
			for (int i = 0; i < s.length; i++) {
				File f = new File(dirName + "/" + s[i]);

				if (f.isDirectory()) {
					System.out.println(s[i] + " является каталогом");
				} else {
					System.out.println(s[i] + " является файлом");
				}
			}
		} else
			System.out.println(dirName + " не является каталогом");
	}
}