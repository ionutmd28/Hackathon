package queue;

import javax.jms.*;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MyReceiver {
    public static void main(String[] args) {
        try {
            //Here we create and start the connection
            InitialContext initialContext = new InitialContext();
            QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) initialContext
                    .lookup("myQueueConnectionFactory");
            QueueConnection queueConnection = queueConnectionFactory.createQueueConnection();

            //Here we create a queue session
            QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

            //Here we get the queue object
            Queue queue = (Queue) initialContext.lookup("myQueue");

            //Here we create the queue receiver
            QueueReceiver queueReceiver = queueSession.createReceiver(queue);

            //Here we create the listener object
            MyListener myListener = new MyListener();

            //Here we register the listener
            queueReceiver.setMessageListener(myListener);

            System.out.println("Reciver1 is ready, waiting for messages...");
            System.out.println("Press Ctrl+c to shutdown...");

            while (true) {
                Thread.sleep(1000);
            }

        } catch (NamingException | JMSException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
