package Day15.Ex9_MVC패턴;

public class Start {

	public static void main(String[] args) {
		
		View.getInstnce().index();
		
		
		
		
	}// main e
}// class e

/*
	내부에서 메소드 [ 멤버 ] 호출 방법	[ 메모리 할당 전 ]
		1. 메소드명();
		
	외부에서 메소드 [ 멤버 ] 호출 방법	[ 메모리 할당 ] 
		1. 인스턴스 메소드			[ new -> 힙 ]
			클래스명 객체명 = new 생성자();	-- 변수명이 존재하기에 재호출 가능
			객체명.메소드명();
				vs
			new 생성자 ().메소드명;		-- 단발성
			
		2. 정적 메소드 			
			클래스명.메소드명();
	
		3. 싱글톤내 메소드 호출		[ new -> 힙 ]
			클래스명.get 싱글톤.메소드();
	
		4. 
			new 생성자 
			

			JVM
			[ 현재 사용중인 메모리 : 컴파일한 클래스 + import 클래스 ]
	메소드 영역 					스택 영역				힘 영역
							- 기본자료형 데이터
							- 힙 주소 저장
		: 클래스 멤버 정보				클래스명 객체명	= 	new 생성자();			
		: static								new 생성자().메소드();	
	
	
	























*/