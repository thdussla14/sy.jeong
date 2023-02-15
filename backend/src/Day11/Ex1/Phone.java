package Day11.Ex1;

public class Phone {

	// 클래스 멤버
		// 인스턴스 멤버 			: 객체 필요 이욯하는 멤버
			// 클래스명 객체명 = new 생성자 () ---> 객체명.멤버
		// 정적 멤버[static]	: 객체 없이 이용하는 멤버
			// 클래스명.멤버
	
	// 멤버 종류
		// 1. 필드	: 객체의 데이터를 저장하는 멤버
		// 접근제한자 (static/final) 타입 변수명;
	
		public String model;
		public String color;
		
		// 2. 생성자	: 객체 생성시 초기화 담당 [지역변수]
		// 접근제한자 클래스명 (매개변수1, 매개변수2){ }
		// *** 생성자가 1개도 없을때 기본생성자 자동 추가
		// *** 생성자가 1개 이상이면 기본생성자 직접 추가 필요
		public Phone() {
			// TODO Auto-generated constructor stub
		}
		
		public Phone(String model, String color) {
			this.model = model;
			this.color = color;
			System.out.println("--부모클래스 생성자 실행");
		}
		
		// 3. 메소드	: 객체의 행위 [지역변수]
		// 접근제한자 (static/final) 반환타입 메소드명 (매개변수1, 매개변수2) { }
		
		public void bell() {// 모든 곳에서 호출 가능한 매개변수 x 반환값 x bell 함수
			System.out.println("벨이 울립니다.");
		}
		public void sendVoice(String message) {		// 모든 곳에서 호출 가능한 매개변수 message 반환값 x sendVoice 함수
			System.out.println("자기 : "+message);
		}
		public void receiveVoice(String message) {	// 모든 곳에서 호출 가능한 매개변수 message 반환값 x receiveVoice 함수
			System.out.println("상대방 : "+message);
		}
		public void hangUp() {// 모든 곳에서 호출 가능한 매개변수 x 반환값 x hangUp 함수
			System.out.println("전화를 끊습니다.");
		}
		
	// 멤버 접근제한자
		// public 	: 모든 곳에서 호출 가능
		// private 	: 해당 클래스에서만 사용 가능
		// default	: 동일한 패키지내에서만 호출 가능 (생략시 기본값) 
		// protected: 동일한 패키지내에서만 호출 가능 [*자식 예외]
		
}// class e
