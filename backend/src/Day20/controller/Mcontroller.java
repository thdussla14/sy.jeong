package Day20.controller;

import Day20.model.DAO.membeDao;
import Day20.model.DTO.MemberDto;

public class Mcontroller {

	private static Mcontroller mcont = new Mcontroller();
	private Mcontroller () { }
	public static Mcontroller getInstance() {
		return mcont;
	}
	// 0. 로그인 세션
	private int loginSession = 0;	// 로그인된 회원번호 담기!
	public int  getLoginSession() {return loginSession;}
	public void setLoginSession(int loginSession) {this.loginSession = loginSession;}
	
	// 1. 회원가입 처리 [ 아이디 중복 체크 ] 
	public int signup(String mid,String mpw,String mname,String mphone) {		
		// 1. 유효성검사
		if(membeDao.getInstance().IDcheck(mid)) { return 2; }
		// 2. 객체화
		MemberDto mdto = new MemberDto(0, mid, mpw, mname, mphone);
		// 3. DB 처리
		return membeDao.getInstance().signup(mdto);
	}

	// 2. 로그인 처리
	public boolean login(String mid,String mpw) {
		
		int result = membeDao.getInstance().login(mid, mpw);
		if(result == 0 ) {return false;}
		else {
			loginSession = result ;
			return true;} 
	}
	public boolean logout() {
		return false;
	}
	
}

