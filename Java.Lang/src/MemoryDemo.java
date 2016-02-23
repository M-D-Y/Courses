//Продемонстрировать применение методов totalМemory(),
//freeМemory() и qc()
class MemoryDemo {
	public static void main(String args[]) {
		Runtime r = Runtime.getRuntime();
		long mem1, mem2;
		Integer someints[] = new Integer[1000];
		System.out.println("Bceгo памяти: " + r.totalMemory());
		mem1 = r.freeMemory();
		System.out.println("Cвoбoднoй памяти исходно: " + mem1);
		r.gc();
		mem1 = r.freeMemory();
		System.out.println("Cвoбoднoй памяти после очистки: " + mem1);
		for (int i = 0; i < 1000; i++)
			someints[i] = new Integer(i);// выделить память для объектов типа
											// Inteqer
		mem2 = r.freeMemory();
		System.out.println("Cвoбoднoй памяти после выделения: " + mem2);
		System.out.println("Иcпoльзoвaнo памяти для выделения: " + (mem1 - mem2));
		// отбросить Integers
		for (int i = 0; i < 1000; i++)
			someints[i] = null;
		r.gc();// запустить сборку "мусора"
		mem2 = r.freeMemory();
		System.out.println("Cвoбoднoй памяти после очистки " + "отвергнутых объектов типа Integer: " + mem2);
	}
}