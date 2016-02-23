
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
		addMouseListener(new MyMouseAdapter(this));
		addMouseMotionListener(new MyMouseMotionAdapter(this));
	}
}

class MyMouseAdapter extends MouseAdapter {
	MouseEventAdapterDemo adapterDemo;

	public MyMouseAdapter(MouseEventAdapterDemo adapterDemo) {
		this.adapterDemo = adapterDemo;
	}

	// обработать событие от щелчка кнопкой мыши
	public void mouseClicked(MouseEvent me) {
		adapterDemo.showStatus("Mouse clicked");
		// Произведен щелчок кнопкой мыши
	}
}

class MyMouseMotionAdapter extends MouseMotionAdapter {
	MouseEventAdapterDemo adapterDemo;

	public MyMouseMotionAdapter(MouseEventAdapterDemo adapterDemo) {
		this.adapterDemo = adapterDemo;
	}

	// обработать событие перетаскивания курсора мыши
	public void mouseDragged(MouseEvent me) {
		adapterDemo.showStatus("Mouse dragged");
		// Перетаскивание курсора мыши
	}
}