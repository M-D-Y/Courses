
//Продемонстрировать некоторые виртуальные коды клавиш
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<applet code="KeyboardExtEventDemo" width=600 height=100>
</applet>
*/
public class KeyboardExtEventDemo extends Applet implements KeyListener {
	String msg = "";
	int Х = 10, У = 20;// координаты вывода

	public void init() {
		addKeyListener(this);
	}

	public void keyPressed(KeyEvent ke) {
		showStatus("KeyDown");// Клавиша нажата
		int key = ke.getKeyCode();
		switch (key) {
		case KeyEvent.VK_F1:
			msg += "<Fl>";
			break;
		case KeyEvent.VK_F2:
			msg += "<F2>";
			break;
		case KeyEvent.VK_F3:
			msg += "<FЗ>";
			break;
		case KeyEvent.VK_PAGE_DOWN:
			msg += "<PgDn>";
			break;
		case KeyEvent.VK_PAGE_UP:
			msg += "<PgUp>";
			break;
		case KeyEvent.VK_LEFT:
			msg += "<LeftArrow>";// Клавиша<+-->
			break;
		case KeyEvent.VK_RIGHT:
			msg += "<RightArrow>";// Клавиша<--+>
			break;
		}
		repaint();
	}

	public void keyReleased(KeyEvent ke) {
		showStatus("KeyUp");// Клавиша отпущена
	}

	public void keyTyped(KeyEvent ke) {
		msg += "<" + ke.getKeyChar() + ">";
		repaint();
	}

	// вывести символы, введенные с клавиатуры
	public void paint(Graphics g) {
		g.drawString(msg, Х, У);
	}
}