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
import java.net.*;

public class BillingClientService extends Thread {
	ObjectInputStream ois;
	ObjectOutputStream oos;
	BillingService bs;
	Socket s;

	public BillingClientService(BillingService bs, Socket s) {
		System.out.println("Constructor BillingClientService\n");
		this.bs = bs;
		this.s = s;
		try {
			this.oos = new ObjectOutputStream(s.getOutputStream());
			this.ois = new ObjectInputStream(s.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//
		System.out.println("Stream`s done \n socket=" + s);
	}

	public void run() {
		System.out.println("ClientService thread started\n");
		boolean work = true;
		while (work) {
			int command;
			Object o;
			try {
				o = ois.readObject();

				// System.out.println(o);
				// System.out.println(o.getClass().getName());

				if (o instanceof Card[]) {
					Card[] cards = (Card[]) o;
					System.out.println("cards loaded. length=" + cards.length);
					for (int i = 0; i < cards.length; i++) {
						bs.addNewCard(cards[i]);
					}
				} else if (o instanceof CardOperation[]) {
					CardOperation[] co = (CardOperation[]) o;
					System.out.println("card operation loaded. length=" + co.length);
					for (int i = 0; i < co.length; i++) {
						bs.addMoney(co[i].card, co[i].amount);
					}
				} else if (o instanceof String) {
					oos.writeObject(bs.getCard((String) o));
				} else
					System.out.println("Bad operation");

			} catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

		}
	}

}
