
//Вывестис ведения о шрифте
import java.applet.*;
import java.awt.*;

/*
<applet code="Fontlnfo" width=350 height=60>
</applet>
*/
public class FontInfo extends Applet {
	public void paint(Graphics g) {
		Font f = g.getFont();
		String fontName = f.getName();
		String fontFamily = f.getFamily();
		int fontSize = f.getSize();
		int fontStyle = f.getStyle();
		String msg = "Family: " + fontName;
		// Stringmsg="Семейство:"+fontName;
		msg += ", Font: " + fontFamily;// Шрифт
		msg += ", Size:" + fontSize + ", Style: ";// Размершрифта
		if ((fontStyle & Font.BOLD) == Font.BOLD)
			msg += "Bold";// Полужирное начертание
		if ((fontStyle & Font.ITALIC) == Font.ITALIC)
			msg += "Italic";// Наклонноеначертание
		if ((fontStyle & Font.PLAIN) == Font.PLAIN)
			msg += "Plain";// Простое начертание
		g.drawString(msg, 4, 16);
	}
}