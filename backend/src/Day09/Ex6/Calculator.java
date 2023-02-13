package Day09.Ex6;

/*
	정적멤버 : 
		1. static 키워
		2. JVM 메소드 영역 저장
		3. 객체 없이 사용 가능
		4. 사용방법
			클래스명.정적멤버
		5. 프로그램 시작시 생성, 프로그램 종료시 초기화
			효율성 판단 : 모든 클래스에서 공통[공유] 메모리 사용시 Good!
		6. 정적멤버는 인스턴스멤버 사용 불가
*/
public class Calculator {

	// 1. 필드
		// 1-1. 인스턴스 멤버
		int no;
		// 1-2. 정적 멤버
		static double pi = 3.141592;
	// 2. 생성자
		//---static 생성자 없음---//
	// 3. 메소드
		// 3-1. 인스턴스 멤버
		int getNo() {
			return no;
		}
		// 3-2. 정적 멤버
		static int plus (int x, int y) {
			return x+y;
		}
		static int minus (int x, int y) {
			return x-y;
		}
		
		// 3-3. 정적 블록
		// static String info= pi+"파이 입니다.";
		static String info;
		static {info = pi+"파이 입니다.";}

		
		
		
		
		
}
