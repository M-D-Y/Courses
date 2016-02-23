
//Преобразовать списочный массив ArrayList в обычный массив
import java.util.*;

class ArrayListToArray {
	public static void main(String args[]) {
		// создать списочный массив
		ArrayList<Integer> al = new ArrayList<Integer>();
		// ввести элементы в списочный массив
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		System.out.println("Coдepжимoe списочного массива al: " + al);
		
		// получить обычный массив
		Integer ia[] = new Integer[al.size()];
		ia = al.toArray(ia);
		int sum = 0;
		
		// суммировать элементы массива
		for (int i : ia)
			sum += i;
		System.out.println("Сумма: " + sum);
	}
}