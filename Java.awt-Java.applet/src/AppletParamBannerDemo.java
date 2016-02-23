
//Параметризованный баннер
import java.awt.*;
import java.applet.*;

//Вывод сообщения "Java оживляет веб!"
/*
<applet code="AppletParamBannerDemo" width=300 height=50>
<param name=message value="Java makes the Web move!">
</applet>
*/
public class AppletParamBannerDemo extends Applet implements Runnable {
	String msg;
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
		msg = getParameter("message");
		if (msg == null)
			msg = "Message not found."; // сообщение не найдено
		msg = " " + msg;
		t = new Thread(this);
		stopFlag = false;
		t.start();
	}

	// точка входа в поток исполнения, воспроизводящего баннер
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