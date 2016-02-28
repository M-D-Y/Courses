
//Продемонстрировать применение текстовой области
import java.awt.*;
import java.applet.*;

/*
<appletcode="TextAreaDemo"width=ЗOOheight=250>
</applet>
*/
public class TextAreaDemo extends Applet {
	public void init() {
		String val = "Java 8 is the latest version of the most\n"
				+ "widely-used computer language for Internet programming.\n"
				+ "Building on а rich heritage, Java has advanced both\n"
				+ "the art and science of computer language design.\n\n"
				+ "One of the reasons for Java's on going success is its\n"
				+ "constant, steady rate of evolution. Java has never stood\n"
				+ "still. Instead, Java has consistently adapted to the\n"
				+ "rapidly changing landscape of the networked world.\n"
				+ "More over, Java has often led the way, chart in gthe\n" + "course for others to follow.";
		TextArea text = new TextArea(val, 10, 30);
		add(text);
	}
}