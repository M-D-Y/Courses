package my.test;

import java.awt.SystemColor;
import java.awt.Window;

public class WindowDemo {
	public static void main(String args[]) {
		Window w = new Window(null);
		w.setBackground(SystemColor.gray);
		w.setBounds(100, 200, 300, 600);
		w.setVisible(true);
	}
}
