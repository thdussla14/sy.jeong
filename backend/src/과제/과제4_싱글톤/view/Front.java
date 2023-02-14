package 과제.과제4_싱글톤.view;

import java.util.ArrayList;
import java.util.Scanner;

import 과제.과제4_싱글톤.controller.Bcontroller;
import 과제.과제4_싱글톤.controller.Mcontroller;
import 과제.과제4_싱글톤.model.Board;

public class Front {

	Scanner scanner = new Scanner(System.in);
	
	// 싱글톤--------------------------------------------------------------
	private static Front front = new Front();
	private Front () { }
	public static  Front getInstance() {
		return front;
	}
	
	// 메인페이지-------------------------------------------------------------
	public void index () {
		while(true) {// 무한루프
			System.out.println("-------------------------------------------");
			System.out.println("메뉴> 1. 회원가입  2. 로그인 3. 아이디 찾기 4. 비밀번호 찾기");
			System.out.println("-------------------------------------------");
			int ch = scanner.nextInt();
			if(ch==1) { signup_page (); }
			else if(ch==2) { login_page (); }
			else if(ch==3) { findid_page (); }
			else if(ch==4) { findpw_page (); }
			else {System.err.println("[알림] 알 수 없는 행동입니다.");  }
		}// while e
	}
	
	// 회원가입페이지-----------------------------------------------------------
	public void signup_page () {
		// 1. 입력 받기
		System.out.println("아이디 : ");		String id = scanner.next();
		System.out.println("비밀번호 : "); 		String pw = scanner.next();
		System.out.println("비밀번호확인 : "); 	String confirmpw = scanner.next();
		System.out.println("이름 : "); 		String name = scanner.next();
		System.out.println("전화번호 : "); 		String phone = scanner.next();
		// 2. 컨트롤러에게 전달 후 결과 받기
		int result = Mcontroller.getInstance().signup(id, pw, confirmpw, name, phone);
		// 3. 결과 제어
		if(result == 1 ) {System.err.println("[알림] 회원가입 실패 . 패스워드 불일치"); }
		else if (result == 0 ) {System.out.println("[알림] 회원가입 성공. 안녕하세요."); }
	}
	
