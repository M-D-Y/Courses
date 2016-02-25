
//Продемонстрировать применение раскрывающихся списков
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<appletcode="ChoiceDemo"width=ЗOOheight=lBO>
</applet>
*/
public class ChoiceDemo extends Applet implements ItemListener {
	Choice os, browser;
	String msg = "";

	public void init() {
		os = new Choice();
		browser = new Choice();
		// ввести элементы в список операционных систем
		os.add("Windows");
		os.add("Android");
		os.add("Solaris");
		os.add("MacOS");
		os.select(2);
		// ввести элементы в список браузеров
		browser.add("Iпternet Explorer");
		browser.add("Firefox");
		browser.add("Chrome");
		// ввести списки выбора в окне
		add(os);
		add(browser);
		// зарегистрировать приемники событий от элементов
		os.addItemListener(this);
		browser.addItemListener(this);
	}

	public void itemStateChanged(ItemEvent ie) {
		repaint();
	}

	// отобразить результаты текущего выбора из списков
	public void paint(Graphics g) {
		msg = "Current OS: ";// Текущая ОС
		msg += os.getSelectedItem();
		g.drawString(msg, 6, 120);
		msg = "Current Browser: ";// Текущий браузер
		msg += browser.getSelectedItem();
		g.drawString(msg, 6, 140);
	}
}