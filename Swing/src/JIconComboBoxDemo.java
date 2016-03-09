
//Продемонстрировать применение компонента типа JComboBox
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
<applet code="JComboBoxDemo" width=300 height=200>
</applet>
*/
public class JIconComboBoxDemo extends JApplet {
	JLabel jlab;
	ImageIcon hourglass, analog, digital, stopwatch;
	JComboBox<ImageIcon> jcb;
	String timepieces[] = { "Hourglass", "Analog", "Digital", "Stopwatch" };

	public void init() {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					makeGUI();
				}
			});
		} catch (Exception exc)

		{
			System.out.println("Can't create because of " + exc);
			// Нельзя создать по указанной причине
		}
	}

	private void makeGUI() {
		// изменить поточную компоновку
		setLayout(new FlowLayout());
		// получить экземпляр объекта комбинированного списка и ввести его на
		// панели содержимого
		hourglass = new ImageIcon("hourglass.png");
		analog = new ImageIcon("analog.png");
		digital = new ImageIcon("digital.png");
		stopwatch = new ImageIcon("stopwatch.png");
		ImageIcon[] icons = {hourglass, analog, digital, stopwatch};
		jcb = new JComboBox<ImageIcon> (icons);
		//jcb = new JComboBox<String>(timepieces);

		add(jcb);
		// обработать события выбора элементов из списка
		jcb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ае) {
				ImageIcon i = (ImageIcon) jcb.getSelectedItem();
				jlab.setIcon(new ImageIcon(i.toString().toLowerCase() ));
			}
		});
		// создать метку и ввести ее на панели содержимого
		jlab = new JLabel(new ImageIcon("hourglass.png"));
		add(jlab);
	}
}