
//Простой пример применения семафора
import java.util.concurrent.*;

class SemaphorDemo {
	public static void main(String args[]) {
		Semaphore sem = new Semaphore(1);
		new IncThread(sem, "А");
		new DecThread(sem, "В");
	}
}

// Общий ресурс
class Shared {
	static int count = 0;
}

// Поток исполнения, увеличивающий sначение счетчика на единицу
class IncThread implements Runnable {
	String name;
	Semaphore sem;

	IncThread(Semaphore s, String n) {
		sem = s;
		name = n;
		new Thread(this).start();
	}

	public void run() {
		System.out.println("Зaпycк потока: " + name);
		try {
			// сначала получить разрешение
			System.out.println("Пoтoк " + name + " ожидает разрешения");
			sem.acquire();
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
		sem.release();
	}
}

// Поток исполнения, уменьшающий значение счетчика на единицу
class DecThread implements Runnable {
	String name;
	Semaphore sem;

	DecThread(Semaphore s, String n) {
		sem = s;
		name = n;
		new Thread(this).start();
	}

	public void run() {
		System.out.println("Зaпycк потока: " + name);
		try {
			// сначала получить разрешение
			System.out.println("Пoтoк " + name + " ожидает разрешения");
			sem.acquire();
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
		sem.release();
	}
}
