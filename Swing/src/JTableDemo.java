
//Продемонстрировать применение компонента JLaЬle
import java.awt.*;
import javax.swing.*;

/*
<applet code="JTaЬleDemo" width=400 height=200>
</applet>
*/

public class JTableDemo extends JApplet {
	public void init() {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					makeGUI();
				}
			});
		} catch (Exception ехс) {
			System.out.println("Can't create because of " + ехс);
			// Нельзя создать по указанной причине
		}
	}

	private void makeGUI() {
		// инициализировать заголовки столбцов
		String[] colHeads = { "Name", "Extension", "ID#" };
		// Имя, добавочный номер телефона, идентификационный номер
		// инициализировать данные
		Object[][] data = { { "Gail", "4567", "865" }, { "Ken", "7566", "555" }, { "Viviane", "5634", "587" },
				{ "Melanie", "7345", "922" }, { "Anne", "1237", "333" }, { "John", "5656", "314" },
				{ "Matt", "5672", "217" }, { "Claire", "6741", "444" }, { "Erwin", "9023", "519" },
				{ "Ellen", "//34", "532" }, { "Jennifer", "5689", "//2" }, { "Ed", "9030", "133" },
				{ "Helen", "6751", "145" } };
		// создать таблицу
		JTable table = new JTable(data, colHeads);
		// ввести таблицу на панели с полосами прокрутки
		JScrollPane jsp = new JScrollPane(table);
		// ввести панель с полосами прокрутки на панели содержимого
		add(jsp);
	}
}