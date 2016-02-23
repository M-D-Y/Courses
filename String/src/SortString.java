//Пузырьковая сортировка объектов типа String
class SortString {
	static String arr[] = { "Now", "is", "the", "time", "for", "all", "good", "men", "to", "соте", "to", "the", "aid",
			"of", "their", "country" };

	public static void main(String args[]) {
		String arr_i = null, arr_j = null;

		for (int j = 0; j < arr.length; j++) {
			for (int i = j + 1; i < arr.length; i++) {
				arr_i = arr[i];
				arr_j = arr[j];
				if (arr[i].compareTo(arr[j]) < 0) {
					String t = arr[j];
					arr[j] = arr[i];
					arr[i] = t;
				}
			}
			System.out.println(arr[j]);
		}
	}
}