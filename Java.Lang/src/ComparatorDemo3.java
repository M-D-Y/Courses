
//Использовать специальный компаратор
import java.util.*;

// Компаратор для сравнения символьных строк в обратном порядке
class MyAnotherComp implements Comparator<String> {
	public int compare(String aStr, String bStr) {
		return aStr.compareTo(bStr);
	}
	// переопределятьметодequals()нетребуется
}

class ComparatorDemo3 {
	public static void main(String args[]) {
		// создать древовидное множество типа TreeSet
		MyAnotherComp mac=new MyAnotherComp();//создатькомпаратор
		//передать вариант компаратора типа МуСоmр с обратным
		//упорядочением древовидному множеству типа TreeSet
		TreeSet<String> ts = new TreeSet<String>(mac.reversed());
		// ввести элементы в древовидное множество
		ts.add("C");
		ts.add("A");
		ts.add("B");
		ts.add("E");
		ts.add("F");
		ts.add("D");
		// вывести элементы из древовидного множества
		for (String element : ts)
			System.out.print(element + " ");
		System.out.println();
	}
}