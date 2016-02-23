import java.util.*;

// Продемонстрировать применение комплектов ресурсов
public class ListResourceBundleDemo {
	public static void main(String args[]) {
		// загрузить комплект ресурсов по умолчанию
		ResourceBundle rd;
		Locale russianLocale = new Locale("ru", "RU");
		rd = ResourceBundle.getBundle("SampleRB", russianLocale);
		System.out.println("Русская версия программы: ");
		System.out.println("Cтpoкa по ключу Title: " + rd.getString("title"));
		System.out.println("Cтpoкa по ключу StopText: " + rd.getString("StopText"));
		System.out.println("Cтpoкa по ключу StartText: " + rd.getString("StartText"));
		// загрузить комплект ресурсов для поддержки немецкого языка
		rd = ResourceBundle.getBundle("SampleRB", Locale.GERMAN);
		System.out.println("\nHeмeцкaя версия программы: ");
		System.out.println("Cтpoкa для ключа Title: " + rd.getString("title"));
		System.out.println("Cтpoкa по ключу StopText: " + rd.getString("StopText"));
		System.out.println("Cтpoкa по ключу StartText: " + rd.getString("StartText"));
	}
}