
//Продемонстрировать применение компонента JТаЬЬеdРаnе
import javax.swing.*;

/*
<appletcode="JTabbedPaneDemo"width=400height=lOO>
</applet>
*/
public class JTabbedPaneDemo extends JApplet {
	public void init() {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					makeGUI();
				}
			});
		} catch (Exception ехс) {
			System.out.println("Can't create Ьесаusе of " + ехс);
			// Нельзя создать по указанной причине
		}
	}

	private void makeGUI() {
		JTabbedPane jtp = new JTabbedPane();
		jtp.addTab("Cities", new CitiesPanel());// вкладка городов
		jtp.addTab("Colors", new ColorsPanel());// вкладка цветов
		jtp.addTab("Flavors", new FlavorsPanel());// вкладка ароматов
		add(jtp);
	}
}

// создать панели, которые будут введены на панели с вкладками
class CitiesPanel extends JPanel {
	public CitiesPanel() {
		JButton b1 = new JButton("NewYork");// Нью-Йорк
		add(b1);
		JButton b2 = new JButton("London");// Лондон
		add(b2);
		JButton b3 = new JButton("HongKong");// Гонконг
		add(b3);
		JButton b4 = new JButton("Tokyo");// Токио
		add(b4);
	}
}

class ColorsPanel extends JPanel {

	public ColorsPanel() {
		JCheckBox cb1 = new JCheckBox("Red");// Красный
		add(cb1);
		JCheckBox cb2 = new JCheckBox("Green");// Зеленый
		add(cb2);
		JCheckBox cb3 = new JCheckBox("Blue");// Синий
		add(cb3);
	}
}

class FlavorsPanel extends JPanel {
	public FlavorsPanel() {
		JComboBox<String> jcb = new JComboBox<String>();
		jcb.addItem("Vanilla");// Ванильный аромат
		jcb.addItem("Chocolate");// Шоколадный аромат
		jcb.addItem("Strawberry");// Клубничный аромат
		add(jcb);
	}
}