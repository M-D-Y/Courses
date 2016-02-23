package demo.other;

//Использовать класс Scanner для вычисления среднего
//из списка чисел, вводимых из файла
import java.util.*;
import java.io.*;

class AvgFile {
	public static void main(String args[]) throws IOException {
		int count = 0;
		double sum = 0.0;
		// вывести данные в файл
		FileWriter fout = new FileWriter("test.txt");
		fout.write("23.4567.49.110.5 готово");
		fout.close();
		FileReader fin = new FileReader("Test.txt");
		Scanner src = new Scanner(fin);
		// читать и суммировать числовые значения
		while (src.hasNext()) {
			if (src.hasNextDouble()) {
				sum += src.nextDouble();
				count++;
			} else {
				String str = src.next();
				if (str.equals("гoтoвo"))
					break;
				else {
					System.out.println("Oшибкa формата файла.");
					return;
				}
			}
		}
		src.close();
		System.out.println("Cpeднee равно " + sum / count);
	}
}