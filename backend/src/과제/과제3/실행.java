package 과제.과제3;

import java.util.ArrayList;
import java.util.Scanner;



public class 실행 {

	public static void main(String[] args) {
		
		// * 입력객체
		Scanner scanner = new Scanner(System.in);
		// * 리스트 선언 [Book 객체를 여러개 저장할 리스트]
		ArrayList<Book>bookList = new ArrayList<>();
		ArrayList<Member>memberList = new ArrayList<>();
		
		

		while(true)
			{
			
			while(true)
				{System.out.println("---------- 이젠 도서관 ------------");
					System.out.println("메뉴 > 1.로그인 2.회원가입");
					
					int ch2 = scanner.nextInt();
					// 1. 로그인 선택
					if(ch2==1)
						{
						System.out.println("---------- 이젠 도서관 로그인 ------------");
						System.out.println("id : "); 	   String inputid =scanner.next();
						System.out.println("password : "); String inputpw =scanner.next();
						 
						memberList.forEach((o)->{				
							if(o.id != inputid || o.password != inputpw)
								{System.out.println("등록된 회원이 아닙니다.");}
							else {System.out.println("[알림] 로그인 성공");}
							});		
						}
					// 2. 회원가입 선택
					else if(ch2==2) 
						{
						System.out.println("---------- 이젠 도서관 회원가입 ------------");
						System.out.println("id : "); 		String inputid =scanner.next();
						System.out.println("password : "); 	String inputpw =scanner.next();
						System.out.println("name : "); 		String inname =scanner.next();
						System.out.println("phone : "); 	String inphone =scanner.next();
						
						Member member = new Member();
						member.id 		= inputid;
						member.password = inputpw;
						member.name 	= inname;
						member.phone 	= inphone;
				
						memberList.add(member);
						}	
				break;}
			
			// 출력부
			System.out.println("--------------- 이젠 도서관 ---------------");
			System.out.println("번호\t대여여부\t도서장르\t도서명");

			for( int i = 0 ; i<bookList.size() ; i++ ) { // i는 0부터 리스트내 마지막 인덱스까지 1씩증가 
				System.out.printf("%d \t %s \t %s \t %s \n" ,
						i , (bookList.get(i).state ? "가능" : "불가능") ,
						bookList.get(i).genre , bookList.get(i).name );
			} // for e
			
			// 입력부
			System.out.println("메뉴 > 1.도서대여 2.도서반납 3.도서등록[관리자]");
		
			int ch = scanner.nextInt();
			
			// 1. 도서대여 선택시 
			if(ch==1) 
				{
				System.out.println("--------------- 도서대여 페이지---------------");
				System.out.println("대여 할 도서 번호를 선택해 주세요."); 
				int no = scanner.nextInt();
				if(bookList.get(no).state==true)
					{bookList.get(no).state = false;
					System.out.println("[알림] 대여 성공");}
				else {System.err.println("[알림] 이미 대여중인 도서입니다.");}
				}
			// 2. 도서반납 선택시 
			else if( ch==2 )
				{
				System.out.println("-------------- 도서반납 페이지---------------"); 
				System.out.println("반납 할 도서 번호를 선택해 주세요."); 
				int no = scanner.nextInt();
				
				if(bookList.get(no).state==false)
					{bookList.get(no).state = true;
					System.out.println("[알림] 반납 성공");}
				else {System.err.println("[알림] 대여하신 도서가 아닙니다.");}

				}
			// 3. 도서등록 선택시 
			else if( ch==3 ) 
				{
				System.out.println("-------------- 도서등록 페이지---------------");
				System.out.println("도서명 : "); 	String name  = scanner.next();
				System.out.println("장르 : "); 	String genre = scanner.next();
				
				Book book = new Book();
				book.name 	= name;
				book.genre 	= genre;
				book.state	= true;

				bookList.add(book);
				
				}
			// 4. 그 외 
			else {System.err.println("[알림] 알 수 없는 행동입니다."); }


		} // while e
	} // main e	
} // class e
