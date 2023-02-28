package Day20.view;

import java.util.Scanner;

import Day20.controller.Mcontroller;

public class index_view {

	private static index_view iview = new index_view();
	private index_view () { }
	public static index_view getInstance() {
		return iview;
	}
	
	Scanner scanner = new Scanner(System.in);
	
	public void index() {
		while(true) {
			System.out.println("===============이젠 갤러리===============");
			System.out.println("1. 로그인  2. 회원가입  ");
			try {
				int ch = scanner.nextInt();
				if      (ch==1) {login(); }
				else if (ch==2) {signup(); }
			}catch(Exception e) { 
				System.out.println("[알림] 잘못된 입력입니다.");
				scanner = new Scanner(System.in);}
		}// while e
	}
	
	public void signup() throws Exception {
		System.out.println("================회원가입================");
		System.out.println("아이디: ");  	String mid    = scanner.next();
		System.out.println("비밀번호: "); 	String mpw    = scanner.next();
		System.out.println("이름: ");  	String mname  = scanner.next();
		System.out.println("전화번호: "); 	String mphone = scanner.next();
		
		int result = Mcontroller.getInstance().signup(mid, mpw, mname, mphone);
		if      (result==1) {System.out.println("[알림] 회원가입 성공되었습니다."); }
		else if (result==2) {System.out.println("[알림] 사용중인 아이디입니다."); }
		else if (result==3) {System.out.println("[알림] 시스템 오류 : 관리자에게 문의");}		
		
	}
	public void login() {
		System.out.println("================로그인================");
		System.out.println("아이디: ");  	String mid    = scanner.next();
		System.out.println("비밀번호: "); 	String mpw    = scanner.next();
		boolean result = Mcontroller.getInstance().login(mid,mpw);
		if (result) {System.out.println("[로그인 성공]");
			board_view.getInstance().index();}
		else {System.out.println("[로그인 실패]"); }
	
	}
	
	
	
	
}
