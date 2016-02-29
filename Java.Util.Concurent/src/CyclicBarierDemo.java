
//Продемонстрировать применение класса CycliCВarrier
import java.util.concurrent.*;

import javax.swing.plaf.SliderUI;

public class CyclicBarierDemo {
	public static void main(String args[]) {
		CyclicBarrier cb = new CyclicBarrier(5, new BarAction());
		System.out.println("Зaпycк потоков");
		new CyclicBarierThread(cb, "А");
		new CyclicBarierThread(cb, "В");
		new CyclicBarierThread(cb, "С");
		new CyclicBarierThread(cb, "D");
		new CyclicBarierThread(cb, "E");
		new CyclicBarierThread(cb, "F");
		new CyclicBarierThread(cb, "G");
		new CyclicBarierThread(cb, "H");
		new CyclicBarierThread(cb, "I");
		new CyclicBarierThread(cb, "J");
		new CyclicBarierThread(cb, "K");
		new CyclicBarierThread(cb, "L");
	}
}

// Поток исполнения, использующий барьер типа CycliCВarrier
class CyclicBarierThread implements Runnable {
	CyclicBarrier cbar;
	String name;
Thread t;

	CyclicBarierThread(CyclicBarrier с, String n) {
		cbar = с;
		name = n;
		t = new Thread(this);
		t.start();
	}

	public void run() {
		System.out.println(name);
		try {
			
			cbar.await();	
		} catch (BrokenBarrierException exc) {
			System.out.println(exc);
		} catch (InterruptedException exc) {
			System.out.println(exc);
		}
	}
}

// Объект этого класса вызывается по достижении барьера типа CycliCВarrier
class BarAction implements Runnable {
	public void run() {
		System.out.println("Бapьep достигнут!");
	}
}