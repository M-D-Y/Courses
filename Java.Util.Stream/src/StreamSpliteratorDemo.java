
//Применить итератор-разделитель в потоке данных
import java.util.*;
import java.util.stream.*;

class StreamSpliteratorDemo {
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
		// получить итератор-разделитель
		Spliterator<String> splitItr = myStream.spliterator();
		// перебрать элементы в потоке данных
		while (splitItr.tryAdvance((n) -> System.out.println(n)));
		
		// получить новый поток данных после предыдущего перебора
		System.out.println("\nДругим способом:");
		myStream = myList.stream();
		splitItr = myStream.spliterator();
		splitItr.forEachRemaining((n) -> System.out.println(n));
	}
}