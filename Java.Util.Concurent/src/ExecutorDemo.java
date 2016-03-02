
//Простой пример применения исполнителя
import java.util.concurrent.*;

public class ExecutorDemo {
	public static void main(String args[]) {
		CountDownLatch cdl = new CountDownLatch(5);
		CountDownLatch cdl2 = new CountDownLatch(5);
		CountDownLatch cdl3 = new CountDownLatch(5);
		CountDownLatch cdl4 = new CountDownLatch(5);
		ExecutorService es = Executors.newFixedThreadPool(2);
		System.out.println("Зaпycк потоков");
		// запустить потоки исполнения
		es.execute(new ExecutorDemoThread(cdl, "А"));
		es.execute(new ExecutorDemoThread(cdl2, "В"));
		es.execute(new ExecutorDemoThread(cdl3, "С"));
		es.execute(new ExecutorDemoThread(cdl4, "D"));
		try {
			cdl.await();
			cdl2.await();
			cdl3.await();
			cdl4.await();
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}
		//es.shutdown();
		System.out.println("Зaвepшeниe потоков");
	}
}

class ExecutorDemoThread implements Runnable {
	String name;
	CountDownLatch latch;

	ExecutorDemoThread(CountDownLatch с, String n) {
		latch = с;
		name = n;
		new Thread(this);
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + "·" + i);
			latch.countDown();
		}
	}
}
