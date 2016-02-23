
//Создать прикладную программу на основе библиотеки AWT
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

//создать обрамляющее окно
public

class StandaloneAppDemo extends Frame {
	String keymsg = "This is а test.";// Это тест
	String mousemsg = "";
	int mouseX = 30, mouseY = 30;

	public StandaloneAppDemo() {
		addKeyListener(new MyKeyAdapter(this));
		addMouseListener(new StandaloneAppMouseAdapter(this));
		addWindowListener(new StandaloneAppWindowAdapter());
	}

	public void paint(Graphics g) {
		g.drawString(keymsg, 10, 40);
		g.drawString(mousemsg, mouseX, mouseY);
	}

	// создать окно
	public static void main(String args[]) {
		StandaloneAppDemo appwin = new StandaloneAppDemo();
		appwin.setSize(new Dimension(300, 200));
		appwin.setTitle("An AWT-Based Application");
		// Приложение на основе библиотеки АWТ
		appwin.setVisible(true);
	}
}

class MyKeyAdapter extends KeyAdapter {
	StandaloneAppDemo appWindow;

	public MyKeyAdapter(StandaloneAppDemo appWindow) {
		this.appWindow = appWindow;
	}

	public void keyTyped(KeyEvent ke) {
		appWindow.keymsg += ke.getKeyChar();
		appWindow.repaint();
	};
}

class StandaloneAppMouseAdapter extends MouseAdapter {
	StandaloneAppDemo appWindow;

	public StandaloneAppMouseAdapter(StandaloneAppDemo appWindow) {
		this.appWindow = appWindow;
	}

	public void mousePressed(MouseEvent me) {
		appWindow.mouseX = me.getX();
		appWindow.mouseY = me.getY();
		appWindow.mousemsg = "Mouse Down at " + appWindow.mouseX + ", " + appWindow.mouseY;
		// кнопка мыши нажата в указанной точке
		appWindow.repaint();
	}
}

class StandaloneAppWindowAdapter extends WindowAdapter {
	public void windowClosing(WindowEvent we) {
		System.exit(0);
	}
}