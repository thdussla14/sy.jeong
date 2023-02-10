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
		System.out.println("메뉴> 1.회원가입 2.로그인 3.아이디찾기 4.비밀번호 찾기 : ");
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
		if( result >= 0 ) {community(); }// 게시판으로 이동
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
		
	} // finfid e
	
	// 5. 비밀번호 찾기 페이지
	public void findpw(){
		System.out.println("아이디 : ");		String id = scanner.next();
		System.out.println("전화번호 : ");		String phone = scanner.next();
		String result = mc.findpw(id,phone);
		if( result == null ) {System.err.println("[알림] 존재하지 않는 아이디입니다.");}
		else {System.out.println("회원님의 비밀번호는"+result+"입니다.");}
		
	} // findpw e
	
	// 6. 로그인 성공시 커뮤니티 페이지
	public void community() {
		System.out.println("--------------커뮤니티--------------");
		System.out.println("번호\t조회수\t작성자\t제목");
		
		System.out.println("메뉴> 1. 글쓰기 2. 글보기  3. 로그아웃");
		int ch2 = scanner.nextInt();
		
		if(ch2 == 1) {write(); }
		else if(ch2 == 2) {content(); }
		else if(ch2 == 3) {index(); }
		else {System.err.println("[알림] 알 수 없는 행동입니다."); }
		
	} // community e
	
	// 7. 글 상세 페이지
	public void content() {
		System.out.println("--------------글보기---------------");
		System.out.println("제목:  ");
		System.out.println("작성자: "+"조회수: ");
		System.out.println("내용:  ");
		System.out.println("메뉴> 1. 글삭제 2. 글수정  3. 뒤로가기");
		
		int ch2 = scanner.nextInt();
		if(ch2 == 1) { }
		else if(ch2 == 2) {write(); }
		else if(ch2 == 3) {community();}
		else {System.err.println("[알림] 알 수 없는 행동입니다."); }
		
	} // content e
	
	// 8. 글 작성 페이지
	public void write() {
		System.out.println("--------------글작성---------------");
		System.out.println("제목:  "); String title 	  = scanner.next();
		System.out.println("내용:  "); String content  = scanner.next();
		
		int result = bc.write(content, title, content, 0);
		if(result==0) { System.out.println("[글 작성 성공]");}
		else if(result==1) { System.err.println("[알림] 제목이 공백입니다.");}
		else if(result==2) { System.err.println("[알림] 내용이 공백입니다.");}
		
	} // write e
	
	

} // class e
