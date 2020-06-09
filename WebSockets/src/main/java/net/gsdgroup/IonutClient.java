package net.gsdgroup;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class IonutClient {

    public void myClientMethod() throws URISyntaxException, IOException, DeploymentException {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        Session userSession = container.connectToServer(ClientEndp.class, new URI("ws://localhost:8080/WebSockets/chat/ionut"));

        ClientEndp client = new ClientEndp();

        client.open(userSession);
    }
}

