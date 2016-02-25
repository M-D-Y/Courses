
//Продемонстрировать применение меток
import java.awt.*;
import java.applet.*;
/*
<appletcode="LabelDemo"width=ЗOOheight=200>
</applet>
*/

public class LabelDemo extends Applet {

	public void init() {
		Label one = new Label("One");
		Label two = new Label("Two");
		Label three = new Label("Three");
		// ввести метки в окне аплета
		add(one);
		add(two);
		add(three);
	}
}