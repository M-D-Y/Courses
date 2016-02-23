

import java.util.ArrayList;

//Применение цикла for в стиле for each для перебора элементов коллекции

import java.util.*;

class ForEachDemo {
	public static void main(String args[]) {
		// Создать числовые значения в списочный массив
		ArrayList<Integer> vals = new ArrayList<Integer>();

		// ввести числовые значения в списочный массив
		vals.add(1);
		vals.add(2);
		vals.add(3);
		vals.add(4);
		vals.add(5);
		// Организовать числовые значения в цикле for
		System.out.println("Исходное содержимое спсисочного массива vals: ");
		for (int v : vals)
			System.out.println(v + " ");
		System.out.println();

		// Суммировать числовые значения в цикле for
		int sum = 0;
		for (int v : vals)
			sum += v;
		System.out.println("Сумма численного значения: " + sum);
	}
}