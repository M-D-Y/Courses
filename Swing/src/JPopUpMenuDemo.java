
//Продемонстрировать простое главное меню
import java.awt.*;
import java.awt.event.*;
import java.io.FilePermission;
import java.io.IOException;
import java.io.InputStream;
import java.security.Permission;

import javax.swing.*;

class JPopUpMenuDemo implements ActionListener {
	JLabel jlab;

	JPopUpMenuDemo() {
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

		JPopupMenu jpu;
		// создать всплывающее меню Edit
		jpu = new JPopupMenu();
		// создать пункты всплывающего меню
		JMenuItem jmiCut = new JMenuItem("Cut");
		JMenuItem jmiCopy = new JMenuItem("Copy");
		JMenuItem jmiPaste = new JMenuItem("Paste");
		// ввестипунктывовсплывающееменю
		jpu.add(jmiCut);
		jpu.add(jmiCopy);
		jpu.add(jmiPaste);
		// ввестиприемниксобытийзапускавсплывающегоменю
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
		jmiCut.addActionListener(this);
		jmiCopy.addActionListener(this);
		jmiPaste.addActionListener(this);

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
				new JPopUpMenuDemo();
			}
		});
	}
}