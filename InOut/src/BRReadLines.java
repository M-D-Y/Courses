import java.io.*;

public class BRReadLines {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		
System.out.println("Наберите 'стоп' для выхода");
do {
	try {
		str = br.readLine();
		System.out.println(str);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
} while (!str.equals("стоп"));
	}

}
