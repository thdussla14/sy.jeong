package Day02;	// 현재 클래스가 존재하는 패키지

// !!! 자바는 무조건 class 단위
	// 자바 100% 객체지향	// js : 함수단위
	// 클래스 기반으로 메모리 할당 : 객체
	// 클래스 : 객체 설계도

public class Ex1_출력 {

	// * main 함수 : main 스레드
	public static void main(String[] args) {
		
		System.out.println();
		// System : 시스템 클래스 [관련 매소드 제공]
			// out : 출력
		   		// println() : 출력 후 자동 줄바꿈 처리
				// print() : 출력
				// printf(): 형식 출력
		
		
		// print() : 출력
		System.out.print("print 함수1");
		System.out.print("print 함수2 \n");	
		
		// println() : 출력 후 자동 줄바꿈 처리
		System.out.println("println 함수1");	
		System.out.println("println 함수2"); 

		
		
		// printf("형식문자열",값)
		/*
		 * 형식문자열
		 * 		%d : 정수
		 * 			%자리수d		오른쪽부터 자리수 차지
		 * 			%-자리수d		왼쪽부터 자리수 차지
		 * 			%0자리수d		왼쪽부터 자리수 차지 [ 만일 자리수 데이터 없으면 0 출력 ]
		 *  	%f : 실수
		 *  		%
		 *  	%s : 문자열
		 * */
		int value = 123 ;	// int자료형에 'value' 이름으로 123 저장
		System.out.println("상품의 가격 : "+ value+"원");	//
		System.out.printf("상품의 가격 : %d원 \n ", value);		//
		System.out.printf("상품의 가격 : %6d원 \n", value);		//
		System.out.printf("상품의 가격 : %-6d원 \n", value);	//
		
		
		double area = 3.14159;
		System.out.println("파이 출력 "+area);					// 파이 출력 3.14159
		System.out.printf("파이 출력: %f \n",area);			// 파이 출력: 3.141590 
		System.out.printf("파이 출력: %.1f \n",area);			// 파이 출력: 3.1 
		System.out.printf("파이 출력: %3.2f \n",area);			// 파이 출력: 3.14 
		System.out.printf("파이 출력: %3.4f \n",area);			// 파이 출력: 3.1416 
		
		String name = "홍길동";
		String job = "도적";
		System.out.printf("%6d | %-10s | %10s \n", 1, name, job);
		
		
		
		
		
		
		
	}	// main e
	

	}	// class e

/*
 	String : 문자열 클래스
 	System : 시스템 클래스
 
 
 	* 제어/ 이스케이프 문자
 		\n : 줄바꿈
 		\t : 들여쓰기
 		\" : " 출력
 		\' : ' 출력
 
 */
