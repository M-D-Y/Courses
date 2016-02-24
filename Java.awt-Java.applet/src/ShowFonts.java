
//Отобразить доступные шрифты
/*
<applet code="ShowFonts" width=550 height=60>
</applet>
*/
import java.applet.*;
import java.awt.*;

public class ShowFonts extends Applet {
	public void paint(Graphics g) {
		String FontList[];
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		FontList = ge.getAvailableFontFamilyNames();
		for (int i = 0; i < FontList.length; i++) {
			g.drawString(FontList[i], 4, 16 + i * 15);
		}
	}
}