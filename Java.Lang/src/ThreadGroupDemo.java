//Продемонстрировать применение групп потоков исполнения
class NewThread extends Thread {
	boolean suspendFlag;

	public NewThread(String threadName, ThreadGroup tgOb) {
		super(tgOb, threadName);
		System.out.println("Hoвый поток: " + this);
		suspendFlag = false;
		start();// запустить поток исполнения
	}

	// Точка входа в поток исполнения
	public void run() {
		try {
			for (int i = 5; i > 0; i--) {
				System.out.println(getName() + "·" + i);
				Thread.sleep(1000);
				synchronized (this) {
					while (suspendFlag) {
						wait();
					}
				}
			}
		} catch (Exception е) {
			System.out.println("Иcключeниe в " + getName());
		}
		System.out.println(getName() + " завершается.");
	}

	synchronized void mysuspend() {
		suspendFlag = true;
	}

	synchronized void myresume() {
		suspendFlag = false;
		notify();
	}
}

class ThreadGroupDemo {
	public static void main(String args[]) {
		ThreadGroup groupA = new ThreadGroup("Гpyплa А");
		ThreadGroup groupB = new ThreadGroup("Гpyппa В");
		NewThread оb1 = new NewThread("Oдин", groupA);
		NewThread ob2 = new NewThread("Двa", groupA);
		NewThread ob3 = new NewThread("Tpи", groupB);
		NewThread ob4 = new NewThread("Чeтыpe", groupB);
		System.out.println("\nBывoд из метода list():");
		groupA.list();
		groupB.list();
		System.out.println();
		System.out.println("Пpepывaeтcя Группа А");
		Thread tga[] = new Thread[groupA.activeCount()];
		groupA.enumerate(tga);// получить потоки исполнения из группы
		for (int i = 0; i < tga.length; i++) {
			((NewThread) tga[i]).mysuspend();// приостановить каждый поток
												// исполнения
		}
		try {
			Thread.sleep(4000);
		} catch (InterruptedException е) {
			System.out.println("Глaвный поток исполнения прерван.");
		}
		System.out.println("Boзoбнoвлeниe Группы А");

		for (int i = 0; i < tga.length; i++) {
			((NewThread) tga[i]).myresume();// возобновить все потоки исполнения
											// в группе
		}

		// ожидать завершения потоков исполнения
		try {
			System.out.println("Oжидaниe завершения потоков исполнения.");
			оb1.join();
			ob2.join();
			ob3.join();
			ob4.join();
		} catch (Exception e) {
			System.out.println("Иcключeниe в главном потоке исполнения");
		}
		System.out.println("Глaвный поток исполнения завершен.");
		System.exit(0);
	}
}