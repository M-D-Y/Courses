
//Продемонстрировать применение полос прокрутки
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<appletcode="SBDemo"width=ЗOOheight=200>
</applet>
*/
public class ScrollBarDemo extends Applet implements AdjustmentListener, MouseMotionListener {
	String msg = "";
	Scrollbar vertSB, horzSB;

	public void init() {
		int width = Integer.parseInt(getParameter("width"));
		int height = Integer.parseInt(getParameter("height"));
		vertSB = new Scrollbar(Scrollbar.VERTICAL, 0, 1, 0, height);
		vertSB.setPreferredSize(new Dimension(20, 100));
		horzSB = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, width);
		horzSB.setPreferredSize(new Dimension(100, 20));
		add(vertSB);
		add(horzSB);
		// зарегистрировать приемники событий настройки
		vertSB.addAdjustmentListener(this);
		horzSB.addAdjustmentListener(this);
		addMouseMotionListener(this);
	}

	public void adjustmentValueChanged(AdjustmentEvent ае) {
		repaint();
	}

	// обновить полосу прокрутки в ответ на перетаскивание
	// курсора мыши
	public void mouseDragged(MouseEvent me) {
		int x = me.getX();
		int y = me.getY();
		vertSB.setValue(y);
		horzSB.setValue(x);
		repaint();
	}

	// Это требуется для интерфейса МouseMotionListener
	public void mouseMoved(MouseEvent me) {
	}

	// отобразить текущие значения прокрутки
	public void paint(Graphics g) {
		msg = "Vertical: " + vertSB.getValue();
		// Прокрутка по вертикали
		msg += ", Horizontal: " + horzSB.getValue();
		// Прокрутка по горизонтали
		g.drawString(msg, 6, 160);
		// отобразить текущее положение перетаскиваемого курсора мыши
		g.drawString("*", horzSB.getValue(), vertSB.getValue());
	}
}