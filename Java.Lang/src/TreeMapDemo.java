import java.util.*;

class TreeMapDemo {
	public static void main(String args[]) {
		// создать древовидное отображение
		TreeMap<String, Double> tm = new TreeMap<String, Double>();
		// ввести элементы в древовидное отображение
		tm.put("Джoн Доу", new Double(3434.34));
		tm.put("Toм Смит", new Double(123.22));
		tm.put("Джейн Бейкер", new Double(1378.00));
		tm.put("Toд Халл", new Double(99.22));
		tm.put("Paльф Смит", new Double(-19.08));
		// получить множество записей
		Set<Map.Entry<String, Double>> set = tm.entrySet();
		// вывести множество записей
		for (Map.Entry<String, Double> me : set) {
			System.out.print(me.getKey() + ": ");
			System.out.println(me.getValue());
		}
		System.out.println();
		// внести сумму 1000 на счет Джона Доу
		Double Ьаlапсе = tm.get("Джoн Доу");
		tm.put("Джoн Доу", Ьаlапсе + 1000);
		System.out.println("Hoвый остаток на счете Джона Доу: " + tm.get("Джoн Доу"));
	}
}