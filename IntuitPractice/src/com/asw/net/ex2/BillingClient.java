/*
 * Created on 09.07.2006
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

import java.net.*;
import java.util.Date;
import java.io.*;

public class BillingClient {

	int serverPort = 7896;
	String serverName;
	Socket s;
	ObjectInputStream ois;
	ObjectOutputStream oos;

	public BillingClient(String serverName) {
		this.serverName = serverName;
	}

	public void startTest() throws IOException {
		connectToServer();

		// processCard(new Card("Piter",new Date(),"1",0.0));
		// processCard(new Card("Stefan",new Date(),"2",0.0));
		// processCard(new Card("Nataly",new Date(),"3",0.0));

		Card[] cards = { new Card("Piter", new Date(), "1", 0.0), new Card("Stefan", new Date(), "2", 0.0),
				new Card("Nataly", new Date(), "3", 0.0) };
		processCard(cards);

		int cnt = 30000;
		CardOperation[] co = new CardOperation[cnt];
		for (int i = 0; i < cnt; i++) {
			switch (i % 3) {
			case 0:
				co[i] = new CardOperation("1", 1, new Date());
				break;
			case 1:
				co[i] = new CardOperation("2", 2, new Date());
				break;
			case 2:
				co[i] = new CardOperation("3", 3, new Date());
				break;
			}
		}
		processOperation(co);
		try {
			System.out.println("getCard: " + getCard("1"));
			System.out.println("getCard: " + getCard("2"));
			System.out.println("getCard: " + getCard("3"));
		} catch (IOException e1) {
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		java.lang.Object sync = new java.lang.Object();
		synchronized (sync) {
			try {
				sync.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	void connectToServer() throws UnknownHostException, IOException {
		s = new Socket(serverName, serverPort);
		System.out.println("connection established\n");
		ois = new ObjectInputStream(s.getInputStream());
		oos = new ObjectOutputStream(s.getOutputStream());
		System.out.println("Stream`s done \n ois=" + ois + "\n oos=" + oos);
	}

	void processOperation(CardOperation[] co) throws IOException {
		System.out.println(co);
		oos.writeObject(co);
	}

	void processCard(Card[] c) throws IOException {
		for(int i=0; i<c.length; i++) System.out.println("processCard: c=" + c[i]);
		oos.writeObject(c);
	}

	Card getCard(String card) throws IOException, ClassNotFoundException {
		oos.writeObject(card);
		return (Card) ois.readObject();
	}

	public static void main(String[] args) throws Exception {
		String serverhost = (args != null && args.length > 0 && !args[0].isEmpty()) ? args[0] : "localhost";
		BillingClient bc = new BillingClient(serverhost);
		try {
			bc.startTest();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
