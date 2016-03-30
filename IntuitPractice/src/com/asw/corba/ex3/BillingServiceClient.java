package com.asw.corba.ex3;

import org.omg.CosNaming.*;
import org.omg.CORBA.*;

public class BillingServiceClient {
	org.omg.CORBA.Object BSImpl;

	ORB orb;

	void testAddNewCard(String personName, String card) {
		org.omg.CORBA.Request r2 = BSImpl._request("addNewCard");
		r2.set_return_type(orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
		org.omg.CORBA.Any inc = r2.add_in_arg();
		inc.insert_string(personName);
		org.omg.CORBA.Any inc2 = r2.add_in_arg();
		inc2.insert_string(card);

		// call the Hello server object and print results
		r2.invoke();
		java.lang.Exception ex = r2.env().exception();
		if (ex instanceof org.omg.CORBA.UnknownUserException) {
			org.omg.CORBA.UnknownUserException userEx = (org.omg.CORBA.UnknownUserException) ex;
		}

	}

	void testAddMoney(String card, double amount) {
		org.omg.CORBA.Request r2 = BSImpl._request("addMoney");
		r2.set_return_type(orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
		org.omg.CORBA.Any inc = r2.add_in_arg();
		inc.insert_string(card);
		org.omg.CORBA.Any inc2 = r2.add_in_arg();
		inc2.insert_double(amount);

		// call the Hello server object and print results
		r2.invoke();
		java.lang.Exception ex = r2.env().exception();
		if (ex instanceof org.omg.CORBA.UnknownUserException) {
			org.omg.CORBA.UnknownUserException userEx = (org.omg.CORBA.UnknownUserException) ex;
		}
		String result;
	}

	void testSubMoney(String card, double amount) {
		org.omg.CORBA.Request r2 = BSImpl._request("subMoney");
		r2.set_return_type(orb.get_primitive_tc(org.omg.CORBA.TCKind.tk_void));
		org.omg.CORBA.Any inc = r2.add_in_arg();
		inc.insert_string(card);
		org.omg.CORBA.Any inc2 = r2.add_in_arg();
		inc2.insert_double(amount);

		// call the Hello server object and print results
		r2.invoke();
		java.lang.Exception ex = r2.env().exception();
		if (ex instanceof org.omg.CORBA.UnknownUserException) {
			org.omg.CORBA.UnknownUserException userEx = (org.omg.CORBA.UnknownUserException) ex;
		}
		String result;
	}

	double testGetCardBalance(String card) {
		org.omg.CORBA.Request r2 = BSImpl._request("getCardBalance");
		r2
				.set_return_type(orb
						.get_primitive_tc(org.omg.CORBA.TCKind.tk_double));
		org.omg.CORBA.Any inc = r2.add_in_arg();
		inc.insert_string(card);

		// call the Hello server object and print results
		r2.invoke();
		java.lang.Exception ex = r2.env().exception();
		if (ex instanceof org.omg.CORBA.UnknownUserException) {
			org.omg.CORBA.UnknownUserException userEx = (org.omg.CORBA.UnknownUserException) ex;
		}
		double result;
		result = r2.return_value().extract_double();
		System.out.println("Balance= " + result);
		return result;
	}

	public void doTest(String args[]) throws Exception {
		orb = ORB.init(args, null);
		org.omg.CORBA.Object objRef = orb
				.resolve_initial_references("NameService");
		NamingContext ncRef = NamingContextHelper.narrow(objRef);

		// resolve the Object Reference in Naming
		// make sure there are no spaces between ""
		NameComponent nc = new NameComponent("BillingService", "");
		NameComponent path[] = { nc };
		BSImpl = ncRef.resolve(path);
		System.out.println(BSImpl);
		this.testAddNewCard("Ivan", "1");
		this.testAddMoney("1", 10.2);
		this.testGetCardBalance("1");
		this.testSubMoney("1", 8.1);
		this.testGetCardBalance("1");
	}

	public static void main(String args[]) {
		try {
			BillingServiceClient bsc = new BillingServiceClient();
			bsc.doTest(args);
		} catch (Exception e) {
			System.out.println("ERROR : " + e);
			e.printStackTrace(System.out);
		}
	}
}

