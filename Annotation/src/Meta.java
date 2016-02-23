import java.lang.annotation.*;
import java.lang.reflect.*;

//Объявление типа аннотации
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno {
	String str();

	int val();
}

class Meta {

	// аннотировать метод
	@MyAnno(str = "Пример аннотации", val = 100)
	public static void myMeth() {
		Meta ob = new Meta();
		// получить аннотацию из метода
		// и вывести значения ее членов
		try {
			// сначала получить объект типа Class,
			// представляющий данный класс
			Class<?> c = ob.getClass();
			// затем получить объект типа Мethod,
			// представляющий данный метод
			Method m = c.getMethod("myMeth");

			// далее получить аннотацию для данного класса
			MyAnno anno = m.getAnnotation(MyAnno.class);

			// инаконец, вывести значения членов аннотации
			System.out.println(anno.str() + " " + anno.val());
		} catch (NoSuchMethodException ехс) {
			System.out.println("Meтoд не найден.");
		}
	}

	public static void main1(String args[]) {
		String ob = new String();

		// получить аннотацию из метода
		// и вывести значения ее членов
		try {
			// сначала получить объект типа Class,
			// представляющий данный класс
			Class<?> c = ob.getClass();
			// затем получить объект типа Мethod,
			// представляющий данный метод
			Method m = c.getMethod("toLowerCase");

			// далее получить аннотацию для данного класса
			Annotation anno[] = m.getAnnotations();
			for (Annotation a : anno) {
				System.out.print(a.toString());
			}

		} catch (NoSuchMethodException ехс) {
			System.out.println("Meтoд не найден.");
		}
	}

	public static void main2(String args[]) {
		myMeth();
	}

	public static void main(String args[]) {
		main1(args);
	}
}