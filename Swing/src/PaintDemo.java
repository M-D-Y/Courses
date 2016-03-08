
//Рисовать линии на панели
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

//Этот класс расширяет класс JPanel. В нем переопределяется
//метод paintComponent(), чтобы произвольно рисовать линии на панели
class PaintPanel extends JPanel {
	Insets ins; // служит для хранения размеров границ панели
	Random rand; // служит для генерирования случайных чисел

	// создать панель
	PaintPanel() {
		// разместить рамку вокруг панели, определив ее границы
		setBorder(BorderFactory.createLineBorder(Color.RED, 5));
		rand = new Random();
	}

	// переопределить метод paintCoшponent()
	protected void paintComponent(Graphics g) {
		// вызывать всегда первым метод из суперкласса
		super.paintComponent(g);
		int x, y, x2, y2;
		// получить высоту и ширину компонента
		int height = getHeight();
		int width = getWidth();
		// получить размеры границ панели
		ins = getInsets();
		// нарисовать десять линий, конечные точки которых формируются
		// произвольно
		for (int i = 0; i < 10; i++) {
			// получить произвольные координаты, определяюще конечные точки
			// каждой линии
			x = rand.nextInt(width - ins.left);
			y = rand.nextInt(height - ins.bottom);
			x2 = rand.nextInt(width - ins.left);
			y2 = rand.nextInt(height - ins.bottom);
			// нарисовать линию
			g.drawLine(x, y, x2, y2);
		}
	}
}

// продемонстрировать рисование непосредственно на панели
public class PaintDemo {
	JLabel jlab;
	PaintPanel pp;

	PaintDemo() {
		// создать новый контейнер типа Jpanel
		JFrame jfrm = new JFrame("PaintDemo");
		// задать исходные размеры фрейма
		jfrm.setSize(200, 150);
		// завершить приложение, если пользователь закроет его окно
		jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// создать панель для рисования
		pp = new PaintPanel();
		// Ввести эту панель на панели содержимого. В данном
		// случае применяется граничная компоновка, поэтому
		// размеры панели будут автоматически подгоняться таким
		// образом, чтобы она заняла центральную область
		jfrm.add(pp);
		// отобразить фрейм
		jfrm.setVisible(true);
	}

	public static void main(String args[]) {
		// создать фрейм в потоке диспетчеризации событий
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new PaintDemo();
			}
		});

	}
}