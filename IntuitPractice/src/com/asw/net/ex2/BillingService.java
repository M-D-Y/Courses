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




public class BillingService extends Thread{
		
	private int serverPort = 7896;
	private ServerSocket ss;
	private	Hashtable hash;
	
	public static void main(String[] args) {
		BillingService bs = new BillingService();
		bs.start();
	}
	public BillingService(){
		hash = new Hashtable();
	}
	public void run(){
		try {
			ss = new ServerSocket(serverPort);
			System.out.println("Server started");
			while(true){
				System.out.println("new client waiting...");
				Socket s = ss.accept();
				System.out.println("Client accepted");
				BillingClientService bcs = new BillingClientService(this,s);
				System.out.println("bcs created");
				bcs.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	public void addNewCard(Card card) {
		hash.put(card.cardNumber, card);
	}
	public void addMoney(String card, double money) {
		Card c = (Card)hash.get(card);
		if (c==null) {
			System.out.println("Bad Card number\n");
			return;
		};
		c.balance+=money;
		hash.put(card,c);
	}
	public Card getCard(String card){
		return (Card)hash.get(card);
	}
	
}
