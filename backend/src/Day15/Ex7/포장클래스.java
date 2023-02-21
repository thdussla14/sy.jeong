package Day15.Ex7;

import java.util.ArrayList;

public class 포장클래스 {

	public static void main(String[] args) {
		
		// 1. 특정 API는 객체만 지원
		// ArrayList< int >  list = new ArrayList<>();        [x]
		ArrayList <Integer> list = new ArrayList<>();
		
		// 2. 객체를 사용하면 디양한 메소들를 제공
		int     a = 10; 	// System.out.println(a.);        [x]
		Integer b = 10;		System.out.println(b.toString());
		
		//------------------------------------------------------
		// 박싱
		Integer obj = 100; // 기본자료형 ---> 객체화
		System.out.println(obj.intValue());
		
		// 언박싱
		int value = obj;  //  객체화 ---> 기본자료형
		System.out.println(value);
		
		// 연산시 박싱 객체는 언박싱으로 변환 후 연산처리
		int result = obj +100;	System.out.println(result);
		
		
	}// main e
}// class e

/*
 	기본타입 --------> 포장클래스 
 	boolean			Boolean
 	byte
 	char
 	short
 	int
 	long
 	float
 	double
 	
 	1. 특정 API는 객체만 지원
 	2. 객체를 사용하면 디양한 메소들를 제공
 	
 	p.65

 */