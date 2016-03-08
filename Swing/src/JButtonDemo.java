
//Продемонстрировать применение компонента типа JВutton в виде значка
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
<applet code="JButtonDemo" width=250 height=750>
</applet>
*/
public class JButtonDemo extends JApplet implements ActionListener {
	JLabel jlab;

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
		// ввести кнопки на панели содержимого.
		ImageIcon hourglass = new ImageIcon("hourglass.png");
		JButton jb = new JButton(hourglass);
		jb.setActionCommand("Hourglass");// Песочныечасы
		jb.addActionListener(this);
		add(jb);
		ImageIcon analog = new ImageIcon("analog.png");
		jb = new JButton(analog);
		jb.setActionCommand("Analog Clock");// Аналоговые часы
		jb.addActionListener(this);
		add(jb);
		ImageIcon digital = new ImageIcon("digital.png");
		jb = new JButton(digital);
		jb.setActionCommand("Digital Clock");// Цифровые часы
		jb.addActionListener(this);
		add(jb);
		ImageIcon stopwatch = new ImageIcon("stopwatch.png");
		jb = new JButton(stopwatch);
		jb.setActionCommand("Stopwatch");// Секундомер
		jb.addActionListener(this);
		add(jb);
		// создать метку и ввести ее на панели содержимого
		jlab = new JLabel("Choose а Time piece");// выбрать часы
		add(jlab);
	}

	// обработать события от кнопок
	public void actionPerformed(ActionEvent ae) {
		jlab.setText("You selected " + ae.getActionCommand());
		// Выбраны указанные часы
	}
}