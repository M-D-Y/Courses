class EqualsDemo {
	public static void main(String args[]) {
		String s1 = "Привет";
		String s2 = "Привет";
		String sЗ = "Прощай";
		String s4 = "ПРИВЕТ";
		System.out.println(s1 + " равно " + s2 + " -> " + s1.equals(s2));
		System.out.println(s1 + " равно " + sЗ + " -> " + s1.equals(sЗ));
		System.out.println(s1 + " равно " + s4 + " -> " + s1.equals(s4));
		System.out.println(s1 + " равно без учета регистра " + s4 + "->" + s1.equalsIgnoreCase(s4));
	}
}