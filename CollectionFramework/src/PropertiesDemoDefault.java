
//Использоватьсписоксвойствпоумолчанию
import java.util.*;

class PropertiesDemoDefault {
	public static void main(String args[]) {
		Properties defList = new Properties();
		defList.put("Флopидa", "Тэлесси");
		defList.put("Bиcкoнcин", "Мэдисон");
		Properties capitals = new Properties(defList);
		capitals.put("Иллинойс", "Спрингфилд");
		capitals.put("Миccypи", "Джефферсон-Сити");
		capitals.put("Вашингтон", "Олимпия");
		capitals.put("Калифорния", "Сакраменто");
		capitals.put("Индиана", "Индианаполис");
		// получить множество ключей
		Set<?> states = capitals.keySet();
		// вывести все штаты и их столицы
		for (Object name : states)
			System.out.println("Cтoлицa штата " + name + "-" + capitals.getProperty((String) name) + ".");
		System.out.println();
		// Теперь штат Флорида будет найден в списке по умолчанию
		String str = capitals.getProperty("Флopидa");
		System.out.println("Cтoлицa Флориды - " + str + ".");
	}
}