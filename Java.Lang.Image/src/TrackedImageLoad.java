
/*
<applet code="TrackedimageLoad" width=300 height=400>
<param name="img"
value="vincent+leonardo+matisse+picasso+renoir+seurat+vermeer">
</applet>
*/
import java.util.*;
import java.applet.*;
import java.awt.*;

public class TrackedImageLoad extends Applet implements Runnable {
	MediaTracker tracker;
	int tracked;
	int framerate = 100;
	int currentimg = 0;
	Thread motor;
	static final int МAXIМAGES = 10;
	Image img[] = new Image[МAXIМAGES];
	String name[] = new String[МAXIМAGES];
	volatile boolean stopFlag;

	public void init() {
		tracker = new MediaTracker(this);
		// StringTokenizer st = new StringTokenizer(getParameter("img"), "+");
		String parameter = "vincent+leonardo+matisse+picasso+renoir+seurat+vermeer";
		StringTokenizer st = new StringTokenizer(parameter, "+");
		while (st.hasMoreTokens() && tracked <= МAXIМAGES) {
			name[tracked] = st.nextToken();
			img[tracked] = getImage(getCodeBase(), "images/" + name[tracked] + ".jpg");
			tracker.addImage(img[tracked], tracked);
			tracked++;
		}
	}

	public void paint(Graphics g) {
		String loaded = "";
		int donecount = 0;

		for (int i = 0; i < tracked; i++) {
			if (tracker.checkID(i, true)) {
				donecount++;
				loaded += name[i] + " ";
			}
		}
		Dimension d = getSize();
		int w = d.width;
		int h = d.height;
		
		if (donecount == tracked) {
			framerate = 1;
			Image i = img[currentimg++];

			int iw = i.getWidth(null);
			int ih = i.getHeight(null);
			g.drawImage(i, (w - iw) / 2, (h - ih) / 2, null);
			showStatus("Image: " + name[currentimg-1]);
			if (currentimg >= tracked)
				currentimg = 0;
			
		} else {
			
			int x = w * donecount / tracked;
			g.setColor(Color.black);
			g.fillRect(0, h / 3, x, 16);
			g.setColor(Color.white);
			g.fillRect(x, h / 3, w - x, 16);
			g.setColor(Color.black);
			g.drawString(loaded, 10, h / 2);
		}
	}

	public void start() {
		motor = new Thread(this);
		stopFlag = false;
		motor.start();
	}

	public void stop() {
		stopFlag = true;
	}

	public void run() {
		motor.setPriority(Thread.MIN_PRIORITY);
		while (true) {
			repaint();
			try {
				Thread.sleep(1000 / framerate);
			} catch (InterruptedException e) {
				System.out.println("Interrupted");
				return;
			}
			if (stopFlag)
				return;
		}
	}
}