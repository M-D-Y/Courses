
/*Простой аплет, воспроизводящий баннер. Этот аnлет создает потоки сполнения, прокручивающий
	сообщение, содержащееся в переменной msq, справа налево в окне аплета.
	*/
import java.awt.Graphics;
import java.awt.*;
import java.applet.*;

/*
<appletcode="SimpleBaппer"width=ЗOOheight=SO>
</applet>
*/
public class SimpleBannerDemo extends Applet implements Runnable {
	String msg = "А Simple Moving Banner."; // Простой движущийся баннер
	Thread t = null;
	int state;
	volatile boolean stopFlag;

	// установить цвета и инициализировать поток исполнения
	public void init() {
		setBackground(Color.cyan);
		setForeground(Color.red);
	}

	// запустить поток исполнения
	public void start() {
		t = new Thread((Runnable) this);
		stopFlag = false;
		t.start();
	}

	// точка входа в поток исполнения, прокручивающий баннер
	public void run() {
		// воспроизвести баннер повторно
		for (;;) {
			try {
				repaint();
				Thread.sleep(250);
				if (stopFlag)
					break;
			} catch (InterruptedException е) {
			}
		}
	}

	// приостановить воспроизведение баннера
	public void stop() {
		stopFlag = true;
		t = null;
	}

	// воспроизвести баннер
	public void paint(Graphics g) {
		char ch;
		ch = msg.charAt(0);
		msg = msg.substring(1, msg.length());
		msg += ch;
		g.drawString(msg, 50, 30);
	}
}