import java.io.*;

public class ShowFile2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i;
		String fileName = "Test.txt";
		FileInputStream fi = null;
		
		try {
			 fi = new FileInputStream(fileName);
			 do {
				 i = fi.read();
				 System.out.println((char) i);
			 } while (i != -1);
			 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fi!=null) fi.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	}

}
