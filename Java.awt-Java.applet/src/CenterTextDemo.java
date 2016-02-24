import java.applet.Applet;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

/*
<applet code="CenterTextDemo" width=200 height=100>
</applet>
*/
public class CenterTextDemo extends Applet {
	final Font f = new Font("SansSerif", Font.BOLD, 18);

	public void paint(Graphics g) {
		Dimension d = this.getSize();
		g.setColor(Color.white);
		g.fillRect(0, 0, d.width, d.height);
		g.setColor(Color.black);
		g.setFont(f);
		drawCenteredString("This is centered.", d.width, d.height, g);
		// Этот текст отцентрован
		g.drawRect(0, 0, d.width - 1, d.height - 1);
	}

	public void drawCenteredString(String s, int w, int h, Graphics g) {
		FontMetrics fm = g.getFontMetrics();
		int х = (w - fm.stringWidth(s)) / 2;
		int у = (fm.getAscent() + (h - (fm.getAscent() + fm.getDescent())) / 2);
		g.drawString(s, х, у);
	}
}