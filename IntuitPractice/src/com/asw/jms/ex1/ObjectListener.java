package com.asw.jms.ex1;

import javax.jms.*;


public class ObjectListener implements MessageListener {
    /**
     * Casts the message to a TextMessage and displays its text.
     *
     * @param message     the incoming message
     */
    BillingService bs;
    public ObjectListener (BillingService bs){
    	this.bs = bs;
    }
    public void onMessage(Message message) {
        ObjectMessage msg = null;

        try {
            if (message instanceof ObjectMessage) {
                msg = (ObjectMessage) message;
		Object o = msg.getObject();
                System.out.println("Reading message: " + o);
		if (o instanceof Card) bs.addNewCard((Card)o);
		else if (o instanceof CardOperation) bs.performCardOperation((CardOperation)o);
            } else {
                System.err.println("Message is not a ObjectMessage");
		bs.printCards();
            }
        } catch (JMSException e) {
            System.err.println("JMSException in onMessage(): " + e.toString());
        } catch (Throwable t) {
            System.err.println("Exception in onMessage():" + t.getMessage());
        }
    }
}
