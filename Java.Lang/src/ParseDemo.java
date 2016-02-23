
/*Эта программа суммирует ряд целых чисел, вводимых пользователем.
Она преобразует строковое представление каждого числа в целое
значение методом parseint()
*/
import java.io.*;

class ParseDemo {
	public static void main(String args[]) throws IOException {
		// создать буферизированный поток чтения типа ВufferedReader,
		// используя стандатный лоток ввода Systeш.in
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		int i=0;
		int sum = 0;
		System.out.println("Bвeдитe число, О - для выхода.");
		do {
			str = br.readLine();
			try {
				i = Integer.parseInt(str);
			} catch (NumberFormatException е) {
				System.out.println("Heвepный формат");
				i = 0;
			}
			sum += i;
			System.out.println("Teкyщaя сумма: " + sum);
		} while (i != 0);
	}
}
