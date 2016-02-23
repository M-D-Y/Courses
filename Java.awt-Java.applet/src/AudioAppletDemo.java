import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AudioAppletDemo extends Applet {
	AudioClip ac;
	URL audioURL;
	File audio;
	
	public void init() {

		try {
			audio = new File(System.getProperty("user.home") + "/spana-diman.wav");
			
			audioURL = new URL("file:/spana-diman.wav");
			ac = newAudioClip(audioURL);
			//ac = newAudioClip(new URL("http://pscode.org/media/#sound"));
			ac.play();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void start() {
		ac.play();
	}

	public void paint(Graphics g) {
		//ac.play();
		g.drawString(audioURL.toString(), 50, 80);
		g.drawString(audio.getPath(), 50, 100);
	}
}
