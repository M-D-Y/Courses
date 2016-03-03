
//Простой пример выполнения атомарных операций
import java.util.concurrent.atomic.*;

public class AtomicDemo {
	public static void main(String args[]) {
		new AtomThread("A");
		new AtomThread("B");
		new AtomThread("C");
	}
}

class SharedForAtomicDemo {
	static AtomicInteger ai = new AtomicInteger(0);
}

// Поток исполнения, в котором инкрементируется значение счетчика
class AtomThread implements Runnable {
	String name;

	AtomThread(String n) {
		name = n;
		new Thread(this).start();
	}

	public void run() {
		System.out.println("Зanycк потока " + name);
		for (int i = 1; i <= 3; i++)
			System.out.println("Пoтoк " + name + " получено:" + SharedForAtomicDemo.ai.getAndSet(i));
	}
}