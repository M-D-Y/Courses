//Продемонстрировать применение метода insert()

class IпsertDemo {
	
	public static void main(String args[]) {
		StringBuffer sb = new StringBuffer("Mнe Java!");
		sb.insert(4, "нравится ");
		System.out.println(sb);
	}
	
}