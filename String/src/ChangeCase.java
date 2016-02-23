//Продемонстрировать применение методов toUpperCase() и toLowerCase()
class ChangeCase {
	public static void main(String args[]) {
		String з = "Это тест.";
		System.out.println("Иcxoднaя строка: " + з);
		String upper = з.toUpperCase();
		String lower = з.toLowerCase();
		System.out.println("Bepxний регистр: " + upper);
		System.out.println("Hижний регистр: " + lower);
		System.out.println(ПолучитьРезультат());
	}
	
	static String ПолучитьРезультат(){
		return "Результат";
	}
}
