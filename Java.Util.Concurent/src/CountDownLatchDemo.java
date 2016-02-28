
//Продемонстрировать применение класса CountDownLatch
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
	public static void main(String args[]) {
		CountDownLatch cdl = new CountDownLatch(5);
		System.out.println("Зaпycк потока исполнения");
		new CountDownLatchThread(cdl);
		try {
			cdl.await();
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}
		System.out.println("Зaвepшeниe потока исполнения");
	}
}

class CountDownLatchThread implements Runnable {
	CountDownLatch latch;

	CountDownLatchThread(CountDownLatch c) {
		latch = c;
		new Thread(this).start();
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(i);
			latch.countDown(); // обратный отсчет
		}
	}
}