
//Обработать события от мыши в дочернем окне и окне аплета
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<appletcode="WindowEvents"width=ЗOOheight=50>
</applet>
*/
//создать подкласс, производный от класса Frame
class SampleFrameExt extends Frame implements MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 362473401638740933L;
	String msg = "";
	int mouseX = 10, mouseY = 40;
	int movX = 0, movY = 0;

	SampleFrameExt(String title) {
		super(title);
		// зарегистрировать этот объект в качестве приемника
		// собственных событий от мыши
		addMouseListener(this);
		addMouseMotionListener(this);
		// создать объект для обработки событий в окне
		MyWindowEventsAdapter adapter = new MyWindowEventsAdapter(this);
		// зарегистрировать этот объект в качестве приемника
		// событий в окне
		addWindowListener(adapter);
	}

	// обработать событие от щелчка кнопкой мыши
	public void mouseClicked(MouseEvent me) {
	}

	// обработать событие наведения курсора мыши на окно
	public void mouseEntered(MouseEvent evtObj) {
		// сохранить координаты
		mouseX = 10;
		mouseY = 54;
		msg = "Mouse just entered child.";
		// Курсормыши был только что наведен на дочернее окно
		repaint();
	}

	// обработать событие отведения курсора мыши от окна
	public void mouseExited(MouseEvent evtObj) {
		// сохранить координаты
		mouseX = 10;
		mouseY = 54;
		msg = "Mouse just left child window.";
		// Курсор мыши был только что отведен от дочернего окна
		repaint();
	}

	// обработать событие нажатия кнопки мыши
	public void mousePressed(MouseEvent me) {
		// сохранить координаты
		mouseX = me.getX();
		mouseY = me.getY();
		msg = "Down";// Кнопка мыши нажата
		repaint();
	}

	// обработать событие отпускания кнопки мыши
	public void mouseReleased(MouseEvent me) {
		// сохранить координаты
		mouseX = me.getX();
		mouseY = me.getY();
		msg = "Up";// Кнопка мыши отпущена
		repaint();
	}

	// обработать событие перетаскивания курсора мыши
	public void mouseDragged(MouseEvent me) {
		// сохранить координаты
		mouseX = me.getX();
		mouseY = me.getY();
		movX = me.getX();
		movY = me.getY();
		msg = "*";
		repaint();
	}

	// обработать событие перемещения мыши
	public void mouseMoved(MouseEvent me) {
		// сохранить координаты
		movX = me.getX();
		movY = me.getY();
		repaint(0, 0, 100, 60);
	}

	public void paint(Graphics g) {
		g.drawString(msg, mouseX, mouseY);
		g.drawString("Mouse at " + movX + ", " + movY, 10, 40);
		// Курсор мыши в точке с указанными координатами
	}
}

class MyWindowEventsAdapter extends WindowAdapter {
	SampleFrameExt sampleFrame;

	public MyWindowEventsAdapter(SampleFrameExt sampleFrame) {
		this.sampleFrame = sampleFrame;
	}

	public void windowClosing(WindowEvent we) {
		sampleFrame.setVisible(false);
	}
}

// Окно аплета
public class WindowEvents extends Applet implements MouseListener, MouseMotionListener {
	SampleFrameExt f;
	String msg = "";
	int mouseX = 0, mouseY = 10;
	int movX = 0, movY = 0;

	// создать обрамляющее окно
	public void init() {
		f = new SampleFrameExt("Handle Mouse Events");
		// Обработка событий от мыши
		f.setSize(300, 200);
		f.setVisible(true);
		// зарегистрировать объект в качестве приемника
		// собственных событий от мыши
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	// удалить обрамляющее окно при остановке аплета
	public void stop() {
		f.setVisible(false);
	}

	// показать обрамляющее окно при запуске аплета
	public void start() {
		f.setVisible(true);
	}

	// обработать событие от щелчка кнопкой мьши
	public void mouseClicked(MouseEvent me) {
	}

	// обработать событие наведения курсора мыши на окно
	public void mouseEntered(MouseEvent me) {
		// сохранить координаты
		mouseX = 0;
		mouseY = 24;
		msg = "Моuые just entered applet window.";
		// Курсор мыши был только что наведен на окно аnлета
		repaint();
	}

	// обработать событие отведения курсора мыши от окна
	public void mouseExited(MouseEvent me) {
		// сохранить координаты
		mouseX = 20;
		mouseY = 24;
		msg = "Моusе just left applet window.";
		// Курсор мыши был только что отведен от окна аплета
		repaint();
	}

	// обработать событие нажатия кнопки мыши
	public void mousePressed(MouseEvent me) {
		// сохранить координаты
		mouseX = me.getX();
		mouseY = me.getY();
		msg = "Down";// Кнопка мыши нажата
		repaint();
	}

	// обработать событие отпускания кнопки мыши
	public void mouseReleased(MouseEvent me) {
		// сохранить координаты
		mouseX = me.getX();
		mouseY = me.getY();
		msg = "Up";// Кнопка мыши отпущена
		repaint();
	}

	// обработать событие перетаскивания курсора мыши
	public void mouseDragged(MouseEvent me) {
		// сохранить координаты
		mouseX = me.getX();
		mouseY = me.getY();
		movX = me.getX();
		movY = me.getY();
		msg = "*";
		repaint();
	}

	// обработать событие перемещения мыши
	public void mouseMoved(MouseEvent me) {
		// сохранить координаты
		movX = me.getX();
		movY = me.getY();
		repaint(0, 0, 100, 20);
	}

	// отобразить сообщение в окне аплета
	public void paint(Graphics g) {
		g.drawString(msg, mouseX, mouseY);
		g.drawString("Mouse at " + movX + ", " + movY, 0, 10);
		// Курсор мыши в точке с указанными координатами
	}
}