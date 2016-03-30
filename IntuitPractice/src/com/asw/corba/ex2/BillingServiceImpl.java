/*
 * Created on 16.07.2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.asw.corba.ex2;

/**
 * @author Alexey Svistunov
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
//AccountManagerImpl.java
import com.asw.corba.ex2.BillingServiceModule.*;

import java.util.*;

public class BillingServiceImpl extends BillingServicePOA {
  public synchronized Card addNewCard(String personName, String cardCode) {
    // Lookup the account in the account dictionary.
    Card card = (Card) _cards.get(cardCode);
    // If there was no account in the dictionary, create one.
    if(card == null) {
      // Make up the account's balance, between 0 and 1000 dollars.
      // Create the account implementation, given the balance.
      CardImpl cardServant = new CardImpl(personName,0.0);
      try {
        // Activate it on the default POA which is root POA for this servant
        card = CardHelper.narrow(_default_POA().servant_to_reference(cardServant));
      } catch (Exception e) {
        e.printStackTrace();
      }
      // Print out the new account.
      System.out.println("Created " + cardCode + "'s account: " + card);
      // Save the account in the account dictionary.
      _cards.put(cardCode, card);
    }
    // Return the account.
    return card;
  }
  private Dictionary _cards = new Hashtable();
  private Random _random = new Random();
/* (non-Javadoc)
 * @see com.asw.corba.ex2.BillingServiceModule.BillingServiceOperations#getCard(java.lang.String)
 */
public Card getCard(String cardCode) {
	// TODO Auto-generated method stub
	Card card = (Card) _cards.get(cardCode);
	return card;
}
/* (non-Javadoc)
 * @see com.asw.corba.ex2.BillingServiceModule.BillingServiceOperations#addNewCard(java.lang.String, java.lang.String)
 */

}

