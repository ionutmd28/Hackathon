package queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class MyListener  implements MessageListener {
    @Override
    public void onMessage(Message message) {
        try {
            TextMessage textMessage = (TextMessage) message;

            System.out.println("following message is recived:" + textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
