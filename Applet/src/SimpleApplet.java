import java.awt.*;
import java.applet.*;

/*
 <applet code="SimleApplet" width=200 height=60>
 </applet>
 */

public class SimpleApplet extends Applet {

	public void paint(Graphics g) {
		g.drawString("Простейший апплет", 20, 20);
		g.drawString("Eclipse", 20, 40);
		g.draw3DRect(20, 60, 50, 50,true);
	}
}
