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
//Client.java
import org.omg.CosNaming.*;
import com.asw.corba.ex2.BillingServiceModule.*;

public class BillingServiceClient {

  public static void main(String[] args) {
    try {
      // Initialize the ORB.
      org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);

      // Obtain the root context.
      org.omg.CORBA.Object rootObj = orb.resolve_initial_references("NameService");
      NamingContextExt root = NamingContextExtHelper.narrow(rootObj);
      System.out.println("1");
      // Locate an account manager through the Naming Service.
      // Note that casting is needed as a workaround for a JDK 1.1.x bug.
      org.omg.CORBA.Object mgrObj = ((NamingContext)root).resolve(root.to_name("BillingService"));
      System.out.println("2");
      BillingService manager =  BillingServiceHelper.narrow(mgrObj);
      System.out.println("3");
      // use args[0] as the account name, or a default.
      String name = args.length > 0 ? args[0] : "Jack";
      // Request the account manager to open a named account.
      //Card card = manager.addNewCard(name,"1");
      Card card = manager.getCard("1");
      card.addMoney(12345);
      // Get the balance of the account.
      double balance = card.getBalance();
      // Print out the balance.
      System.out.println
        ("The balance in " + name + "'s account is $" + balance);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }
}

