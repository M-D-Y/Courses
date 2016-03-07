
//Продемонстрировать различные форматы времени
import java.text.*;
import java.util.*;

public class TimeFormatDemo {
	public static void main(String args[]) {
		Date date = new Date();
		DateFormat df;
		df = DateFormat.getTimeInstance(DateFormat.SHORT, Locale.JAPAN);
		System.out.println("Яnoния: " + df.format(date));

		df = DateFormat.getTimeInstance(DateFormat.LONG, Locale.UK);
		System.out.println("Benикoбpитaния: " + df.format(date));

		df = DateFormat.getTimeInstance(DateFormat.FULL, Locale.CANADA);
		System.out.println("Kaнaдa: " + df.format(date));
	}
}