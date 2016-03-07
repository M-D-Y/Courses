
//Пример простого Swing-приложения
import javax.swing.*;

public class SwingDemo {
	SwingDemo() {
		// создать новый контейнер типа JFrame
		JFrame jfrm = new JFrame("A Simple Swing Application");
		// Простое Swing-приложение
		// задать исходные размеры фрейма
		jfrm.setSize(275, 100);
		// завершить работу, еслипользователь закрывает приложение
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// создать метку с текстом сообщения
		JLabel jlab = new JLabel("Swing means powerful GUIs.");
		// Swing-это мощные ГПИ
		// ввести метку на панели содержимого
		jfrm.add(jlab);
		// отобразить фрейм
		jfrm.setVisible(true);
	}

	public static void main(String args[]) {
		// создать фрейм в потоке диспетчеризации событий
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new SwingDemo();
			}
		});
	}
}