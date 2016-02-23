
class DoubleDemo {
	public static void main(String args[]) {
		Double dl = new Double(3.14159);
		Double d2 = new Double("314159E-5");
		System.out.println(dl + "=" + d2 + "->" + dl.equals(d2));
	}
}