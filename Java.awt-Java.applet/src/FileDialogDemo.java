
/*Продемонстрировать применение диалогового окна выбора файлов.
Это-прикладная программа, а не аnлет.
*/
import java.awt.*;
import java.awt.event.*;

//создать подкласс, производный от класса Frame
class FileDialogDemoFrame extends Frame {
	FileDialogDemoFrame(String title) {
		super(title);
		// удалить окно после его закрытия
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});
	}


}

// Продемонстрировать применение класса FileDialog
public class FileDialogDemo {
	public static void main(String args[]) {
		// создать обрамляющее окно, которому будет принадлежать диалоговое окно
		Frame f = new FileDialogDemoFrame("FileDialogDemo");
		f.setVisible(true);
		f.setSize(100, 100);
		FileDialog fd = new FileDialog(f, "FileDialog");
		fd.setVisible(true);
	}
}