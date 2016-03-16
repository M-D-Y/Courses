
//Класс сведений о компоненте JavaBean
import java.beans.*;

public class ColorsBeanInfo extends SimpleBeanInfo {
	public PropertyDescriptor[] getPropertyDescriptors() {
		try {
			PropertyDescriptor rectangular = new PropertyDescriptor("rectangular", Colors.class);
			PropertyDescriptor pd[] = { rectangular };
			return pd;
		} catch (Exception е) {
			System.out.println("Пepexвaчeнo событие. " + е);
			return null;
		}
	}
}