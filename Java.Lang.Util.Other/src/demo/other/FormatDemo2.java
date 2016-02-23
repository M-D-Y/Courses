package demo.other;

//Продемонстрировать применение спецификаторов %f и %е
import java.io.IOException;
import java.util.*;

class FormatDemo2 {
	public static void main(String args[]) {
		Formatter fmt = new Formatter();
		for (double i = 1.23; i < 1.0e+6; i += 100){
			fmt.format("%f %e", i, i);
			try {
				fmt.out().append('\n');
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		fmt.format("Шестнадцатеричное число: %x, восьмеричное число: %o",196,196);
		try {
			fmt.out().append('\n');
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(fmt);
		fmt.close();
	}
}