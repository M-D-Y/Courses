
//Продемонстрировать применение текстового поля
import java.awt.*;
import java.applet.Applet;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
<applet code="TextFieldDemo" width=380 height=150>
</applet>
*/
public class TextFieldDemo extends Applet implements ActionListener {
	TextField name, pass;

	public void init() {
		Label namep = new Label("Name: ", Label.RIGHT);
		// Имя пользователя
		Label passp = new Label("Password: ", Label.RIGHT);
		// Пароль пользователя
		name = new TextField(12);
		pass = new TextField(8);
		pass.setEchoChar('?');
		add(namep);
		add(name);
		add(passp);
		add(pass);
		// зарегистрироватьприемникисобытийдействия
		name.addActionListener(this);
		pass.addActionListener(this);
	}

	// Пользователь нажал клавишу <Enter>
	public void actionPerformed(ActionEvent ае) {
		repaint();
	}

	public void paint(Graphics g) {
		g.drawString("Name: " + name.getText(), 6, 60);
		// Имя пользователя
		g.drawString("Selected text in name:" + name.getSelectedText(), 6, 80);
		// Выделенный текст в поле имени пользователя
		g.drawString("Password: " + pass.getText(), 6, 100);
		// Пароль пользователя
	}
}