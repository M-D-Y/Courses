
//Пример применения диалогового окна
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

/*
<appletcode="DialogDemo"width=250height=250>
</applet>
*/
//создать подкласс, производный от класса Dialoq
class SampleDialog extends Dialog implements ActionListener {
	SampleDialog(Frame parent, String title) {
		super(parent, title, false);
		setLayout(new FlowLayout());
		setSize(300, 200);
		add(new Label("Press this button: "));
		Button b;
		add(b = new Button("Cancel"));
		b.addActionListener(this);
	}


	public void actionPerformed(ActionEvent ae) {
		dispose();
	}

	public void paint(Graphics g) {
		g.drawString("This is in the dialog bох", 10, 70);
	}
}

// Этосообщениевыводитсявдиалоговомокне
// создатьподкласс,производныйотклассаFraae
class DialogDemoMenuFrame extends Frame {
	String msg = "";
	CheckboxMenuItem debug, test;

	DialogDemoMenuFrame(String title) {
		super(title);
		// создать строку меню и ввести ее в обрамляющем окне
		MenuBar mbar = new MenuBar();
		setMenuBar(mbar);
		// создать пункты меню
		Menu file = new Menu("File");
		MenuItem iteml, item2, itemЗ, item4;
		file.add(iteml = new MenuItem("New..."));
		file.add(item2 = new MenuItem("Open..."));
		file.add(itemЗ = new MenuItem("Close"));
		file.add(new MenuItem("-"));
		file.add(item4 = new MenuItem("Quit..."));
		mbar.add(file);
		Menu edit = new Menu("Edit");
		MenuItem item5, itemб, item7;
		edit.add(item5 = new MenuItem("Cut"));
		edit.add(itemб = new MenuItem("Copy"));
		edit.add(item7 = new MenuItem("Paste"));
		edit.add(new MenuItem("-"));
		Menu sub = new Menu("Special", true);
		MenuItem item8, item9, item10;
		sub.add(item8 = new MenuItem("First"));
		sub.add(item9 = new MenuItem("Second"));
		sub.add(item10 = new MenuItem("Third"));
		edit.add(sub);
		// создать отмечаемые пункты меню
		debug = new CheckboxMenuItem("Debug");
		edit.add(debug);
		test = new CheckboxMenuItem("Testing");
		edit.add(test);
		mbar.add(edit);
		// создать объект для обработки событий действия и событий от элементов
		DialogDemoMenuHandler handler = new DialogDemoMenuHandler(this);
		// зарегистрировать этот объект для приема событий
		// действия и событий от элементов
		iteml.addActionListener(handler);
		item2.addActionListener(handler);
		itemЗ.addActionListener(handler);
		item4.addActionListener(handler);
		item5.addActionListener(handler);
		itemб.addActionListener(handler);
		item7.addActionListener(handler);
		item8.addActionListener(handler);
		item9.addActionListener(handler);
		item10.addActionListener(handler);
		debug.addItemListener(handler);
		test.addItemListener(handler);
		// создать объект для обработки оконных событий
		DialogDemoWindowAdapter adapter = new DialogDemoWindowAdapter(this);
		// зарегистрировать этот объект для приема оконных событий
		addWindowListener(adapter);
	}

	public void paint(Graphics g) {
		g.drawString(msg, 10, 200);
		if (debug.getState())// Отладка включена 
			g.drawString("Debug is on.", 10, 220);
		else
			// Отладка отключена
			g.drawString("Debug is off.", 10, 220);
		

		if (test.getState()) // тестирование включено
			g.drawString("Testing is on.", 10, 240);
		
		else // Тестирование отключено
			g.drawString("Testing is off.", 10, 240);
		
	}
}

class DialogDemoWindowAdapter extends WindowAdapter {
	DialogDemoMenuFrame dialogDemoMenuFrame;

	public DialogDemoWindowAdapter(DialogDemoMenuFrame dialogDemoMenuFrame) {
		this.dialogDemoMenuFrame = dialogDemoMenuFrame;
	}

	public void windowClosing(WindowEvent we) {
		dialogDemoMenuFrame.dispose();
	}
}

class DialogDemoMenuHandler implements ActionListener, ItemListener {
	DialogDemoMenuFrame dialogDemoMenuFrame;

	public DialogDemoMenuHandler(DialogDemoMenuFrame dialogDemoMenuFrame) {
		this.dialogDemoMenuFrame = dialogDemoMenuFrame;
	}

	// обработать события действия
	public void actionPerformed(ActionEvent ae) {
		String msg = "Уоu selected ";
		String arg = ae.getActionCommand();
		// активизировать диалоговое окно при выборе пункта меню New
		if (arg.equals("New...")) {
			msg += "New.";
			SampleDialog d = new SampleDialog(dialogDemoMenuFrame, "NewDialogВох");
			d.setVisible(true);
		}
		// попытаться определить диалоговые окна для остальных
		// пунктов меню
		else if (arg.equals("Open..."))
			msg += "Open.";
		else if (arg.equals("Close"))
			msg += "Close.";
		else if (arg.equals("Quit..."))
			msg += "Quit.";
		else if (arg.equals("Edit"))
			msg += "Edit.";
		else if (arg.equals("Cut"))
			msg += "Cut.";
		else if (arg.equals("Copy"))
			msg += "Сору.";// Копирование
		else if (arg.equals("Paste"))
			msg += "Paste.";// Вставка
		else if (arg.equals("First"))
			msg += "First.";// Первое окно
		else if (arg.equals("Second"))
			msg += "Second.";// Второе окно
		else if (arg.equals("Third"))
			msg += "Third.";// Третье окно
		else if (arg.equals("Debug"))
			msg += "Debug.";// Отладка
		else if (arg.equals("Testing"))
			msg += "Testing.";// Тестирование
		dialogDemoMenuFrame.msg = msg;
		dialogDemoMenuFrame.repaint();
	}

	public void itemStateChanged(ItemEvent ie) {
		dialogDemoMenuFrame.repaint();
	}
}

// создать обрамляющее окно
public class DialogDemo extends Applet {
	Frame f;

	public void init() {
		f = new DialogDemoMenuFrame("MenuDemo");
		int width = Integer.parseInt(getParameter("width"));
		int height = Integer.parseInt(getParameter("height"));
		setSize(width, height);
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