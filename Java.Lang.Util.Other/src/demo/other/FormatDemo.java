package demo.other;

//Очень простой пример применения класса ForMatter
import java.util.*;

class FormatDemo {
	public static void main(String args[]) {
		Formatter fmt = new Formatter();
		fmt.format("Форматировать %s nросто %d %f", "средствами Java", 10, 98.6);
		System.out.println(fmt);
		fmt.close();
	}
}