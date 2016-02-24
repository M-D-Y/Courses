
//Продемонстрировать применение класса адаптера
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<applet code="EventAdapterDemo" width=300 height=100>
</applet>
*/
public class MouseEventAdapterDemo extends Applet {

	public void init() {
		addMouseListener(new MouseEventAdapter(this));
		addMouseMotionListener(new MouseMotionEventAdapter(this));
	}
}

class MouseEventAdapter extends MouseAdapter {
	MouseEventAdapterDemo adapterDemo;

	public MouseEventAdapter(MouseEventAdapterDemo adapterDemo) {
		this.adapterDemo = adapterDemo;
	}

	// обработать событие от щелчка кнопкой мыши
	public void mouseClicked(MouseEvent me) {
		adapterDemo.showStatus("Mouse clicked");
		// Произведен щелчок кнопкой мыши
	}
}

class MouseMotionEventAdapter extends MouseMotionAdapter {
	MouseEventAdapterDemo adapterDemo;

	public MouseMotionEventAdapter(MouseEventAdapterDemo adapterDemo) {
		this.adapterDemo = adapterDemo;
	}

	// обработать событие перетаскивания курсора мыши
	public void mouseDragged(MouseEvent me) {
		adapterDemo.showStatus("Mouse dragged");
		// Перетаскивание курсора мыши
	}
}