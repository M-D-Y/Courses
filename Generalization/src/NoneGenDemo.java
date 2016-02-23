
public class NoneGenDemo {

	public static void main(String[] args) {
		NoneGen iOb;
		
		iOb = new NoneGen(88);
		iOb.showType();

		int v = (Integer) iOb.getObject();
		System.out.println("Значение: " + v);
		System.out.println();

		NoneGen strOb = new NoneGen("Тест без обобщений");
		strOb.showType();
		String str = (String) strOb.getObject();
		System.out.println("Значение: " + str);

		// Этот код компилируется, но он принципиально неверный
		iOb = strOb;
		v = (Integer) iOb.getObject(); // Ошибка во время выполнения

	}

}
