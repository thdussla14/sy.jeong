package Day20.view;

import java.util.ArrayList;
import java.util.Scanner;

import Day20.controller.Bcontroller;
import Day20.controller.Mcontroller;
import Day20.model.DTO.BoardDto;
import Day20.model.DTO.CategoryDto;

public class board_view {

	private static board_view bview = new board_view();
	private board_view () { }
	public static board_view getInstance() {
		return bview;
	}
	
	private Scanner scanner = new Scanner(System.in);
	
	// 모든 게시물 
	public void index() {
		while(true) {
			System.out.println("=============== 이젠 갤러리 ===============");
			// 최신 게시물 3개 출력

			// 모든 갤러리 출력			
			System.out.println(" -1: 로그아웃 / 0: 갤러리 추가 / 이동할 갤러리 번호 선택 : ");
			try {
				int ch = scanner.nextInt();
				if      (ch>0  ) { categoryPrint();  }
				else if (ch== 0) { categoryAdd(); }
				else if (ch==-1) {
					Mcontroller.getInstance().setLoginSession(0);	// 로그인세션 초기화
					System.out.println("[로그아웃] 안녕히 가세요!");
					break;
				}
			}catch(Exception e) { 
				System.out.println("[알림] 잘못된 입력입니다.");
				scanner = new Scanner(System.in);}
		}// while e
	}
	// 2. 카테고리 추가
	public void categoryAdd() {
		System.out.println("=============== 갤러리 추가 ===============");
		System.out.println("추가할 갤러리 이름: ");  	
		scanner.nextLine();
		String cname = scanner.nextLine();
		boolean result = Bcontroller.getInstance().categoryAdd(cname);
		
		if (result) {System.out.println("[등록 성공] 갤러리가 추가 되었습니다.");}
		else {System.out.println("[등록 실패] 관리자에게 문의해주세요."); }	
	}
	// 3. 모든 카테고리 호출
	public void categoryPrint() {	
		System.out.println("=============== 갤러리 목록 ===============");
		ArrayList<CategoryDto> clist = Bcontroller.getInstance().categoryPrint();
		
		int count = 0;
		
		for(CategoryDto cdto: clist) {
			System.out.print(cdto.getCno()+" - "+cdto.getCname()+"\t");
			count++;
			if(count%4==0) {System.out.println();};		// 4 개마다 줄바꿈
		}
		boardprint();
	}
	// 4. 게시물 등록
	public void boardAdd(int cno) {
		System.out.println("=============== 게시물 등록 ===============");
		System.out.println("제목: ");  	String btitle    = scanner.next();
		System.out.println("내용: "); 	String bcontent  = scanner.next();	
		int mno =  Mcontroller.getInstance().getLoginSession();
		System.out.println(mno);
		
		boolean result = Bcontroller.getInstance().boardAdd
				(btitle, bcontent,mno,cno);
		if (result) {System.out.println("[등록 성공] 게시물이 등록 되었습니다.");}
		else {System.out.println("[등록 실패] 관리자에게 문의해주세요."); }	
		
	}
	// 5. 최신 게시물 3개 출력
	public void boardprintRecent() {
		System.out.println("=============== 최신 갤러리 ===============");
		ArrayList<BoardDto> blist = Bcontroller.getInstance().boardprintRecent();
		System.out.printf("%5s %10s %10s %10s %10s %10s \n","번호","제목","작성자","갤러리","조회수","작성일");
		for(BoardDto dto : blist) {
			System.out.printf("%5s %10s %10s %10s %10s %10s \n",
					dto.getBno(),dto.getBtitle(),dto.getMid(),
					dto.getCname(),dto.getBview(),dto.getBdate());
		}
	}
	// 6. 해당 카테고리 모든 게시물 출력
	public void boardprint() {
		System.out.println("=============== 카테고리 선택 ===============");
		System.out.print("선택 카테고리 번호 :  "); 
		int cno = scanner.nextInt();
		ArrayList<BoardDto> blist = Bcontroller.getInstance().boardprint(cno);
		System.out.printf("%5s %10s %10s %10s %10s\n","번호","제목","작성자","조회수","작성일");
		for(BoardDto dto : blist) {
			System.out.printf("%5s %10s %10s %10s %10s \n",
					dto.getBno(),dto.getBtitle(),dto.getMid(),dto.getBview(),dto.getBdate());
		}
		
		while(true) {
			System.out.println("갤러리메뉴 : 1. 뒤로가기  2. 게시물쓰기  3. 게시물보기");
			int ch = scanner.nextInt();
			if      (ch==1) {break; }
			else if (ch==2) {boardAdd(cno); }
			else if (ch==3) {break;  }
		}
		
	}
	
	
	
	
}
