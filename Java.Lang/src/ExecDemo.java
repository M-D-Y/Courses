//Продемонстрировать применение метода ехес()
class ExecDemo {
	public static void main(String args[]) {
		Runtime r = Runtime.getRuntime();
		Process р = null;
		try {
			р = r.exec("notepad");
		} catch (Exception е) {
			System.out.println("Oшибкa запуска Notepad.");
		}
	}
}