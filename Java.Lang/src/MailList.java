
//Простой пример обработки списка почтовых адресов
import java.util.*;

class Address {
	private String name;
	private String street;
	private String city;
	private String state;
	private String code;

	Address(String n, String s, String с, String st, String cd) {
		name = n;
		street = s;
		city = с;
		state = st;
		code = cd;
	}

	public String toString() {
		return name + "\n" + street + "\n" + city + " " + state + " " + code;
	}
}

class MailList {
	public static void main(String args[]) {
		LinkedList<Address> ml = new LinkedList<Address>();
		// ввести элементы в связный список
		ml.add(new Address("J. W. West", "11 Oak Ave", "Urbana", "IL", "б1801"));
		ml.add(new Address("Ralph Baker", "1142 Maple Lane", "Mahomet", "IL", "61853"));
		ml.add(new Address("Tom Carlton", "867 Elm St", "Champaign", "IL", "61820"));
		// вывести список почтовых адресов
		for (Address element : ml)
			System.out.println(element + "\n");
		System.out.println();
	}
}
