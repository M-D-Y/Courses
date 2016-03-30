/*
 * Created on 01.10.2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.asw.net.ex2;

/**
 * @author Alexey Svistunov
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import java.io.*;
import java.util.*;
public class ex {

	public static void main(String[] args) {
		FileInputStream fis;
		try {
			fis = new FileInputStream("t.tmp");
			ObjectInputStream ois = new ObjectInputStream(fis);
			int i = ois.readInt();
			System.out.println(i);
	        String today = (String) ois.readObject();
	        System.out.println(today);
	        Date date = (Date) ois.readObject();
	        System.out.println(date);

	        ois.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}catch (ClassNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
			
		

	}
}
