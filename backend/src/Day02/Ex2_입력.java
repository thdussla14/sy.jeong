package Day02;

import java.util.Scanner;	// Scanner 클래스를 사용하기 위한 Scanner 클래스 가져오기

public class Ex2_입력 {

	public static void main(String[] args) {
		
		// 1. 입력
			// scan+자동완성 => import 자동 생성
			// 객체 생성 : 클래스명 변수명 = new 생성자명 (인수);
			// 입력 객체 : Scanner Scanner = new Scanner(System.in); // 일반적으로 객체는 클래스의 소문자형으로 작성 
				// { }별 1번 선언
		Scanner Scanner = new Scanner(System.in); 
		
		// 2. 입력메소드 -> 변수 저장 [자료형 맞추기] 

		// 1. 문자열[ 띄어쓰기 불가능] 입력받기 함수
		String 문자열1 	= Scanner.next();				System.out.println("문자열1 : "+문자열1);
		// 2. 문자열[ 띄어쓰기 가능 ] 입력받기 함수	// nextLine() 앞에 다른 next()와 하나로 취급
		Scanner.nextLine();	// 해결방안
		String 문자열2 	= Scanner.nextLine();			System.out.println("문자열2 : "+문자열2);		
		// 3. 논리 입력받기 함수
		boolean 논리  	= 	Scanner.nextBoolean(); 		System.out.println("논리 : "+논리);
		// 4. 첫글자만 입력받기 함수  
		char 문자 	 	= 	Scanner.next().charAt(0); 	System.out.println("문자 : "+문자);
		// 5. 정수형 입력받기 함수  
		byte 바이트 		= Scanner.nextByte();			System.out.println("바이트 : "+바이트);		
		short 쇼트 		= Scanner.nextShort();			System.out.println("쇼트 : "  +쇼트);		  
		int 인트			= Scanner.nextInt();			System.out.println("인트 : "+인트);		  
		long 롤 			= Scanner.nextLong();			System.out.println("롤  : "+롤 );		
		// 6. 실수형 입력받기 함수
		float 플롯 		= Scanner.nextFloat();			System.out.println(" 플롯 : "+ 플롯);	  
		double 더블 		= Scanner.nextDouble();			System.out.println("더블 : "+더블);
		
		// 기본 자료형 비교				[비교 연산자 가능 == ]
		int 비밀번호 = 1234;
			System.out.println(비밀번호 == 1234);	// true
		
		// 문자열 [String 객체] 비교	[String 객체 연산자 불가능-> 문자열A.equals("문자열B")]
		String 아이디 = "qwe";	
			System.out.println(아이디 = "qwe");	// false
		
	
	}	// main e
	
	
}	// class e



/*
	System		import java.lang 패키지 생략
	String 		import java.lang 패키지 생략
	Scanner		import java.util.Scanner;







 */