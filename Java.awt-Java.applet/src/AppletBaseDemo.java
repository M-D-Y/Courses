
//Отобразить базу документов и кодовую базу
import java.awt.*;
import java.applet.*;
import java.net.*;

/*
<applet code="AppletBaseDemo" width=300 height=50>
</applet>
*/
public class AppletBaseDemo extends Applet {
	// вывести в окне аплета базу документов и кодовую базу
	public void paint(Graphics g) {
		String msg;
		URL url = getCodeBase();// получить кодовую базу
		msg = "Codebase: " + url.toString();// кодовая база
		g.drawString(msg, 10, 20);
		url = getDocumentBase();// получить базу документов
		msg = "Documentbase:" + url.toString();// база документа
		g.drawString(msg, 10, 40);
	}
}
