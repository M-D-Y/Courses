
//Пример простого Swing-anлeтa
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

//Этот код HTML можно использовать для запуска аплета:
/*
 <applet code="SwingAppletDemo" width=220 height=90>
</applet>
*/

public class SwingAppletDemo extends JApplet {
	JButton jbtnAlpha;
	JButton jbtnBeta;
	JLabel jlab;

	// инициализировать аплет
	public void init() {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					makeGUI();// инициализировать ГПИ
				}
			});
		} catch (Exception ехс) {
			System.out.println("Can't create because of " + ехс);
			// Нельзя создать из-за исключения указанного типа
		}
	}

	// В этом аплете не нужно переопределять методы
	// start(),stop() или destroy()
	// настроить иинициализировать ГПИ
	private void makeGUI() {
		// установить для аплета диспетчер поточной компоновки
		setLayout(new FlowLayout());
		// создать две кнопки
		jbtnAlpha = new JButton("Alpha");
		jbtnBeta = new JButton("Beta");
		// ввести приемник действия от кнопки Alpha
		jbtnAlpha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				jlab.setText("Alpha was pressed.");
				// Нажата кнопка Alpha
			}
		});
		// ввести приемник действия от кнопки Веtа
		jbtnBeta.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ae) {
				jlab.setText("Beta was pressed.");
				// Нажата кнопка Веtа
			}
		});

		// ввести кнопки на панели содержимого
		add(jbtnAlpha);
		add(jbtnBeta);
		// создать текстовую метку
		jlab = new JLabel("Press а button.");
		// Метка "Нажмите кнопку."
		// ввести метки на панели содержимого
		add(jlab);
	}
}