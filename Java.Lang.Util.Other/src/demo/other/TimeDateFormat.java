package demo.other;

//Форматирование времени и даты
import java.util.*;

class TimeDateFormat {
	public static void main(String args[]) {

		Formatter fmt = new Formatter();

		Calendar cal = Calendar.getInstance();
		// вывести время в стандартном 12-часовом формате
		fmt.format("%tr", cal);
		System.out.println(fmt);
		// вывести все сведения о дате и времени
		fmt = new Formatter();
		fmt.format("%tc", cal);
		System.out.println(fmt);
		// вывести только часы и минуты
		fmt = new Formatter();
		fmt.format("%tl:%tM", cal, cal);
		System.out.println(fmt);
		// вывести название и номер месяца
		fmt = new Formatter();
		fmt.format("%tB %tb %tm", cal, cal, cal);
		System.out.println(fmt);
		fmt.close();
	}
}