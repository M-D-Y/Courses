
//Продемонстрировать применение класса StrinqТokenizer
import java.util.StringTokenizer;

class StringTokenizerDemo {
	static String in = "Название=Jаvа. Полное руководство;" + 
			"Автор=Шилдт;" + 
			"Издательство=МсGrаw-Нill;"	+ 
			"Авторское право=2014";

	public static void main(String args[]) {
		StringTokenizer st = new StringTokenizer(in, "=;");
		while (st.hasMoreTokens()) {
			String key = st.nextToken();
			String val = st.nextToken();
			System.out.println(key + "\t" + val);
		}
	}
}