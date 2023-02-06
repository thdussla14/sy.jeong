package Day04;

import java.util.Scanner;

public class Ex2_예금 {

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		// * 예금액 [ 누적 ] , 계좌번호 , 비밀번호
		int balance = 0; String account="123-1234"; short password = 1234;
		
	
		while(true) {	// 무한루프
			
			System.out.println("-----------------");
			System.out.println("1.예금 2.출금 3.잔고 4.종료 : ");
			System.out.println("-----------------");
			System.out.println(">> 선택 : ");
			
			int ch = scanner.nextInt();
			
			// 1. 예금-----------------------------------------------------------------------
			
			if(ch==1)
				{// 1-1. 예금 계좌번호 입력
				System.out.println(">>> 예금할 계좌번호 : ");
				String inaccount = scanner.next();
				 // 1-2. 예금 계좌번호 일치 확인
				if(account.equals(inaccount)) 
					{	// 1-3. 계좌 일치시 예금 진행
					System.out.println(">>> 예금할 금액 : ");
					balance += scanner.nextInt();
					System.out.println(">>> 예금후 금액 : "+balance);}
				else {	// 1-3. 계좌 불일치시 알림
					System.out.println(">>> 없는 계좌번호 입니다.");}				
				} // 1. 예금 종료
			
			// 2. 출금------------------------------------------------------------------------
			// if1 계좌번호 일치 / if2 비밀번호 일치 / if3 잔액 충족 
			
			
			else if(ch==2) 
				{// 2-1. 출금 계좌번호 입력
				System.out.println(">>> 출금할 계좌번호 : ");
				String inaccount = scanner.next();
				 // 2-2. 출금 계좌번호 일치 확인
				if(account.equals(inaccount)) 
					{// 2-3. 계좌 일치시 비밀번호 입력
					System.out.println(">>> 계좌 비밀번호 : ");
					short inpassword = scanner.nextShort();
					// 2-4. 비밀번호 일치 확인
					if(password==inpassword) 
						{	// 2-5. 비밀번호 일치시 출금 진행
						System.out.println(">>> 출금할 금액 : ");								
						int pay = scanner.nextInt(); 
								// 2-6. 잔액 확인
						if(balance > pay)
							{	// 2-7. 잔액 충족시 출금
							balance -= pay;
							System.out.println(">>> 출금후 금액 : "+balance);}
						else{	// 2-7. 잔액 부족 알림
							System.out.println(">>> 잔액부족 : "+balance);}
						}
					else {	// 2-5. 비밀번호 불일치시 알림
						System.out.println(">>>  해당 계좌번호의 비밀번호가 아닙니다.");}
					}
				else {// 2-3. 계좌 불일치시 알림
					System.out.println(">>> 없는 계좌번호 입니다.");}
				}	// 2. 출금 종료
			
			// 3. 잔고-------------------------------------------------------------------------
			else if(ch==3) 
				{// 3-1. 조회할 계좌번호 입력
				System.out.println(">>> 조회할 계좌번호 : ");			
				System.out.println(">>> 통장 잔고 : "+balance);}
			
			// 4. 종료-------------------------------------------------------------------------
			else if(ch==4) 
				{System.out.println(">>> 종료"); break;}
			else {System.out.println(">>>>알 수 없는 번호입니다. [ 다시입력 ]");}		
			
		}	// while e
		
	}	// main e  
		
}	// class


/*
	* 예제에서 중요한 코드
		1. if 중첩
		2. 	자료형 [char] 	변수 == 변수
			클래스 [String]	변수.equals( 변수 )

*/















