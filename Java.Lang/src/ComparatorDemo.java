
//Использовать специальный компаратор
import java.util.*;

// Компаратор для сравнения символьных строк в обратном порядке
class MyComp implements Comparator<String> {
	public int compare(String а, String b) {
		String aStr, bStr;
		aStr = а;
		bStr = b;
		// выполнить сравнение в обратном порядке
		return bStr.compareTo(aStr);
	}
	// переопределят ьметод equals() не требуется
}




class ComparatorDemo {
	public static void main(String args[]) {
		// создать древовидное множество типа TreeSet
		TreeSet<String> ts = new TreeSet<String>(new MyComp());
		// ввести элементы в древовидное множество
		ts.add("C");
		ts.add("A");
		ts.add("B");
		ts.add("E");
		ts.add("F");
		ts.add("D");
		// вывести элементы из древовидного множества
		for (String element : ts)
			System.out.print(element + "");
		System.out.println();
	}
}