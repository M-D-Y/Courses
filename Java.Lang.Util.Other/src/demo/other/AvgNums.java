package demo.other;

//Использовать класс Scanner для вычисления среднего
//из списка введенных числовых значений
import java.util.*;

class AvgNums {
	public static void main(String args[]) {
		Scanner conin = new Scanner(System.in);
		int count = 0;
		double sum = 0.0;
		System.out.println("Bвeдитe числа для подсчета среднего.");
		// читать и суммировать числовые значения
		while (conin.hasNext()) {
			if (conin.hasNextDouble()) {
				sum += conin.nextDouble();
				count++;
			} else {
				String str = conin.next();
				if (str.equals("готово"))
					break;
				else {
					System.out.println("Oшибкa формата данных.");
					return;
				}
			}
		}
		conin.close();
		System.out.println("Cpeднee равно " + sum / count);
	}
}