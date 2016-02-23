import java.io.*;

public class PrintWriterDemo {

	public static void main(String[] args) {

		PrintWriter pw = new PrintWriter(System.out, true);
		pw.println("Это строка");
		int i = 11;
		double j = 4.5E-7;
		pw.println(i);
		pw.println(j);
	}

}
