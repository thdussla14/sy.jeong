package practice4;

import java.util.InputMismatchException;
import java.util.Scanner;

public class View {
	
	// 싱글톤
	private static View view = new View();
	private View () { }
	public static View getInsetance() { return view;}
	
	// 입력 객체
	Scanner scanner = new Scanner(System.in);
	
	// 인덱스
	public void index() {
		while(true) {
			try {
				System.out.println("---------------------------------------------");
				System.out.println("메뉴> 1. 관리자 	2. 사용자");
				System.out.println("---------------------------------------------");
				int ch = scanner.nextInt();
				if		(ch==1) {manager();}
				else if	(ch==2) {user();}
				else {break;}
			}
			catch (InputMismatchException e) {
				Scanner scanner = new Scanner(System.in);
				System.out.println(e.getMessage());}	
			catch (Exception e) {System.out.println("프로그램내 오류발생 - 관리자에게 문의하세요.");}
		}// while e		
	}
	// 관리자 
	public void manager() {
		while(true) {
			try {
				System.out.println("---------------------------------------------");
				System.out.println("메뉴> 1.등록 2.출력 3.수정 4.재고수정 5.삭제 6.나가기");
				System.out.println("---------------------------------------------");
				int ch = scanner.nextInt();
				if		(ch==1) {register();}
				else if	(ch==2) {list();}
				else if	(ch==3) {update();}
				else if	(ch==4) {stockUpdate();}
				else if	(ch==5) {delete();}
				else if	(ch==6) {break;}
			}
			catch (InputMismatchException e) {
				Scanner scanner = new Scanner(System.in);
				System.out.println(e.getMessage());}
			catch (Exception e) {System.out.println("프로그램내 오류발생 - 관리자에게 문의하세요.");}
		}// while e
	}
	// 등록
	public void register() {
		System.out.println("---------------------------------------------");
		System.out.print("제품명 : "); 	String 	pname 	= scanner.next();
		System.out.print("제품가격 : ");	int 	pprice 	= scanner.nextInt();
		System.out.print("초기재고 : ");	int 	pstock 	= scanner.nextInt();
		
		boolean result = Contoller.getInsetance().register(pname,pprice,pstock);
		
		if(result) {System.out.println("[알림] 제품 등록이 완료되었습니다.");}
		else {System.out.println("[알림] 제품 등록에 실패하였습니다.");}		
	}
	// 출력
	public void list() {
		System.out.println("---------------------------------------------");
		System.out.printf("%3s\t%10s\t%9s%10s\n","번호","제품명","가격","재고");
		System.out.println("---------------------------------------------");
		Contoller.getInsetance().list();
		System.out.println("---------------------------------------------");
	}
	// 수정
	public void update() {
		System.out.println("---------------------------------------------");
		System.out.print("수정할 제품번호 : ");	int 	pno 	= scanner.nextInt();
		System.out.println("---------------------------------------------");
		System.out.print("제품명 : "); 		String 	pname 	= scanner.next();
		System.out.print("제품가격 : ");		int 	pprice 	= scanner.nextInt();

		boolean result = Contoller.getInsetance().update(pno,pname,pprice);
		
		if(result) {System.out.println("[알림] 제품 수정이 완료되었습니다.");}
		else {System.out.println("[알림] 제품 수정에 실패하였습니다.");}	
	}
	// 재고 수정
	public void stockUpdate() {
		System.out.println("---------------------------------------------");
		System.out.print("수정할 제품번호 : ");	int 	pno 	= scanner.nextInt();
		System.out.println("---------------------------------------------");
		System.out.print("수정재고 : ");		int 	pstock 	= scanner.nextInt();
		
		boolean result = Contoller.getInsetance().stockUpdate(pno,pstock);
		
		if(result) {System.out.println("[알림] 재고 수정이 완료되었습니다.");}
		else {System.out.println("[알림] 재고 수정에 실패하였습니다.");}	
	}
	// 삭제
	public void delete() {
		System.out.println("---------------------------------------------");
		System.out.print("삭제할 제품번호 : ");	int 	pno 	= scanner.nextInt();
		System.out.println("---------------------------------------------");
		
		boolean result = Contoller.getInsetance().delete(pno);
		
		if(result) {System.out.println("[알림] 제품 삭제가 완료되었습니다.");}
		else {System.out.println("[알림] 제품 삭제에 실패하였습니다.");}	
	}
	// 사용자
	public void user() {
		while(true) {
			try {
				System.out.println("---------------------------------------------");
				System.out.printf("%3s\t%10s\t%9s%10s\n","번호","제품명","가격","상태");
				System.out.println("---------------------------------------------");
				Contoller.getInsetance().user();
				System.out.println("---------------------------------------------");
				System.out.println("메뉴> 1.제품선택 2.장바구니 3.결제 4.나가기");
				System.out.println("---------------------------------------------");
				
				int ch = scanner.nextInt();
				if		(ch==1) {check();}
				else if	(ch==2) {shoppingList();}
				else if	(ch==3) {buy();}
				else if	(ch==4) {break;}
			}
			catch (InputMismatchException e) {
				Scanner scanner = new Scanner(System.in);
				System.out.println(e.getMessage());}
			catch (Exception e) {System.out.println("프로그램내 오류발생 - 관리자에게 문의하세요.");}
		}// while e
	}
	// 제품선택
	public void check() {
		System.out.println("---------------------------------------------");
		System.out.print("구매할 제품번호 : ");	int 	pno 	= scanner.nextInt();
		System.out.println("---------------------------------------------");
		
		boolean result = Contoller.getInsetance().check(pno);
		
		if(result) {System.out.println("[알림] 제품을 장바구니에 담았습니다.");}
		else {System.out.println("[알림] 재고가 부족합니다.");}	
	}
	// 장바구니 확인
	public void shoppingList() {
		if(Contoller.getInsetance().shoppingList.size()>0) {
			try {
				System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<[장바구니]");
				System.out.printf("%3s\t%10s\t%10s%3s\n","번호","제품명","가격","수량");
				System.out.println("---------------------------------------------");
				Contoller.getInsetance().shoppingList();
				System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
				System.out.println("메뉴> 1.삭제 2.결제 3.결제취소 4.뒤로가기");
				System.out.println("---------------------------------------------");
					
				int ch = scanner.nextInt();
				if		(ch==1) {MYdelete();}
				else if	(ch==2) {buy();}
				else if	(ch==3) {reset();}
			}
			catch (InputMismatchException e) {
				Scanner scanner = new Scanner(System.in);
				System.out.println(e.getMessage());}
			catch (Exception e) {System.out.println("프로그램내 오류발생 - 관리자에게 문의하세요.");}
		}
		else { System.out.println("[알림] 장바구니가 비었습니다.");}
	}
	// 결제
	public void buy() {
		if(Contoller.getInsetance().shoppingList.size()>0) {
			System.out.println("[영수증]<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			System.out.printf("%3s\t%10s\t%10s%3s\n","번호","제품명","가격","수량");
			System.out.println("---------------------------------------------");
			Contoller.getInsetance().shoppingList();
			System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
			boolean result = Contoller.getInsetance().buy();		
			if(result) {System.out.println("[알림] 결제 완료되었습니다.");}
			else {System.out.println("[알림] 결제 실패하였습니다.");}
		}
		else { System.out.println("[알림] 장바구니가 비었습니다.");}
	}
	// 장바구니 제품 삭제
	public void MYdelete() {
		System.out.println("---------------------------------------------");
		System.out.print("삭제할 번호 : ");	int 	index 	= scanner.nextInt();
		
		boolean result =  Contoller.getInsetance().MYdelete(index);

		if(result) {System.out.println("[알림] 장바구니에서 제품이 삭제되었습니다.");}
		else {System.out.println("[알림] 삭제 실패하였습니다.");}
	}
	// 결제 취소 = 장바구니 비우기
	public void reset() {
		Contoller.getInsetance().reset();
	}
	
	
}
