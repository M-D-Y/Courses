//Изменить порядок следования символов в объекте
//типа StringВUffer с помощью метода reverse()
class ReverseDemo {
	public static void main(String args[]) {
		StringBuffer s = new StringBuffer("abcdef");
		System.out.println(s);
		s.reverse();
		System.out.println(s);
	}
}