
//Показать все аннотации для класса и метода
import java.lang.annotation.*;
import java.lang.reflect.*;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnno2 {
	String str();
	int val();
}

@Retention(RetentionPolicy.RUNTIME)
@interface What {
	String description();
}

@What(description = "Аннотация тестового класса")
@MyAnno2(str = "Meta2", val = 99)

class Meta2 {

	@What(description = "Аннотация тестового метода")
	@MyAnno2(str = "Testing", val = 100)
	public static void myMeth() {
		Meta2 ob = new Meta2();

		try {
			Annotation annos[] = ob.getClass().getAnnotations();
			// вывести все аннотации для класса Меtа2
			System.out.println("Bce аннотации для класса Meta2:");
			for (Annotation a : annos)
				System.out.println(a);

			System.out.println();

			// вывести все аннотации для метода myMеth()
			Method m = ob.getClass().getMethod("myMeth");
			annos = m.getAnnotations();
			System.out.println("Bce аннотации для метода myMeth():");
			for (Annotation a : annos)
				System.out.println(a);
		} catch (NoSuchMethodException ехс) {
			System.out.println("Meтoд не найден.");
		}
	}

	public static void main(String args[]) {
		myMeth();
	}
}
