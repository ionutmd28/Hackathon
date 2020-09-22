package queue;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class MySender {
    public static void main(String[] args) {

        try {
            Properties p = new Properties();
            String conFact = "com.sun.enterprise.naming.SerialInitContextFactory";
            p.setProperty(Context.INITIAL_CONTEXT_FACTORY, conFact);
            //Here we create and start a connection
            InitialContext initialContext = new InitialContext();
            QueueConnectionFactory queueConnectionFactory = (QueueConnectionFactory) initialContext.lookup("myQueueConnectionFactory");
            QueueConnection queueConnection = queueConnectionFactory.createQueueConnection();
            queueConnection.start();

            //Here we create a queue session
            QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

            //Here we get the queue object
            Queue queue = (Queue) initialContext.lookup("myQueue");

            //Here we create the queue sender object
            QueueSender sender = queueSession.createSender(queue);

            //Here we create a text message object
            TextMessage textMessage = queueSession.createTextMessage();

            //Here we write the message
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                System.out.println("Enter message, end to terminate:");
                String s = bufferedReader.readLine();
                if(s.equals("end")) {
                    break;
                }
                textMessage.setText(s);

                //Here we send the message
                sender.send(textMessage);
                System.out.println("Message successfully sent.");
            }

            //Here we close the connection
            queueConnection.close();
        } catch (NamingException | JMSException | IOException e) {
            e.printStackTrace();
        }


    }
}
