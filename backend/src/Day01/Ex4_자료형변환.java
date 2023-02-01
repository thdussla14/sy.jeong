package Day01;

public class Ex4_자료형변환 { // class s

	public static void main(String[] args) { // main s
		
		// 1. 자동 타입 변환	
		
		byte b1 = 10; 	int i1 = b1; 				// byte  --> int  가능
		char c1 = '가';	i1 = c1; 					// char  --> int  가능
		int i2 = 50 ; 	long l1 = i2;				// int  --> long  가능
		long l2 = 100; 	float f1 = l2; 				// long --> float 가능
		
		// 2. 강제 타입 변환	
		
		//int i3 = 10 ; 	byte b2 = i3 ;			// int	--> byte 불가능
		int i3 = 10 ; 		byte b2 = (byte)i3;
		//long l3 = 300; 	int i4 = l3; 			// long	--> int  불가능
		long l3 = 300; 		int i4 = (int)l3; 
		//int i5 = 65; 		char c2 = i5 ; 			// int	--> char 불가능
		int i5 = 65; 		char c2 = (char)i5 ; 
		
		
		// 4. 문자열 타입 변환
		String str1 = "10"; 						//  10 : int vs "10" 다르다		
		
		byte 바이트1  = Byte.parseByte(str1);
		short 쇼트1  = Short.parseShort(str1);
		int 인트1 = Integer.parseInt(str1);
		long 롱1  = Long.parseLong(str1);
		float 플롯1  = Float.parseFloat(str1);
		double 더블1 = Double.parseDouble(str1);
		
			// "10"  문자열 타입의 숫자 10  --> 10 : 정수형 타입의 숫자 10
			// "ABC" 문자열 타입의 문자 ABC --> 불가능
		
		// String str2 = "안녕";
		// int 인트2 = Integer.parseInt(str2); System.out.println(인트2);	 // 불가능 
		// int 인트3 = Integer.parseInt(str2);
		
	} // main e

}  // class e


/* 

	자료형/타입 변환
		- 허용 범위 순서
		
			byte [1] > short, char [2] > int [4] > long [8] > float [4] > double [8]
		
		1. 자동 타입 변환	[ 캐스팅 ] 
			- 작은 타입 --> 큰 타입 이동
			
			작은 허용범위 타입  = 큰 허용범위 타입
		
		2. 강제 타입 변환	[ 캐스팅 ] 
			- 손실이 있더라도 강제로 변환
			(새로운 타입) 변환할 데이터 

			작은 허용범위 타입  = 큰 허용범위 타입 [X]
			작은 허용범위 타입  = (타입)큰 허용범위 타입 [O]

		3. 연산시 자동 타입 변환
		 피연산자 중 큰 타입의 결과를 반환

				예외) int 보다 작은 byte, short 연산시 무조건 int 결과 
					byte  + byte   = int
					short + short  = int	
				
		4. !! 문자열 타입 변환
 			
 

 */































