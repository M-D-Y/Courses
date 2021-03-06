/*
 * Created on 09.07.2006
 *
 * 
 */
package com.asw.rmi.ex1;

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
	public void addNewCard(String personName, String card) throws RemoteException {
		
		hash.put(card, new Double(0.0));
	}

	/* (non-Javadoc)
	 * @see com.asw.rmi.ex1.BillingService#addMoney(java.lang.String, double)
	 */
	public void addMoney(String card, double money) throws RemoteException {
		Double d = (Double)hash.get(card);
		
		if (d!=null) hash.put(card,new Double(d.doubleValue()+money));
		else throw new NotExistsCardOperation();
	}

	/* (non-Javadoc)
	 * @see com.asw.rmi.ex1.BillingService#subMoney(java.lang.String, double)
	 */
	public void subMoney(String card, double money) throws RemoteException {
		Double d = (Double)hash.get(card);
				
		if (d!=null) hash.put(card,new Double(d.doubleValue()-money));
		else throw new NotExistsCardOperation();
	}
	
	public double getCardBalance(String card) throws RemoteException{
		Double d = (Double)hash.get(card);
		if (d!=null) return d.doubleValue();
		else throw new NotExistsCardOperation();
	};
	
	public static void main (String[] args) throws Exception {
		System.out.println("Initializing BillingService...");
		BillingService service = new BillingServiceImpl();
		String serviceName = "rmi://localhost/BillingService";
		Naming.rebind(serviceName, service);
	}

}
