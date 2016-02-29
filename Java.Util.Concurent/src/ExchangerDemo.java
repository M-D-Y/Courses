
//Пример применения класса Exchanger
import java.util.concurrent.Exchanger;

class ExchangerDemo {
	public static void main(String args[]) {
		Exchanger<String> exgr = new Exchanger<String>();
		new UseString(exgr);
		new MakeString(exgr);
	}
}

// Поток типа Тhread, формирующий символьную строку
class MakeString implements Runnable {
	Exchanger<String> ex;
	String str;

	MakeString(Exchanger<String> c) {
		ex = c;
		str = new String();
		new Thread(this).start();
	}

	public void run() {
		char ch = 'А';
		for (int i = 0; i < 3; i++) {
			// заполнить буфер
			for (int j = 0; j < 5; j++)
				str += (char) ch++;
			try {
				System.out.println("Отправлено:  " + str);
				// обменять заполненный буфер на пустой
				str = ex.exchange(str);
			} catch (InterruptedException exc) {
				System.out.println(exc);
			}
		}
	}
}

// Поток типа Тhread, использующий символьную строку
class UseString implements Runnable {
	Exchanger<String> ex;
	String str;

	UseString(Exchanger<String> c) {
		ex = c;
		new Thread(this).start();
	}

	public void run() {
		;
		for (int i = 0; i < 3; i++) {
			try {
				// обменять пустой буфер на заполненный
				str = ex.exchange(new String());
				System.out.println("Пoлyчeнo: " + str);
			} catch (InterruptedException exc) {
				System.out.println(exc);
			}
		}
	}
}