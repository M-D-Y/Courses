
//Продемонстрировать применение компонента JList
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

/*
<applet code="JListDemo" width=200 height=120>
</applet>
*/
public class JListDemo extends JApplet {
	JList<String> jlst;
	JLabel jlab;
	JScrollPane jscrlp;
	// создать массив из названий городов
	String Cities[] = { "NewYork", "Chicago", "Houston", "Denver", "LosAngeles", "Seattle", "London", "Paris",
			"NewDelhi", "HongKong", "Tokyo", "Sydney" };

	public void init() {
		try {
			SwingUtilities.invokeAndWait(new Runnable() {
				public void run() {
					makeGUI();
				}
			});
		} catch (Exception exc) {
			System.out.println("Can't create because of " + exc);
			// Нельзя создать по указанной причине
		}
	}

	private void makeGUI() {
		// изменить поточную компоновку
		setLayout(new FlowLayout());
		// создать список на основе компонента типа JList
		jlst = new JList<String>(Cities);
		// задать режим выбора единственного элемента из списка
		jlst.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		// ввести список на панели с полосами прокрутки
		jscrlp = new JScrollPane(jlst);
		// задать предпочтительные размеры панели с полосами прокрутки
		jscrlp.setPreferredSize(new Dimension(120, 90));
		// создать метку для отображения выбранного города
		jlab = new JLabel("Choose а City");// Выбор города

		// ввести приемник событий выбора из списка
		jlst.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent le) {
				// получить индекс измененного элемента
				int idx = jlst.getSelectedIndex();

				// отобразить сделанный выбор, если элемент был выбран из списка
				if (idx != -1)
					jlab.setText("Curreпt selection: " + Cities[idx]);
				// Текущий выбор: указанный город
				else // В противном случае еще раз предложить выбрать город из
						// списка
					jlab.setText("Choose а City");// Выбор города

			}
		});
		// ввестисписокиметкунапанелисодержимого
		add(jscrlp);
		add(jlab);
	}

}