package services;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/receiverClass")
public class ReceiverService {

    //Here we create connection
    @Resource(lookup = "jms/myQueueConnectionFactory")
    QueueConnectionFactory queueConnectionFactory;

    //Here we get the queue object
    @Resource(lookup = "myQueue")
    Queue queue;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendMessage() {


        try {
            //Here we create and start the connection
            QueueConnection queueConnection = queueConnectionFactory.createQueueConnection();

            //Here we create a queue session
            QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

            //Here we create the queue receiver
            QueueReceiver queueReceiver = queueSession.createReceiver(queue);

            queueConnection.start();

            //Here we get the message from the receiver
            TextMessage textMessage = (TextMessage) queueReceiver.receive();

            String message = textMessage.getText();

            queueConnection.stop();

            return Response.status(Response.Status.OK).entity("Here is the message:" + message).build();

        } catch (JMSException e) {
            e.printStackTrace();
        }

        return Response.status(Response.Status.OK).entity("FAILED!").build();
    }
}
