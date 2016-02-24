
//Продемонстрировать вывод многострочного текста
import java.applet.*;
import java.awt.*;

/*
<applet code="MultiLineDemo" width=300 height=100>
</applet>
*/
public class MultiLineDemo extends Applet {
	int curX = 0, curY = 0;// текущая позиция

	public void init() {
		Font f = new Font("SansSerif", Font.PLAIN, 12);
		setFont(f);
	}

	public void paint(Graphics g) {
		FontMetrics fm = g.getFontMetrics();
		nextLine("This is on line one.", g);
		// Этот текст выводится в первой строке
		nextLine("This is on line two.", g);
		// Этот текст выводится во второй строке
		sameLine("This is on same line.", g);
		// Этот текст выводится в той же самой строке
		sameLine("This, too.", g);
		// И этот текст выводится в той же самой строке
		nextLine("This is оn line three.", g);
		// Этот текст выводится в третьей строке
		curX = curY = 0; // установить координаты в исходное состояние перед
							// каждой перерисовкой
	}

	// перейти на следующую строку
	void nextLine(String s, Graphics g) {
		FontMetrics fm = g.getFontMetrics();
		curY += fm.getHeight();// перейти на следующую строку
		curX = 0;
		g.drawString(s, curX, curY);
		curX = fm.stringWidth(s);// перейти в конец строки
	}

	// отобразить текст в той же самой строке
	void sameLine(String s, Graphics g) {
		FontMetrics fm = g.getFontMetrics();
		g.drawString(s, curX, curY);
		curX += fm.stringWidth(s); // перейти в конец строки
	}
}