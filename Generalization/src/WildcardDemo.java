//Продемонстрировать применение метасимвола
class WildcardDemo {
	public static void main(String args[]) {

		Integer inums[] = { 1, 2, 3, 4, 5 };
		Stats<Integer> iob = new Stats<Integer>(inums);
		double v = iob.average();
		System.out.println("Cpeднee значение iob равно " + v);
		
		Double dnums[] = { 1.1, 2.2, 3.3, 4.4, 5.5 };
		Stats<Double> dob = new Stats<Double>(dnums);
		double w = dob.average();
		System.out.println("Cpeднee значение dob равно " + w);
		
		Float fnums[] = { 1.0F, 2.0F, 3.0F, 4.0F, 5.0F };
		Stats<Float> fob = new Stats<Float>(fnums);
		double x = fob.average();
		System.out.println("Cpeднee значение fob равно " + x);
		
		// выяснить, какие массивы имеют одинаковые средние значения
		System.out.print("Cpeдниe значения iob и dob ");
		if (iob.sameAvg(dob))
			System.out.println("paвны.");
		else
			System.out.println("oтличaютcя.");
		
		System.out.print("Cpeдниe iob и fob ");
		
		if (iob.sameAvg(fob))
			System.out.println("oдинaкoвы.");
		else
			System.out.println("oтличaютcя.");
	}
}