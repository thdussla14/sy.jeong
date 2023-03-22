package model.Dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.websocket.Session;

import controller.admin.Chatting;
import model.Dao.MemberDao;

public class MessageDto {

	private String 	frommid;	//메세지보낸회원아이디;
	private String  frommimg;	//메세지보낸회원프로필;
	private String 	msg;		//메세지내용;
	private String 	time;		//메세지보낸시간;

	public MessageDto() { }

	// 클라이언트에게 메세지 전송시 사용 생성자
	public MessageDto(Session session, String msg) {
		super();
		this.msg      = msg;
		for(ClientDto cdto :  Chatting.list) {
			if(cdto.getSession() == session) {
				
				this.frommid  = cdto.getMid();
				this.frommimg = MemberDao.getInstance().getMember(this.frommid).getMimg();
				this.time     = new SimpleDateFormat("aa hh:mm").format(new Date());
				
			}
		}
	}

	@Override
	public String toString() {
		return "MessageDto [frommid=" + frommid + ", frommimg=" + frommimg + ", msg=" + msg
				+ ", time=" + time + "]";
	}

	public String getFrommid() {
		return frommid;
	}

	public void setFrommid(String frommid) {
		this.frommid = frommid;
	}

	public String getFrommimg() {
		return frommimg;
	}

	public void setFrommimg(String frommimg) {
		this.frommimg = frommimg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
	
}
