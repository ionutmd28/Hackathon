package net.gsdgroup;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

public class Client {

    protected   WebSocketContainer container;
    
    public static void main(String[] args) throws InterruptedException, IOException, DeploymentException, URISyntaxException
    {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        Session userSession = container.connectToServer(ClientEndp.class, new URI("ws://localhost:8080/WebSockets/chat/ionut"));
        userSession.getAsyncRemote().sendText("HALLO!!!!!!");
        System.out.println(container);

        Thread.sleep(100000);
    }

}