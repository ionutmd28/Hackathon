package org.example;

import javax.websocket.*;
import java.io.IOException;
import java.net.URI;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Set;

@ClientEndpoint
public class MyClient {

//    public MyClient(String host, int port) {
//        super();
//    }

    public static void main(String[] args) throws IOException, DeploymentException {

        final WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        String uri = "http://localhost:8080/WebSocket/chat";
        container.connectToServer(MyClient.class, URI.create(uri));

        MyClient client = new MyClient();
        Session session = new Session() {
            @Override
            public WebSocketContainer getContainer() {
                return container;
            }

            @Override
            public void addMessageHandler(MessageHandler messageHandler) throws IllegalStateException {

            }

            @Override
            public <T> void addMessageHandler(Class<T> aClass, MessageHandler.Whole<T> whole) {

            }

            @Override
            public <T> void addMessageHandler(Class<T> aClass, MessageHandler.Partial<T> partial) {

            }

            @Override
            public Set<MessageHandler> getMessageHandlers() {
                return null;
            }

            @Override
            public void removeMessageHandler(MessageHandler messageHandler) {

            }

            @Override
            public String getProtocolVersion() {
                return null;
            }

            @Override
            public String getNegotiatedSubprotocol() {
                return null;
            }

            @Override
            public List<Extension> getNegotiatedExtensions() {
                return null;
            }

            @Override
            public boolean isSecure() {
                return false;
            }

            @Override
            public boolean isOpen() {
                return false;
            }

            @Override
            public long getMaxIdleTimeout() {
                return 0;
            }

            @Override
            public void setMaxIdleTimeout(long l) {

            }

            @Override
            public void setMaxBinaryMessageBufferSize(int i) {

            }

            @Override
            public int getMaxBinaryMessageBufferSize() {
                return 0;
            }

            @Override
            public void setMaxTextMessageBufferSize(int i) {

            }

            @Override
            public int getMaxTextMessageBufferSize() {
                return 0;
            }

            @Override
            public RemoteEndpoint.Async getAsyncRemote() {
                return null;
            }

            @Override
            public RemoteEndpoint.Basic getBasicRemote() {
                return null;
            }

            @Override
            public String getId() {
                return "01";
            }

            @Override
            public void close() throws IOException {

            }

            @Override
            public void close(CloseReason closeReason) throws IOException {

            }

            @Override
            public URI getRequestURI() {
                return null;
            }

            @Override
            public Map<String, List<String>> getRequestParameterMap() {
                return null;
            }

            @Override
            public String getQueryString() {
                return null;
            }

            @Override
            public Map<String, String> getPathParameters() {
                return null;
            }

            @Override
            public Map<String, Object> getUserProperties() {
                return null;
            }

            @Override
            public Principal getUserPrincipal() {
                return null;
            }

            @Override
            public Set<Session> getOpenSessions() {
                return null;
            }
        };

        client.onOpen(session);
    }


    @OnOpen
    public void onOpen(Session session) {
        System.out.println("Open client:" + session.getId());
        try {
            session.getBasicRemote().sendText("Hello server");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @OnClose
    public void onClose(CloseReason closeReason) {
        System.out.println("Close from client:" + closeReason.getReasonPhrase());
    }

    @OnError
    public void onError(Throwable t) {
        System.out.println("Error on client:" + t.getMessage());
    }
}
