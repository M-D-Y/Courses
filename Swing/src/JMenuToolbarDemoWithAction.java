
//Продемонстрировать простое главное меню
import java.awt.*;
import java.awt.event.*;
import java.io.FilePermission;
import java.security.Permission;

import javax.swing.*;

public class JMenuToolbarDemoWithAction implements ActionListener {
	JLabel jlab;
	DebugAction setAct;
	DebugAction clearAct;
	DebugAction resumeAct;

	JMenuToolbarDemoWithAction() {
		// System.out.println(getClass().getProtectionDomain().getCodeSource());
		// if (1==1) return;
		System.setSecurityManager(new SecurityManager());
		Permission p = new FilePermission("D:\\java-dev\\git\\courses\\Swing\\bin\\about_icon.png", "read");
		SecurityManager security = System.getSecurityManager();
		if (security != null)
			security.checkPermission(p);

		// создать новый контейнер типа JFrame
		JFrame jfrm = new JFrame("Menu Demo");// Демонстрация меню
		// указать диспетчер поточной компоновки тиnа FlowLayout
		jfrm.setLayout(new FlowLayout());
		// задать исходные размеры фрейма
		jfrm.setSize(220, 200);
		// завершить прикладную программу, когда пользователь закроет еео кно
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// создать метку для отображения результатов выбора из меню
		jlab = new JLabel();

		// создать строку меню
		JMenuBar jmb = new JMenuBar();

		// создать меню File с мнемоникой и оперативными клавишами
		JMenu jmFile = new JMenu("File");// Файл
		jmFile.setMnemonic(KeyEvent.VK_F);
		JMenuItem jmiOpen = new JMenuItem("Open", KeyEvent.VK_O);// Открыть
		jmiOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		JMenuItem jmiClose = new JMenuItem("Close", KeyEvent.VK_C);// Закрыть
		jmiClose.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_DOWN_MASK));
		JMenuItem jmiSave = new JMenuItem("Save", KeyEvent.VK_S);// Сохранить
		jmiSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		JMenuItem jmiExit = new JMenuItem("Exit", KeyEvent.VK_E);// Выход
		jmiExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_DOWN_MASK));

		jmFile.add(jmiOpen);
		jmFile.add(jmiClose);
		jmFile.add(jmiSave);
		jmFile.addSeparator();
		jmFile.add(jmiExit);

		jmb.add(jmFile);
		// создатьменю Options
		JMenu jmOptions = new JMenu("Options");// Параметры

		// создать подменю Priority
		JMenu jmPriority = new JMenu("Priority");// Приоритет
		JMenuItem jmiHigh = new JMenuItem("High");// высокий
		JMenuItem jmiLow = new JMenuItem("Low");// Низкий
		jmPriority.add(jmiHigh);
		jmPriority.add(jmiLow);
		jmOptions.add(jmPriority);
		// создать пункт меню Reset
		JMenuItem jmiReset = new JMenuItem("Reset");// Сбросить
		jmOptions.addSeparator();
		jmOptions.add(jmiReset);
		// И наконец, ввести все выбираемые меню в строку меню
		jmb.add(jmOptions);
		// создать меню Help
		JMenu jmHelp = new JMenu("Help");// Справка
		ImageIcon aboutIcon = new ImageIcon("D:\\java-dev\\git\\courses\\Swing\\bin\\about_icon.png");
		JMenuItem jmiAbout = new JMenuItem("About");// Опрограмме

		jmiAbout.setIcon(aboutIcon);
		jmiAbout.setHorizontalAlignment(SwingConstants.RIGHT);
		jmiAbout.setToolTipText("About this programm....");

		jmHelp.add(jmiAbout);
		jmb.add(jmHelp);
		// ввести приемники действий от пунктов меню
		jmiOpen.addActionListener(this);
		jmiClose.addActionListener(this);
		jmiSave.addActionListener(this);
		jmiExit.addActionListener(this);

		jmiHigh.addActionListener(this);
		jmiLow.addActionListener(this);
		jmiReset.addActionListener(this);
		jmiAbout.addActionListener(this);

		// загрузить изображения значков
		ImageIcon setIcon = new ImageIcon("breakpoint_new(1).png");
		ImageIcon clearIcon = new ImageIcon("breakpoint_delete(1).png");
		ImageIcon resumeIcon = new ImageIcon("breakpoint_run(1).png");
		/// создать действия
		setAct = new DebugAction("Set Breakpoint", setIcon, KeyEvent.VK_S, KeyEvent.VK_B, "Set а breakpoint.");
		// Установить точку прерывания
		clearAct = new DebugAction("Clear Breakpoint", clearIcon, KeyEvent.VK_C, KeyEvent.VK_L, "Clear а breakpoint.");
		// Очистить точку прерывания
		resumeAct = new DebugAction("Resume", resumeIcon, KeyEvent.VK_R, KeyEvent.VK_R,
				"Resume execution after breakpoint.");
		// Возобновить выполнение после точки прерывания
		// сделать первоначально недоступным вариант выбора Clear Breakpoint
		clearAct.setEnabled(false);

		// создатькнопкидляпанелиинструментов,
		// используясоответствующиедействия
		JButton jbtnSet = new JButton(setAct);
		JButton jbtnClear = new JButton(clearAct);
		JButton jbtnResume = new JButton(resumeAct);
		// создатьпанельинструментовDeЬuq
		JToolBar jtb = new JToolBar("Breakpoiпts");
		// ввестикнопкинапанелиинструментов
		jtb.add(jbtnSet);
		jtb.add(jbtnClear);
		jtb.add(jbtnResume);
		// ввести панель инструментов в северном расположении панели содержимого
		jfrm.add(jtb, BorderLayout.NORTH);
		// создать подменю Debug, входящее в меню Options,
		// используя действия для создания пунктов этого подменю

		JMenu jmDebug = new JMenu("Debug");
		JMenuItem jmiSetBP = new JMenuItem(setAct);
		JMenuItem jmiClearBP = new JMenuItem(clearAct);
		JMenuItem jmiResume = new JMenuItem(resumeAct);
		jmDebug.add(jmiSetBP);
		jmDebug.add(jmiClearBP);
		jmDebug.add(jmiResume);
		jmOptions.add(jmDebug);

		// ввести метку на панели содержимого
		jfrm.add(jlab);
		// ввести строку меню во фрейм
		jfrm.setJMenuBar(jmb);
		// отобразитьфрейм
		jfrm.setVisible(true);

	}

	// обработать событиядействия от пунктов меню
	public void actionPerformed(ActionEvent ae) {
		// получить команду действия из выбранного меню
		String comStr = ae.getActionCommand();
		// выйти из программы, если пользователь выберет пункт меню Exit
		if (comStr.equals("Exit"))
			System.exit(0);
		// отобразить в противном случае результат выбора из меню
		jlab.setText(comStr + " Selected");// Выбрано указанное
	}

	public static void main(String args[]) {
		// создать фрейм в потоке диспетчеризации событий
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new JMenuToolbarDemoWithAction();
			}
		});
	}

	// Класс действий для подменю и панели инструментов Debug
	class DebugAction extends AbstractAction {

		public DebugAction(String name, Icon image, int mnem, int accel, String tTip) {
			super(name, image);
			putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(accel, InputEvent.CTRL_DOWN_MASK));
			putValue(MNEMONIC_KEY, new Integer(mnem));
			putValue(SHORT_DESCRIPTION, tTip);
		}

		// обработать события как на панели инструментов, так и в подменю Debug
		public void actionPerformed(ActionEvent ae) {
			String comStr = ae.getActionCommand();
			jlab.setText(comStr + " Selected"); // Выбрано указанное
			// изменить разрешенное состояние вариантов выбора
			// режимов установки и очистки точек прерывания
			if (comStr.equals("Set Breakpoint")) {
				clearAct.setEnabled(true);
				setAct.setEnabled(false);
			} else if (comStr.equals("Clear Breakpoint")) {
				clearAct.setEnabled(false);
				setAct.setEnabled(true);
			}
		}
	}

}