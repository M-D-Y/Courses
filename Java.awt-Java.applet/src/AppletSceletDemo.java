
//Скелет аплета
import java.awt.*;
import java.applet.*;

/*
<appletcode="AppletSkel"width=ЗOOheight=lOO>
</applet>
*/
public class AppletSceletDemo extends Applet {
	// Этот метод вызывается первым
	public void init() {
		// инициализация
	}

	/*
	 * Этот метод вызывается вторым, после метода init(). Вызывается также при
	 * перезапуске аплета.
	 */
	public void start() {
		// начать или возобновить выполнение аплета
	}

	// Этот метод вызывается при остановке аплета
	public void stop() {
		// приостановить выполнение аплета
	}

	/*
	 * Этот метод вызывается перед уничтожением аплета. Это последний
	 * выполняемый метод.
	 */
	public void destroy() {
		// выполнить завершающие действия
	}

	// Этот метод вызывается, когда окно аплета
	// должно быть восстановлено.
	public void paint(Graphics g) {
		// повторно воспроизвести содержимое окна
		g.setColor(Color.green);
		g.drawString(this.getName(), 10, 10);
	}
}