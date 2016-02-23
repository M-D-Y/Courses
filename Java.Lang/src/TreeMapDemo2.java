
//использовать компаратор для сортировки счетов
//по фамилиям вкладчиков
import java.util.*;

//сравнить последние слова в обеих символьных строках
class TComp implements Comparator<String> {
	public int compare(String aStr, String bStr) {
		int i, j, k;
		// найти индекс символа, с которого начинается фамилия
		i = aStr.lastIndexOf(' ');
		j = bStr.lastIndexOf(' ');
		k = aStr.substring(i).compareTo(bStr.substring(j));
		if (k == 0) // Фамилии совпадают, проверить имя и фамилию полностью
			return aStr.compareTo(bStr);
		else
			return k;
	}
	// переопределять метод equals() не требуется
}

class TreeMapDemo2 {
	public static void main(String args[]) {
		// переопределять метод equals() не требуется
		// создать древовидное отображение
		TreeMap<String, Double> tm = new TreeMap<String, Double>(new TComp());
		// ввести элементы в древовидное отображение
		tm.put("Джoн Доу", new Double(3434.34));
		tm.put("Toм Смит", new Double(123.22));
		tm.put("Джейн Бейкер", new Double(1378.00));
		tm.put("Toд Халл", new Double(99.22));
		tm.put("Paльф Смит", new Double(-19.08));

		// получить множество элементов
		Set<Map.Entry<String, Double>> set = tm.entrySet();

		// вывести элементы из множества
		for (Map.Entry<String, Double> me : set) {
			System.out.print(me.getKey() + ":");
			System.out.println(me.getValue());
		}
		System.out.println();
		// внести сумму 1000 на счет Джона Доу
		double balance = tm.get("Джoн Доу");
		tm.put("Джoн Доу", balance + 1000);
		System.out.println("Hoвый остаток на счете Джона Доу: " + tm.get("Джoн Доу"));
	}
}