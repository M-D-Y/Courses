
//Продемонстрировать свойства и события
import java.awt.*;
import java.beans.*;

public class IntrospectorDemo {

	public static void main(String args[]) {
		try {
			Class<?> c = Class.forName("Colors");
			BeanInfo beanInfo = Introspector.getBeanInfo(c);
			System.out.println("Cвoйcтвa: ");
			PropertyDescriptor propertyDescriptor[] = beanInfo.getPropertyDescriptors();
			for (int i = 0; i < propertyDescriptor.length; i++)
				System.out.println("\t" + propertyDescriptor[i].getName());
			System.out.println("Coбытия: ");
			EventSetDescriptor eventSetDescriptor[] = beanInfo.getEventSetDescriptors();
			for (int i = 0; i < eventSetDescriptor.length; i++)
				System.out.println("\t" + eventSetDescriptor[i].getName());
		} catch (Exception е) {
			System.out.println("Пepexвaчeнo событие." + е);
		}
	}
}