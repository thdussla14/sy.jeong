package 과제.과제4.view;

import java.util.ArrayList;
import java.util.Scanner;

import 과제.과제4.controller.Bcontroller;
import 과제.과제4.controller.Mcontroller;
import 과제.과제4.model.Board;

// * 입출력 담당 : print, Scanner
public class Front {
	
	// * 입력 객체
	Scanner scanner = new Scanner(System.in);
	Mcontroller mc = new Mcontroller(); //*******
	Bcontroller bc = new Bcontroller();
	
	// 1. 메인 페이지
	public void index() {
		while(true) {
			System.out.println("---------------------------------");
			System.out.println("메뉴> 1.회원가입 2.로그인 3.아이디찾기 4.비밀번호 찾기 : ");
			System.out.println("---------------------------------");
			
			int ch = scanner.nextInt();
			if(ch==1) {signup();}
			else if(ch==2) {login();}
			else if(ch==3) {findid();}
			else if(ch==4) {findpw();}
			else {System.err.println("[알림] 알 수 없는 행동입니다."); }
		
		}//while e
	}// index e
	
	// 2. 회원가입 페이지
	public void signup(){
		System.out.println("아이디 : ");		String id = scanner.next();
		System.out.println("비밀번호 : ");		String pwd = scanner.next();
		System.out.println("비밀번호 확인 : ");	String confirmpwd = scanner.next();
		System.out.println("이름 : ");		String name = scanner.next();
		System.out.println("전화번호 : ");		String phone = scanner.next();	
		
		int result = mc.signup(id,pwd,confirmpwd,name,phone);
		if(result == 0) {System.out.println("[회원가입 성공]"); }
		else if(result == 1) { System.err.println("[회원가입 실패]비밀번호가 일치하지 않습니다.");}
		
	} // signup e
	
	// 3. 로그인 페이지
	public void login(){	
		System.out.println("아이디 : ");		String id = scanner.next();
		System.out.println("비밀번호 : ");		String pwd = scanner.next();
		int result = mc.login(id,pwd);
		if( result >= 0 ) {community(id); }// 게시판으로 이동
		else if(result == -1 ) {System.err.println("[알림] 비밀번호가 일치하지 않습니다.");}
		else if(result == -2 ) {System.err.println("[알림] 존재하지 않는 아이디입니다.");}
		
	}// login e
	
	// 4. 아이디 찾기 페이지
	public void findid(){
		System.out.println("이름 : ");		String name = scanner.next();
		System.out.println("전화번호 : ");		String phone = scanner.next();
		
		String result = mc.findid(name,phone);
		if( result == null ) {System.err.println("[알림] 존재하지 않는 회원입니다.");}
		else {System.out.println("회원님의 아이디는"+result+"입니다.");}
		
	} // findid e
	
	// 5. 비밀번호 찾기 페이지
	public void findpw(){
		System.out.println("아이디 : ");		String id = scanner.next();
		System.out.println("전화번호 : ");		String phone = scanner.next();
		
		String result = mc.findpw(id,phone);
		if( result == null ) {System.err.println("[알림] 존재하지 않는 아이디입니다.");}
		else {System.out.println("회원님의 비밀번호는"+result+"입니다.");}
		
	} // findpw e
	
	// 6. 로그인 성공시 커뮤니티 페이지
	public void community(String id) {
		while(true) { // 무한루프 [ 종료조건 : 로그아웃 ]
			System.out.println("---------------------------------");
			System.out.println(id+"님의 아이디로 로그인되었습니다.");
			System.out.println("--------------커뮤니티--------------");
			System.out.println("번호\t조회수\t작성자\t제목");
			
			ArrayList<Board> result = bc.print();
			for(int i=0; i<result.size(); i++)
				{System.out.println(i+"\t"+result.get(i).view+"\t"+result.get(i).writer+"\t"+result.get(i).title);}
			
			System.out.println("---------------------------------");
			System.out.println("메뉴> 1. 글쓰기 2. 글보기  3. 로그아웃");
			System.out.println("---------------------------------");
			
			int ch2 = scanner.nextInt();
			if(ch2 == 1) {write(id); }
			else if(ch2 == 2) {content(id); }
			else if(ch2 == 3) {
				System.out.println("로그아웃 되었습니다.");
				break;}
			else {System.err.println("[알림] 알 수 없는 행동입니다."); }
			
		}// while e
	} // community e
	
	// 7. 글 상세 페이지
	public void content(String id) {
		
		System.out.println("상세보기할 게시물 번호 : ");
		int ch = scanner.nextInt();
		Board result = bc.content(ch);
		
		System.out.println("--------------글보기---------------");
		System.out.println("제목:  "+result.title);
		System.out.println("작성자: "+result.writer		+"\t\t조회수: "+result.view);
		System.out.println("내용:  "+result.content);
		System.out.println("---------------------------------");
		System.out.println("메뉴> 1. 글삭제 2. 글수정  3. 뒤로가기");
		System.out.println("---------------------------------");
		
		int ch2 = scanner.nextInt();
		if(ch2 == 1) { delete(id,ch);}
		else if(ch2 == 2) {rewrite(id,ch); }
		else if(ch2 == 3) {community(id);}
		else {System.err.println("[알림] 알 수 없는 행동입니다."); }
	} // content e
	
	// 8. 글 작성 페이지
	public void write(String id) {
		
		System.out.println("--------------글작성---------------");
		System.out.println("제목:  "); String title 	  = scanner.next();
		System.out.println("내용:  "); String content  = scanner.next();
		int view = 0;
		
		int result = bc.write(id, title, content, view);
		if(result==0) { System.out.println("[글 작성 성공]");}
		else {System.err.println("[알림] 알 수 없는 행동입니다."); }
		
	} // write e
		
	// 9. 글 삭제 페이지
	public void delete(String id, int ch) {
		
		// 9-1. 유효성검사
		boolean result = bc.check(ch, id);
		if(result) { 
			//9-2. 게시물 삭제
			int result2 = bc.delete(ch);
			if(result2==0) {System.out.println("[글 삭제 성공]");}
		}
		else {System.err.println("[알림] 권한 없음 ");}

	}// delete e
	
	// 10. 글 수정 페이지
	public void rewrite(String id, int ch) {
		
		// 10-1. 유효성검사
		boolean result = bc.check(ch, id);
		if(result) { 
			// 10-2. 게시물 수정
			System.out.println("-------- 글 수정 --------");
			System.out.println("새로운 내용 : "); String recontent = scanner.next();
			int result2 = bc.rewrite(ch,recontent);
			if(result2==0) {System.out.println("[글 수정 성공]");}
		}
		else {System.err.println("[알림] 권한 없음 ");}

	} // rewrite e
	
	
} // class e
