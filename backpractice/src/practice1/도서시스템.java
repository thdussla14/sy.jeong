package practice1;

import java.util.ArrayList;
import java.util.Scanner;

public class 도서시스템 {

	public static void main(String[] args) throws Exception{
		
		Scanner scanner = new Scanner(System.in);
		
		ArrayList<Book>   bookList   = new ArrayList<>();
		ArrayList<Member> memberList = new ArrayList<>();
		ArrayList<Book>   rentList   = new ArrayList<>();
	
			while(true) // 무한 루프 
				{
				System.out.println("--------------- 이젠 도서관 ---------------");
				System.out.println("메뉴 >  1. 로그인   2. 회원가입");
				
				int ch = scanner.nextInt();
					
				// 1. 로그인 선택---------------------------------------------------------------------------------
				if (ch==1)	
					{System.out.println("------------ 이젠 도서관 로그인 -------------");
					 System.out.println("id : "); String inid = scanner.next();
					 System.out.println("pw : "); String inpw = scanner.next();
					
					 for (int i=0 ; i<memberList.size() ; i++ )
					 	{//  회원 로그인--------------------------------------------------------------------------
						 if(memberList.get(i).id.equals(inid) && memberList.get(i).password.equals(inpw))
					 		{System.out.println("[로그인 성공]");
					 		while(true)
								 {System.out.println("--------------- 이젠 도서관 ---------------");
								 System.out.println("번호\t대여여부\t도서장르\t도서명");
								 for (int j=0; j< bookList.size() ; j++)
								 	{ System.out.println(j+ "\t"
								 		+ ( bookList.get(j).state? "가능" : "불가능" ) + "\t"
								 		+ bookList.get(j).genre + "\t"
								 		+ bookList.get(j).name);}
						 		
								 System.out.println("메뉴 > 1.도서대여 2.도서반납 3.대여도서목록 4.로그아웃");
									
								 int ch2 = scanner.nextInt();
								 
								// 도서대여
								if( ch2==1)
									{System.out.println("------------ 도서대여 -------------");
									 System.out.println("대여 도서 번호 : ");  	int no 	= scanner.nextInt();
									
									 if(bookList.get(no).state == true)
									 	{System.out.println("[대여성공]"); 
									 	bookList.get(no).state = false;
									 	bookList.get(no).member= memberList.get(i);
									 	rentList.add(bookList.get(no));
									 	memberList.get(i).rentList=rentList;}
									 else { System.err.println("[알림] 대여 불가능한 도서입니다.");}
									
									} // 도서대여 e
								
								// 도서반납
								else if( ch2==2)
									{System.out.println("------------ 도서반납 -------------");
									 System.out.println("반납 도서 번호 : ");  	int no 	= scanner.nextInt();
									
									 if(bookList.get(no).state == false)
									 	{System.out.println("[반납완료]"); bookList.get(no).state = true;}
									 else { System.err.println("[알림] 대여한 도서가 아닙니다.");}
									
									} // 도서반납 e
								else if( ch2==3)
									{
									 if(memberList.get(i).rentList != null)
										 { System.out.println("----------- 대여도서목록 -----------");
										 System.out.println("도서장르\t도서명");
										 for (int j=0; j< memberList.get(i).rentList.size() ; j++)
										 	{System.out.println( 
										 		rentList.get(j).genre + "\t"
										 		+ rentList.get(j).name);}
										 }
									 else {System.out.println("[알림] 대여중인 도서가 없습니다.");}
									} // 대여목록 e
								else if( ch2==4)
								 	{System.out.println("[로그아웃]"); break; } 
								
								else {System.err.println("[알림] 알 수 없는 행동입니다.");} 
								
								 }// while e
					 		} // 회원 로그인 e
					 	}// for e
						 
						//  관리자 로그인--------------------------------------------------------------------------
					 	if ( "admin".equals(inid) && "1234".equals(inpw) )
					 		{System.out.println("[관리자 로그인 성공]");
					 		while(true)
								 {System.out.println("--------------- 이젠 도서관 ---------------");
								 System.out.println("번호\t대여여부\t도서장르\t도서명\t대여회원");
								 for (int j=0; j< bookList.size() ; j++)
								 	{ System.out.println(j+ "\t"
								 		+ ( bookList.get(j).state? "가능" : "불가능" ) + "\t"
								 		+ bookList.get(j).genre + "\t"
								 		+ bookList.get(j).name+ "\t"
								 		+(bookList.get(j).state?" ": bookList.get(j).member.id) );}
						 		
						 		 System.out.println("[관리자] 메뉴 > 1.도서등록  2.도서삭제  3.로그아웃");
								
								 int ch2 = scanner.nextInt();
								 
								// 도서등록
								 if( ch2==1)
									{System.out.println("------------ 도서등록 -------------");
									 System.out.println("도서명 : ");  	String inname 	= scanner.next();
									 System.out.println("도서장르 : ");	String ingenre 	= scanner.next();
									
									 Book book = new Book();
									 book.name 		= inname;
									 book.genre		= ingenre;
									 book.state		= true;
									 
									 bookList.add(book);
									
									} // 도서등록 e
								 
								 // 도서삭제
								 else if( ch2==2)
									{System.out.println("------------ 도서삭제 -------------");
									 System.out.println("삭제 도서 번호 : ");  	int no 	= scanner.nextInt();
									 
									 if(bookList.get(no).state) 
									 	{bookList.remove(no);
									 	System.out.println("[도서삭제 성공]");}
									 else {System.err.println("[알림] 대여중인 도서는 삭제가 불가능합니다.");}
									
									} // 도서삭제 e
								 // 로그아웃
								 else if( ch2==3)
								 	{System.out.println("[로그아웃]"); break; } 
								 
								 else {System.err.println("[알림] 알 수 없는 행동입니다.");} 
						 		
							 }// while e
					 		} // 관리자 로그인 e
					 	
						 //  로그인 실패--------------------------------------------------------------------------
					 	 else {System.err.println("[로그인 실패]");}
				 
					}// 로그인 e
				
				// 2. 회원가입 선택---------------------------------------------------------------------------------
				else if (ch==2)
					{System.out.println("------------ 이젠 도서관 회원가입 -------------");
					 System.out.println("id : "); 	 	String inid 	= scanner.next();
					 System.out.println("pw : "); 	 	String inpw 	= scanner.next();
					 System.out.println("회원명 : ");  	String inname 	= scanner.next();
					 System.out.println("전화번호 : ");	String inphone 	= scanner.next();
					
					 Member member = new Member();
					 member.id 			= inid;
					 member.password 	= inpw;
					 member.name 		= inname;
					 member.phone 		= inphone;
					 member.rentList    = null;
					 
					 memberList.add(member);
					 
					 System.out.println("[회원가입 성공]");
					 System.out.println(member);
					}// 회원가입 e
				
				else { 	System.out.println("[알림] 알수 없는 행동 입니다.");}
				
		} // while e
	} // main e	
} // class e
