package Day07.EX4;

import java.util.Scanner;

public class 실행 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		Member[] memberList = new Member[3];	// Member 객체 3개 저장할 수 있는 배열 선언
												// Member : String 2개 저장할 수 있는 클래스
		
		while(true)
			{
			// 출력
			System.out.println("번호\t회원명\t전화번호");
			for( int i=0 ; i<memberList.length; i++)
				{if(memberList[i] != null)
					{System.out.println(memberList[i].name+"\t"+memberList[i].phone);}
				}

			// 입력
			System.out.println("메뉴> 1. 회원 등록     2. 회원 삭제");
			int ch = scanner.nextInt();
			if(ch==1) 
				{System.out.println("회원명 : "); 	String inname  = scanner.next(); 
				 System.out.println("전화번호 : "); 	String inphone = scanner.next(); 
				
				for(int i=0 ; i<memberList.length ; i++) 
					{ if(memberList[i]==null)
					 	{ // [X] name + "," + phone
						  // [O] 객체 만들기
						 Member member = new Member();
						 member.name  = inname;
						 member.phone = inphone;
						 memberList[i] = member;}
					} // for e
				} // if e
			else if(ch==2) { }
			else {break;}
			
			
		} 	// while e
	}	// main e
	
}	//class e
