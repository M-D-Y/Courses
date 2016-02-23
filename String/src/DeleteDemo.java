//Продемонстрировать применение методов delete() и deleteCharAt()
class DeleteDemo {
	public static void main(String args[]) {
		StringBuffer sb = new StringBuffer("Этo простой тест.");
		sb.delete(3, 11);
		System.out.println("Пocлe вызова delete(): " + sb);
		sb.deleteCharAt(0);
		System.out.println("Пocлe вызова deleteCharAt(): " + sb);
	}
}