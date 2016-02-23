
//Продемонстрировать применение метода replace()
public class ReplaceDemo {
	public static void main(String args[]) {
		StringBuffer sb = new StringBuffer("Этo простой тест.");
		sb.replace(4, 11, "был");
		System.out.println("Пocлe замены: " + sb);
	}
}