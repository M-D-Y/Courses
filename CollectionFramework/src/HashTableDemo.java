
//ПродемонстрироватьпримененияклассаHashtaЫe
import java.util.*;

class HashTableDemo {
	public static void maiп(String args[]) {
		Hashtable<String, Double> balance = new Hashtable<String, Double>();
		Enumeration<String> names;
		String str;
		double bal;
		balance.put("Джoн Доу", 3434.34);
		balance.put("Toм Смит", 123.22);
		balance.put("Джейн Бейкер", 1378.00);
		balance.put("Toд Холл", 99.22);
		balance.put("Paльф Смит", -19.08);
		// показать все счета в хеш-таблице
		names = balance.keys();
		while (names.hasMoreElements()) {
			str = names.nextElement();
			System.out.println(str + "·" + balance.get(str));
		}
		System.out.println();
		// внести сумму 1000 на счет ДжонаДоу
		bal = balance.get("Джoн Доу");
		balance.put("Джoн Доу", bal + 1000);
		System.out.println("Hoвый остаток на счете Джона Доу: " + balance.get("Джoн Доу"));
	}
}