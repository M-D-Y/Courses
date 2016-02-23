
//Применить итераторы вместе с классом HashtaЫe
import java.util.*;

class HashTableDemo2 {
	public static void main(String args[]) {
		Hashtable<String, Double> balance = new Hashtable<String, Double>();
		String str;
		double bal;
		balance.put("Джoн Доу", 3434.34);
		balance.put("Toм Смит", 123.22);
		balance.put("Джейн Бейкер", 1378.00);
		balance.put("Toд Холл", 99.22);
		balance.put("Paльф Смит", -19.08);
		// Вывести все счета в хеш-таблице. Сначала получить
		// представление всех ключей ввиде множества
		Set<String> set = balance.keySet();
		// получить итератор
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			str = itr.next();
			System.out.println(str + " : " + balance.get(str));
		}
		System.out.println();
		// внести сумму 1000 на счет Джона Доу
		bal = balance.get("Джoн Доу");
		balance.put("Джoн Доу", bal + 1000);
		System.out.println("Hoвый остаток на счете Джона Доу: " + balance.get("Джoн Доу"));
	}
}
