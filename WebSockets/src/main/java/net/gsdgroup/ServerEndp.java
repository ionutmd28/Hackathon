package net.gsdgroup;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint(value = "/chat/{username}")
public class ServerEndp {

    private static Set<ServerEndp> endpoints = new CopyOnWriteArraySet<>();
    private static HashMap<String, String> users = new HashMap<>();
    private static HashMap<String, String> chatBox = new HashMap<>();
    private Session session;

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username) throws IOException, EncodeException {
        System.out.println("Opened a new session (id): " + session.getId());
        this.session = session;
        endpoints.add(this);
        session.getBasicRemote().sendText("Opened a new session for you " + session.getId() + " user: " + username);
    }

    @OnMessage
    public void onMessage(Session session, String message) throws IOException, EncodeException {
        System.out.println("### sessionId " + session.getId());
        System.out.println("### message " + message);
        for(ServerEndp serverEndp : endpoints) {
            if(serverEndp != this) {
                serverEndp.session.getBasicRemote().sendText(message);
            }
        }
    }

    @OnClose
    public void onClose(Session session) throws IOException, EncodeException {
        endpoints.remove(this);
        broadcast("Session with id:  " + session.getId() + " is now closed!");
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
    }

    private static void broadcast(String message) throws IOException, EncodeException {

        endpoints.forEach(endpoint -> {
            synchronized (endpoint) {
                try {
                    endpoint.session.getBasicRemote().sendText(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
