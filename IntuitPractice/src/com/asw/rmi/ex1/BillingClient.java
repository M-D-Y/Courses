/*
 * Created on 09.07.2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.asw.rmi.ex1;

/**
 * @author Alexey Svistunov
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
import java.rmi.*;

public class BillingClient {

	public static void main(String[] args) throws Exception {
		String hostname = (args != null && args.length > 0 && !args[0].isEmpty()) ? args[0] : "localhost";
		String objectName = "rmi://" + hostname + "/BillingService";
		BillingService bs = (BillingService) Naming.lookup(objectName);
		bs.addNewCard("Piter", "1");
		bs.addNewCard("Stefan", "2");
		bs.addNewCard("Nataly", "3");
		for (int i = 0; i < 1000; i++) {
			bs.addMoney("1", i % 10);
			bs.addMoney("2", i % 20);
			bs.addMoney("3", i % 30);
		}

		System.out.println("1:" + bs.getCardBalance("1"));
		System.out.println("2:" + bs.getCardBalance("2"));
		System.out.println("3:" + bs.getCardBalance("3"));

	}
}
