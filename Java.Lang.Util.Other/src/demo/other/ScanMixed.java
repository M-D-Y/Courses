package demo.other;

//Использовать класс Scanner для чтения разнотипных данных из файла
import java.util.*;
import java.io.*;

class ScanMixed {
	public static void main(String args[]) throws IOException {
		int i;
		double d;
		boolean b;
		String str;
		// вывести данные в файл
		FileWriter fout = new FileWriter("test.txt");
		fout.write("Tecтиpoвaниe Scanner 1012,2 один true два false");
		fout.close();
		FileReader fin = new FileReader("Test.txt");
		Scanner src = new Scanner(fin);
		// читать данные до конца файла
		while (src.hasNext()) {
			if (src.hasNextInt()) {
				i = src.nextInt();
				System.out.println("int: " + i);
			} else if (src.hasNextDouble()) {
				d = src.nextDouble();
				System.out.println("double: " + d);
			} else if (src.hasNextBoolean()) {
				b = src.nextBoolean();
				System.out.println("boolean: " + b);
			} else {
				str = src.next();
				System.out.println("String: " + str);

			}
		}
		src.close();
	}
}