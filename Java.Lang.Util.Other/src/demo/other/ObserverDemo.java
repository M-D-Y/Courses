package demo.other;

/*Продемонстрировать применение класса OЬservable и интерфейса OЬserver
*/
import java.util.*;

//Это наблюдающий класс
class Watcher implements Observer {
	public void update(Observable obj, Object arg) {
		System.out.println("Метод update() вызван, отсчет count равен " + ((Integer) arg).intValue());
	}
}

// А это наблюдаемый класс
class BeingWatched extends Observable {
	void counter(int period) {
		for (; period >= 0; period--) {
			setChanged();
			notifyObservers(new Integer(period));
			try {
				Thread.sleep(100);
			} catch (InterruptedException е) {
				System.out.println("Oжидaниeпрервано");
			}
		}
	}
}

class ObserverDemo {
	public static void main(String args[]) {
		BeingWatched observed = new BeingWatched();
		Watcher observing = new Watcher();
		/*
		 * Ввести наблюдающий объект в список наблюдателей за наблюдаемым
		 * объектом
		 */
		observed.addObserver(observing);
		observed.counter(10);
	}
}