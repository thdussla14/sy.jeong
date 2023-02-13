package Day09.Ex9;

/*
	싱글톤 : 프로그램내 하나의 객체르 가지는 패턴
		- 1. 클래스 내부에 객체 생성
		- 2. 생성자 private
		- 3. 내부 객체 반환 함수 : getInstance();
		- * 함수 호출시 객체가 필요하나 외부에서 객체 생성 금지 -> static 
*/

public class Member {

	// 1-1. 자신의 타입으로 객체 생성
	// 1-2. private	
	private static Member mem = new Member();// 힙영역 메모리 1개 생성하여 메소드 영역(=static영역)에 저장
	// 1-3. 생성자도 private
	private Member() { }
	// 1-4. 
	public static Member getInstance() {
		return mem;
	}
	
}// class e
