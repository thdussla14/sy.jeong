package 과제.과제5.controller;

import java.util.ArrayList;

import 과제.과제5.model.Member;
import 과제.과제5.model.Product;
import 과제.과제5.model.Memo;

public class Mcontroller {
	
	// ** 싱글톤
	private static Mcontroller mc = new Mcontroller();
	private Mcontroller () { }
	public static Mcontroller getInsetance(){
		return mc;
	}
	// DB 대용
	private ArrayList<Member> memberDB = new ArrayList<>();
	private ArrayList<Memo> memoDB = new ArrayList<>();
	
	// logsession 로그인 흔적?
	private Member logSession = null;	

	public Member getLogSession() {
		return logSession;
	}
	public void setLogSession(Member logSession) {
		this.logSession = logSession;
	}

	// 1. 회원가입
	public boolean signup() {
		
		memberDB.add(null);
		return true;
	}
	// 2. 로그인
	public boolean login() {
		
		return true;
	}

	// 3. 받은쪽지함
	public ArrayList<Memo> receiM() {
		
		return memoDB;
	}
	
	// 4. 보낸쪽지함
	public ArrayList<Memo> sendM() {
		
		return memoDB;
	}
	
	
}// class e
