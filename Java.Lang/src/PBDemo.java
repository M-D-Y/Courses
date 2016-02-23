import java.io.File;

public class PBDemo {
	public static void main(String args[]) {
		try {
			ProcessBuilder proc = new ProcessBuilder("notepad", "c:\\testfile.txt");
			proc.start();
			File f = new File("c:\\out.txt");
			ProcessBuilder.Redirect redirect = ProcessBuilder.Redirect.to(f);
		} catch (Exception е) {
			System.out.println("Oшибкa запуска Notepad.");
		}
	}
}