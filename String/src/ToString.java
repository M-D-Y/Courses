//Переопределить метод toString() в классе Вох
class Вох {

	double width;
	double height;
	double depth;

	Вох(double w, double h, double d) {
		width = w;
		height = h;
		depth = d;
	}

	public String toString() {
		return "Размеры " + width + " на " + depth + " на " + height + ".";
	}
}

class toStringDemo {
	public static void main(String args[]) {
		Вох b = new Вох(10, 12, 14);
		String s = "Объект типа Вох: " + b;// выполнить сцепление
		// символьной строки с объектом типа Вох
		System.out.println(b);// преобразовать объект типа ВОх
		// в символьную строку при выводе
		System.out.println(s);
	}
}