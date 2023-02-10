package Day07.EX6;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex6_회원시스템_컬렉션프레임워크 {

	
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		// 배열 대신 컬렉션 프레임 워크
		ArrayList<Member> memberList = new ArrayList<>(); // 가변길이
		
			// ArrayList : 리스트 선언에 사용되는 클래스
			// <클래스명>	 : 리스트 안에 들어갈 항목의 클래스
		
		while(true)
			{ 
			//memberList.forEach((o)->{ System.out.println(o);}); // js : (인수)=>{실행문;} vs JAVA : (인수)->{실행문;} 
			// 배열명  	.legth   : 배열내 길이 		[고정 길이]
			// 리스트명	.size()  : 리스트내 요소들의 개수	[가변 길이]
			System.out.println("번호\t회원명\t전화번호");
			for ( int i=0 ; i<memberList.size() ; i++)
				{ System.out.println(i+"\t"+ memberList.get(i).name+"\t"+memberList.get(i).phone);}
			
			System.out.println("메뉴> 1. 회원등록   2. 회원삭제");
			int ch = scanner.nextInt();
			
			if(ch == 1)
				{
				System.out.println("회원명 : ");	 	String inname  = scanner.next();
				System.out.println("전화번호 : "); 	String inphone = scanner.next();
				
				Member member = new Member();
				member.name  = inname;
				member.phone = inphone;
				memberList.add(member); // 리스트에 객체 추가
				}
			else if(ch == 2) 
				{
				System.out.println("삭제할 번호를 입력해주세요."); 
				int no = scanner.nextInt();
				memberList.remove(no);
				}
			else {break; }
			
			} // while e
		} // main e
	} // class e
