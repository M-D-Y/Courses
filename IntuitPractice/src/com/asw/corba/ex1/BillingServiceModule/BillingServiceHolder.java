package com.asw.corba.ex1.BillingServiceModule;

/**
* com/asw/corba/ex1/BillingServiceModule/BillingServiceHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.1"
* from com/asw/corba/ex1/BillingService.idl
* 16 ���� 2006 �. 14:12:21 MSD
*/

public final class BillingServiceHolder implements org.omg.CORBA.portable.Streamable
{
  public com.asw.corba.ex1.BillingServiceModule.BillingService value = null;

  public BillingServiceHolder ()
  {
  }

  public BillingServiceHolder (com.asw.corba.ex1.BillingServiceModule.BillingService initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = com.asw.corba.ex1.BillingServiceModule.BillingServiceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    com.asw.corba.ex1.BillingServiceModule.BillingServiceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return com.asw.corba.ex1.BillingServiceModule.BillingServiceHelper.type ();
  }

}
