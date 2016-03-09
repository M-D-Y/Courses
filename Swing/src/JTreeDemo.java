
//Продемонстрировать применение компонента типа JТree
import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;
import javax.swing.tree.*;

/*
<applet code="JTreeDemo" width=400 height=200>
</applet>
*/
public class JTreeDemo extends JApplet {
	JTree tree;
	JLabel jlab;

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
		// создать самый верхний узел дерева
		DefaultMutableTreeNode top = new DefaultMutableTreeNode("Options");
		// создать поддерево "А"
		DefaultMutableTreeNode a = new DefaultMutableTreeNode("A");
		top.add(a);
		DefaultMutableTreeNode a1 = new DefaultMutableTreeNode("Al");
		a.add(a1);
		DefaultMutableTreeNode a2 = new DefaultMutableTreeNode("A2");
		a.add(a2);
		// создать поддерево "В"
		DefaultMutableTreeNode b = new DefaultMutableTreeNode("B");
		top.add(b);
		DefaultMutableTreeNode b1 = new DefaultMutableTreeNode("Bl");
		b.add(b1);
		DefaultMutableTreeNode b2 = new DefaultMutableTreeNode("B2");
		b.add(b2);
		DefaultMutableTreeNode b3 = new DefaultMutableTreeNode("BЗ");
		b.add(b3);
		// создать дерево
		tree = new JTree(top);
		// ввести дерево на панели прокрутки
		JScrollPane jsp = new JScrollPane(tree);
		// ввести панель с полосами прокрутки на панели содержимого
		add(jsp);
		// ввести метку на панели содержимого
		jlab = new JLabel();
		add(jlab, BorderLayout.SOUTH);
		// обработать события выбора узлов дерева
		tree.addTreeSelectionListener(new TreeSelectionListener() {
			public void valueChanged(TreeSelectionEvent tse) {
				jlab.setText("Selection is " + tse.getPath());
				// Выбран узел дерева по указанному пути
			}
		});
	}
}