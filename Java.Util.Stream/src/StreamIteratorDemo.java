
//Применить итератор в потоке данных
import java.util.*;
import java.util.stream.*;

class StreamIteratorDemo {
	public static void main(String[] args) {
		// создать список символьных строк
		ArrayList<String> myList = new ArrayList<>();
		myList.add("Aльфa");
		myList.add("Бeтa");
		myList.add("Гaммa");
		myList.add("Дeльтa");
		myList.add("Kcи");
		myList.add("Oмeгa");
		// получить поток данных для списочного массива
		Stream<String> myStream = myList.stream();
		// получить итератор для потока данных
		Iterator<String> itr = myStream.iterator();
		// перебрать элементы в потоке данных
		while (itr.hasNext())
			System.out.println(itr.next());
	}
}