
//Создать дочернее окно в аплете
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<applet code="AppletFrame" width=300 height=50>
</applet>
*/
//создать подкласс, производный от класса Frame
class SampleFrame extends Frame {
	public SampleFrame(String title) {
		super(title);
		// создать объект для обработки событий в окне
		MyWindowAdapter adapter = new MyWindowAdapter(this);
		// зарегистрировать его в качестве приемника событий
		addWindowListener(adapter);
	}

	public void paint(Graphics g) {
		g.drawString("This is in frame window", 10, 40);
		// Это сообщение выводится в обрамляющем окне
	}
}

class MyWindowAdapter extends WindowAdapter {
	SampleFrame sampleFrame;

	public MyWindowAdapter(SampleFrame sampleFrame) {
		this.sampleFrame = sampleFrame;
	}

	public void windowCloзing(WindowEvent we) {
		sampleFrame.setVisible(false);
	}
}

public class AppletFrame extends Applet {
	private static final long serialVersionUID = 5207200881834521464L;
	Frame f;

	// создать обрамляющее окно
	public void init() {
		f = new SampleFrame("A Frame Window");// Обрамляющее окно
		f.setSize(250, 250);
		f.setVisible(true);
	}

	public void start() {
		f.setVisible(true);
	}

	public void stop() {
		f.setVisible(false);
	}

	public void paint(Graphics g) {
		g.drawString("This is in applet window", 10, 20);
		// Это сообщение выводится в окне аnлета
	}
}