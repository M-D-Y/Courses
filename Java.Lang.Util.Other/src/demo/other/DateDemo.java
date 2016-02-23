package demo.other;

//Вывести дату и время, используя только методы из класса Date
import java.util.Date;

class DateDemo {
	public static void main(String args[]) {
		// создать объект типа Date
		Date date = new Date();
		// вывести дату и время методом toString()
		System.out.println(date);
		// вывести количество миллисекунд, прошедших с 1 января 1970 г. по Гринвичу
		long msec = date.getTime();
		System.out.println("Koличecтвo миллисекунд, прошедших с 1января 1970 г. по Гринвичу = " + msec);
	}
}