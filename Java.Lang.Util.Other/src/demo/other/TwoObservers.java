package demo.other;

//За одним объектом могут наблюдать несколько наблюдателей.

import java.util.*;

//Класс первого наблюдателя
class Watcher1 implements Observer {
	public void update(Observable obj, Object arg) {
		System.out.println("Метод update() вызван, отсчет count равен " + ((Integer) arg).intValue());
	}
}

// Класс второго наблюдателя
class Watcher2 implements Observer {
	public void update(Observable obj, Object arg) {
		// по окончании выдать звуковой сигнал
		if (((Integer) arg).intValue() == 0)
			System.out.println("Гoтoвo" + '\7');
	}
}

// Наблюдаемый класс
class BeingWatched1 extends Observable {
	void counter(int period) {
		for (; period >= 0; period--) {
			setChanged();
			notifyObservers(new Integer(period));
			try {
				Thread.sleep(100);
			} catch (InterruptedException е) {
				System.out.println("Oжидaниe прервано");
			}
		}
	}
}

class TwoObservers {
	public static void main(String args[]) {
		BeingWatched1 observed = new BeingWatched1();
		Watcher1 observingl = new Watcher1();
		Watcher2 observing2 = new Watcher2();
		// ввести в список оба наблюдателя
		observed.addObserver(observingl);
		observed.addObserver(observing2);
		observed.counter(10);
	}
}
