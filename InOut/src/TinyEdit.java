import java.io.*;

public class TinyEdit {

	public static void main(String[] args) {
		String str[] = new String[100];
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Введите текст или 'стоп' для отмены");
		for(int i=0; i<100; i++){
			try {
				str[i] = br.readLine();
				if (str[i].equals("стоп")) break;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		System.out.println("Был набран текст:");
		for (int i = 0; i < str.length; i++) {
			if (str[i].equals("стоп")) break;
			System.out.println(str[i]);
		}
	}

}
