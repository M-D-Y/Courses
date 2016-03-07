
//Простой пример применения класса RecursiveTask<V>
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.*;

//класс RecursiveTask, используемый для вычисления суммы
//значений элементов в массиве типа double
class RecursiveTaskDemoSum extends RecursiveTask<Double> {
	// Пороговое значение последовательного выполнения
	final int seqThresHold = 500;
	// Обрабатываемый массив
	double[] data;
	// определить часть обрабатываемых данных
	int start, end;

	RecursiveTaskDemoSum(double[] vals, int s, int e) {
		data = vals;
		start = s;
		end = e;
	}

	// определить сумму значений элементов в массиве типа double
	protected Double compute() {
		double sum = 0;
		// Если количество элементов ниже порогового значения,
		// то выполнить далее обработку последовательно
		if ((end - start) < seqThresHold) {
			// суммировать значения элементов в массиве типа double
			for (int i = start; i < end; i++)
				sum += data[i];
		} else {
			// В противном случае продолжить разделение данных на меньшие части
			// найти середину
			int middle = (start + end) / 2;
			// запустить новые подзадачи на выполнение, используя разделенные на
			// части данные
			RecursiveTaskDemoSum subTaskA = new RecursiveTaskDemoSum(data, start, middle);
			RecursiveTaskDemoSum subTaskB = new RecursiveTaskDemoSum(data, middle, end);
			// запустить каждую подзадачу путем разветвления
			subTaskA.fork();
			subTaskB.fork();
			// ожидатьзавершенияподзадачинакопитьрезультаты
			sum = subTaskA.join() + subTaskB.join();

			// Имеются и другие способы асинхронного выполнения подзадач.
			// Например, в следующем фрагменте кода метод fork() вызывается 
			// для запуска подзадачи subTaskA, а метод invoke() - для запуска
			// и ожидания завершения подзадачи subTaskB:
			//subTaskA.fork();
			//sum = subTaskA.join() + subTaskB.invoke();
			// В качестве еще одного варианта можно непосредственно вызвать
			// метод compute() для подзадачи subTaskB, как показано ниже.
			//subTaskA.fork();
			//sum = subTaskA.join() + subTaskB.compute();
		}
		// возвратить конечную сумму
		return sum;
	}
}

// Продемонстрировать параллельное выполнение
class RecursiveTaskDemo {
	public static void main(String args[]) {
		// создать пул задач
		ForkJoinPool fjp = new ForkJoinPool();
		double[] nums = new double[5000];
		// инициализировать массив nums чередующимися
		// положительными и отрицательными значениями
		for (int i = 0; i < nums.length; i++)
			nums[i] = (double) (((i % 2) == 0) ? i : -i);
		RecursiveTaskDemoSum task = new RecursiveTaskDemoSum(nums, 0, nums.length);
		// Запустить задачи типа ForkJoinTask. Обратите
		// внимание на то, что в данном случае метод invoke() возвращает
		// результат
		double summation = fjp.invoke(task);
		System.out.println("Cyммиpoвaниe " + summation);
	}
}