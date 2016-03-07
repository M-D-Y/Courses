
//Продемонстрировать различные форматы дат
import java.text.*;
import java.util.*;

public class DateFormatDemo {
	public static void main(String args[]) {
		Date date = new Date();
		DateFormat df;
		df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.JAPAN);
		System.out.println("Яnoния: " + df.format(date));

		df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.KOREA);
		System.out.println("Kopeя: " + df.format(date));

		df = DateFormat.getDateInstance(DateFormat.LONG, Locale.UK);
		System.out.println("Beликoбpитaния: " + df.format(date));

		df = DateFormat.getDateInstance(DateFormat.FULL, Locale.US);
		System.out.println("CШA: " + df.format(date));
	}
}