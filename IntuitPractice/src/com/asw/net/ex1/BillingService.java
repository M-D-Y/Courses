/*
 * Created on 01.10.2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.asw.net.ex1;

/**
 * @author Alexey Svistunov
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
/*
 * 
 * public void addNewCard(String personName, String card) throws RemoteException;
	public void addMoney(String card, double money) throws RemoteException;
	public void subMoney(String card, double money) throws RemoteException;
	public double getCardBalance(String card) throws RemoteException;
 * 
 * 
 * */
import java.net.*;
import java.util.Hashtable;
import java.io.*;

public class BillingService extends Thread {
	public static final int ADD_NEW_CARD = 1;
	public static final int ADD_MONEY = 2;
	public static final int SUB_MONEY = 3;
	public static final int GET_CARD_BALANCE = 4;
	public static final int EXIT_CLIENT = 5;

	private int serverPort = 7896;
	private ServerSocket ss;
	private Hashtable hash;

	public static void main(String[] args) {
		BillingService bs = new BillingService();
		bs.start();
	}

	public BillingService() {
		hash = new Hashtable();
	}

	public void run() {
		try {
			ss = new ServerSocket(serverPort);
			System.out.println("Server started");
			while (true) {
				Socket s = ss.accept();
				System.out.println("Client accepted");
				BillingClientService bcs = new BillingClientService(this, new DataInputStream(s.getInputStream()),
						new DataOutputStream(s.getOutputStream()));
				bcs.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void addNewCard(String personName, String card) {
		hash.put(card, new Double(0.0));
	}

	public void addMoney(String card, double money) {
		Double d = (Double) hash.get(card);
		if (d != null)
			hash.put(card, new Double(d.doubleValue() + money));

	}

	public void subMoney(String card, double money) {
		Double d = (Double) hash.get(card);
		if (d != null)
			hash.put(card, new Double(d.doubleValue() - money));

	}

	public double getCardBalance(String card) {
		Double d = (Double) hash.get(card);
		if (d != null)
			return d.doubleValue();
		return 0;
	}



}
