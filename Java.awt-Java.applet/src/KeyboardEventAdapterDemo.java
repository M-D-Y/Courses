import java.applet.Applet;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/*
<applet code="KeyboardEventAdapterDemo" width=200 height=80>
</applet>
*/
public class KeyboardEventAdapterDemo extends Applet {

	public void init() {
		addKeyListener(new MyKeyboardAdapter(this));
	}
}

class MyKeyboardAdapter extends KeyAdapter {
	KeyboardEventAdapterDemo keyboardEventAdapterDemo;

	public MyKeyboardAdapter(KeyboardEventAdapterDemo keyboardEventAdapterDemo) {
		this.keyboardEventAdapterDemo = keyboardEventAdapterDemo;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		keyboardEventAdapterDemo.showStatus("Typed: " + e.getKeyChar());
		super.keyTyped(e);
	}

}