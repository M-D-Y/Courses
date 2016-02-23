//Измерение времени выполнения программы
class Elapsed {
	public static void main(String args[]) {
		long start, end;
		System.out.println("Измерение времени перебора от 0 до 100000000");
		// измерить время перебора от 0 до 100000000
		start = System.currentTimeMillis();// получить начальный момент времени
		for (long i = 0; i < 1000000001; i++)
			;
		end = System.currentTimeMillis();// получить конечный момент времени
		System.out.println("Bpeмя выполнения по currentTimeMillis: " + (end - start) + " мс");
		
		start=System.nanoTime();//получить начальный момент времени
		for(long i=0; i<1000000001; i++);
		end=System.nanoTime();//получить конечный момент времени
		System.out.println("Bpeмя выполнения по nanoTime: " + (end - start) + " нс");
	}
}