
//Продемонстрировать применение списков
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<appletcode="ListDemo" width=400 height=400>
</applet>
*/
public class ListDemo extends Applet implements ActionListener {
	List os, browser;
	String msg = "";

	public void init() {
		os = new List(4, true);
		browser = new List(4, false);
		// ввести элементы в список операционных систем
		os.add("Windows");
		os.add("Android");
		os.add("Solaris");
		os.add("MacOS");
		// ввести элементы в список брауэеров
		browser.add("Internet Explorer");
		browser.add("Firefox");
		browser.add("Chrome");
		browser.select(1);
		// ввести списки в окно
		setPreferredSize(new Dimension(400, 400));
		add(os);
		add(browser);
		// зарегистрировать приемники событий действия
		os.addActionListener(this);
		browser.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ае) {
		repaint();
	}

	// отобразить текущие результаты выбора из списков
	public void paint(Graphics g) {
		int idx[];
		msg = "CurrentOS: ";// Текущая ОС
		idx = os.getSelectedIndexes();
		for (int i = 0; i < idx.length; i++)
			msg += os.getItem(idx[i]) + ", ";
		g.drawString(msg, 6, 120);
		msg = "Current Browser: ";// Текущий браузер
		msg += browser.getSelectedItem();
		g.drawString(msg, 6, 140);
		showStatus(getWidth() + ", " + getHeight());
	}
}