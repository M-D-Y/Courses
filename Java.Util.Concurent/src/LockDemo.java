
//Простой пример блокировки
import java.util.concurrent.locks.*;

public class LockDemo {
	public static void main(String args[]) {
		ReentrantLock lock = new ReentrantLock();
		new LockThread(lock, "А");
		new LockThread(lock, "В");
	}

}

// Общий ресурс
class SharedForLockDemo {
	static int count = 0;

}

// Поток исполнения, инкрементирующий значение счетчика
class LockThread implements Runnable {
	String name;
	ReentrantLock lock;

	LockThread(ReentrantLock lk, String n) {
		lock = lk;
		name = n;
		new Thread(this).start();
	}

	public void run() {
		System.out.println("Зaпycк потока " + name);
		try {
			// сначала заблокировать счетчик
			System.out.println("Поток " + name + " ожидает блокировки счетчика");
			lock.lock();
			System.out.println("Пoтoк " + name + " блокирует счетчик.");
			SharedForLockDemo.count++;
			System.out.println("Пoтoк " + name + " : " + SharedForLockDemo.count);
			// а теперь переключение контекста, если это возможно
			System.out.println("Пoтoк " + name + " ожидает");
			Thread.sleep(1000);
		} catch (InterruptedException exc) {
			System.out.println(exc);
		} finally {
			// снять блокировку
			System.out.println("Поток " + name + " разблокирует счетчик");
			lock.unlock();
		}
	}
}