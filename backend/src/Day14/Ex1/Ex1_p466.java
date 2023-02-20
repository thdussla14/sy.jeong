package Day14.Ex1;

public class Ex1_p466 {

	// 함수 선언
		// 접근제한자 키워드 반환타입 함수명 (타입 매개변수1,타입 매개변수2...) {return 데이터; }
		// 접근제한자	: public , private, default[생략], protected
		// 키워드		: static[정적], final[오버라이딩 금지]
		// 함수명		: 카멜표기법
		// 반환타입 	: return 할 데이터의 타입
		// 매개변수 	: 타입 맞춰서 선언
	public static void printLength(String data) {
		
		try { // * 예외 발생할 것 같은 코드 try { } 안에 넣기
			int result  = data.length();
			System.out.println(" 문자 수 : "+ result);
		}
		catch (NullPointerException e){ 
			 // * try { } 에서 예외가 발생했을때 실행되는 코드
				// try { } 에서 예외가 발생하지 않으면 실행 x
				// e : 예외객체명 [ 아무거나 ] 예외정보가 남겨져 있는 객체
			e.printStackTrace ( );
		}
		finally { // * 예외 발생과 상관없이 실행되는 코드
			System.out.println(" 마무리 실행 ");
		}
		
	}
	
	// main 함수 선언 : main 스레드가 포함된 함수 - 스레드 : 코드를 읽어주는 흐름 단위 [ 단일 스레드 ]
	public static void main(String[] args) {		
		System.out.println("[프로그램 시작]");
		printLength("ThisIsJava");
		printLength(null);		// java.lang.NullPointerException
		System.out.println("[프로그램 종료]");
		
	}// main e

}// class e
/*
	에러 : 컴퓨터 하드웨어의 고장으로 인해 응용프로그램 실행 오류 발생
	예외 : 에러 이외의 오류
		* 잘못된 사용[사용자] 또는 코딩[개발자]으로 인해 오류 발생
		* 잘못된 사용 : 사용자가 비정상적인 행동했을때  -> 경험 바탕
		* 1-3 입력 요청 했으나 A 입력하는 경우
			1. 일반 예외 : 컴파일 전 발생할 수 있는 예외 [ *자바 외부 통신 [스트림] ]
			2. 실행 예외 : 컴파일 후 발생하 수 있는 예외 -> 경험
			
	예외 클래스 
		Exception 클래스 : 모든 예외를 받을 수 있는 예외 중 최상위 클래스
	문법
		try 	{
		 	1. 예외 발생할 것 같은 코드 [ 경험 ] 
		 }
		catch(예외클래스e) 	{
			2. try { } 에서 예외가 발생했을때 실행되는 코드 [ 예외 발생시 실행되는 코드 ] 
		 }
		final 	{ 
			3. 예외 발생과 상관없이 실행되는 코드 [ *생략 가능 ] 
		}
			
*/