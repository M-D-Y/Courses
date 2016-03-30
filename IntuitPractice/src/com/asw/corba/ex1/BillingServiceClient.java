/*
 * Created on 16.07.2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.asw.corba.ex1;

import com.asw.corba.ex1.BillingServiceModule.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;

/**
 * @author Alexey Svistunov
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BillingServiceClient {

	
	  static BillingService BSImpl;

	  public static void main(String args[])
	    {
	      try{
	        // create and initialize the ORB
	      	ORB orb = ORB.init(args, null);

	        // get the root naming context
	        org.omg.CORBA.Object objRef = 
		    orb.resolve_initial_references("NameService");
	        // Use NamingContextExt instead of NamingContext. This is 
	        // part of the Interoperable naming Service.  
	        NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
	 
	        // resolve the Object Reference in Naming
	        String name = "BillingService";
	        BSImpl = BillingServiceHelper.narrow(ncRef.resolve_str(name));

	        System.out.println("Obtained a handle on server object: " + BSImpl);
	        //BSImpl.addNewCard("Ivan","1");
	        BSImpl.addMoney("1",1234);
	        System.out.println(BSImpl.getCardBalance("1"));

		} catch (Exception e) {
	          System.out.println("ERROR : " + e) ;
		  e.printStackTrace(System.out);
		  }
	    }


	
}
