package demo.other;

//Продемонстрировать выравнивание по левому краю
import java.util.*;

class LeftJustify {
	public static void main(String args[]) {
		Formatter fmt = new Formatter();
		// выровнять по правому краю (по умолчанию)
		fmt.format("1%10.2f1", 123.123);
		System.out.println(fmt);
		fmt.close();
		// а теперь выровнять по левому краю
		fmt = new Formatter();
		fmt.format("l%-10.2fl", 123.123);
		System.out.println(fmt);
		fmt.close();

	}

}