//Ожидать завершения работы текстового редактора Notepad

public class ExecDemoFinish {
	public static void main(String args[]) {
		Runtime r = Runtime.getRuntime();
		Process p = null;
		try {
			p = r.exec("Notepad");
			p.waitFor();
		} catch (Exception е) {
			System.out.println("Oшибкa запуска Notepad.");
		}
		System.out.println("Notepad возвратил " + p.exitValue());
	}
}
