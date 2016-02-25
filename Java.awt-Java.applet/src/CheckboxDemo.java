
//Продемонстрировать применение флажков
import java.applet.Applet;
import java.awt.Checkbox;
import java.awt.Graphics;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/*
<appletcode="CheckЬoxDemo"width=240height=200>
</applet>
*/
public class CheckboxDemo extends Applet implements ItemListener {
	String msg = "";
	Checkbox windows, android, solaris, mac;

	public void init() {
		windows = new Checkbox("Windows", null, true);
		android = new Checkbox("Android");
		solaris = new Checkbox("Solaris");
		mac = new Checkbox("MacOS");
		add(windows);
		add(android);
		add(solaris);
		add(mac);
		windows.addItemListener(this);
		android.addItemListener(this);
		solaris.addItemListener(this);
		mac.addItemListener(this);
	}

	public void itemStateChanged(ItemEvent ie) {
		repaint();
	}

	// отобразитьтекущеесостояниефлажков
	public void paint(Graphics g) {
		msg = "Current state: ";// Текущее состояние
		g.drawString(msg, 6, 80);
		msg = "Windows: " + windows.getState();
		g.drawString(msg, 6, 100);
		msg = "Android: " + android.getState();
		g.drawString(msg, 6, 120);
		msg = "Solaris: " + solaris.getState();
		g.drawString(msg, 6, 140);
		msg = "МаcOS: " + mac.getState();
		g.drawString(msg, 6, 160);
	}
}