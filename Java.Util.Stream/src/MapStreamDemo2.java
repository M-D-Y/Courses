
//Применить метод map() для создания нового потока данных,
//содержащего только избранные элементы из исходного потока
import java.util.*;
import java.util.stream.*;

class MapStreamDemo2 {
	public static void main(String[] args) {
		// Список имен, номеров телефонов и адресов электронной почты
		ArrayList<NamePhoneEmail> myList = new ArrayList<>();
		myList.add(new NamePhoneEmail("Лappи", "555-5555", "Larry@HerbSchildt.com"));
		myList.add(new NamePhoneEmail("Джeймc", "555-4444", "James@HerbSchildt.com"));
		myList.add(new NamePhoneEmail("Джeймc", "333-4444", "James@HerbSchildt.org"));
		myList.add(new NamePhoneEmail("Mэpи", "555-3333", "Mary@HerbSchildt.com"));
		System.out.println("Иcxoдныe элементы из списка myList: ");
		myList.stream().forEach((a) -> {
			System.out.println(a.name + " " + a.phonenum + " " + a.email);
		});
		System.out.println();

		// отобразить на новый поток данных
		// только имена и номера телефонов
		Stream<NamePhone> nameAndPhone = myList.stream().map((a) -> new NamePhone(a.name, a.phonenum));
		System.out.println("Cпиcoк имен и номеров телефонов: ");
		nameAndPhone.forEach((a) -> {
			System.out.println(a.name + " " + a.phonenum);
		});

		// Отфильтровать по имени Джeймc
		System.out.println("Cпиcoк номеров телефонов с именем Джeймc: ");
		Stream<NamePhone> nameAndPhoneFiltered = myList.stream().filter((a) -> a.name.equals("Джeймc"))
				.map((a) -> new NamePhone(a.name, a.phonenum));
		nameAndPhoneFiltered.forEach((a) -> {
			System.out.println(a.name + " " + a.phonenum);
		});
	}
}