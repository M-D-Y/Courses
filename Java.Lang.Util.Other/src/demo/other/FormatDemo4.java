package demo.other;

//Продемонстрировать применение спецификатора ширины поля
import java.util.*;

class FormatDemo4 {
	public static void main(String args[]) {
		Formatter fmt = new Formatter();
		fmt.format("l%fl%nl%12fl%nl%012fl", 10.12345, 10.12345, 99.0);
		System.out.println(fmt);
		fmt.close();
	}
}