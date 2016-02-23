package demo.other;

//Использовать класс Scanner для вычисления среднего
//из списка чисел, разделяемых запятыми
import java.util.*;
import java.io.*;

class SetScanerDelimiters {
	public static void main(String args[]) throws IOException {
		int count = 0;
		double sum = 0.0;
		// вывести данные в файл
		FileWriter fout = new FileWriter("test.txt");
		// а теперь сохранить данные в списке, разделив их запятыми
		fout.write("2,3.4,5,6,7.4,9.1,10.5,готово");
		fout.close();
		FileReader fin = new FileReader("Test.txt");
		Scanner src = new Scanner(fin);
		// установить в качестве разделителей запятые и пробелы
		src.useDelimiter(",*");
		// читать и суммировать числовые значения
		while (src.hasNext()) {
			if (src.hasNextDouble()) {
				sum += src.nextDouble();
				count++;
			} else {
				String str = src.next();
				if (str.equals("готово"))
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