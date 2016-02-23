package demo.other;

//Продемонстрировать применение класса Calendar
import java.util.Calendar;

class CalendarDemo {
	public static void main(String args[]) {
		String months[] = { "Jan", "Feb", "Mar", "Apr", "Мау", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		// создать календарь, инициализируемый
		// текущими датой и временем с учетом региональных
		// настроек и часового пояса по умолчанию
		Calendar calendar = Calendar.getInstance();
		// вывести текущие дату и время
		System.out.print("Дaтa: ");
		System.out.print(months[calendar.get(Calendar.MONTH)]);
		System.out.print(" " + calendar.get(Calendar.DATE) + " ");
		System.out.println(calendar.get(Calendar.YEAR));
		System.out.print("Bpeмя: ");
		System.out.print(calendar.get(Calendar.HOUR) + ":");
		System.out.print(calendar.get(Calendar.MINUTE) + ":");
		System.out.println(calendar.get(Calendar.SECOND));
		// установить дату и время и вывести их
		calendar.set(Calendar.HOUR, 10);
		calendar.set(Calendar.MINUTE, 29);
		calendar.set(Calendar.SECOND, 22);
		System.out.print("Измeнeннoe время: ");
		System.out.print(calendar.get(Calendar.HOUR) + ":");
		System.out.print(calendar.get(Calendar.MINUTE) + ":");
		System.out.println(calendar.get(Calendar.SECOND));
	}
}