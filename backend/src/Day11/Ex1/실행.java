package Day11.Ex1;

public class 실행 {

	public static void main(String[] args) {
		
		// 1. phone 객체
		Phone phone = new Phone();
		// 2. phone 객체의 인스턴스멤버 호출
		phone.color = "빨강";
		System.out.println(phone.color);
		phone.bell();
		phone.sendVoice("안녕하세요");
		
		// phone 클래스가 smartphone 멤버 호출
		// phone.wifi;
		// ***부모객체는 자식클래스의 멤버를 호출 불가능

		// 1. smartphone 객체
		SmartPhone smartphone = new SmartPhone();
		smartphone.color = "파랑";
		System.out.println(smartphone.color);
		smartphone.bell();
		smartphone.sendVoice("안녕하세요");
		
		// 자식클래스로 객체 생성
		SmartPhone myphone = new SmartPhone("갤럭시", "은색");
		
		// 자식클래스로 부모클래스의 멤버 호출
		System.out.println("모델 : "+myphone.model);
		System.out.println("색상 : "+myphone.color);
		
		// 자식클래스 본인 멤버 호출
		System.out.println("와이파이 상태 : "+myphone.wifi);
		
		// 자식클래스로 부모클래스의 멤버 호출
		myphone.bell();
		myphone.sendVoice("여보세요");
		myphone.receiveVoice("안녕하세요! 저는 홍길동입니다.");
		myphone.sendVoice("아~네, 반갑습니다.");
		myphone.hangUp();
		
		// 자식클래스 본인 멤버 호출ㄴ
		myphone.setWifi(true);
		myphone.internet();
		
	}// main e
	
}// class e
/*
	자동완성메뉴
	필드	: 필드명, 자료형, 클래스명 
	함수	: 함수명(매개변수) 반환타입 클래스명



*/