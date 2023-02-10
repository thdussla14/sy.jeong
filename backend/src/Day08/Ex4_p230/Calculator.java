package Day08.Ex4_p230;

public class Calculator {

	// 1. 필드
	
	
	// 2. 생성자
	
	
	// 3. 메소드
		// 1. 반환x 인수x
		void powerOn()
			{System.out.println("전원을 켭니다.");}
		
		void powerOff()
			{System.out.println("전원을 끕니다.");}

		// 2. 인수  x,y / 반환 : int		// 예 ) x=3, y=5		return = 8
		int plus (int x, int y)
			{int result = x+y ;
			return result;}
		
		// 3. 인수 x,y / 	반환 : double		// 예 ) x=3, y=5		return = 0.6
		double divide(int x, int y)
			{double result = (double)x/(double)y;
			return result;}
		
		// 4. 인수 x,y /  반환 x
		void multiply (int x, int y)
			{double result = (double)x *(double)y;
			System.out.println(result);}
		
		// 5. 인수 x /  반환 o
		String info()
			{return "이젠 계산기";	}
		
		// 6. 내부에서 함수 호출 // 함수명();
		void 함수호출()
			{powerOn();}



}	

/*
	함수 = 메소드
	
	JS 								vs 		JAVA 					
	<선언>									<선언>
	function 함수명(인수1, 인수2){함수}				리턴타입 함수명 (인수1, 인수2) {함수}
	<호출>									<내부 호출>	
	함수명 (인수1, 인수2)							함수명 (인수1, 인수2)
											<외부 호출>
											객체명.함수명(인수1, 인수2)
																						
	1. 인수x 반환x
		void 함수명 ( ){ }
	2. 인수o 반환x
		void 함수명 (인수1, 인수2 ){ }											
	3. 인수x 반환o
		리턴타입 함수명 ( ){return 값;}											
	4. 인수o 반환o
		리턴타입 함수명 (인수1, 인수2 ){return 값; }											
											
*/