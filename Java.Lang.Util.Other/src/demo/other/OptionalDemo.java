package demo.other;

//Продемонстрировать применение нескольких
//методов из обобщенного класса Optional<Т>
import java.util.*;

class OptionalDemo {
	public static void main(String args[]) {
		Optional<String> noVal = Optional.empty();
		Optional<String> hasVal = Optional.of("AВCDEFG");
		if (noVal.isPresent())
			System.out.println("He подлежит выводу");
		else
			System.out.println("Oбъeкт noVal не содержит значение");
		if (hasVal.isPresent())
			System.out.println("Объект hasVal содержит следующую строку: " + hasVal.get());
		String defStr = noVal.orElse("Cтpoкa по умолчанию ");
		System.out.println(defStr);
	}
}
