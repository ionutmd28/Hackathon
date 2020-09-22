//package org.example;
//
//import org.apache.activemq.ActiveMQConnectionFactory;
//import org.apache.activemq.broker.BrokerFactory;
//import org.apache.activemq.broker.BrokerService;
//
//import javax.jms.*;
//import java.net.URI;
//
//public class QueueExample {
//    public static void main(String[] args) throws Exception {
//        BrokerService brokerService = BrokerFactory.createBroker(new URI("broker:(tcp://localhost:61617)"));
//        brokerService.start();
//        Connection connection = null;
//        try {
//            // Producer
//            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61617");
//            connection = connectionFactory.createConnection();
//            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
//            Queue queue = session.createQueue("customerQueue");
//            String payload = "Important Task";
//            Message msg = session.createTextMessage(payload);
//            MessageProducer producer = session.createProducer(queue);
//            System.out.println("Sendind text'" + payload + "'");
//            producer.send(msg);
//
//            // Consumer
//            MessageConsumer consumer = session.createConsumer(queue);
//            connection.start();
//            TextMessage textMessage = (TextMessage) consumer.receive();
//            System.out.println(textMessage);
//            System.out.println("Received: " + textMessage.getText());
//            session.close();
//        } finally {
//            if(connection != null) {
//                connection.close();
//            }
//            brokerService.stop();
//        }
//    }
//}
