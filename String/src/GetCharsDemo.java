class getCharsDemo {
	
	public static void main(String args[]) {
		String s = "Это демонстрация метода getChars().";
		int start = 4;
		int end = 8;
		char buf[] = new char[end - start];
		s.getChars(start, end, buf, 0);
		System.out.println(buf);
	}
	
}