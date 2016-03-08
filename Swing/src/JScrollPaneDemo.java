
//Продемонстрировать применение компонент а JScrollPane
import java.awt.*;
import javax.swing.*;
/*
<applet code="JScrollPaneDemo" width=300  height=250>
</applet>
*/

public class JScrollPaneDemo extends JApplet {
	public void init() {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					makeGUI();
				}
			});
		} catch (Exception ехс) {
			System.out.println("Can't create because of " + ехс);
			// Нельзя создать по указанной причине
		}
	}

	private void makeGUI() {
		// ввести 400 кнопок на панели
		JPanel jp = new JPanel();
		jp.setLayout(new GridLayout(20, 20));
		int b = 0;
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				jp.add(new JButton("Button " + b));
				++b;

			}
		}
		// создать панель с полосами прокрутки
		JScrollPane jsp = new JScrollPane(jp);
		// Ввести панель с полосами прокрутки на панели содержимого.
		// По умолчанию выполняется граничная компоновка, и поэтому,
		// панель с полосами прокрутки вводится по центру
		add(jsp, BorderLayout.CENTER);
	}
}