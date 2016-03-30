package com.asw.corba.ex3;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;

public class BillingServiceServer {

	public static void main(String args[]) {
		try {
			// create and initialize the ORB
			ORB orb = ORB.init(args, null);

			// create servant and register it with the ORB
			BillingServiceImpl BSRef = new BillingServiceImpl(orb);
			orb.connect(BSRef);

			System.out.println(BSRef);

			org.omg.CORBA.Object objRef = orb
					.resolve_initial_references("NameService");
			NamingContext ncRef = NamingContextHelper.narrow(objRef);

			// bind the Object Reference in Naming
			//make sure there are no spaces between ""
			NameComponent nc = new NameComponent("BillingService", "");
			NameComponent path[] = { nc };
			ncRef.rebind(path, BSRef);

			java.lang.Object sync = new java.lang.Object();
			synchronized (sync) {
				sync.wait();
			}

		} catch (Exception e) {
			System.err.println("ERROR: " + e);
			e.printStackTrace(System.out);
		}
	}
}