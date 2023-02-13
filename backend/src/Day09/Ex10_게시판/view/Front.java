package Day09.Ex10_게시판.view;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Day09.Ex10_게시판.controller.Bcontroller;
import Day09.Ex10_게시판.model.Board;

public class Front {
	
	// 1. 싱글톤 객체 [ 1. 프로그램내 하나의 객체 => 공유메모리 ]
	private static Front front = new Front();
	private Front() {}
	public static Front getInstance() {
		return front;
	}
	
	// 필드 : 입력 객체 [ 인스턴스 멤버 ]
	private Scanner scanner = new Scanner(System.in);
		
	// 2. index 함수
	public void index() {		
		while(true) {
			print_page(); // 출력 함수
			System.out.println("메뉴> 1. 쓰기  2. 보기");
			int ch = scanner.nextInt();
			
			if(ch==1) {writer_page();}// 쓰기 함수
			else if(ch==2) {view_page();}
			else {System.err.println("[알림] 알 수 없는 행동입니다."); }
		
		}// while e
	}// class e

	// 3. 쓰기 페이지 함수
	private void writer_page() {
		// 입력 받기 
		System.out.println("--------------- 글 쓰기 페이지 ----------------");
		System.out.println("제목 : ");	String title 	= scanner.next();
		System.out.println("내용 : ");	String content 	= scanner.next();
		System.out.println("작성자 : ");	String writer 	= scanner.next();
		System.out.println("비밀번호 : ");	String password = scanner.next();
		Date date = new Date();			// import java.util.Date; 모든 클래스에 import 적용 필수 !!!
		int view = 0; // 조회수는 0 부터 시작
		
		// 글쓰기 로직으로 전달
		boolean result = 
		Bcontroller.getInstance().write(title,content,writer,password,date,view); // new Bcontroller().write();
		
		// 결과에 따른 출력
		if(result) 	{System.out.println("[알림] 글쓰기 성공");}
		else 		{System.out.println("[알림] 글쓰기 실패");}

	}// 쓰기 e
	
	// 4. 출력 페이지 함수
	private void print_page() {
		System.out.println("--------------- 글 보기 페이지 ----------------");
		
		// 4-1. 싱글톤 객체를 통해 boardDB 리스트 객체 반환 받기
		ArrayList<Board> result = Bcontroller.getInstance().print();
		System.out.println("번호\t제목\t작성자\t조회수\t날짜");
		// 4-2. 반환된 리스트 객체 수만큼 반복문으로 출력하기
		for(int i=0; i<result.size() ; i++)
			{System.out.println(i+"\t"+result.get(i).toString());}
	
	}// 출력 e
	
	// 5. 상세 페이지 함수
	private void view_page() {
		// 5-1. 번호 입력받기
		System.out.println("게시물 번호 : ");	int bno = scanner.nextInt();
		// 5-2. 입력받은 게시물 번호를 전달하여 해당 게시물 정보를 컨트롤에게 요청
		Board result = Bcontroller.getInstance().view(bno);
		// 5-3. 출력
		System.out.println("-------------- 게시물 상세 "+bno+"----------------");
		System.out.println("제목 : "	+result.getTitle());
		System.out.println("작성자: "	+result.getWriter()		+"\t 조회수 : "+result.getView());
		System.out.println("내용 : "	+result.getContent());
		
		System.out.println("메뉴 > 1. 뒤로가기 2. 삭제 3. 수정");
		int ch2 = scanner.nextInt();
		if(ch2==1) {return ; }
		// 글 삭제
		else if(ch2==2) {
			
			boolean result2 = Bcontroller.getInstance().delete(bno);		
			if(result2) {System.out.println("[글 삭제 성공]");}
		}
		else { System.err.println("[알림] 알 수 없는 행동입니다.");}
		
	}// 상세 e
	
}// class e
