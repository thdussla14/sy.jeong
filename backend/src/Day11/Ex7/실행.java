package Day11.Ex7;

import java.security.PublicKey;

public class 실행 {

	public static void main(String[] args) {
		
		// 1. 기본 타입 자동 타입 변환
		byte value1 = 10;
			short value2 = value1;
				int value3 = value2;
					long value4 = value3;
						float value5 = value4;
							double value6 = value5;
							
		// 2. 기본 타입 강제 타입 변환---> 캐스팅( )
		double value7 = 10.111111;
			float value8 = (float) value7;
				long value9 = (long) value8;
					int value10 = (int) value9;
						short value11 = (short) value10;
							byte value12 = (byte) value11;
							
		// 3. 매개변수, 리턴타입
		double result 	= 함수1 	(value1);	
		double result2 	= 함수2	((byte)value3); // 함수 선언시에는 캐스팅 x , 데이터 대입시 캐스팅 o
	
		// 4. 배열, ArrayList
		double[] 배열 = new double[3];
		배열[0] = 3.3; 배열[1] = 3;
		
							
	}// main e
	
	
	public static int 	함수1 (double 매개변수) {return 3;}
	public static byte 	함수2 (byte 	매개변수) {return 3;} 
	
}// class e

/*
 
	타입의 종류
	 
		1. 기본 타입 - 스택 저장
			boolean , char , byte , short , int , long , float , double
		
		2. 참조 타입 - 힙  저장 -> 힙 주소를 스택에 저장
			배열, 클래스 , 인터페이스
	
	타입 변환
		
		1. 자동타입변환
	
		2. 강제타입변환
		
*/
