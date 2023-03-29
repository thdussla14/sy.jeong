package controller.admin;

import java.util.ArrayList;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import model.Dao.MemberDao;
import model.Dto.ClientDto;


@ServerEndpoint("/alarm/{mid}")
public class Alarm {

	private static ArrayList<ClientDto> 알림명단 = new ArrayList<>();
	
	@OnOpen
	public void 서버입장(Session session, @PathParam("mid") String mid) throws Exception {
		System.out.println(session);
		알림명단.add(new ClientDto(session,mid));
	}

	@OnClose
	public void 서버퇴장(Session session) throws Exception {
		System.out.println(session);
		for (ClientDto c : 알림명단) {
			if(c.getSession() == session) {
				알림명단.remove(c);}
		}
	}
	@OnMessage
	public static void 서버메세지(Session session, String msg) throws Exception {
		System.out.println(session);
		
		int 	tomno = Integer.parseInt(msg.split(",")[0]); 
		String 	tomsg = msg.split(",")[1];
		
		for(ClientDto c : 알림명단) {
			
			int cmno = MemberDao.getInstance().getMember(c.getMid()).getMno();
			if( cmno == tomno) {
				c.getSession().getBasicRemote().sendText(" ");
			}			
		}
	}
	@OnError
	public void 서버오류(Session session, Throwable e) throws Exception {
		System.out.println(e);
	}
	
}
