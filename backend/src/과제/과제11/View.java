package 과제.과제11;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class View {

	private static View view = new View();
	private View () { }
	public static View getInstance() {return view;}
	
	Scanner scanner = new Scanner(System.in);
	
	public void index() {
		
		while(true) {
			try {
				System.out.println("----------------------------------------------");
				System.out.println("메뉴> 1.관리자 2.사용자 ");	
				System.out.println("----------------------------------------------");
				int ch = scanner.nextInt();
				if	   (ch==1) {manager_main(); }
				else if(ch==2) {user_main(); }
			}
			catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				Scanner scanner = new Scanner(System.in);
			}
			catch (Exception e) {System.out.println("프로그램내 오류발생 - 관리자에게 문의하세요.");}
		}// while e		
	}
	public void manager_main() {
		while(true) {
			try {
				System.out.println("----------------------------------------------");
				System.out.println("메뉴> 1.등록 2.출력 3.수정 4.재고수정 5.삭제 6.나가기");	
				System.out.println("----------------------------------------------");
				int ch = scanner.nextInt();
				if	   (ch==1) {register(); }
				else if(ch==2) {list(); }
				else if(ch==3) {update(); }
				else if(ch==4) {storage_update();}
				else if(ch==5) {delete(); }
				else if(ch==6) {break; }
			}
			catch (InputMismatchException e) {
				System.out.println("잘못된 입력입니다.");
				Scanner scanner = new Scanner(System.in);
			}
			catch (Exception e) {System.out.println("프로그램내 오류발생 - 관리자에게 문의하세요.");}
		}// while e	
	}
	public void user_main() {	
		while(true) {
			System.out.println("[키오스크]---------------------------------------");
			System.out.printf("%3s\t%10s\t%9s%10s\n","번호","제품명","가격","상태");
			ArrayList<DTO> result = Controller.getInstance().list();
			for(DTO dto : result) {
			 System.out.printf("%3d\t%10s\t%10d%10s\n",dto.getPno(),dto.getPname(),dto.getPrice(),
					(dto.getStorage()>0? "판매중":"재고부족"));
			}// for e
			System.out.println("----------------------------------------------");
			System.out.println("메뉴> 0. 결제 1. 제품번호선택 2. 나가기");
			System.out.println("----------------------------------------------");
			int ch  = scanner.nextInt();
			// 결제 선택
			if(ch == 0) {				
				boolean result3 = Controller.getInstance().sale(); 
				if(result3) {System.out.println("[알림] 구매 성공");}
				else{System.out.println("[알림] 구매 실패");}
				}
			else if ( ch==1 ) { 
				System.out.println("----------------------------------------------");
				System.out.print("구매할 제품번호 : "); int pno = scanner.nextInt();	
				System.out.println("----------------------------------------------");
				boolean result2 = Controller.getInstance().check(pno);
				if(result2) {System.out.println("장바구니 :"+Controller.getInstance().wishlist.size()+"개");}
				else {System.out.println("[알림] 재고 부족"); }
				}
			else if ( ch==2 ) {
				Controller.getInstance().wishlist.clear();
				break;}
			else {System.out.println("프로그램내 오류발생 - 관리자에게 문의하세요.");}	
		}
	}
	public void register() {	
		System.out.println("[등록]-----------------------------------------");
		System.out.print("제품이름 : "); String pname = scanner.next();
		System.out.print("제품가격 : "); int    price = scanner.nextInt();
		System.out.print("초기재고 : "); int  storage = scanner.nextInt();
		System.out.println("----------------------------------------------");
		boolean result = Controller.getInstance().register(pname,price,storage);
		
		if(result) {System.out.println("[알림] 제품 등록 성공");}
		else {System.err.println("[알림] 제품 등록 실패");}
	}
	public void list() {
		System.out.println("[출력]-----------------------------------------");
		System.out.printf("%3s\t%10s\t%10s%10s\n","번호","제품명","가격","재고");
		//System.out.println("제품번호\t제품명\t가격\t재고");
		ArrayList<DTO> result = Controller.getInstance().list();
		for(DTO dto : result) {
		 System.out.printf("%3d\t%10s\t%10d%10d\n",dto.getPno(),dto.getPname(),dto.getPrice(),dto.getStorage());
			//System.out.println(dto.getPno()+"\t"+dto.getPname()+"\t"+dto.getPrice()+"\t"+dto.getStorage());
		}
		System.out.println("----------------------------------------------");
	}
	public void update() {
		System.out.println("[수정]------------------------------------------");
		System.out.print("수정할 제품번호 : "); 	int 	pno  = scanner.nextInt();
		System.out.print("제품이름 : "); 		String pname = scanner.next();
		System.out.print("제품가격 : "); 		int    price = scanner.nextInt();
		System.out.println("----------------------------------------------");
		boolean result = Controller.getInstance().update(pno,pname,price);		
		if(result) {System.out.println("[알림] 제품 수정 성공");}
		else {System.err.println("[알림] 제품 수정 실패");}
		
	}
	public void storage_update() {
		System.out.println("-------[재고수정]------------------------------");
		System.out.print("수정할 제품번호 : "); 	int 	pno  = scanner.nextInt();
		System.out.print("재고 : "); 			int    stock = scanner.nextInt();
		System.out.println("--------------------------------------------");
		boolean result = Controller.getInstance().storage_update(pno,stock);
		if(result) {System.out.println("[알림] 재고 수정 성공");}
		else {System.err.println("[알림] 재고 수정 실패");}
		
	}
	public void delete() {
		System.out.println("-------[삭제]---------------------------------");
		System.out.print("삭제할 제품번호 : "); 	int 	pno  = scanner.nextInt();
		System.out.println("--------------------------------------------");
		boolean result = Controller.getInstance().delete(pno);
		if(result) {System.out.println("[알림] 제품 삭제 성공");}
		else {System.err.println("[알림] 제품 삭제 실패");}
	}

	
}
