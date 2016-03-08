
//Продемонстрировать применение компонента JТextField
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
<applet code="JTextFieldDemo" width=300 height=50>
</applet>
*/
public class JTextFieldDemo extends JApplet {
	JTextField jtf;

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
		// ввести текстовое поле на панели содержимого
		jtf = new JTextField(15);
		add(jtf);
		jtf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ае) {
				// отобразить текст, когда пользователь нажимает клавишу <Enter>
				showStatus(jtf.getText());
			}
		});
	}

}