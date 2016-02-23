
//Использовать строку состояния в окне аплета
import java.awt.*;
import java.applet.*;

/*
<appletcode="StatusWindow"width=ЗOOheight=50>
</applet>
*/
public class StatusWindow extends Applet {
	public void init() {
		setBackground(Color.cyan);
	}

	// вывести сообщение в окне аплета и в строке состояния
	public void paint(Graphics g) {
		g.drawString("This is in the applet window.", 10, 20);
		showStatus("This is shown in the status window.");
	}
}