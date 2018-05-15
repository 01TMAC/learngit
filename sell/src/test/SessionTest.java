package test;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

public class SessionTest {
	HttpSession session = null;
	public HttpSession getSession(){
		session.setAttribute("user", "123456");
		return session;
	}

}
