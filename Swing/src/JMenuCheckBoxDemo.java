
//Продемонстрировать простое главное меню
import java.awt.*;
import java.awt.event.*;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStream;
import java.security.Permission;

import javax.swing.*;

class JMenuCheckBoxDemo implements ActionListener {
	JLabel jlab;

	JMenuCheckBoxDemo() {
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

		// создатьменюFilaсмнемоникойиоперативнЫЬIИклавишами
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

		// создать меню Options
		JMenu jmOptions = new JMenu("Options");
		// создать подменю Colors
		JMenu jmColors = new JMenu("Colors");
		// использовать флажки, чтобы пользователь мог выбрать
		// сразу несколько цветов
		JCheckBoxMenuItem jmiRed = new JCheckBoxMenuItem("Red");
		JCheckBoxMenuItem jmiGreen = new JCheckBoxMenuItem("Green");
		JCheckBoxMenuItem jmiBlue = new JCheckBoxMenuItem("Blue");
		jmColors.add(jmiRed);
		jmColors.add(jmiGreen);
		jmColors.add(jmiBlue);
		jmOptions.add(jmColors);
		// создатьподменюPriority
		JMenu jmPriority = new JMenu("Priority");
		// Использовать кнопки-переключатели для установки приоритета.
		// Благодаря этому в меню не только отображается установленный
		// приоритет, но и гарантируется установка одного и только
		// одного приоритета. Исходно выбирается кнопка-переключатель
		// в пункте меню High
		JRadioButton jmiHigh = new JRadioButton("High", true);
		JRadioButtonMenuItem jmiLow = new JRadioButtonMenuItem("Low");
		jmPriority.add(jmiHigh);
		jmPriority.add(jmiLow);
		jmOptions.add(jmPriority);
		// создать группу кнопок-переключателей в пунктах подменю Priority
		ButtonGroup bg = new ButtonGroup();
		bg.add(jmiHigh);
		bg.add(jmiLow);
		// создать пункт меню Reset
		JMenuItem jmiReset = new JMenuItem("Reset");
		jmOptions.addSeparator();
		jmOptions.add(jmiReset);
		// инаконец,ввестименюOptionsвстрокуменю
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
		jmiRed.addActionListener(this);
		jmiGreen.addActionListener(this);
		jmiBlue.addActionListener(this);
		jmiHigh.addActionListener(this);
		jmiLow.addActionListener(this);
		jmiReset.addActionListener(this);
		jmiAbout.addActionListener(this);

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
				new JMenuCheckBoxDemo();
			}
		});
	}
}