package net.gsdgroup;

import javax.websocket.ClientEndpoint;
import javax.websocket.CloseReason;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

@ClientEndpoint
public class ClientEndp {
	private Session session;

	@OnOpen
	public void open(Session s) {
		this.session = s;
		System.out.println("Open new session: " + session);
	}

	@OnClose
	public void close(CloseReason c) {
		System.out.println("Close session: " + session);
		this.session = null;
	}

	@OnError
	public void error(Throwable t) {
	}

	@OnMessage
	public void onMessage(String msg) {
		System.out.println("Current session: " + session);
		System.out.println("Message: " + msg);
		this.session.getAsyncRemote().sendText("Echo: " + msg);
	}
}