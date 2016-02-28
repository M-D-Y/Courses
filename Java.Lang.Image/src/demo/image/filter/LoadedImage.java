package demo.image.filter;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;

public class LoadedImage extends Canvas {
	Image img;

	public LoadedImage(Image i) {
		set(i);
	}

	void set(Image i) {
		MediaTracker mt = new MediaTracker(this);
		mt.addImage(i, 0);
		try {
			mt.waitForAll();
		} catch (InterruptedException е) {
			System.out.println("Interrupted");
			return;
		}
		img = i;
		repaint();
	}

	public void paint(Graphics g) {
		if (img == null) {
			g.drawString("no image", 10, 30);
		} else {
			g.drawImage(img, 0, 0, this);
		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(img.getWidth(this), img.getHeight(this));
	}

	public Dimension getMinimumSize() {
		return getPreferredSize();
	}
}