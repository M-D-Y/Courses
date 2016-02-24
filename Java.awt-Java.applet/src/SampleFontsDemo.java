
//Показать шрифты
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

/*
<appletcode="SampleFontsDemo" width=200 height=100>
</applet>
*/
public class SampleFontsDemo extends Applet {
	int next = 0;
	Font f;
	String msg;

	public void init() {
		f = new Font("Dialog", Font.PLAIN, 12);
		msg = "Dialog";
		setFont(f);
		addMouseListener(new SampleFontsDemoMouseAdapter(this));
	}

	public void paint(Graphics g) {
		g.drawString(msg, 4, 20);
	}
}

class SampleFontsDemoMouseAdapter extends MouseAdapter {
	SampleFontsDemo sampleFonts;

	public SampleFontsDemoMouseAdapter(SampleFontsDemo sampleFonts) {
		this.sampleFonts = sampleFonts;
	}

	public void mousePressed(MouseEvent me) {
		// сменить шрифт после каждого щелчка кнопкой мыши
		sampleFonts.next++;
		switch (sampleFonts.next) {
		case 0:
			sampleFonts.f = new Font("Dialog", Font.PLAIN, 12);
			sampleFonts.msg = "Dialog";
			break;
		case 1:
			sampleFonts.f = new Font("Dialoginput", Font.PLAIN, 12);
			sampleFonts.msg = "DialogInput";
			break;
		case 2:
			sampleFonts.f = new Font("SansSerif", Font.PLAIN, 12);
			sampleFonts.msg = "SansSerif";
			break;
		case 3:
			sampleFonts.f = new Font("Serif", Font.PLAIN, 12);
			sampleFonts.msg = "Serif";
			break;
		case 4:
			sampleFonts.f = new Font("Monospaced", Font.PLAIN, 12);
			sampleFonts.msg = "Monospaced";
			break;
		}
		if (sampleFonts.next == 4)
			sampleFonts.next = -1;

		sampleFonts.setFont(sampleFonts.f);
		sampleFonts.repaint();
	}
}