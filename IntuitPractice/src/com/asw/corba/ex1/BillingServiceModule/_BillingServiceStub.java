package com.asw.corba.ex1.BillingServiceModule;


/**
* com/asw/corba/ex1/BillingServiceModule/_BillingServiceStub.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from com/asw/corba/ex1/BillingService.idl
* 16 ���� 2006 �. 14:12:21 MSD
*/

public class _BillingServiceStub extends org.omg.CORBA.portable.ObjectImpl implements com.asw.corba.ex1.BillingServiceModule.BillingService
{

  public void addNewCard (String personName, String card)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("addNewCard", true);
                $out.write_string (personName);
                $out.write_string (card);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                addNewCard (personName, card        );
            } finally {
                _releaseReply ($in);
            }
  } // addNewCard

  public void addMoney (String card, double money)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("addMoney", true);
                $out.write_string (card);
                $out.write_double (money);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                addMoney (card, money        );
            } finally {
                _releaseReply ($in);
            }
  } // addMoney

  public void subMoney (String card, double money)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("subMoney", true);
                $out.write_string (card);
                $out.write_double (money);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                subMoney (card, money        );
            } finally {
                _releaseReply ($in);
            }
  } // subMoney

  public double getCardBalance (String card)
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("getCardBalance", true);
                $out.write_string (card);
                $in = _invoke ($out);
                double $result = $in.read_double ();
                return $result;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                return getCardBalance (card        );
            } finally {
                _releaseReply ($in);
            }
  } // getCardBalance

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:BillingServiceModule/BillingService:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.Object obj = org.omg.CORBA.ORB.init (args, props).string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
     String[] args = null;
     java.util.Properties props = null;
     String str = org.omg.CORBA.ORB.init (args, props).object_to_string (this);
     s.writeUTF (str);
  }
} // class _BillingServiceStub
