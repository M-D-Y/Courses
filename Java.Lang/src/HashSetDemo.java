

//Продемонстрировать применение класса HashSet
import java.util.*;

class HashSetDemo {
	public static void main(String args[]) {
		// создать хеш-множество
		HashSet<String> hs = new HashSet<String>();
		// ввести элементы в хеш-множество
		hs.add("Бета");
		hs.add("Aльфa");
		hs.add("Этa");
		hs.add("Гaммa");
		hs.add("Эпсилон");
		hs.add("OМeгa");
		hs.add("Aasdasd");
		System.out.println(hs);
		System.out.println("hashCode абв " + "абв".hashCode());
		System.out.println("hashCode абвг " + "абвг".hashCode());
		System.out.println("hashCode абг " + "абг".hashCode());
	}
}
