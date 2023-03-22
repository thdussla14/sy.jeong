package model.Dto;

import javax.websocket.Session;

public class ClientDto {

	private Session session;
	private String 	mid;
	// private int 채팅방번호;
	
	public ClientDto() { }
	public ClientDto(Session session, String mid) {
		super();
		this.session = session;
		this.mid = mid;
	}
	@Override
	public String toString() {
		return "ClientDto [session=" + session + ", mid=" + mid + "]";
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	public String getMid() {
		return mid;
	}
	public void setMid(String mid) {
		this.mid = mid;
	}
	
	
	
}
