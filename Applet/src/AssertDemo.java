
public class AssertDemo {

	static int val = 3;

	// возвратить целочисленное значение
	static int getnum() {
		return val--;
	}

	public static void main(String args[]) {
		int n = 0;
		for (int i = 0; i < 10; i++) {
			assert (n = getnum()) > 0;
			//assert n > 0 : "n отрицательное число"; // не nодтвердится, если n == О
			System.out.println("n  равно " + n);

		}
	}
}