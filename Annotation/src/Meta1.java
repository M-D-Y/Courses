import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno1 {
	String str();
	int val();
}

public class Meta1{
	
	
	// у Меth() теnерь имеются два аргумента
	@MyAnno1(str = "Два параметра", val = 19)
	public static void myMeth(String str, int i) {

		Meta1 ob = new Meta1();
		try {
			Class<?> c = ob.getClass();
			// Здесь указываются типы параметров
			Method m = c.getMethod("myMeth", String.class, int.class);
			MyAnno1 anno = m.getAnnotation(MyAnno1.class);
			System.out.println(anno.str() + " " + anno.val());
		} catch (NoSuchMethodException ехс) {
			System.out.println("Meтoд не найден.");
		}
	}

	public static void main(String args[]) {
		myMeth("Tecт", 10);
	}
}