	// 로그인페이지------------------------------------------------------------
	public void login_page () {
		// 1. 입력 받기
		System.out.println("아이디 : ");		String id = scanner.next();
		System.out.println("비밀번호 : "); 		String pw = scanner.next();
		// 2. 컨트롤러에게 전달 후 결과 받기
		int result = Mcontroller.getInstance().login(id, pw);
		// 3. 결과 제어
		if(result == -1 ) {System.err.println("[알림] 로그인 실패 . 패스워드 불일치"); }
		else if (result == -2 ) {System.err.println("[알림] 로그인 실패 . 존재하는 아이디가 없습니다."); }
		else { System.out.println("[알림] 로그인 성공. 안녕하세요.");board_page ();}
	}
	// 아이디찾기페이지----------------------------------------------------------
	public void findid_page () {
		// 1. 입력 받기
		System.out.println("이름 : "); 		String name  = scanner.next();
		System.out.println("전화번호 : "); 		String phone = scanner.next();
		// 2. 컨트롤러에게 전달 후 결과 받기
		String result = Mcontroller.getInstance().findid(name, phone);
		// 3. 결과 제어
		if( result == null) {System.err.println("[알림] 아이디 찾기 실패 "); }
		else { System.out.println("[알림] 회원님의 아이디는 "+result+" 입니다.");}
		
	}
	// 비밀번호찾기페이지---------------------------------------------------------
	public void findpw_page () {
		// 1. 입력 받기
		System.out.println("아이디 : ");		String id 	 = scanner.next();
		System.out.println("전화번호 : "); 		String phone = scanner.next();
		// 2. 컨트롤러에게 전달 후 결과 받기
		String result = Mcontroller.getInstance().findpw(id, phone);
		// 3. 결과 제어
		if( result == null) {System.err.println("[알림] 비밀번호 찾기 실패 "); }
		else { System.out.println("[알림] 회원님의 비밀번호는 "+result+" 입니다.");}
		
	}
	// 로그인 성공 페이지---------------------------------------------------------
	public void board_page () {
		while(true) {// 무한루프
			System.out.println("-------------------커뮤니티-------------------");
			System.out.println("번호\t조회수\t작성자\t제목");
			// 1. 컨트롤러에게 전달 후 결과 받기
			ArrayList<Board> result = Bcontroller.getInsetance().getList();// ctrl 누른상태로 함수 클릭시 해당 함수로 이동
			// 2. 결과 제어

			for(int i=0; i<result.size() ; i++)
				{System.out.println(i+"\t"+result.get(i).getView()+"\t"+result.get(i).getMember().getId()+"\t"+result.get(i).getTitle());}
			
			System.out.println("-------------------------------------------");
			System.out.println("메뉴> 1. 글쓰기   2. 글보기  3. 로그아웃");
			System.out.println("-------------------------------------------");
			
			int ch = scanner.nextInt();
			if(ch==1) { write_page (); }
			else if(ch==2) { view_page (); }
			else if(ch==3) { Mcontroller.getInstance().logOut(); break; }// break 가 아닌 index(); 사용시 에러
			else {System.err.println("[알림] 알 수 없는 행동입니다.");  }
		}// while e
	}
	// 게시물 쓰기 페이지---------------------------------------------------------
	public void write_page () {
		// 1. 입력 받기
		System.out.println("--------------------글쓰기--------------------");
		System.out.println("제목 : ");		String title 	= scanner.next();
		System.out.println("내용 : "); 		String content 	= scanner.next();
		// 2. 컨트롤러에게 전달 후 결과 받기
		boolean result = Bcontroller.getInsetance().write(title, content);
		// 3. 결과 제어
		if(result) {System.out.println("[알림] 글 작성 성공"); }
		else {System.err.println("[알림] 글 작성 실패"); }
	}
	// 게시물 상세 페이지---------------------------------------------------------
	public void view_page () {
		// 1. 입력 받기
		System.out.println("게시물 번호 : "); 	int bno = scanner.nextInt();
		// 2. 컨트롤러에게 전달 후 결과 받기
		Board result = Bcontroller.getInsetance().getBoard(bno);
		// 3. 결과 제어
		System.out.println("-------------------글상세--------------------");
		System.out.println("제목  : "+result.getTitle());
		System.out.println("작성자 : "+result.getMember().getId()+"\t조회수 : "+result.getView());
		System.out.println("내용  : "+result.getContent());
		System.out.println("-------------------------------------------");
		System.out.println("메뉴> 1. 삭제  2. 수정  3. 뒤로가기");
		System.out.println("-------------------------------------------");
		
		int ch = scanner.nextInt();
		if(ch==1) { delete_page (bno); }
		else if(ch==2) { update_page (bno); }
		else if(ch==3) { return; }
		else {System.err.println("[알림] 알 수 없는 행동입니다.");  }
		
	}
	// 게시물 삭제 페이지---------------------------------------------------------
	public void delete_page (int bno) {
		// 1. 유효성검사 [ 현재 보고 있는 글의 작성자와 로그인된 회원 동일할 경우 ]
		if(Bcontroller.getInsetance().getBoard(bno).getMember().equals(Mcontroller.getInstance().getLogSession()))
			{// 2. 컨트롤러에게 전달 후 결과 받기
			boolean result = Bcontroller.getInsetance().delete(bno);
			// 3. 결과 제어
			if(result) {System.out.println("[알림] 글 삭제 성공"); return;}
			}
		
		else {System.err.println("[알림] 삭제 권한이 없습니다.");}
	}
	
	
	// 게시물 수정 페이지---------------------------------------------------------
	public void update_page (int bno) {
		// 1. 유효성검사 [ 현재 보고 있는 글의 작성자와 로그인된 회원 동일할 경우 ]
		if(Bcontroller.getInsetance().getBoard(bno).getMember().equals(Mcontroller.getInstance().getLogSession()))
			{// 1. 입력 받기
			System.out.println("새로운 제목 : ");		String title 	= scanner.next();
			System.out.println("새로운 내용 : "); 		String content 	= scanner.next();
			// 2. 컨트롤러에게 전달 후 결과 받기
			boolean result = Bcontroller.getInsetance().update(bno, title, content);
			// 3. 결과 제어
			if(result) {System.out.println("[알림] 글 수정 성공"); return;}
			}
		
		else {System.err.println("[알림] 수정 권한이 없습니다.");}
	}
	
}// class e
