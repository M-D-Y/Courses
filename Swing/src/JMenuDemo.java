
//Продемонстрировать простое главное меню
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JMenuDemo implements ActionListener {
	JLabel jlab;

	JMenuDemo() {
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
		// создатьменюOptions
		JMenu jmOptions = new JMenu("Options");// Параметры
		// создатьnодменюColors
		JMenu jmColors = new JMenu("Colors");// Цвета
		JMenuItem jmiRed = new JMenuItem("Red");// Красный
		JMenuItem jmiGreen = new JMenuItem("Green");// Зеленый
		JMenuItem jmiBlue = new JMenuItem("Blue");// Синий
		jmColors.add(jmiRed);
		jmColors.add(jmiGreen);
		jmColors.add(jmiBlue);
		jmOptions.add(jmColors);
		// создать подменю Priority
		JMenu jmPriority = new JMenu("Priority");// Приоритет
		JMenuItem jmiHigh = new JMenuItem("High");// высокий
		JMenuItem jmiLow = new JMenuItem("Low");// Низкий
		jmPriority.add(jmiHigh);
		jmPriority.add(jmiLow);
		jmOptions.add(jmPriority);
		// создатьпунктменюReaet
		JMenuItem jmiReset = new JMenuItem("Reset");// Сбросить
		jmOptions.addSeparator();
		jmOptions.add(jmiReset);
		// И наконец, ввести все выбираемые меню в строку меню
		jmb.add(jmOptions);
		// создать меню Help
		JMenu jmHelp = new JMenu("Help");// Справка
		ImageIcon aboutIcon = new ImageIcon("about_icon.png");
		JMenuItem jmiAbout = new JMenuItem("About", aboutIcon);// Опрограмме
		JLabel iconLabel = new JLabel("JLabel");
		iconLabel.setIcon(aboutIcon);
		iconLabel.setBounds(0, 0, 300, 300);
		jfrm.add(iconLabel);
		jlab.setIcon(aboutIcon);
		
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
		// обработать событиядействия от пунктов меню
	

	}

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
				new JMenuDemo();
			}
		});
	}
}