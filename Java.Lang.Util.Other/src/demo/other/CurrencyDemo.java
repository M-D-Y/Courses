package demo.other;

//Продемонстрировать применение класса Currency
import java.util.*;

class CurrencyDemo {
	public static void main(String args[]) {
		Currency c;
		c = Currency.getInstance(Locale.US);
		System.out.println("Cимвoл: " + c.getSymbol());
		System.out.println("Количество цифр в дробной части числа по умолчанию: " + c.getDefaultFractionDigits());
	}
}
