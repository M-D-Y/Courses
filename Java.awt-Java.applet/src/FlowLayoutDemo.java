
//Применитьпоточнуюкомпоновкусвыравниваниемполевомукраю
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<appletcode="FlowLayoutDemo"width=240height=200>
</applet>
*/
public class FlowLayoutDemo extends Applet implements ItemListener

{
	String msg = "";
	Checkbox windows, android, solaris, mac;

	public void init() {
		// установить поточную компоновку с выравниванием по левому краю
		setLayout(new FlowLayout(FlowLayout.LEFT));
		windows = new Checkbox("Windows", null, true);
		android = new Checkbox("Android");
		solaris = new Checkbox("Solaris");
		mac = new Checkbox("MacOS");
		add(windows);
		add(android);
		add(solaris);
		add(mac);
		// зарегистрировать получателя событий от элементов
		windows.addItemListener(this);
		android.addItemListener(this);
		solaris.addItemListener(this);
		mac.addItemListener(this);
	}

	// перерисовать, когда состояние флажка изменится
	public void itemStateChanged(ItemEvent ie) {
		repaint();
	}

	// отобразить текущее состояние флажков
	public void paint(Graphics g) {
		msg = "Current state: ";
		g.drawString(msg, 6, 80);
		msg = "Windows: " + windows.getState();
		g.drawString(msg, 6, 100);
		msg = "Android: " + android.getState();
		g.drawString(msg, 6, 120);
		msg = "Solaris: " + solaris.getState();
		g.drawString(msg, 6, 140);
		msg = "Маc: " + mac.getState();
		g.drawString(msg, 6, 160);
	}
}