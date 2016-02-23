package demo.other;

//Продемонстрировать применение метода findinLine()
import java.util.*;

class FindinLineDemo {
	public static void main(String args[]) {
		String instr = "Имя: Том Boэpacт: 28 ID: 77";
		Scanner conin = new Scanner(instr);
		// найти поле возраста и вывести его содержимое
		conin.findInLine("Boэpacт:");
		if (conin.hasNext())
			System.out.println(conin.next());
		else
			System.out.println("Omибкa!");
		conin.close();
	}
}