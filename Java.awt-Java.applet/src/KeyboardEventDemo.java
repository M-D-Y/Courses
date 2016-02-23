
//Продемонстрировать обработчики событий от клавиатуры
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
/*
<applet code="KeyboardEventDemo" width=300 height=100>
</applet>
*/

public class KeyboardEventDemo extends Applet implements KeyListener {
	String msg = "";
	int Х = 10, У = 20; // координаты вывода

	public void init() {
		addKeyListener(this);
	}

	public void keyPressed(KeyEvent ke) {
		showStatus("KeyDown"); // Клавиша нажата
	}

	public void keyReleased(KeyEvent ke) {
		showStatus("KeyUp");// Клавиша отпущена
	}

	public void keyTyped(KeyEvent ke) {
		msg += ke.getKeyChar();
		repaint();
	}

	// вывести символы, введенные с клавиатуры
	public void paint(Graphics g) {
		g.drawString(msg, Х, У);
	}
}