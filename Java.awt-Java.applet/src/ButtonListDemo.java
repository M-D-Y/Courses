
//Распознать объекты типа Вutton
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<appletcode="ButtonList"width=250height=l50>
</applet>
*/
public class ButtonListDemo extends Applet implements ActionListener {
	String msg = "";
	Button List[] = new Button[3];

	public void init() {
		Button yes = new Button("Yes");
		Button no = new Button("No");
		Button maybe = new Button("Undecided");
		//// сохранить ссылки на кнопки при их вводе
		List[0] = (Button) add(yes);
		List[1] = (Button) add(no);
		List[2] = (Button) add(maybe);
		// зареrистрировать приемники на получение уведомлений о событиях
		// действия
		for (int i = 0; i < 3; i++) {
			List[i].addActionListener(this);
		}
	}

	public void actionPerformed(ActionEvent ae) {
		for (int i = 0; i < 3; i++) {
			if (ae.getSource() == List[i])
				msg = "You pressed " + List[i].getLabel();
			// Нажата указанная кнопка
		}
		repaint();
	}

	public void paint(Graphics g) {
		g.drawString(msg, 6, 100);
	}
}