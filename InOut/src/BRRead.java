import java.io.*;


public class BRRead {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader( new InputStreamReader(System.in) );
		char c = 0;
		System.out.println("Нажмите q для выхода");
		do {
			try {
				c = (char) br.read();
				System.out.println(c);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (c != 'q');

	}

}
