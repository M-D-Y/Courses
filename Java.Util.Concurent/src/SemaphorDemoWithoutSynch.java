
//Простой пример применения семафора
import java.util.concurrent.*;

class SemaphorDemoWithoutSych {
	public static void main(String args[]) {
		Semaphore sem = new Semaphore(1);
		new IncThreadNoSynch(sem, "А");
		new DecThreadNoSynch(sem, "В");
	}
}

// Общий ресурс
class SharedNoSynch {
	volatile static int count = 0;
}

// Поток исполнения, увеличивающий sначение счетчика на единицу
class IncThreadNoSynch implements Runnable {
	String name;
	Semaphore sem;

	IncThreadNoSynch(Semaphore s, String n) {
		sem = s;
		name = n;
		new Thread(this).start();
	}

	public void run() {
		System.out.println("Зaпycк потока: " + name);
		try {
			// сначала получить разрешение
			System.out.println("Пoтoк " + name + " ожидает разрешения");
		//	sem.acquire();
			System.out.println("Пoтoк " + name + " получает разрешение");
			// а теперь получить доступ к общему ресурсу
			for (int i = 0; i < 5; i++) {
				Shared.count++;
				System.out.println(name + ": " + Shared.count);
				// разрешить, если возможно, переключение контекста
				Thread.sleep(10);
			}
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}
		// освободить разрешение
		System.out.println("Пoтoк " + name + " освобождает разрешение");
		//sem.release();
	}
}

// Поток исполнения, уменьшающий значение счетчика на единицу
class DecThreadNoSynch implements Runnable {
	String name;
	Semaphore sem;

	DecThreadNoSynch(Semaphore s, String n) {
		sem = s;
		name = n;
		new Thread(this).start();
	}

	public void run() {
		System.out.println("Зaпycк потока: " + name);
		try {
			// сначала получить разрешение
			System.out.println("Пoтoк " + name + " ожидает разрешения");
			//sem.acquire();
			System.out.println("Пoтoк " + name + " получает разрешение");
			// а теперь получить доступ к общему ресурсу
			for (int i = 0; i < 5; i++) {
				Shared.count--;
				System.out.println(name + " : " + Shared.count);
				// разрешить, если возможно, переключение контекста
				Thread.sleep(10);
			}
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}
		// освободить разрешение
		System.out.println("Пoтoк " + name + " освобождает разрешение");
		//sem.release();
	}
}
