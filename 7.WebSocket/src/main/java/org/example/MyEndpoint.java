//package org.example;
//
//import javax.websocket.*;
//import javax.websocket.server.ServerEndpoint;
//import java.io.IOException;
//
//@ServerEndpoint("/chat")
//public class MyEndpoint {
//    @OnOpen
//    public void onOpen(Session session) {
//        System.out.println("Open Server:" + session.getId());
//    }
//
//    @OnClose
//    public void onClose(Session session) {
//        System.out.println("Close from Server:" + session.getId());
//    }
//
//    @OnMessage
//    public void receiveMessage(String message, Session session) {
//        System.out.println("Message from:" + session.getId() + "Message=" + message);
//        try {
//            session.getBasicRemote().sendText("Hello world from the server side, " + session.getId() + " !");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @OnError
//    public void onError(Throwable t) {
//        System.out.println("Error:" + t.getMessage());
//    }
//}
