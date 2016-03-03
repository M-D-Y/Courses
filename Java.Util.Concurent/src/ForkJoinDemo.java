
//Простой пример реализации стратегии "разделяй и властвуй".
//В данном примере применяется класс RecurвiveAction
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

//Класс ForkJoinTask преобразует (через класс RecuraiveAction}
//значения элементов массива типа double в их квадратные корни
class SqrtTransform extends RecursiveAction {

	// В данном примере пороговое значение произвольно устанавливается
	// равным 1000. В реальном коде его оптимальное значение может
	// быть определено в результате профилирования исполняющей системы
	// или экспериментально
	final int seqTreshHold = 1000;
	// обрабатываемый массив
	double[] data;
	// определить часть обрабатываемых данных
	int start, end;

	SqrtTransform(double[] vals, int s, int е) {
		data = vals;
		start = s;
		end = е;
	}

	// Этот метод выполняет параллельное вычисление
	protected void compute() {
		// Если количество элементов меньше порогового значения,
		// выполнить дальнейшую обработку последовательно
		if ((end - start) < seqTreshHold) {
			// преобразовать значение каждого элемента массива
			// в его квадратный корень
			for (int i = start; i < end; i++) {
				data[i] = Math.sqrt(data[i]);
			}
		} else {
			// в противном случае продолжить разделение данных на
			// меньшие части
			// найтис ередину
			int middle = (start + end) / 2;
			// запустить новые подзадачи на выполнение, используя
			// разделенные на части данные
			invokeAll(new SqrtTransform(data, start, middle), new SqrtTransform(data, middle, end));
		}
	}
}

// продемонстрировать параллельное выполнение
public class ForkJoinDemo {
	public static void main(String args[]) {
		// создать пул задач
		final ForkJoinPool fjp = new ForkJoinPool();

		double[] nums = new double[100000];
		// присвоить некоторые значения
		for (int i = 0; i < nums.length; i++)
			nums[i] = (double) i;
		System.out.println("Чacть исходной последовательности: ");

		for (int i = 0; i < 10; i++)
			System.out.print(nums[i] + "");
		System.out.println("\n");

		SqrtTransform task = new SqrtTransform(nums, 0, nums.length);
		// запустить главную задачу типа ForkJoinTask на выполнение
		fjp.invoke(task);
		System.out.println("Чacть преобразованной последовательности "
				+ "(с точностью до четырех знаков после десятичной точки):");

		for (int i = 0; i < 10; i++)
			System.out.format("%.4f", nums[i]);
		System.out.println();
	}
}