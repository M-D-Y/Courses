/*
 * Created on 16.07.2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.asw.corba.ex2;

import com.asw.corba.ex2.BillingServiceModule.*;

/**
 * @author Alexey Svistunov
 * 
 * TODO To change the template for this generated type comment go to Window -
 * Preferences - Java - Code Style - Code Templates
 */
//AccountImpl.java
public class CardImpl extends CardPOA {

	public CardImpl(String personName,double balance) {
		_personName = personName;
		_balance = balance;
	}

	private double _balance;
	private String _personName;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asw.corba.ex2.BillingServiceModule.CardOperations#addMoney(double)
	 */
	public void addMoney(double money) {
		_balance += money;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.asw.corba.ex2.BillingServiceModule.CardOperations#subMoney(double)
	 */
	public void subMoney(double money) {
		_balance -= money;

	}

	/* (non-Javadoc)
	 * @see com.asw.corba.ex2.BillingServiceModule.CardOperations#getBalance()
	 */
	public double getBalance() {
		// TODO Auto-generated method stub
		return _balance;
	}
}

