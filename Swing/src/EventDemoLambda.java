
//Обработка события в Swing-приложении
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

class EventDemoLambda {
	JLabel jlab;

	EventDemoLambda() {
		// создать новый контейнер типа JFrame
		JFrame jfrm = new JFrame("An Event Example");
		// Пример обработки событий
		// определить диспетчер поточной компоновки типа FlowLayout
		jfrm.setLayout(new FlowLayout());
		// установить исходные размеры фрейма
		jfrm.setSize(220, 90);
		// завершить работу приложения, если пользователь закрывает его окно
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// создать две кнопки
		JButton jbtnAlpha = new JButton("Alpha");
		JButton jbtnBeta = new JButton("Beta");
		// ввести nриемник действий от кнопки Alpha
		jbtnAlpha.addActionListener((ae) -> jlab.setText(ae.getActionCommand() + " was pressed."));

		// ввести приемник действий от кнопки Bеtа
		jbtnBeta.addActionListener((ae) -> jlab.setText(ae.getActionCommand() + " was pressed."));

		// ввести кнопки напанели содержимого
		jfrm.add(jbtnAlpha);
		jfrm.add(jbtnBeta);
		// создать текстовую метку
		jlab = new JLabel("Press а button.");
		// Метка "Нажмите кнопку."
		// ввести метку на панели содержимого
		jfrm.add(jlab);
		// отобразить фрейм
		jfrm.setVisible(true);
	}

	public static void main(String args[]) {
		// создать фрейм в потоке диспетчеризации событий
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new EventDemoLambda();
			}
		});
	}
}