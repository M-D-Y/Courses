
//Использоват метод thenComparinq() для сортировки
//счетов вкладчиков сначала по фамилии, а затем по имени
import java.util.*;


// использовать метод thenComparing() для создания
// компаратора, сравнивающего сначала фамилии, а затем
// Ф.И.О. вкладчиков, если фамилии одинаковы


class TreeMapDemo2B {
	public static void main(String args[]) {
		//Компаратор, сравнивающий фамилии вкладчиков
		Comparator<String> compLN = new Comparator<String>() { 
			public int compare(String aStr, String bStr) {
				return aStr.substring(aStr.lastIndexOf(' ')).compareToIgnoreCase(bStr.substring(bStr.lastIndexOf(' ')));
				}
			};
		// отсортировать счета вкладчиков по Ф.И.О., если фамилии одинаковы
		Comparator<String> compLastThenFirst = compLN.thenComparing((aStr, bStr) -> aStr.compareToIgnoreCase(bStr));
		// создать древовидное отображение
		TreeMap<String, Double> tm = new TreeMap<String, Double>(compLastThenFirst);
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
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
		System.out.println();
		// внестисумму 1000 на счет Джона Доу
		double balance = tm.get("Джoн Доу");
		tm.put("Джон Доу", balance + 1000);
		System.out.println("Hoвый остаток на счете Джона Доу: " + tm.get("Джoн Доу"));
	}
}