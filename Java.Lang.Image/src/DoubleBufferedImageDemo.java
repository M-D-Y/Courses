
/*
<applet code="DoubleBufferedImageDemo" width=250 height=250>
</applet>
*/
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class DoubleBufferedImageDemo extends Applet {
	int gap = 3;
	int mx, my;
	boolean flicker = true;
	Image buffer = null;
	int w, h;

	public void init() {
		Dimension d;
		//d = getSize();
		d = new Dimension(500, 500);
		setSize(d);
		w = d.width;
		h = d.height;
		buffer = createImage(w, h);
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent me) {
				mx = me.getX();
				my = me.getY();
				//flicker = false;
				repaint();
			}
			public void mouseMoved(MouseEvent me) {
				mx = me.getX();
				my = me.getY();
				//flicker = true;
				repaint();
			}
		});
		addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
			flicker = !flicker;			
			}
			public void mouseEntered(MouseEvent e) {				
			}
			public void mouseExited(MouseEvent e) {				
			}
			public void mousePressed(MouseEvent e) {				// TODO Auto-generated method stub			
			}
			public void mouseReleased(MouseEvent e) {
			}
		});
	}



	public void paint(Graphics g) {
		Graphics screengc = null;
		if (!flicker) {
			screengc = g;
			g = buffer.getGraphics();
		}
		g.setColor(Color.blue);
		g.fillRect(0, 0, w, h);
		g.setColor(Color.red);
		for (int i = 0; i < w; i += gap)
			g.drawLine(i, 0, w - i, h);
		for (int i = 0; i < h; i += gap)
			g.drawLine(0, i, w, h - i);
		g.setColor(Color.black);
		g.setFont( new Font ("Arial", Font.BOLD, 14));
		g.drawString("Press mouse button to double Ьuffer", 10, h / 2);
		// Щелкните кнопкой мыши, чтобы перейти в режим двойной буфериэации
		g.setColor(Color.yellow);
		g.fillOval(mx - gap, my - gap, gap * 2 + 1, gap * 2 + 1);
		if (!flicker) {
			screengc.drawImage(buffer, 0, 0, null);
		}
	}

	public void update(Graphics g) {
		paint(g);
	}
}

