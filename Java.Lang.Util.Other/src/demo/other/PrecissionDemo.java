package demo.other;

//Продемонстрировать/применение/спецификатора/точности
import java.util.*;

class PrecisionDemo {
	public static void main(String args[]) {
		Formatter fmt = new Formatter();
		// Формат с четырьмя цифрами после десятичной точки
		fmt.format("%.4f", 123.1234567);
		System.out.println(fmt);
		fmt.close();
		// Формат с двумяцифрами после десятичной точки
		// в поле из 16 символов
		fmt = new Formatter();
		fmt.format("%16.2e", 123.1234567);
		System.out.println(fmt);
		fmt.close();
		// вывести максимум 15 символов из строки
		fmt = new Formatter();
		fmt.format("%.15s", "Форматировать в Java теперь очень просто.");
		System.out.println(fmt);
		fmt.close();
	}
}