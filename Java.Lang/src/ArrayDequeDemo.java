

//Продемонстрировать применения класса ArrayDeque
import java.util.*;

class ArrayDequeDemo {
	public static void main(String args[]) {
		// создать двухстороннюю очередь
		ArrayDeque<String> adq = new ArrayDeque<String>();
		// использовать класс ArrayDeque для организации стека
		adq.push("A");
		adq.push("B");
		adq.push("D");
		adq.push("E");
		adq.push("F");
		System.out.print("Извлeчeниe из стека: ");
		while (adq.peek() != null)
			System.out.print(adq.pop() + " ");
		System.out.println();
	}
}