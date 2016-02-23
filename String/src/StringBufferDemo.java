//Сравнить методы lenqth() и capacity() из класса StringBuffer
public class StringBufferDemo {
	public static void main(String args[]) {
		StringBuffer sb = new StringBuffer("Hello");
		System.out.println("бyфep = " + sb);
		System.out.println("длинa = " + sb.length());
		System.out.println("eмкocть = " + sb.capacity());
	}
}