import java.io.*;

class OnlyExt implements FilenameFilter {

	private String ext;

	public OnlyExt(String ext) {
		this.ext = "." + ext;
	}

	public boolean accept(File dir, String name) {
		return name.endsWith(ext);
	}

}

// Просмотреть каталог class-файлов

class DirListOnly {
	public static void main(String args[]) {
		String dirName = "./bin";
		File fl = new File(dirName);
		FilenameFilter only = new OnlyExt("class");
		String s[] = fl.list(only);
		for (int i = 0; i < s.length; i++)
			System.out.println(s[i]);
	}
}