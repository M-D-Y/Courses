package com.asw.jms.ex1;

import javax.jms.*;
import javax.annotation.Resource;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Enumeration;


public class BillingService {
    @Resource(mappedName = "jms/ConnectionFactory")
    private static ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/Queue")
    private static Queue queue;

    Hashtable hash = new Hashtable();
    public void addNewCard(Card c) {
	hash.put(c.cardNumber, c);		
    };
    public void performCardOperation(CardOperation co){
	Card c = (Card)hash.get(co.card);
	if (c==null) return;
	c.balance+=co.amount;
	hash.put(co.card,c);

    };
    public void printCards(){
    	for(Enumeration e = hash.elements();e.hasMoreElements();)
		System.out.println(e.nextElement());
    }


    public static void main(String[] args) {
        String destType = null;
        Connection connection = null;
        Session session = null;
        Destination dest = (Destination) queue;
        MessageConsumer consumer = null;
        ObjectListener listener = null;
        TextMessage message = null;

        InputStreamReader inputStreamReader = null;
        char answer = '\0';

        try {
            connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            consumer = session.createConsumer(dest);
            listener = new ObjectListener(new BillingService());
            consumer.setMessageListener(listener);
            connection.start();
            System.out.println(
                    "To end program, type Q or q, " + "then <return>");
            inputStreamReader = new InputStreamReader(System.in);

            while (!((answer == 'q') || (answer == 'Q'))) {
                try {
                    answer = (char) inputStreamReader.read();
                } catch (IOException e) {
                    System.err.println("I/O exception: " + e.toString());
                }
            }
        } catch (JMSException e) {
            System.err.println("Exception occurred: " + e.toString());
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e) {
                }
            }
        }
    }
}
