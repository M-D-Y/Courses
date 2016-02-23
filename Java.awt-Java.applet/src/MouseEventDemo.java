
//Продемонстрировать обработчики событий от мыши
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<applet code="MouseEvents" width=300 height=100>
</applet>
*/
public class MouseEventDemo extends Applet implements MouseListener, MouseMotionListener, MouseWheelListener {
	String msg = "";
	int mouseX = 0, mouseY = 0; // координаты курсора мыши

	public void init() {
		addMouseListener(this);
		addMouseMotionListener(this);
		addMouseWheelListener(this);
	}

	// обработать событие от щелчка кнопкой мыши
	public void mouseClicked(MouseEvent me) {
		// сохранить координаты
		mouseX = 0;
		mouseY = 10;
		msg = "Mouse clicked.";// Произведен щелчок кнопкой мыши
		repaint();
	}

	// обработать событие наведения курсора мыши
	public void mouseEntered(MouseEvent me) {
		// сохранить координаты
		mouseX = 0;
		mouseY = 10;
		msg = "Mouse entered.";// Курсор наведен
		repaint();
	}

	// обработать событие от ведения курсора мыши
	public void mouseExited(MouseEvent me) {
		// сохранить координаты
		mouseX = 0;
		mouseY = 10;
		msg = "Mouse exited.";// Курсоротведен
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
		msg = "*";
		showStatus("Dragging mouse at " + mouseX + ", " + mouseY);
		// Перетаскивание курсора мыши в точку с указанными координатами
		repaint();
	}

	// обработать событие перемещения мыши
	public void mouseMoved(MouseEvent me) {
		// показать состояние
		showStatus("Moving mouse at " + me.getX() + ", " + me.getY());
		// Перемещение курсора мыши в точку с указанными координатами
	}

	// вывести сообщение из переменной msg на текущей позиции
	// с координатами Х, У в окне аплета
	public void paint(Graphics g) {
		g.drawString(msg, mouseX, mouseY);
	}

	// обработать событие нажатия кнопки мыши
	public void mousePressed(MouseEvent arg0) {
		// сохранить координаты
		mouseX = arg0.getX();
		mouseY = arg0.getY();
		msg = "Down";// Кнопка мыши нажата
		repaint();
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		String event = null;
		// Прокрутка колеса
		if (e.getScrollType() == MouseWheelEvent.WHEEL_UNIT_SCROLL)
			msg = "Wheel scroll - event: WHEEL_UNIT_SCROLL, " + e.getWheelRotation() + " point";
		else
			msg = "Wheel scroll - event: WHEEL_BLOCK_SCROLL" + e.getWheelRotation() + " point";
		showStatus(msg);
	}

}