package com.asw.corba.ex3;

import java.util.*;
import org.omg.CORBA.*;

// servant must extend DynamicImplementation
class BillingServiceImpl extends DynamicImplementation {

	// store the repository ID for the implemented interface
	static String[] myIDs = { "IDL:JavaIDL/DSIBillingService:1.0" };

	ORB orb;

	Hashtable hash;

	// create a reference to the ORB
	BillingServiceImpl(ORB orb) {
		this.orb = orb;
		hash = new Hashtable();
	}

	// must implement invoke() for handling requests
	public void invoke(ServerRequest request) {
		try {
			System.out.println("DSI: invoke called, op = " + request.op_name());
			if (request.op_name().equals("addNewCard") == true) {
				/*String personName, String card*/
				NVList nvlist = orb.create_list(0);
				Any any1 = orb.create_any();
				any1.insert_string("");
				nvlist.add_value("arg1", any1, ARG_IN.value);

				Any any2 = orb.create_any();
				any2.insert_string("");
				nvlist.add_value("arg2", any2, ARG_IN.value);

				// pass the NVList to the request to get values
				request.params(nvlist);

				addNewCard(nvlist.item(0).value().extract_string(), nvlist
						.item(1).value().extract_string());
				TypeCode result_tc = orb.get_primitive_tc(TCKind.tk_void);
				Any result_any = orb.create_any();
				result_any.type(result_tc);

				request.result(result_any);
			} else if (request.op_name().equals("addMoney") == true) {
				/*String card, double money*/
				NVList nvlist = orb.create_list(0);
				Any any1 = orb.create_any();
				any1.insert_string("");
				nvlist.add_value("arg1", any1, ARG_IN.value);

				Any any2 = orb.create_any();
				any2.insert_double(0);
				nvlist.add_value("arg2", any2, ARG_IN.value);

				// pass the NVList to the request to get values
				request.params(nvlist);

				addMoney(nvlist.item(0).value().extract_string(), nvlist
						.item(1).value().extract_double());
				TypeCode result_tc = orb.get_primitive_tc(TCKind.tk_void);
				Any result_any = orb.create_any();
				result_any.type(result_tc);

				request.result(result_any);
			} else if (request.op_name().equals("subMoney") == true) {
				/*String card, double money*/
				NVList nvlist = orb.create_list(0);
				Any any1 = orb.create_any();
				any1.insert_string("");
				nvlist.add_value("arg1", any1, ARG_IN.value);

				Any any2 = orb.create_any();
				any2.insert_double(0);
				nvlist.add_value("arg2", any2, ARG_IN.value);

				// pass the NVList to the request to get values
				request.params(nvlist);

				subMoney(nvlist.item(0).value().extract_string(), nvlist
						.item(1).value().extract_double());
				TypeCode result_tc = orb.get_primitive_tc(TCKind.tk_void);
				Any result_any = orb.create_any();
				result_any.type(result_tc);

				request.result(result_any);
			} else if (request.op_name().equals("getCardBalance") == true) {
				/*String card, double money*/
				NVList nvlist = orb.create_list(0);
				Any any1 = orb.create_any();
				any1.insert_string("");
				nvlist.add_value("arg1", any1, ARG_IN.value);

				// pass the NVList to the request to get values
				request.params(nvlist);

				double d = getCardBalance(nvlist.item(0).value()
						.extract_string());
				TypeCode result_tc = orb.get_primitive_tc(TCKind.tk_double);
				Any result_any = orb.create_any();
				result_any.insert_double(d);
				request.result(result_any);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("DSIExample: Exception thrown: " + ex);
		}
	}

	// implement an _ids method to return repository ID of interface
	public String[] _ids() {
		return myIDs;
	}

	public void addNewCard(String personName, String card) {
		// TODO Auto-generated method stub
		hash.put(card, new Double(0.0));
	}

	public void addMoney(String card, double money) {
		// TODO Auto-generated method stub
		synchronized (hash) {
			Double d = (Double) hash.get(card);
			if (d != null)
				hash.put(card, new Double(d.doubleValue() + money));
			//else throw new NotExistsCardOperation();
		}
	}

	public void subMoney(String card, double money) {
		// TODO Auto-generated method stub
		Double d = (Double) hash.get(card);

		if (d != null)
			hash.put(card, new Double(d.doubleValue() - money));
		//else throw new NotExistsCardOperation();
	}

	public double getCardBalance(String card) {
		// TODO Auto-generated method stub
		Double d = (Double) hash.get(card);
		if (d != null)
			return d.doubleValue();
		else
			return 0;
		//else throw new NotExistsCardOperation();
	}

}