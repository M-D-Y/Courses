package com.asw.jms.ex1;


import javax.jms.*;
import javax.annotation.Resource;
import java.util.Date;


public class BillingClient {
    @Resource(mappedName = "jms/ConnectionFactory")
    private static ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/Queue")
    private static Queue queue;

    public static void main(String[] args) {
        Connection connection = null;

        Destination dest = (Destination) queue;

        try {
            connection = connectionFactory.createConnection();

            Session session = connection.createSession(
                        false,
                        Session.AUTO_ACKNOWLEDGE);

            MessageProducer producer = session.createProducer(dest);
            ObjectMessage message = session.createObjectMessage();
	    

	    Card c = new Card ("Piter",new Date(),"1",0.0);
            message.setObject(c);
	    producer.send(message);
            c = new Card("Stefan",new Date(),"2",0.0);
            message.setObject(c);
	    producer.send(message);
            c = new Card("Nataly",new Date(),"3",0.0);
            message.setObject(c);
	    producer.send(message);

            int cnt = 1000;
            for (int i = 0; i < cnt; i++) {
		CardOperation co = new CardOperation ((i%3+1)+"",10+i,new Date());
                message.setObject(co);
                System.out.println("Sending message: " + message.getObject());
                producer.send(message);
            }
            /*
             * Send a non-text control message indicating end of
             * messages.
             */
            producer.send(session.createMessage());
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
