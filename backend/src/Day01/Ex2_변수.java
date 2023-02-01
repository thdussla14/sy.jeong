
package Day01;	// 패키지명


//[p.34 변수]
public class Ex2_변수 {	// class s

	// ! main 함수 : 코드 읽어주는 역할 함수 [m+c+s+e]
	public static void main(String[] args) { // main s
		
/*		int value; 					// 변수 선언 : 자료형[타입] 변수명
		// 초기화 되지 않은 변수는  사용 불가
		System.out.println(value);  // [syso+c+s+e]
		
		int result = vlaue + 10 ;
		
		System.out.println(result);*/
		
		
		int hour = 3;				// 변수 선언 : int형 자료형 변수에 'hour'이름으로 저장
		int minute = 5;				// 변수 선언 : int형 자료형 변수에 'minute'이름으로 저장
		System.out.println(hour+"시"+minute+"분");
		
		int totalMinute = (hour*60)+minute;
		System.out.println(totalMinute);
		
		
		
		// [p.38 스왑]
		int x = 3;
		int y = 5;
		System.out.println("X"+x+"Y"+y);
		
		int temp = x;
		x = y;
		y = temp ;
		System.out.println("X"+x+"Y"+y);
		
		
		
		
		
	} // main e
	
	
}	// class e


/*
 * 
 	변수 : 데이터 1개를 저장 할 수 있는 메모리 공간
		1. 자료형/타입		2. 변수명		3. 초기값
		
		- 변수 선언
		지료형 변수명 = 초기값;	: 값이 존재하기 때문에 사용 가능
		자료형 변수명 ;			: 값이 존재하지 않으므로 사용 불가능
		- 변수 호출
		변수명
		


	java : 자료형/타입 직접 선언
	
		int 변수명 = 10 ;
		char 변수명 = 'A';
	
	vs
	
	
	JS : 자료형/타입 자동 관리
		let 변수명 = 10
		let 변수명 = 'A'


 * 
 */