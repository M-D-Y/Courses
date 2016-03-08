
//Продемонстрировать применение компонента JCheckЬox
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/*
<appletcode="JCheckBoxDemo"width=270height=SO>
</applet>
*/
public class JCheckBoxDemo extends JApplet implements ItemListener {
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
		// ввести флажки на панели содержимого
		JCheckBox cb = new JCheckBox("C");
		cb.addItemListener(this);
		add(cb);
		cb = new JCheckBox("C++");
		cb.addItemListener(this);
		add(cb);
		cb = new JCheckBox("Java");
		cb.addItemListener(this);
		add(cb);
		cb = new JCheckBox("Perl");
		cb.addItemListener(this);
		add(cb);
		// создать метку и ввести ее на панели содержимого
		jlab = new JLabel("Select languages");
		// Выбор языка программирования
		add(jlab);
		// обработать событие от флажка
	}

	public void itemStateChanged(ItemEvent ie) {
		JCheckBox cb = (JCheckBox) ie.getItem();
		if (cb.isSelected()) {
			jlab.setText(cb.getText() + " is selected");
			// Выбран указанный язык программирования
		} else {
			jlab.setText(cb.getText() + " is cleared");
			// Указанныйфлажоксброшен
		}
	}
}