package demo.other;

//Продемонстрировать применение пробела в качестве спецификатора формата
import java.util.*;

class FormatDemoS {
	public static void main(String args[]) {
		Formatter fmt = new Formatter();
		fmt.format("%d", -100);
		System.out.println(fmt);
		fmt.close();
		fmt = new Formatter();
		fmt.format("%d", 100);
		System.out.println(fmt);
		fmt.close();
		fmt = new Formatter();
		fmt.format("%d", -200);
		System.out.println(fmt);
		fmt.close();
		fmt = new Formatter();
		fmt.format("%d", 200);
		System.out.println(fmt);
		fmt.format("%,.2f", 4356783497.34);
		System.out.println(fmt);
		fmt.close();
	}
}