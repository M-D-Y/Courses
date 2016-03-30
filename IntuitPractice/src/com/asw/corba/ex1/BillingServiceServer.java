/*
 * Created on 16.07.2006
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.asw.corba.ex1;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;
import com.asw.corba.ex1.BillingServiceModule.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

/**
 * @author Alexey Svistunov
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class BillingServiceServer {

		  public static void main(String args[]) {
		    try{
		      // create and initialize the ORB
		      ORB orb = ORB.init(args, null);

		      // get reference to rootpoa & activate the POAManager
		      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		      rootpoa.the_POAManager().activate();

		      // create servant and register it with the ORB
		      BillingServiceImpl BSImpl = new BillingServiceImpl();
		      BSImpl.setORB(orb); 

		      // get object reference from the servant
		      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(BSImpl);
		      BillingService href = BillingServiceHelper.narrow(ref);
			  
		      // get the root naming context
		      // NameService invokes the name service
		      org.omg.CORBA.Object objRef =
		          orb.resolve_initial_references("NameService");
		      // Use NamingContextExt which is part of the Interoperable
		      // Naming Service (INS) specification.
		      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

		      // bind the Object Reference in Naming
		      String name = "BillingService";
		      NameComponent path[] = ncRef.to_name( name );
		      ncRef.rebind(path, href);

		      System.out.println("HelloServer ready and waiting ...");

		      // wait for invocations from clients
		      orb.run();
		    } 
			
		      catch (Exception e) {
		        System.err.println("ERROR: " + e);
		        e.printStackTrace(System.out);
		      }
			  
		      System.out.println("BillingServer Exiting ...");
			
		  }



		}