

//Продемонстстрировать простое применение интерфейса Spliterator
import java.util.*;

class SpliteratorDemo {

	public static void main(String args[]) {
		// создать списочный массив числовых значений типа double
		ArrayList<Double> vals = new ArrayList<>();
		// ввести значения в списочный массив
		vals.add(1.0);
		vals.add(2.0);
		vals.add(3.0);
		vals.add(4.0);
		vals.add(5.0);
		// вызвать метод tryAdvance() для вывода содержимого списочного массива
		// vals
		System.out.print("Coдepжимoe списочного массива vals: ");
		Spliterator<Double> spltitr = vals.spliterator();
		while (spltitr.tryAdvance((n) -> System.out.println(n)))
			;
		System.out.println();
		// создатъ новый списочный массив, содержащий квадратные корни числовых
		// значений из списочного массива vals
		spltitr = vals.spliterator();
		ArrayList<Double> sqrs = new ArrayList<>();
		while (spltitr.tryAdvance((n) -> sqrs.add(Math.sqrt(n))))
			;
		// вызвать метод forEachReшaining() для вывода содержимого списочного массива sqrs
		System.out.print("Coдepжимoe списочного массива sqrs: ");
		spltitr = sqrs.spliterator();
		spltitr.forEachRemaining((n) -> System.out.println(n));
	}
}