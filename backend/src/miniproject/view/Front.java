package miniproject.view;

import java.util.ArrayList;
import java.util.Scanner;

import miniproject.controller.CMember;
import miniproject.controller.CMemo;
import miniproject.controller.CProduct;
import miniproject.model.Accessories;
import miniproject.model.Beauty;
import miniproject.model.Dresses;
import miniproject.model.Electronics;
import miniproject.model.Memo;
import miniproject.model.Product;

public class Front {
	
	// 싱글톤
	private static Front front = new Front();
	private Front() {}
	public static Front getInstance() { return front; }
	private Scanner scanner = new Scanner(System.in);
	
	Product p  = new Product();
	Product p1 = new Dresses();
	Product p2 = new Beauty();
	Product p3 = new Accessories();
	Product p4 = new Electronics();

	// 1. 메인페이지
	public void index() {
		while(true) {
			System.out.println(" ---------------이젠 중고--------------- ");
			System.out.println(" 1. 회원가입 2. 로그인 3. 아이디찾기 4. 비밀번호찾기");	// 즐겨찾기 품목 추가??
			System.out.println("메뉴 선택 : ");int ch = scanner.nextInt();
			if ( ch == 1 ) { signup_page(); }
			else if ( ch == 2 ) { login_page(); }
			else if ( ch == 3) { findId_page(); }
			else if ( ch == 4 ) { findPw_page(); } 
			else { System.err.println("메뉴선택을 [1] ~ [4]번 안에서 해주세요."); }
		}
	}
	
	// 2. 회원가입 페이지
	public void signup_page() {
		System.out.println("ID : ");			String id = scanner.next();
		System.out.println("PW : ");			String pwd = scanner.next(); 
		System.out.println("Password 확인 : ");	String confirmpwd = scanner.next();
		System.out.println("이름 : ");			String name = scanner.next();
		System.out.println("전화번호 : ");			String phone = scanner.next();
		
		int result = CMember.getInstance().signup(id, pwd, confirmpwd, name, phone );
		if ( result == -6) { System.out.println("[알림] 회원가입 성공 축하드립니다!"); } // 회원가입 성공 시 product 페이지로 이동
		else if ( result == -1 ) { System.out.println("비밀번호가 다릅니다.");}
		else if ( result == -2 ) { System.out.println("ID의 길이를 5~10글자로 해주세요.");}
		else if ( result == -3 ) { System.out.println("ID는 영문과 숫자로 입력해주세요.");}
		else if ( result == -4 ) { System.out.println("전화번호에 숫자만 입력해주세요."); }
		else if ( result == -5 ) { System.out.println("ID와 Password 값이 같습니다. 다르게 입력해주세요.");  }
	}
	
	// 3. 로그인 페이지
	public void login_page(  ) {
		System.out.println("ID : "); String id = scanner.next();
		System.out.println("PW : "); String pw = scanner.next();
		int result = CMember.getInstance().login( id, pw );
		if ( result == -1 ) {System.out.println("ID나 PW가 옳지 않습니다.");}
		else if ( result == -2 ) { System.out.println("로그인 실패. 해당 아이디가 존재하지 않습니다."); } 
		else if ( result >= 0){ System.out.println("[알림]로그인 성공" + result); main_page( result ); } // result가 0이상일때 로그인성공 + mno 부여
		
	}
	
	// 4. 아이디 찾기 페이지
	public void findId_page(){
		System.out.println(" 이름 입력 : ");		String name = scanner.next();
		System.out.println(" 전화번호 입력 : ");	String phone = scanner.next();
		String result = CMember.getInstance().findId(name, phone);
		if ( result == null ) { System.out.println("아이디 찾기 실패"); }
		else { System.out.println("회원님의 아이디 : " + result + "입니다."); }
	}
	
