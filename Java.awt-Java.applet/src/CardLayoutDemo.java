
//Продемонстрировать применение карточной компоновки
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<applet code="CardLayoutDemo" width=300 height=100>
</applet>
*/
public class CardLayoutDemo extends Applet implements ActionListener, MouseListener {
	Checkbox windowsXP, windows7, windows6, android, solaris, mac;
	Panel osCards;
	CardLayout cardLO;
	Button Win, Other;

	public void init() {
		Win = new Button("Windows");
		Other = new Button("Other");
		add(Win);
		add(Other);
		cardLO = new CardLayout();
		osCards = new Panel();
		osCards.setLayout(cardLO);// установить компоновку панели для
									// раsмещенияк арт
		windowsXP = new Checkbox("WindowsХР", null, true);
		windows7 = new Checkbox("Windows7", null, false);
		windows6 = new Checkbox("Windows6", null, false);
		android = new Checkbox("Android");
		solaris = new Checkbox("Solaris");
		mac = new Checkbox("MacOS");
		// ввести на панели флажки для выбора типа ОС Windows
		Panel winPan = new Panel();
		winPan.add(windowsXP);
		winPan.add(windows7);
		winPan.add(windows6);
		// ввести на панели флажки для выбора других ОС
		Panel otherPan = new Panel();
		otherPan.add(android);
		otherPan.add(solaris);
		otherPan.add(mac);
		// ввести панели отдельных карт на панели колоды карт
		osCards.add(winPan, "Windows");
		osCards.add(otherPan, "Other");
		// ввести карты на главной панели аплета
		add(osCards);
		// sарегистрировать приемники событий действия
		Win.addActionListener(this);
		Other.addActionListener(this);
		// sарегистрировать приемники событий от мыши
		addMouseListener(this);
		// перебрать панели карт
	}

	public void mousePressed(MouseEvent me) {
		cardLO.next(osCards);
	}

	// предоставить пустые реализации других методов из интерфейса MouвeLiвtener
	public void mouseClicked(MouseEvent me) {
	}

	public void mouseEntered(MouseEvent me) {
	}

	public void mouseExited(MouseEvent me) {
	}

	public void mouseReleased(MouseEvent me) {
	}

	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource() == Win) {
			cardLO.show(osCards, "Windows");
		} else {
			cardLO.show(osCards, "Other");
		}
	}
}