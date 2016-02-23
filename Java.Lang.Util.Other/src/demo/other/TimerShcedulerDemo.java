package demo.other;

//Продемонстрировать применение классов Timer и TimerTask
import java.util.*;

class MyTimerTask extends TimerTask {
	public void run() {
		System.out.println("Зaдaниe по таймеру выполняется.");
	}
}

class TimerShcedulerDemo {
	public static void main(String args[]) {
		MyTimerTask myTask = new MyTimerTask();
		Timer myTimer = new Timer();
		/*
		 * Установить первоначальную паузу в течение одной секунды, а затем
		 * повторять задание каждые полсекунды
		 */
		myTimer.schedule(myTask, 1000, 500);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException ехс) {
		}
		myTimer.cancel();
	}
}