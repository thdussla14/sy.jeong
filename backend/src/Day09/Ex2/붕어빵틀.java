package Day09.Ex2;
/*
 	생성자 : 객체 생성시 초기화 담당
 		- new
 		- 생성자 선언이 없을 경우 기본생성자 자동 생성
 		- !!!***생성자 이름은 클래스와 동일***!!!
 		- 목적
 			1. 인수로 박은 데이터를 필드 초기화
 			2. 필터링/행위
 	메소드 : 
 		인수[매개변수] 	: 함수 안으로 들어오는 데이터
 		반환[리턴] 	  	: 함수 종료시 호출했던 곳으로 리턴되는 데이터 
 		
		1. 선언
		리턴타입 함수명 (타입 매개변수1, 타입 매개변수2){
			return 리턴타입범위내 데이터
		}
		
		2. 호출
		내부 : 함수명(데이터, 데이터)
		외부 : 객체명.함수명 (데이터, 데이터)

*/

import java.util.ArrayList;

// JVM 메소드영역
public class 붕어빵틀 {

	// 1. 필드
	String 재료1;
	String 재료2;
	
	// 2. 생성자
	// 2-1. 기본 생성자
	public 붕어빵틀() {}
	
	// 2-2. 필드 1개 생성자
	public 붕어빵틀(String 재료1) {
		this.재료1 = 재료1;
	}

	// 2-3. 풀 생성자
	public 붕어빵틀(String 재료1, String 재료2) {
		this.재료1 = 재료1;
		this.재료2 = 재료2;
	}

	// 3. 메소드
	
	// 3-1. to String() 메소드
	@Override
	public String toString() {
		return "붕어빵틀 [재료1=" + 재료1 + ", 재료2=" + 재료2 + "]";
	}
	
	// 3-2. 붕어빵 굽기	 [ 인수x , 반환x(void) ]
	void 굽기() {
		System.out.println("붕어빵 굽습니다.");
	}
		
	// 3-3. 붕어빵 속 변경 [ 인수x , 반환x(void) ]
	void 변경(String 재료1, String 재료2) {
		this.재료1 = 재료1;
		this.재료2 = 재료2;
		System.out.println("붕어빵 속 변경되었습니다.");
	
	}
	
	// 3-4. 붕어빵 판매 [ 인수x , 반환o(타입) ]
	int 판매가() {
		return 3000;
	}
	
	붕어빵틀 판매() {
		붕어빵틀 붕어빵 = new 붕어빵틀();
		return 붕어빵;
	}
	
	void 확인(붕어빵틀 붕어빵) {
		System.out.println(붕어빵);
	}

	ArrayList<붕어빵틀> 여러개판매 (int 개수){
		
		ArrayList<붕어빵틀>붕어빵포장종이 = new ArrayList<>();
		
		for( int i=1; i<=개수 ; i++) {
			붕어빵포장종이.add(판매());			
		}
		return 붕어빵포장종이;
	}

}
