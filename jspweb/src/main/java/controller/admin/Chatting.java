package controller.admin;

import java.util.ArrayList;

import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.catalina.connector.Response;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Dto.ClientDto;
import model.Dto.MemberDto;
import model.Dto.MessageDto;

import javax.websocket.Session;
import javax.websocket.OnOpen;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;

// URL 매개변수 받을때 : /경로/{매개변수1}/{매개변수2} 				---> @PathParam("경로상의 매개변수명") 타입 변수명
// URL 매개변수 받을때 : /경로? 매개변수1 = 데이터 & 매개변수2 = 데이터	---> request.getparameter


// 채팅방 분리시 
// @ServerEndpoint("/chatting/{mid}/{채팅방번호}")
//  해당 클래스를 서버소켓[종착점]으로 만들기
@ServerEndpoint("/chatting/{mid}")
public class Chatting {

	// 접속한 클라이언트 명단		// session [ 접속한 클라이언트소켓 객체 ]  
	public static ArrayList<ClientDto> list = new ArrayList<>();
	
	// 클라이언트 소켓이 접속시 실행되는 메소드
	@OnOpen
	public void OnOpen(Session session, @PathParam("mid") String mid) {
		System.out.println("클라이언트 웹소켓 접속");
		list.add(new ClientDto(session,mid));
	}
	
	// 클라이언트 소켓이 연결 해제시 실행되는 메소드
	@OnClose
	public void OnClose(Session session) {
		System.out.println("클라이언트 웹소켓 접속해제");
		for (ClientDto cdto : list) {
			if(cdto.getSession() == session) {
				list.remove(cdto);
			}
		}
	}
	
	// 클라이언트 소켓이 메세지 전송시 실행되는 메소드 [ 서버가 메세지 받기 ]
	@OnMessage
	public void OnMessage(Session session, String msg) throws Exception {
		System.out.println("클라이언트 웹소켓 메시지 전송");
		System.out.println(msg);
		
		// 메세지 형식 구성
		MessageDto dto = new MessageDto(session,msg);
		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(dto);

		System.out.println(json);

		// * 서버가 클라이언트 소켓에게 메세지 전송
		for (ClientDto cdto : list) {
							//getBasicRemote().sendText(json);은 setcontentType 지원 X 객체가 아닌 문자열로 전송
			cdto.getSession().getBasicRemote().sendText(json);
		}
	}

}
