package 과제.과제5.view;

import java.util.ArrayList;
import java.util.Scanner;

import 과제.과제5.controller.Mcontroller;
import 과제.과제5.controller.Pcontroller;
import 과제.과제5.model.Memo;
import 과제.과제5.model.Product;

public class Front {
	// 싱글톤
	private static Front front = new Front();
	private Front () { }
	public static Front getInstance() {
		return front;
	}
	
	Scanner scanner = new Scanner(System.in);
	
	// 초기 페이지------------------------------------------------------------------------------
	public void index() {
		while(true) {// 무한루프  [종료조건 : 없음 ]
			
			System.out.println("-------------------------------------------");
			System.out.println("메뉴>  1.회원가입  2.로그인 ");
			System.out.println("-------------------------------------------");
			int ch = scanner.nextInt();
			if(ch==1) { signup_page (); }
			else if(ch==2) { login_page (); }
			else {System.err.println("[알림] 알 수 없는 행동입니다.");  }
	
		}// while e
	}// index e
	
	// 회원가입 페이지---------------------------------------------------------------------------
	public void signup_page() {
			
		// 1. 입력 받기
		System.out.println("아이디 : ");		String id = scanner.next();
		System.out.println("비밀번호 : "); 	String pw = scanner.next();
		System.out.println("전화번호 : "); 	String phone = scanner.next();
		// 2. 컨트롤러에게 전달 후 결과 받기
		boolean result = Mcontroller.getInsetance().signup(id, pw, phone);
		// 3. 결과 제어
		if(result) {System.out.println("[알림] 회원가입 성공"); }
		else {System.err.println("[알림] 회원가입 실패"); }

	}// signup e
	
	// 로그인 페이지-----------------------------------------------------------------------------
	public void login_page() {
		// 1. 입력 받기
		System.out.println("아이디 : ");		String id = scanner.next();
		System.out.println("비밀번호 : "); 	String pw = scanner.next();	
		// 2. 컨트롤러에게 전달 후 결과 받기
		boolean result = Mcontroller.getInsetance().login(id, pw);
		// 3. 결과 제어
		if(result) {System.out.println("[알림] 로그인 성공"); main_page(); }
		else {System.err.println("[알림] 로그인 실패"); }
		
	}// login e
	
	// 메인 페이지-------------------------------------------------------------------------------
	public void main_page() {
		while(true) {// 무한루프 [종료조건 : 4.로그아웃 ]
			System.out.println("-------------------------------------------");
			System.out.println("제품번호\t제품이름\t제품가격\t제품상태 ");
			
			ArrayList<Product> result = Pcontroller.getInstance().print();
			for(Product p : result)
				{ System.out.println(p.getPno()+"\t"+p.getTitle()+"\t"+p.getPrice()+"\t"+p.getState());}// for e

			System.out.println("-------------------------------------------");
			System.out.println("메뉴>  1.제품등록  2.제품상세  3.마이페이지  4.로그아웃");
			System.out.println("-------------------------------------------");
			int ch = scanner.nextInt();
			if(ch==1) { register_page (); }
			else if(ch==2) { view_page(); }
			else if(ch==3) { my_page_index(); }
			else if(ch==4) { break; }
			else {System.err.println("[알림] 알 수 없는 행동입니다.");  }
	
		}// while e	
	}// main e
	
	// 제품 등록 페이지----------------------------------------------------------------------------
	public void register_page() {
		
		// 1. 입력 받기		
		System.out.println("-------------------------------------------");	
		System.out.println("제목 : ");	String title 	= scanner.next();
		System.out.println("내용 : "); 	String content 	= scanner.next();
		System.out.println("가격 : "); 	String price 	= scanner.next();
		// 2. 컨트롤러에게 전달 후 결과 받기
		boolean result = Pcontroller.getInstance().register(title, content, price);
		// 3. 결과 제어
		if(result) {System.out.println("[알림] 제품 등록 성공"); }
		else {System.err.println("[알림] 제품 등록 실패"); }				
	}// register e
		
	// 제품 상세 페이지-----------------------------------------------------------------------------
	public void view_page() {
		
		// 1. 입력 받기
		System.out.println("제품번호 : ");	int spno	= scanner.nextInt();	
		// 2. 컨트롤러에게 전달 후 결과 받기
		Product result = Pcontroller.getInstance().view(spno);
		// 3. 결과 제어
		System.out.println("상태 : "+result.getState());
		System.out.println("제목 : "+result.getTitle());
		System.out.println("내용 : "+result.getContent()); 	
		System.out.println("가격 : "+result.getPrice()); 
		
		System.out.println("-------------------------------------------");
		System.out.println("메뉴>  1.쪽지보내기  2.뒤로가기 ");
		System.out.println("-------------------------------------------");

		int ch = scanner.nextInt();
		if(ch==1) { write_page(spno); }
		else if(ch==2) { return; }
		else {System.err.println("[알림] 알 수 없는 행동입니다.");  }
		
	}// view e
	
	// 쪽지 작성 페이지----------------------------------------------------------------------------
	public void write_page(int spno) {
		
		System.out.println("-------------------------------------------");	
		// 1. 입력 받기
		System.out.println("내용 : "); 	String content 	= scanner.next();		
		// 2. 컨트롤러에게 전달 후 결과 받기
		boolean result = Mcontroller.getInsetance().send(spno, content);
		// 3. 결과 제어
		if(result) {System.out.println("[알림] 쪽지 전송 성공"); }
		else {System.err.println("[알림] 쪽지 전송 실패"); }	
	
	}// write e

