
//Продемонстрировать простое главное меню
import java.awt.*;
import java.awt.event.*;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStream;
import java.security.Permission;

import javax.swing.*;

public class JToolBarDemo implements ActionListener {
	JLabel jlab;

	JToolBarDemo() {
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
		//jfrm.setLayout(new FlowLayout());
		// задать исходные размеры фрейма
		jfrm.setSize(220, 200);
		// завершить прикладную программу, когда пользователь закроет еео кно
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// создать метку для отображения результатов выбора из меню
		jlab = new JLabel();

		
		jfrm.add(jlab, BorderLayout.CENTER);
		//создать панель инструментов Debug
		JToolBar jtb = new JToolBar("Debug");
		jtb.setSize(200, 24);
		//загрузить изображения значков кнопок
		ImageIcon set = new ImageIcon("breakpoint_new(1).png");
		ImageIcon clear = new ImageIcon("breakpoint_delete(1).png");
		ImageIcon resume = new ImageIcon("breakpoint_run(1).png");
		//создатькнопкидляпанелиинструментов
		JButton jbtnSet = new JButton(set);
		jbtnSet.setActionCommand("Set Breakpoint");
		jbtnSet.setToolTipText("Set Breakpoint");
		
		//Установить точку прерывания
		JButton jbtnClear = new JButton(clear);
		jbtnClear.setActionCommand("Clear Breakpoint");
		jbtnClear.setToolTipText("Clear Breakpoint");
		//Очиститьточкупрерывания
		JButton jbtnResume = new JButton(resume);
		jbtnResume.setActionCommand("Resume");
		jbtnResume.setToolTipText("Resume");
		//Возобновить выполнение программы
		//ввестик нопки на панели инструментов
		jtb.add(jbtnSet);
		jtb.add(jbtnClear);
		jtb.add(jbtnResume);
		//ввести панель инструментов в северном расположении напанели содержимого
		jfrm.add(jtb,BorderLayout.NORTH);
		//ввести приемники действий для панели
		jbtnSet.addActionListener(this);
		jbtnClear.addActionListener(this);
		jbtnResume.addActionListener(this);

		// ввести метку на панели содержимого
		jfrm.add(jlab);
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
				new JToolBarDemo();
			}
		});
	}
	
	
}

