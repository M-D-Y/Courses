
/*
<applet code="SimplelmageLoad" width=400 height=345>
<param name="img" value="Lilies.jpg">
</applet>
*/
import java.awt.*;
import java.net.URL;
import java.applet.*;

public class SimpleImageLoad extends Applet {
	Image img;

	public void init() {
		//img = getImage(getDocumentBase(), getParameter("img"));
		URL docBase = getCodeBase();
		img = getImage(getCodeBase(), "images/image.jpg");
	}

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}
}