	// 5. 비밀번호 찾기 페이지
	public void findPw_page() {
		System.out.println("ID 입력 : ");			String id = scanner.next();
		System.out.println("전화번호 입력 : ");		String phone = scanner.next();
		String result = CMember.getInstance().findPw(id, phone);
		if ( result == null ) { System.out.println("비밀번호 찾기 실패"); }
		else { System.out.println("회원님의 비밀번호 : " + result + "입니다."); }
 	}
	
	// 7. 메인
	public void main_page( int mno ) {
		while(true) {
			System.out.println(">>>>main>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("-----------------------------------------------------------\n"
						+ "01. 의류\n02. 화장품\n03. 악세사리\n04. 전자제품\n"
						+ "-----------------------------------------------------------\n"
						+ "메뉴 > 1. 카테고리 선택  2. 마이페이지  3. 로그아웃\n"
						+ "-----------------------------------------------------------");
				
			int ch  = scanner.nextInt();
			if		(ch==1) {String ch2  = scanner.next();
							print_page(ch2,mno);}
			else if	(ch==2) {myproduct_page(mno); }
			else if	(ch==3) {break; }
		}// while e
	}
	
	// 8. 출력
	public void print_page(String ch2,int mno) {

		ArrayList<Product> List = null;
	
		System.out.println(">>>>출력>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("---------------------------------------------------------------");
			
		System.out.println("카테고리번호제품번호\t제품이름\t제품가격\t제품상태");
		if(ch2.equals("01")) 	  {List = p1.print("01");}
		else if(ch2.equals("02")) {List = p1.print("02");}
		else if(ch2.equals("03")) {List = p1.print("03");}
		else if(ch2.equals("04")) {List = p1.print("04");}
		else {System.out.println("[알림] 등록된 제품이 없습니다.");}
				
		System.out.println("-----------------------------------------------------------\n"
					+ "메뉴 > 1. 제품등록	    2. 제품상세  3. 쪽지보내기 \n"
					+ "--------------------------------------------------------------");
			
		int ch  = scanner.nextInt();
		if ( ch == 1 )		{ resgister_page(mno); }
		else if ( ch == 2 ) { view_page(mno); }
		else if ( ch == 3 ) { System.out.println("쪽지 보낼 제품 번호 : "); int pno = scanner.nextInt();
							writeMemo(mno,pno); }
	}
	// 9. 등록
	public void resgister_page(int mno) {
			
		System.out.println(">>>>등록>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("------------------------------------------------------------");
		System.out.println("1. 의류 2. 화장품 3. 악세사리 4. 전자제품");
		System.out.println("카테 고리:");	String pcode 	= scanner.next();
		System.out.println("제품 이름:"); 	String title 	= scanner.next();
		System.out.println("제품 내용:"); 	String content 	= scanner.next();
		System.out.println("제품 가격:"); 	String price 	= scanner.next();
			
		if		(pcode.equals("1")) {p1.register(mno, title, content, price);}
		else if	(pcode.equals("2")) {p2.register(mno, title, content, price);}
		else if	(pcode.equals("3")) {p3.register(mno, title, content, price);}
		else if	(pcode.equals("4")) {p4.register(mno, title, content, price);}
		
		System.out.println("[알림] 등록 완료되었습니다.");
	}
	// 10. 상세
	public void view_page(int mno) {
		System.out.println(">>>>상세>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("-----------------------------------------------------------");
		System.out.println("제품 번호:");  int pno 	= scanner.nextInt();
		System.out.println("-----------------------------------------------------------");
		p.view(mno, pno);
	}
		
		
	// 11. 등록제품 출력
	public void myproduct_page(int mno) {
		while(true) {	
			
			ArrayList<Product> myP = CProduct.getInstance().myProducts(mno);
				
			int pno = 0; // pno 나와야함
				
			System.out.println(">>>>MY 등록 제품>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
			System.out.println("------------------------------------------------------------");
			System.out.println("카테고리번호제품번호\t제품이름\t제품가격");
			for(Product p : myP)
				{System.out.println(p.pCode+"\t"+p.pno+"\t"+p.title+"\t"+p.price+"\t"+p.state);}
			System.out.println("------------------------------------------------------------");
			System.out.println("메뉴 > 1. 제품수정   2. 제품삭제  3. 판매완료  4. 쪽지함 5. 뒤로가기");
			System.out.println("------------------------------------------------------------");
			
			int ch = scanner.nextInt();
			if		(ch==1) {update_page(mno); }
			else if	(ch==2) {delete_page(mno); }
			else if	(ch==3) {compelete_page(mno);}
			else if	(ch==4) {printMemo(mno, pno); }
			else if	(ch==5) {break; }
			else {System.err.println("[알림] 알 수 없는 행동입니다."); }
		
		}// while e
	}// page e
		
	// 12. 제품 수정
	public void update_page(int mno) {
			
		System.out.println(">>>>수정>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("-------------------------------------------------------------");
		System.out.println("제품 번호:");  int 	pno 	= scanner.nextInt();
		System.out.println("-------------------------------------------------------------");
		System.out.println("제품 이름:"); 	String title 	= scanner.next();
		System.out.println("제품 내용:"); 	String content 	= scanner.next();
		System.out.println("제품 가격:"); 	String price 	= scanner.next();
			
		p.update(mno, pno, title, content, price);
			
	}
	// 13. 제품 삭제
	public void delete_page(int mno) {
		System.out.println(">>>>삭제>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("------------------------------------------------------------");
		System.out.println("제품 번호:");  int 	pno 	= scanner.nextInt();
		System.out.println("------------------------------------------------------------");
			
		p.delete(mno, pno);
	}
	// 14. 제품 상태 변경
	public void compelete_page(int mno) {
		System.out.println(">>>>완료>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.println("------------------------------------------------------------");
		System.out.println("제품 번호:");  int 	pno 	= scanner.nextInt();
		System.out.println("------------------------------------------------------------");
		
		p.compelete(mno, pno);
	}
		
	//----------------------------------------------------- 메모 Strat
	// 1. 쪽지 작성 화면
	public void writeMemo( int fromNo, int pno ) {
		System.out.println("-----------------------쪽지 작성 페이지-----------------------");
		System.out.print("제목: ");					String title = scanner.next();
		System.out.print("내용: ");					String content = scanner.next();
		System.out.print("[하단 버튼] 1.발송 2.취소: ");	int send = scanner.nextInt();
			
		boolean result = CMemo.getInstance().writeMemo(fromNo, pno, title, content, send);
		if(result) {
			System.out.println("[알림]쪽지 발송 완료");
		}
		// 확인 필요 내용: 2번 눌렀을 때, 뒤 메뉴로 가는지 확인
	}
		
	// 2. 쪽지 출력 화면
	public void printMemo( int mno, int pno ) {
		while( true ) {
			System.out.println("-----------------------쪽지함-----------------------");
			System.out.println("제목\t내용");
			int i = 0;
			for( Product p : CProduct.getInstances()  ) {
				if( p.mno == mno) {
					for( Memo m : CMemo.getInstance().getMemoDB()) {
						if( p.mno == m.getfromNo() ) {
							System.out.println( m.getTitle() + "\t" + m.getContent() );
							}
						}
					}
				}
				
			System.out.print("쪽지 클릭: ");	int choice = scanner.nextInt();
			if( choice == -1) {
			break;
			}
			detailMemo(choice, pno);
		}
	}
		
	public void detailMemo( int mNo, int pno ) {
		CMemo.getInstance().detailMemo(mNo);
		System.out.print("[하단 버튼]1.뒤로가기 2.삭제");	int choice = scanner.nextInt();
		if( choice == 1 ) {
				
		}
		else if( choice == 2 ) {
			
		}
		else if( choice == 3 ) {
			
		}
		else { System.out.println("번호를 다시 입력해주세요.");	}
		}
	
}// class e
