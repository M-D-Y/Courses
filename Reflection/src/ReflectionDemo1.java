
//Продемонстрировать применение рефлексии
import java.lang.reflect.*;

public class ReflectionDemo1 {
	public static void main(String args[]) {
		int i;
		try {
			Class<?> c = Class.forName("java.awt.Dimension");
			System.out.println("Koнcтpyктopы: ");
			Constructor constructors[] = c.getConstructors();
			for (i = 0; i < constructors.length; i++) {
				System.out.println(" " + constructors[i]);
			}
			System.out.println("Пoля: ");
			Field fields[] = c.getFields();
			for (i = 0; i < fields.length; i++) {
				System.out.println(" " + fields[i]);
			}
			System.out.println("Meтoды: ");
			Method methods[] = c.getMethods();
			for (i = 0; i < methods.length; i++) {
				System.out.println(" " + methods[i]);
			}
		} catch (Exception е) {
			System.out.println("Иcключeниe: " + е);
		}
	}
}