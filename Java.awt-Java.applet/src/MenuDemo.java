
//Пример применения меню
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<applet code ="MenuDemo" width=250 height=250>
</applet>
*/
//создать подкласс, производный от класса Frame
class MenuFrame extends Frame {
	String msg = "";
	CheckboxMenuItem debug, test;

	MenuFrame(String title) {
		super(title);
		// создать строку меню и ввести ее в обрамляющее окно
		MenuBar mBar = new MenuBar();
		setMenuBar(mBar);
		// создать пункты меню
		Menu file = new Menu("File");
		MenuItem iteml, item2, itemЗ, item4, item5;
		file.add(iteml = new MenuItem("New..."));
		file.add(item2 = new MenuItem("Open..."));
		file.add(itemЗ = new MenuItem("Close"));
		file.add(item4 = new MenuItem("-"));
		file.add(item5 = new MenuItem("Quit..."));
		mBar.add(file);
		Menu edit = new Menu("Edit");
		MenuItem item6, item7, item8, item9;
		edit.add(item6 = new MenuItem("Cut"));
		edit.add(item7 = new MenuItem("Сору"));

		edit.add(item8 = new MenuItem("Paste"));
		edit.add(item9 = new MenuItem("-"));

		Menu sub = new Menu("Special");
		MenuItem item10, item11, item12;
		sub.add(item10 = new MenuItem("First"));
		sub.add(item11 = new MenuItem("Second"));
		sub.add(item12 = new MenuItem("Third"));
		edit.add(sub);
		// создать отмечаемые пункты меню
		debug = new CheckboxMenuItem("Debug");
		edit.add(debug);
		test = new CheckboxMenuItem("Testing");
		edit.add(test);
		mBar.add(edit);
		// создать объект для обработки событий действия и событий от элементов
		MenuFrameMenuHandler handler = new MenuFrameMenuHandler(this);
		// зарегистрировать этот объект для приема событий действия и событий от
		// элементов
		iteml.addActionListener(handler);
		item2.addActionListener(handler);
		itemЗ.addActionListener(handler);
		item4.addActionListener(handler);
		item5.addActionListener(handler);
		item6.addActionListener(handler);
		item7.addActionListener(handler);
		item8.addActionListener(handler);
		item9.addActionListener(handler);
		item10.addActionListener(handler);
		item11.addActionListener(handler);
		item12.addActionListener(handler);
		debug.addItemListener(handler);
		test.addItemListener(handler);
		// создатьо бъект для обработки оконных событий
		MenuFrameWindowAdapter adapter = new MenuFrameWindowAdapter(this);
		// зарегистрировать этот объект для приема оконных событий
		addWindowListener(adapter);
	}

	public void paint(Graphics g) {
		g.drawString(msg, 10, 200);
		if (debug.getState())
			g.drawString("Debug is on.", 10, 220);
		else // Отладка включена
			g.drawString("Debug is off.", 10, 220);
		// Отладка отключена
		if (test.getState())
			g.drawString("Testing is on.", 10, 240);
		// Тестирование включено
		g.drawString("Testing is off.", 10, 240);
		// Тестирование отключено
	}
}

class MenuFrameWindowAdapter extends WindowAdapter {
	MenuFrame menuFrame;

	public MenuFrameWindowAdapter(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}

	public void windowClosing(WindowEvent we) {
		menuFrame.setVisible(false);
	}
}

class MenuFrameMenuHandler implements ActionListener, ItemListener {
	MenuFrame menuFrame;

	public MenuFrameMenuHandler(MenuFrame menuFrame) {
		this.menuFrame = menuFrame;
	}

	// обработать события действия
	public void actionPerformed(ActionEvent ae) {
		String msg = "You selected ";// Выбран пункт меню
		String arg = ae.getActionCommand();
		if (arg.equals("New..."))
			msg += "New.";
		else if (arg.equals("Open..."))
			msg += "Open.";
		else if (arg.equals("Close"))
			msg += "Сlозе.";
		else if (arg.equals("Quit..."))
			msg += "Quit.";
		else if (arg.equals("Edit"))
			msg += "Edit.";
		else if (arg.equals("Cut"))
			msg += "Cut.";
		else if (arg.equals("Copy"))
			msg += "Сору.";
		else if (arg.equals("Paste"))
			msg += "Paste.";
		else if (arg.equals("Firзt"))
			msg += "First.";
		else if (arg.equals("Second"))
			msg += "Second.";
		else if (arg.equals("Third"))
			msg += "Third.";
		else if (arg.equals("Debug"))
			msg += "Debug.";
		else if (arg.equals("Testing"))
			msg += "Testing.";
		menuFrame.msg = msg;
		menuFrame.repaint();
	}

	// обработать события от элементов
	public void itemStateChanged(ItemEvent ie) {
		menuFrame.repaint();
	}
}

// создать обрамляющее окно
public class MenuDemo extends Applet {
	Frame f;

	public void init() {
		f = new MenuFrame("MenuDemo");// Демонстрационное меню
		int width = Integer.parseInt(getParameter("width"));
		int height = Integer.parseInt(getParameter("height"));
		setSize(new Dimension(width, height));
		f.setSize(width, height);
		f.setVisible(true);
	}

	public void start() {
		f.setVisible(true);
	}

	public void stop() {
		f.setVisible(false);
	}
}