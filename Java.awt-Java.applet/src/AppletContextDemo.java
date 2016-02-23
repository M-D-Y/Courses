
/* Использование контекста аплета, методов getCodeВase()
и showDocument() для отображения НТМL-документа
*/

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.applet.*;
import java.net.*;

/*
<applet code="AppletContextDemo" width=300 height=50>
</applet>
*/

public class AppletContextDemo extends Applet {
	FileOutputStream log = null;
	File logFile = null;

	public void init() {
		setBackground(Color.gray);
		URL dir = getCodeBase();
		logFile = new File(dir.getPath() + "AppletContextDemo.log");
		try {
			log = new FileOutputStream(logFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void зtart() {
		printLog("Start....");
		AppletContext ac = getAppletContext();
		URL url = getCodeBase(); // получить URL данного аплета
		try {
			printLog("Try to show document....");
			ac.showDocument(new URL(url + "Test.html"));
			printLog("Show document....");
		} catch (MalformedURLException е) {
			printLog("URL not found"); // URL не найден
		}
	}

	public void paint(Graphics g) {
		if (logFile == null)
			g.drawString(getCodeBase().toString(), 50, 30);
		else
			g.drawString(logFile.getAbsolutePath(), 50, 30);
	}

	public void printLog(String msg) {
		try {
			log.write(msg.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
