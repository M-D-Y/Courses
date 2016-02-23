package demo.other;

//Продемонстрировать применение класса типа GreqorianCalendar
import java.util.*;

class GregorianCalendarDemo {
	public static void main(String args[]) {
		String months[] = { "Jan", "Feb", "Mar", "Apr", "Мау", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" };
		int year;
		// создать григорианский календарь, инициализируемый
		// текущими датой и временем с учетом региональных
		// настроек и часового пояса по умолчанию
		GregorianCalendar gcalendar = new GregorianCalendar();
		// вывести текущие время и дату
		System.out.print("Дaтa: ");
		System.out.print(months[gcalendar.get(Calendar.MONTH)]);
		System.out.print(" " + gcalendar.get(Calendar.DATE) + " ");
		System.out.println(year = gcalendar.get(Calendar.YEAR));
		System.out.print("Bpeмя: ");
		System.out.print(gcalendar.get(Calendar.HOUR) + ":");
		System.out.print(gcalendar.get(Calendar.MINUTE) + ":");
		System.out.println(gcalendar.get(Calendar.SECOND));
		// проверить, является ли текущий год високосным
		if (gcalendar.isLeapYear(year)) {
			System.out.println("Teкyщий год високосный");
		} else {
			System.out.println("Teкyщий год невисокосный");
		}
	}
}