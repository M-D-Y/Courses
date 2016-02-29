
//Пример применения класса Phaser
import java.util.concurrent.Phaser;

public class PhaserDemo {
	public static void main(String args[]) {
		Phaser phsr = new Phaser(1);
		int curPhase;

		System.out.println("запуск потоков");

		new PhaserThread(phsr, "А");
		new PhaserThread(phsr, "В");
		new PhaserThread(phsr, "С");
		// ожидать завершения всеми потоками исполнения первой фазы
		curPhase = phsr.getPhase();
		phsr.arriveAndAwaitAdvance();
		System.out.println("Фaзa " + curPhase + " завершена");
		// ожидать завершения всеми потоками исполнения второй фазы
		curPhase = phsr.getPhase();
		phsr.arriveAndAwaitAdvance();
		System.out.println("Фaзa " + curPhase + " завершена");
		curPhase = phsr.getPhase();
		phsr.arriveAndAwaitAdvance();
		System.out.println("Фaзa " + curPhase + " завершена");
		// снять основной поток исполнения с регистрации
		phsr.arriveAndDeregister();
		if (phsr.isTerminated())
			System.out.println("Cинxpoнизaтop фаз завершен");
		// Поток исполнения, использующий синхронизатор фаз типа Phaser
	}
}

class PhaserThread implements Runnable {
	Phaser phsr;
	String name;

	PhaserThread(Phaser р, String n) {
		phsr = р;
		name = n;
		phsr.register();
		new Thread(this).start();
	}

	public void run() {
		System.out.println("Пoтoк " + name + " начинает первую фазу");
		phsr.arriveAndAwaitAdvance(); // известить о достижении фазы
		// Небольшая пауза, чтобы не нарушить порядок вывода.
		// Только для иллюстрации, но необязательно для правильного
		// функционирования синхронизатора фаз
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		System.out.println("Пoтoк " + name + " начинает вторую фазу");
		phsr.arriveAndAwaitAdvance(); // известить о достижении фазы
		// Небольшая пауза, чтобы не нарушить порядок вывода.
		// Только для иллюстрации, но необязательно для правильного
		// функционирования синхронизатора фаз
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			System.out.println(e);
		}
		System.out.println("Пoтoк " + name + " начинает третью фазу");
		phsr.arriveAndDeregister();// известить о достижении фазы и
		// снять потоки с регистрации
	}
}