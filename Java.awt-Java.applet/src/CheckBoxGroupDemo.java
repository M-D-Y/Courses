
//Продемонстрировать применение кнопок - переключателей
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<appletcode="CBGroup"width=240height=200>
</applet>
*/
public class CheckBoxGroupDemo extends Applet implements ItemListener {
	String msg = "";
	Checkbox windows, android, solaris, mac;
	CheckboxGroup cbg;

	public void init() {
		cbg = new CheckboxGroup();
		windows = new Checkbox("Windows", cbg, true);
		android = new Checkbox("Android", cbg, false);
		solaris = new Checkbox("Solaris", cbg, false);
		mac = new Checkbox("MacOS", cbg, false);
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

	// отобразить текущее состояние кнопок-переключателей
	public void paint(Graphics g) {
		msg = "Current selection: ";
		msg += cbg.getSelectedCheckbox().getLabel();
		g.drawString(msg, 6, 100);
	}
}