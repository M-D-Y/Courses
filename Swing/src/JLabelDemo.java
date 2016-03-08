
//Продемонстрировать применение компонентов типа JLabel и ImageIcon
import java.awt.*;
import javax.swing.*;

/*
<applet code="JLabelDemo" width=250 height=200>
</applet>
*/
public class JLabelDemo extends JApplet {
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
		// создать значок
		ImageIcon ii = new ImageIcon("hourglass.png");
		// создать метку
		JLabel jl = new JLabel("Hourglass", ii, JLabel.CENTER);
		// ввести метку на панели содержимого
		add(jl);
	}
}