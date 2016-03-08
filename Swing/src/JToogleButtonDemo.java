
//Продемонстрировать применение компонента типа JТoggleВutton
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
<applet code="JToggleButtonDemo" width=200 height=50>
</applet>
*/
public class JToogleButtonDemo extends JApplet {
	JLabel jlab;
	JToggleButton jtbn;

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
		// изменить поточную компоновку
		setLayout(new FlowLayout());
		// создать метку
		jlab = new JLabel("Button is off.");// кнопка отпущена
		// создать переключатель
		jtbn = new JToggleButton("On/Off");
		// ввести приемник событий от переключателя
		jtbn.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent ie) {
				if (jtbn.isSelected())
					jlab.setText("Button is on.");// Кнопка нажата
				else
					jlab.setText("Button is off.");// Кнопка отпущена
			}
		});
		// ввести переключатель и метку на панель содержимого
		add(jtbn);
		add(jlab);
	}
}