//Простой аплет, устанавливающий цвета фона
//и переднего плана и выводящий символьную строку

import java.awt.*;
import java.applet.*;

/*
<appletcode="Sample"width=ЗOOheight=50>
</applet>
*/
public class AppletSampleDemo extends Applet {
	String msg;

	// установить цвета фона и переднего плана
	public void init() {
		setBackground(Color.cyan);
		setForeground(Color.red);
		msg = "Inside init()--";
	}

	// инициализировать выводимую символьную строкуТ
	public void start() {
		msg += "Inside start()--";
	}

	// вывести символьную строку msq в окне аплета
	public void paint(Graphics g) {
		msg += "Inside paint()--.";
		g.drawString(msg, 10, 30);
	}
}