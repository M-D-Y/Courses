
//Продемонстрировать применение некоторых методов из класса File
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

class FileDemo {
	static void p(String s) {
		System.out.println(s);
	}

	public static void main(String args[]) {
		File root = new File("");
		//System.out.println("root: " + root.getAbsolutePath());
		File fl = new File("./bin/COPYRIGHT");

		p("Имя файла: " + fl.getName());
		p("Путь: " + fl.getPath());
		p("Абсолютный путь: " + fl.getAbsolutePath());
		p("Родительский каталог: " + fl.getParent());
		p(fl.exists() ? "существует" : "не существует");
		p(fl.canWrite() ? "доступен для записи" : "недоступен для записи");
		p(fl.canRead() ? "доступен для чтения" : "недоступен для чтения");
		p(fl.isDirectory() ? "является каталогом" : "не является каталогом");
		p(fl.isFile() ? "является обычным файлом" : "может быть именованным каналом");
		p(fl.isAbsolute() ? "является абсолютным" : "не является абсолютным");
		p("Последнее изменение в файле: " + fl.lastModified());
		p("Размер: " + fl.length() + " байт");
	}

	public static void main2(String[] args) throws Exception {

		File bigdir = new File("bin").getAbsoluteFile();
		URI bigdirUri = bigdir.toURI();

		System.out.println("-> Relatives:");
		String relative;
		List<String> relatives = new ArrayList<String>();
		for (File f : bigdir.listFiles()) {

			relative = bigdirUri.relativize(f.toURI()).getPath();
			relatives.add(relative);
			System.out.println(relative);
		}

		System.out.println("\n-> Absolutes:");
		File file;
		for (String s : relatives) {

			file = new File(bigdir, s);
			System.out.println(file);
		}
	}
}