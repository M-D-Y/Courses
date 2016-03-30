/*
 * Created on 16.07.2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.asw.corba.ex1;

/**
 * @author Alexey Svistunov
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */

import java.util.Hashtable;
import com.asw.corba.ex1.BillingServiceModule.*;

import org.omg.CORBA.*;



public class BillingServiceImpl  extends BillingServicePOA {
  private ORB orb;
  private	Hashtable hash = new Hashtable();
	

  public void setORB(ORB orb_val) {
    orb = orb_val; 
  }


public void addNewCard(String personName, String card) {
	// TODO Auto-generated method stub
	hash.put(card, new Double(0.0));
}

/* (non-Javadoc)
 * @see com.asw.corba.ex1.BillingServiceModule.BillingServiceOperations#addMoney(java.lang.String, double)
 */
	public void addMoney(String card, double money) {
		// TODO Auto-generated method stub
		synchronized (hash) {
			Double d = (Double) hash.get(card);

			if (d != null)
				hash.put(card, new Double(d.doubleValue() + money));
			//else throw new NotExistsCardOperation();
		}
	}

/* (non-Javadoc)
 * @see com.asw.corba.ex1.BillingServiceModule.BillingServiceOperations#subMoney(java.lang.String, double)
 */
public void subMoney(String card, double money) {
	// TODO Auto-generated method stub
	Double d = (Double)hash.get(card);
	
	if (d!=null) hash.put(card,new Double(d.doubleValue()-money));
	//else throw new NotExistsCardOperation();
}

/* (non-Javadoc)
 * @see com.asw.corba.ex1.BillingServiceModule.BillingServiceOperations#getCardBalance(java.lang.String)
 */
public double getCardBalance(String card) {
	// TODO Auto-generated method stub
	Double d = (Double)hash.get(card);
	if (d!=null) return d.doubleValue();
	else return 0;
	//else throw new NotExistsCardOperation();
}
  
  
}

