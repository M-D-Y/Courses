/*
 * Created on 09.07.2006
 *
 * 
 */
package com.asw.rmi.ex2;

import java.rmi.*;
import java.util.*;
import java.rmi.server.*;

/**
 * @author Administrator
 *
 * 
 */
public class BillingServiceImpl extends UnicastRemoteObject implements BillingService {

	/* (non-Javadoc)
	 * @see com.asw.rmi.ex1.BillingService#addNewCard(java.lang.String)
	 */
	private	Hashtable hash;
	public BillingServiceImpl() throws RemoteException{
		super();
		hash = new Hashtable();
	}
	public void addNewCard(Card card) throws RemoteException {
		
		hash.put(card.cardNumber, card);
	}

	/* (non-Javadoc)
	 * @see com.asw.rmi.ex1.BillingService#addMoney(java.lang.String, double)
	 */
	public void processOperations(CardOperation[] operations) throws RemoteException {
		for (int i=0;i<operations.length;i++){
			Card c = (Card)hash.get(operations[i].card);
			if (c==null) throw new NotExistsCardOperation();
			c.balance+=operations[i].amount;
			hash.put(operations[i].card,c);
		}
	}

	
	
	public Card getCard(String card) throws RemoteException{
		Card c = (Card)hash.get(card);
		return c; 
	};
	
	public static void main (String[] args) throws Exception {
		System.out.println("Initializing BillingService...");
		BillingService service = new BillingServiceImpl();
		String serviceName = "rmi://localhost/BillingService";
		Naming.rebind(serviceName, service);
	}

}
