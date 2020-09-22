package services;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/class")
public class SenderService {

    //Here we create connection
    @Resource(lookup = "jms/myQueueConnectionFactory")
    QueueConnectionFactory queueConnectionFactory;

    //Here we get the queue object
    @Resource(lookup = "myQueue")
    Queue queue;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{myMessage}")
    public Response sendMessage(@PathParam("myMessage") String myMessage) {


        try {
            //Here we start a connection
            QueueConnection queueConnection = queueConnectionFactory.createQueueConnection();
            queueConnection.start();

            //Here we create a queue session
            QueueSession queueSession = queueConnection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);

            //Here we create the queue sender object
            QueueSender sender = queueSession.createSender(queue);

            //Here we create a text message object
            TextMessage textMessage = queueSession.createTextMessage();

            //Here we write the message
            textMessage.setText(myMessage);

            //Here we send the message
            sender.send(textMessage);
            System.out.println("Message successfully sent.");

            //Here we close the connection
            queueConnection.close();
        } catch (JMSException e) {
            e.printStackTrace();
        }

        return Response.status(Response.Status.OK).entity("The message from the PathParam was sended to the Queue!").build();
    }
}
