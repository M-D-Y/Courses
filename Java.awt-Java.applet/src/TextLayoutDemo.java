
//Продемонстрировать выравнивание многострочного текста 
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/* 
 <title>Text Layout Demo</title> 
<applet code="TextLayoutDemo" width=200 height=200> 
<param name="text" value="Output to а Java window is actually 
quiteeasy. 
As you have seen, the AWT provides support for 
fonts, colors, text, and graphics. <Р>Of course, 
уоu must effectively utilize these items 
if you are to achieve professional results."> 
<param name="fontname" value="Serif"> 
<param name="fontSize" value="l4"> 
</applet> 
*/
public class TextLayoutDemo extends Applet {
	final int LEFT = 0;
	final int RIGHT = 1;
	final int CENTER = 2;
	final int LEFTRIGHT = 3;
	int align;
	Dimension d;
	Font f;
	FontMetrics fm;
	int fontSize;
	int fh, bl;
	int space;
	String text;

	public void init() {
		setBackground(Color.white);
		text = getParameter("text");
		try {
			fontSize = Integer.parseInt(getParameter("fontSize"));
		} catch (NumberFormatException е) {
			fontSize = 14;
		}
		;
		align = LEFT;
		addMouseListener(new TextyLayoutMouseAdapter(this));
	}

	public void paint(Graphics g) {
		update(g);
	}

	public void update(Graphics g) {
		d = getSize();
		g.setColor(getBackground());
		g.fillRect(0, 0, d.width, d.height);
		if (f == null)
			f = new Font(getParameter("fontname"), Font.PLAIN, fontSize);
		g.setFont(f);
		if (fm == null) {
			fm = g.getFontMetrics();
			bl = fm.getAscent();
			fh = bl + fm.getDescent();
			space = fm.stringWidth("");
		}
		g.setColor(Color.black);
		StringTokenizer st = new StringTokenizer(text);
		int x = 0;
		int nextx;
		int у = 0;
		String word, sp;
		int wordCount = 0;
		String line = "";
		while (st.hasMoreTokens()) {
			word = st.nextToken();
			if (word.equals("<P>")) {
				drawString(g, line, wordCount, fm.stringWidth(line), у + bl);
				line = "";
				wordCount = 0;
				x = 0;
				у = у + (fh * 2);
			} else {
				int w = fm.stringWidth(word);
				if ((nextx = (x + space + w)) > d.width) {
					drawString(g, line, wordCount, fm.stringWidth(line), у + bl);
					line = "";
					wordCount = 0;
					x = 0;
					у = у + fh;
				}
				if (x != 0)
					sp = " ";
				else
					sp = "";

				line = line + sp + word;
				x = x + space + w;
				wordCount++;
			}
		}
		drawString(g, line, wordCount, fm.stringWidth(line), у + bl);
	}

	public void drawString(Graphics g, String line, int wc, int lineW, int у) {
		switch (align) {
		case LEFT:
			g.drawString(line, 0, у);
			break;
		case RIGHT:
			g.drawString(line, d.width - lineW, у);
			break;
		case CENTER:
			g.drawString(line, (d.width - lineW) / 2, у);
			break;
		case LEFTRIGHT:
			if (lineW < (int) (d.width * .75)) {
				g.drawString(line, 0, у);
			} else {
				int toFill = (d.width - lineW) / wc;
				int nudge = d.width - lineW - (toFill * wc);
				int s = fm.stringWidth(" ");
				StringTokenizer st = new StringTokenizer(line);
				int х = 0;
				while (st.hasMoreTokens()) {
					String word = st.nextToken();
					g.drawString(word, х, у);
					if (nudge > 0) {
						х = х + fm.stringWidth(word) + space + toFill + toFill + 1;
						nudge--;
					} else {
						х = х + fm.stringWidth(word) + space + toFill;
					}
				}
			}
			break;
		}
	}

}

class TextyLayoutMouseAdapter extends MouseAdapter {
	TextLayoutDemo tl;

	public TextyLayoutMouseAdapter(TextLayoutDemo tl) {
		this.tl = tl;
	}

	public void mouseClicked(MouseEvent me) {
		tl.align = (tl.align + 1) % 4;
		tl.repaint();
	}
}