	// 마이 페이지--------------------------------------------------------------------------------
	public void my_page_index() {
		
		System.out.println("-------------------------------------------");
		System.out.println("메뉴>  1.등록제품목록  2.받은쪽지함  3.보낸쪽지함 ");
		System.out.println("-------------------------------------------");
		int ch = scanner.nextInt();
		if(ch==1) { my_page_product(); }
		else if(ch==2) { my_page_recieM(); }
		else if(ch==3) { my_page_sendM(); }
		else {System.err.println("[알림] 알 수 없는 행동입니다.");  }	
		}

	// 마이 페이지- 제품 목록------------------------------------------------------------------------
	public void my_page_product() {
		
		System.out.println("-------------------------------------------");
		System.out.println("제품번호\t제품이름\t제품가격\t제품상태 ");
		
		ArrayList<Product> result = Pcontroller.getInstance().myproduct();
		for(Product p : result)
			{ System.out.println(p.getPno()+"\t"+p.getTitle()+"\t"+p.getPrice()+"\t"+p.getState());}	
		
		System.out.println("-------------------------------------------");
		System.out.println("메뉴>  1.제품수정  2.제품삭제  3.판매완료  4.뒤로가기");
		System.out.println("-------------------------------------------");
		
		int ch = scanner.nextInt();
		if(ch==1) { update(); }
		else if(ch==2) { delete(); }
		else if(ch==3) { compelete(); }
		else if(ch==4) { return; }
		else {System.err.println("[알림] 알 수 없는 행동입니다.");  }	
		
	}// my_product e
	
	// 마이 페이지- 받은 쪽지함-----------------------------------------------------------------------
	public void my_page_recieM() {
		
		ArrayList<Memo> result = Mcontroller.getInsetance().receiM();
		if(result.size()>0) { 
			System.out.println("-------------------------------------------");
			System.out.println("제품번호\t보낸사람\t내용 ");	
			for(Memo me : result) 
				{System.out.println(me.getPno()+"\t"+me.getSendmno()+"\t"+me.getmContent()); }
			}
		else { System.err.println("[알림] 받은 쪽지가 없습니다.");}
	}// recieM e

	// 마이 페이지- 보낸 쪽지함-----------------------------------------------------------------------
	public void my_page_sendM() {

		ArrayList<Memo> result = Mcontroller.getInsetance().sendM();
		if(result.size()>0) {
			System.out.println("-------------------------------------------");
			System.out.println("제품번호\t내용 ");		
			for(Memo me : result) 
				{System.out.println(me.getPno()+"\t"+me.getmContent()); }
		
			}
		else { System.err.println("[알림] 보낸 쪽지가 없습니다.");}
		
	}// sendM e	

	// 제품수정------------------------------------------------------------------------------------
	public void update() {
		
		// 1. 입력 받기
		System.out.println("제품번호 : ");	int    pno 		= scanner.nextInt();
		// 2. 컨트롤러에게 전달 후 결과 받기
		int result = Pcontroller.getInstance().check(pno);
		// 3. 결과 제어
		if(result==-1){System.err.println("[알림] 해당 제품 수정 권한 없음"); }	
		else if(result>=0) {
			
			System.out.println("-------------------------------------------");	
			System.out.println("제목 : ");	String title 	= scanner.next();
			System.out.println("내용 : "); 	String content 	= scanner.next();
			System.out.println("가격 : "); 	String price 	= scanner.next();
			
			boolean result2 = Pcontroller.getInstance().update(result, title, content, price);
			
			if(result2) {System.out.println("[알림] 제품 수정 성공"); }
			else {System.err.println("[알림] 제품 수정 실패"); }			
		}
	}// update e
	
	// 제품삭제------------------------------------------------------------------------------------
	public void delete() {
		
		// 1. 입력 받기
		System.out.println("제품번호 : ");	int    pno 		= scanner.nextInt();
		// 2. 컨트롤러에게 전달 후 결과 받기
		int result = Pcontroller.getInstance().check(pno);
		// 3. 결과 제어	
		if(result==-1){System.err.println("[알림] 해당 제품 수정 권한 없음"); }
		else if(result>=0) {
			
			boolean result2 = Pcontroller.getInstance().delete(result);
				
			if(result2) {System.out.println("[알림] 제품 삭제 성공"); }
			else {System.err.println("[알림] 제품 삭제 실패"); }	
		}
		
	}// delete e
	// 판매완료------------------------------------------------------------------------------------
	public void compelete() {

		// 1. 입력 받기
		System.out.println("제품번호 : ");	int   pno 	= scanner.nextInt();
		
		// 2. 컨트롤러에게 전달 후 결과 받기
		int result = Pcontroller.getInstance().check(pno);
		// 3. 결과 제어
		if(result==-1){System.err.println("[알림] 해당 제품 수정 권한 없음"); }
		else if(result>=0) {
			
			boolean result2 = Pcontroller.getInstance().compelete(result);	
			
			if(result2) {System.out.println("[알림] 상태 변경 성공"); }
			else {System.err.println("[알림] 상태 변경 실패"); }	
		}
	}// compelete e
	
	
}// class e
