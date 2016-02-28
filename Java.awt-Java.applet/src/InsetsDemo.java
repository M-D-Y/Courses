
//Продемонстрировать применение граничной компоновки со вставками
import java.awt.*;
import java.applet.*;
import java.util.*;

/*
<applet code="IпsetsDemo" width=400 height=200>
</applet>
*/
public class InsetsDemo extends Applet {
	public void init() {
		// задать цвет фона, чтобы легко различать вставки
		setBackground(Color.cyan);
		setLayout(new BorderLayout());
		add(new Button("This is across the top."), BorderLayout.NORTH);
		// Кнопка, размещаемая сверху по ширине окна
		add(new Label("The footer message might go here."));
		// Здесь размещается нижний колонтитул для вывода сообщений
		add(new Button("Right"), BorderLayout.EAST);
		add(new Button("Left"), BorderLayout.WEST);
		String msg = "The reasonable man adapts" + "himself to the world;\n" + "the unreasonable one persists in"
				+ "trying to adapt the world to himself.\n" + "Therefore all progress depends"
				+ "on the unreasonable man.\n\n" + "        -GeorgeBernardShaw\n\n";
		add(new TextArea(msg), BorderLayout.CENTER);
	}

	// добавить вставки

	public Insets getInsets() {
		return new Insets(10, 10, 10, 10);
	}

}