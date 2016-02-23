//Продемонстрировать применение метод аappend()
class AppendDemo {
	public static void main(String args[]) {
		
/*		String str1 = "У кота ";
		String str2 = " лапы";
		int paws = 4;
		StringBuffer sb = new StringBuffer(20);
		sb.append(str1).append(paws).append(str2);
		System.out.println(sb.toString());
		*/
		
		String s;
		int a = 42;
		StringBuffer sb = new StringBuffer(40);
		s = sb.append("a = ").append(a).append("!").toString();
		System.out.println(s);
	}
}