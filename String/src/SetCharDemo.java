//ПродемонстрироватьприменениеметодовcharAt()иsetCharAt()
class setCharAtDemo {
	public static void main(String args[]) {
		StringBuffer sb = new StringBuffer("Hello");
		
		System.out.println("Бyфep до = " + sb);
		System.out.println("дo вызова charAt(l) = " + sb.charAt(1));
		
		sb.setCharAt(1, 'i');
		sb.setLength(2);
		
		System.out.println("Бyфep после = " + sb);
		System.out.println("пocлe вызова charAt(l) + " + sb.charAt(1));
	}
}