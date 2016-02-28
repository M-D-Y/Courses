import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;

/*
<applet code="ImageUpdateDemo" width=400 height=345>
</applet>
*/
public class ImageUpdateDemo extends Applet {
	Image img;

	public void init() {
		//img = getImage(getDocumentBase(), getParameter("img"));
		img = getImage(getCodeBase(), "images/image.jpg");
	}

	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}
	
	public boolean imageUpdate(Image img, int flags){
			if((flags & ALLBITS)==0){
			System.out.println("Still processing the image.");
			//Изображение все еще обрабатывается
			return true;
			} else {
			System.out.println("Done processing the image.");
			//Обработка изображения завершена
			return false;
			}
	}
}
