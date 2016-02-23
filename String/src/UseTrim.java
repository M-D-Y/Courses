
//Использоватьметодtri.JI()дляобработкикоманд,
//вводимыхпользователем
import java.io.*;

class UseTrim {
	public static void main(String args[]) throws IOException {
		// создать буферизированный поток чтения типа BufferedReader,
		// используя стандатный поток ввода Systea.in
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		System.out.println("Bвeдитe 'стоп' для завершения.");
		System.out.println("Bвeдитe название штата:");
		do {
			str = br.readLine();
			str = str.trim();// удалитьпробелы
			if (str.equals("Иллинойс"))
				System.out.println("Cтoлицa-Спрингфилд.");
			else if (str.equals("Миссури"))
				System.out.println("Cтoлицa-Джефферсон-сити.");
			else if (str.equals("Калифорния"))
				System.out.println("Cтoлицa-Сакраменто.");
			else if (str.equals("Вашингтон"))
				System.out.println("Cтoлицa-Олимпия.");
		} while (!str.equals("стоп"));
	}
}