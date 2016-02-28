
//Продемонстрировать применение граничной компоновки
import java.awt.*;
import java.applet.*;
import java.util.*;

/*
 
<applet code="BorderLayoutDemo" width=400 height=200>
</applet>
*/
public class BorderLayoutDemo extends Applet {
	public void init() {
		setLayout(new BorderLayout());
		add(new Button("This is across the top."), BorderLayout.NORTH);
		// Кнопка, раэмещаемая сверху по всей ширине окна
		add(new Label("The footer message might go here."), BorderLayout.SOUTH);
		// Здесь размещается нижний колонтитул для вывода сообщений
		add(new Button("Right"), BorderLayout.EAST);// Кнопка справа
		add(new Button("Left"), BorderLayout.WEST);// Кнопка слева
		String msg = "The reasonable man adapts" + "himself to the world;\n" + "the unreasonable one persists in"
				+ "trying to adapt the world to himself.\n" + "Therefore all progress depends"
				+ "on the unreasonable man.\n\n" + "      - GeorgeBernardShaw\n\n";
		add(new TextArea(msg), BorderLayout.CENTER);
	}
}