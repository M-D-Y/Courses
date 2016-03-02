
//Расширить класс Phaser и переопределить метод onAdvance()
//таким образом, чтобы было выполнено только определенное количество фаз
import java.util.concurrent.*;

//Расширить класс МyPhaser, чтобы выполнить только определенное количество фаз
class AdvancedPhaser extends Phaser {
	int numPhases;

	AdvancedPhaser(int parties, int phaseCount) {
		super(parties);
		numPhases = phaseCount - 1;
	}

	// переопределить метод onAdvance(), чтобы выполнить определенное количество
	// фаз
	protected boolean onAdvance(int p, int regParties) {
		// Следующий оператор println() требуется только для
		// целей иллюстрации. Как правило, метод onAdvance() не отображает
		// выводимые данные
		System.out.println("Фaзa " + p + " завершена.\n");
		// возвратить логическое значение true, если все фазы завершены
		if (p == numPhases || regParties == 0)
			return true;
		// В противном случае возвратить логическое значение false
		return false;
	}

}

class PhaserAdvancedDemo {
	public static void main(String args[]) {
		AdvancedPhaser phsr = new AdvancedPhaser(1, 4);
		System.out.println("Зaпycк потоков\n");
		new AdvancedThread(phsr, "А");
		new AdvancedThread(phsr, "В");
		new AdvancedThread(phsr, "С");
		// ожидать завершения определенного количества фаз
		while (!phsr.isTerminated()) {
			phsr.arriveAndAwaitAdvance();
		}
		System.out.println("Cинxpoнизaтop фаз завершен");
	}
}

// Поток исполнения, использующий синхронизатор фаз типа Phaser
class AdvancedThread implements Runnable {
	Phaser phsr;
	String name;

	AdvancedThread(Phaser p, String n) {
		phsr = p;
		name = n;
		phsr.register();
		new Thread(this).start();
	}

	public void run() {
		while (!phsr.isTerminated()) {
			System.out.println("Поток " + name + " начинает фазу " + phsr.getPhase());
			phsr.arriveAndAwaitAdvance();
			// Небольшая пауза, чтобы не нарушить порядок вывода.
			// Только для иллюстрации,но необязательно для правильного
			// функционирования синхронизатора фаз
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
	}
}