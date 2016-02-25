
//Продемонстрировать применение кнопок
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*

<appletcode="ButtonDemoWithLambda"width=250height=l50>
</applet>
*/
public class ButtonDemoWithLambda extends Applet implements ActionListener {
	String msg = "";
	Button yes, no, maybe;

	public void init() {
		yes = new Button("Yes");
		no = new Button("No");
		maybe = new Button("Undecided");
		add(yes);
		add(no);
		add(maybe);
		// рименить лямбда-выражения для обработки событий действия
		yes.addActionListener((ae) -> {
			msg = "Уоu pressed " + ae.getActionCommand();// Нажата кнопка
			repaint();
		});
		no.addActionListener((ae) -> {
			msg = "Уоu pressed " + ae.getActionCommand();
			repaint();
		});
		maybe.addActionListener((ae) -> {
			msg = "Уоu pressed " + ae.getActionCommand();
			repaint();
		});
	}

	public void actionPerformed(ActionEvent ae) {
		String str = ae.getActionCommand();
		if (str.equals("Yes"))
			msg = "You pressed Yes.";
		// Нажатак нопка Yes
		else if (str.equals("No"))
			msg = "You pressed No.";
		// Нажата кнопка Nо
		else
			msg = "You pressed Undecided.";
		// Нажата кнопка Undecided
		repaint();
	}

	public void paint(Graphics g) {
		g.drawString(msg, 6, 100);
	}
}