
//Использовать класс GridВagLayout
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<applet code="GridBagLayoutDemo" width=250 height=200>
</applet>
*/
public class GridBagLayoutDemo extends Applet implements ItemListener {
	String msg = "";
	Checkbox windows, android, solaris, mac;

	public void init() {
		GridBagLayout gbag = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		setLayout(gbag);
		// определить флажки
		windows = new Checkbox("Windows", null, true);
		android = new Checkbox("Android");
		solaris = new Checkbox("Solaris");
		mac = new Checkbox("МаcOS");
		// определить сеточный контейнер
		// использовать нулевой вес по умолчанию для первой строки
		gbc.weightx = 1.0; // использовать единичный вес для столбца
		gbc.ipadx = 200; // заполнить на 200 единиц
		gbc.insets = new Insets(4, 4, 0, 0);// сделать небольшую вставку
											// относительно левого верхнего угла
		gbc.anchor = GridBagConstraints.NORTHEAST;
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(windows, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(android, gbc);
		// придать второй строке единичный вес
		gbc.weighty = 1.0;
		gbc.gridwidth = GridBagConstraints.RELATIVE;
		gbag.setConstraints(solaris, gbc);
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbag.setConstraints(mac, gbc);
		// ввести компоненты
		add(windows);
		add(android);
		add(solaris);
		add(mac);
		// зарегистрировать приемники событий от элементов
		windows.addItemListener(this);
		android.addItemListener(this);
		solaris.addItemListener(this);
		mac.addItemListener(this);
	}

	// перерисовать, когда изменится состояние флажка
	public void itemStateChanged(ItemEvent ie) {
		repaint();
	}

	// отобразить текущее состояние флажков
	public void paint(Graphics g) {
		msg = "Current state: ";// Текущее состояние
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