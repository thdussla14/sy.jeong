package Day08.Ex5;

import java.util.ArrayList;
import java.util.Scanner;

public class Front {

	// 1. 필드 [ 변수, 객체 , 배열]
		// 1. 입력 객체
		Scanner scanner = new Scanner(System.in);
		// 2. 리스트 객체 [ member 객체 여러개 저장할 수 있는 배열 ]
		ArrayList<Member> memberList = new ArrayList<>();
	// 2. 생성자
	
	// 3. 메소드
	
	// 3-1. 메인페이지 함수
	void index(){
		while(true){
			print();
			System.out.println("1. 회원등록   2. 회원삭제  : ");
			int ch = scanner.nextInt();
			if(ch==1)		{signup();}
			else if(ch==2)	{delete();}
			else { }

		}	// while e
	}	// index e
	
	// 3-2. 회원등록 페이지 함수
	void signup() {
		System.out.println("회원명 : ");		String name = scanner.next();
		System.out.println("전화번호 : ");		String phone = scanner.next();
		// * 생성자를 이용한 객체 선언
		Member member = new Member(name, phone);
		// * 배열 or 리스트에 객체 저장
		memberList.add(member);
		}// signup e
	
	// 3-3. 회원삭제 페이지 함수
	void delete() {
		System.out.println("삭제할 번호/인덱스 : ");	
		int no = scanner.nextInt();
		memberList.remove(no);

		}// delete e
	
	// 3-4. 출력
	void print() {
		System.out.println("번호\t회원명\t전화번호");
		for ( int i=0 ; i<memberList.size() ; i++)
			{ System.out.println(i+"\t"+ memberList.get(i).name
			+"\t"+memberList.get(i).phone);}// for e
		}// print e

} // class e
