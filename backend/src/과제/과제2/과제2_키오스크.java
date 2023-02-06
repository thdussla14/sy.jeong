package 과제.과제2;

import java.util.Scanner;

public class 과제2_키오스크 {

	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		// 재고 현황
		int colastorage 	= 10;
		int ciderstorage 	= 8;
		int hwantastorage 	= 15;
		// 장바구니 현황
		int cola  	= 0;
		int cider 	= 0;
		int hwanta	= 0;
		
		while(true)
		{System.out.println("1. 콜라[300원] 2. 사이다[400원] 3. 환타[500]");
			
		int ch = scanner.nextInt();
			// 1. 콜라 선택
			if(ch==1)
				{	// 1-1. 콜라 재고 확인
				if(colastorage>1)
					{ // 1-2. 콜라 재고 차감 , 장바구니 콜라 증가
					colastorage--;cola++;}
				else{ // 1-2. 재고 부족 알림
					System.err.println(">>>[알림]콜라 재고 부족");}
				}
			// 2. 사이다 선택
			else if(ch==2) 
				{	// 2-1. 사이다 재고 확인
				if(ciderstorage>1)
					{ // 2-2. 사이다 재고 차감 , 장바구니 사이다 증가
					ciderstorage--;cider++;}
				else{ // 2-2. 재고 부족 알림
					System.err.println(">>>[알림]사이다 재고 부족");}
				}
			// 3. 환타 선택
			else if(ch==3)
				{	// 3-1. 환타 재고 확인
				if(hwantastorage>1)
					{ // 3-2. 콜라 재고 차감 , 장바구니 콜라 증가
					hwantastorage--;hwanta++;}
				else{ // 3-2. 재고 부족 알림
					System.err.println(">>>[알림]환타 재고 부족");}
				}
			// 4. 결제 선택
			else if(ch==4) 
				{	// 4-1.장바구니 현황 출력 		
				System.out.println("----------------------");
				System.out.printf("%3s  %6s %5s \n","제품명","수량","가격");
				
				if(cola	!= 0)
					{System.out.printf("%3s  %6d %5d \n","콜라"	,cola	,(cola*300));}
				if(cider!= 0)
					{System.out.printf("%3s  %6d %5d \n","사이다"	,cider	,(cider*400));}
				if(hwanta!= 0)
					{System.out.printf("%3s  %6d %5d \n","환타"	,hwanta	,(hwanta*500));}
				
				int total = (cola*300)+(cider*400)+(hwanta*500);
				System.out.println("----------------------");
				System.out.println("총가격 : "+total);
				System.out.println("----------------------");
					// 4-2. 결제 여부 선택
				System.out.println(" 1. 결제  2. 취소");
					int ch2 = scanner.nextInt();
					// 4-3. 결제 선택	
					if(ch2 == 1)
						{System.out.println("금액을 입력해주세요.");
						int pay = scanner.nextInt();
						// 금액 충족 확인
						if(pay>total) 
							{// 잔액 출력
							System.out.println("잔액 :"+(pay-total));
							// 장바구니 초기화
							cola  	= 0;cider 	= 0;hwanta	= 0;
							}
						else {// 잔액 부족 알림
							System.err.println("[알림]잔액이 부족합니다. \n결제가 취소되었습니다.");
							// 장바구니 초기화
							cola  	= 0;cider 	= 0;hwanta	= 0;
							}
						}
					// 4-3. 취소 선택
					else if(ch2 == 2)
						{// 재고 복구
						colastorage += cola;ciderstorage += cider;hwantastorage += hwanta;
						// 장바구니 초기화
						cola  	= 0;cider 	= 0;hwanta	= 0;
						}
					// 4-3. 예외의 번호 입력시 에러 알람	
					else {System.err.println(">>> 알 수 없는 번호 입니다.");}				
			}
		// 5. 예외의 번호 입력시 에러 알람	
		else {System.err.println(">>> 알 수 없는 번호 입니다.");}
		
		}	// while e	
		
	}	// main e
	
}	// class e
