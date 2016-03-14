
//Окончательный вариант программы MenuDemoCompleted
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MenuDemoCompleted implements ActionListener {
	JFrame jfrm;
	JLabel jlab;
	JMenuBar jmb;
	JToolBar jtb;
	JPopupMenu jpu;
	DebugAction setAct;
	DebugAction clearAct;
	DebugAction resumeAct;

	class DebugAction extends AbstractAction {
		public DebugAction(String name, Icon image, int mnem, int ассеl, String tTip) {
			super(name, image);
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(ассеl, InputEvent.CTRL_DOWN_MASK));
			putValue(MNEMONIC_KEY, new Integer(mnem));
			putValue(SHORT_DESCRIPTION, tTip);
		}

		// обработать события как на панели инструментов, так и в подменю Debug
		public void actionPerformed(ActionEvent ae) {
			String comStr = ae.getActionCommand();
			jlab.setText(comStr + " Selected");// Выбрать указанное
			// изменить разрешенное состояние вариантов выбора
			// режимов установкии очистки точек прерывания
			if (comStr.equals("Set Breakpoint")) {
				clearAct.setEnabled(true);
				setAct.setEnabled(false);
			} else if (comStr.equals("Clear Breakpoint")) {
				clearAct.setEnabled(false);
				setAct.setEnabled(true);
			}
		}
	}

	MenuDemoCompleted() {
		// создать новый контейнер тиnа JFrame
		jfrm = new JFrame("Menu Demo Completed");
		// Полная демонстрация меню
		// использовать граничную компоновку, выбираемую по умолчанию
		// задать исходные размеры фрейма
		jfrm.setSize(360, 200);
		// завершить прикладную программу, когда пользователь закроет ее окно
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// создать метку для отображения результатов выбора из меню
		jlab = new JLabel();
		// создать строку меню
		jmb = new JMenuBar();
		// создатьменюFile
		makeFileMenu();
		// создать действия отладки
		makeActions();
		// создать панель инструментов
		makeToolBar();
		// создать меню Options
		makeOptionsMenu();
		// создать меню Help
		makeHelpMenu();
		// создать меню Edit
		makeEditPUMenu();
		// ввести приемник событий запуска всплывающего меню
		jfrm.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent me) {
				if (me.isPopupTrigger())
					jpu.show(me.getComponent(), me.getX(), me.getY());
			}
			public void mouseReleased(MouseEvent me) {
				if (me.isPopupTrigger())
					jpu.show(me.getComponent(), me.getX(), me.getY());
			}
		});

		// ввести метку в центре панели содержимого
		jfrm.add(jlab, SwingConstants.CENTER);
		// ввести панель инструментов в северном положении панели содержимого
		jfrm.add(jtb, BorderLayout.NORTH);
		// ввести строку меню во фрейм
		jfrm.setJMenuBar(jmb);
		// отобразить фрейм
		jfrm.setVisible(true);
	}

	// Обработать события действия от пунктов меню.
	// Здесь НЕ обрабатываются события, генерируемые
	// при выборе режимав отладки вподменю или напанели инструментов Debug
	public void actionPerformed(ActionEvent ae) {
		// получить команду действия из выбранного меню
		String comStr = ae.getActionCommand();
		// выйти из программы, если пользователь выберет пункт меню Exit
		if (comStr.equals("Exit"))
			System.exit(0);
		// отобразить в противном случае результат выбора из меню
		jlab.setText(comStr + " Selected");
		// Класс действий для подменю и панели инструментов Debug
	}

	// создать меню File с мнемоникой и оперативными клавишами
	void makeFileMenu() {
		JMenu jmFile = new JMenu("File");
		jmFile.setMnemonic(KeyEvent.VK_F);
		JMenuItem jmiOpen = new JMenuItem("Open", KeyEvent.VK_O);
		jmiOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		JMenuItem jmiClose = new JMenuItem("Close", KeyEvent.VK_C);
		jmiClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		JMenuItem jmiSave = new JMenuItem("Save", KeyEvent.VK_S);
		jmiSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		JMenuItem jmiExit = new JMenuItem("Exit", KeyEvent.VK_E);
		jmiExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));
		jmFile.add(jmiOpen);
		jmFile.add(jmiClose);
		jmFile.add(jmiSave);
		jmFile.addSeparator();
		jmFile.add(jmiExit);
		jmb.add(jmFile);
		// ввестиприемникидействийдляпунктовменюFile
		jmiOpen.addActionListener(this);
		jmiClose.addActionListener(this);
		jmiSave.addActionListener(this);
		jmiExit.addActionListener(this);
	}

	// создатьменюOptiona
	void makeOptionsMenu() {
		JMenu jmOptions = new JMenu("Options");
		// создать подменю Colora
		JMenu jmColors = new JMenu("Colors");
		// использовать флажки, чтобы пользователь мог выбрать сразу несколько
		// цветов
		JCheckBoxMenuItem jmiRed = new JCheckBoxMenuItem("Red");
		JCheckBoxMenuItem jmiGreen = new JCheckBoxMenuItem("Green");
		JCheckBoxMenuItem jmiBlue = new JCheckBoxMenuItem("Blue");
		// ввестипунктывподменюColors
		jmColors.add(jmiRed);
		jmColors.add(jmiGreen);
		jmColors.add(jmiBlue);
		jmOptions.add(jmColors);
		// создатьподменюPriority
		JMenu jmPriority = new JMenu("Priority");
		// Использовать кнопки-перелючатели для установки приоритета. Благодаря
		// этому в меню не только отображается
		// установленный приоритет, но и гарантируется установка одного и только
		// одного приоритета.
		// Исходно выбирается кнопка-переключатель в пункте меню High
		JRadioButtonMenuItem jmiHigh = new JRadioButtonMenuItem("High", true);
		JRadioButtonMenuItem jmiLow = new JRadioButtonMenuItem("Low");
		// ввести пункты в подменю Priority
		jmPriority.add(jmiHigh);
		jmPriority.add(jmiLow);
		jmOptions.add(jmPriority);
		// создать группу кнопок-переключателей в пунктах подменю Priority
		ButtonGroup bg = new ButtonGroup();
		bg.add(jmiHigh);
		bg.add(jmiLow);
		// создать подменю Debug, входящее в меню Options,
		// используя действия для создания пунктов этого подменю
		JMenu jmDebug = new JMenu("Debug");
		JMenuItem jmiSetBP = new JMenuItem(setAct);
		JMenuItem jmiClearBP = new JMenuItem(clearAct);
		JMenuItem jmiResume = new JMenuItem(resumeAct);
		// ввести пункты в подменю Debug
		jmDebug.add(jmiSetBP);
		jmDebug.add(jmiClearBP);
		jmDebug.add(jmiResume);
		jmOptions.add(jmDebug);
		// создать пункт меню Reset
		JMenuItem jmiReset = new JMenuItem("Reset");
		jmOptions.addSeparator();
		jmOptions.add(jmiReset);
		// И наконец, ввести все выбираемые меню в строку меню
		jmb.add(jmOptions);
		// ввести приемники действий для пунктов меню Options,
		// кроме тех, что поддерживаются в подменю DeЬug
		jmiRed.addActionListener(this);
		jmiGreen.addActionListener(this);
		jmiBlue.addActionListener(this);
		jmiHigh.addActionListener(this);
		jmiLow.addActionListener(this);
		jmiReset.addActionListener(this);
	}

	// создать меню Help
	void makeHelpMenu() {
		JMenu jmHelp = new JMenu("Help");
		// ввести значок для пункта меню About
		ImageIcon icon = new ImageIcon("about_icon.png");
		JMenuItem jmiAbout = new JMenuItem("About", icon);
		jmiAbout.setToolTipText("Info about the MenuDemo program.");
		jmHelp.add(jmiAbout);
		jmb.add(jmHelp);
		// ввести приемник действий для пункта меню About
		jmiAbout.addActionListener(this);
	}

	// создать действия для управления подменю и панелью инструментов Debug
	void makeActions() {
		// загрузить изображения для обозначения действий
		ImageIcon setIcon = new ImageIcon("breakpoint_new.png");
		ImageIcon clearIcon = new ImageIcon("breakpoint_delete.png");
		ImageIcon resumeIcon = new ImageIcon("breakpoint_run.png");
		// создать действия
		setAct = new DebugAction("Set Breakpoint", setIcon, KeyEvent.VK_S, KeyEvent.VK_B, "Set а breakpoint.");
		clearAct = new DebugAction("Clear Breakpoint", clearIcon, KeyEvent.VK_C, KeyEvent.VK_L, "Clear а breakpoint.");
		resumeAct = new DebugAction("Resume", resumeIcon, KeyEvent.VK_R, KeyEvent.VK_R,
				"Resume execution after breakpoint.");
		// Initially disable the Clear Breakpoint option.
		clearAct.setEnabled(false);
	}

	// создать панель инструментов Debug
	void makeToolBar() {
		// создать кнопки для панели инструментов,
		// используя соответствующие действия
		JButton jbtnSet = new JButton(setAct);
		JButton jbtnClear = new JButton(clearAct);
		JButton jbtnResume = new JButton(resumeAct);
		// создать панель инструментов Debug
		jtb = new JToolBar("Breakpoints");
		// ввести кнопки на панели инструментов
		jtb.add(jbtnSet);
		jtb.add(jbtnClear);
		jtb.add(jbtnResume);
	}

	// создать всплывающее меню Edit
	void makeEditPUMenu() {
		jpu = new JPopupMenu();
		// создатьпунктывсплывающегоменюEdit
		JMenuItem jmiCut = new JMenuItem("Cut");
		JMenuItem jmiCopy = new JMenuItem("Copy");
		JMenuItem jmiPaste = new JMenuItem("Paste");
		// ввести пункты во всплывающее меню Edit
		jpu.add(jmiCut);
		jpu.add(jmiCopy);
		jpu.add(jmiPaste);
		// ввести приемники действий для всплывающего меню Edit
		jmiCut.addActionListener(this);
		jmiCopy.addActionListener(this);
		jmiPaste.addActionListener(this);
	}

	public static void main(String args[]) {
		// создать фрейм в потоке диспетчеризации событий
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new MenuDemoCompleted();
			}
		});
	}
}