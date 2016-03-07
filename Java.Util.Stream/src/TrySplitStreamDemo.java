
//Продемонстрировать применение метода trySplit()
import java.util.*;
import java.util.stream.*;

class TrySplitStreamDemo {
	public static void main(String[] args) {
		// создать список символьных строк
		ArrayList<String> myList = new ArrayList<>();
		myList.add("Aльфa");
		myList.add("Бeтa");
		myList.add("Гaммa");
		myList.add("Дeльтa");
		myList.add("Kcи");
		myList.add("Омега");
		// получить поток данных для списочного массива
		Stream<String> myStream = myList.stream();
		// получить итератор-разделитель
		Spliterator<String> splitItr = myStream.spliterator();
		// а теперь разделить первый итератор
		Spliterator<String> splitItr2 = splitItr.trySplit();
		// использовать сначала итератор splitItr2, если нельзя разделить -
		// итератор splitItr
		if (splitItr2 != null) {
			System.out.println("Peзyльтaт, выводимый итератором splitItr2: ");
			splitItr2.forEachRemaining((n) -> System.out.println(n));
		}
		// а теперь воспользоваться итератором splitItr
		System.out.println("\nPeзyльтaт, выводимый итератором splitItr: ");
		splitItr.forEachRemaining((n) -> System.out.println(n));

	}
}