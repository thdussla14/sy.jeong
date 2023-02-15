package 과제.과제6.상속;

public class 실행 {
	
	public static void main(String[] args) {
		
		Car car = new Car(); // car 객체 생성
		for( int i = 1 ; i<=10 ;i++ ) {
			int result =  car.run();	// 자동차 주행함수로 [자동차가 달립니다.]출력되며 각 위치 Tire 누적회전수가 최대회전수를 초과할시 , 정지 함수 실행과 동시에 숫자 반환
			if( result == 1 ) car.frontLeftTire 	= new HankookTire	( 15 , "앞왼쪽" );   // 앞왼쪽  타이어 누적회전수가 최대회전수를 초과하여 펑크시 앞왼쪽에 최대 회전수명이 15인 HankookTire로 교체 
			if( result == 2 ) car.frontRightTire 	= new HankookTire	( 13 , "앞오른쪽" );  // 앞오른쪽 타이어 누적회전수가 최대회전수를 초과하여 펑크시 앞오른쪽에 최대 회전수명이 13인 HankookTire로 교체 
			if( result == 3 ) car.backLeftTire 		= new KumhoTire		( 14 , "뒤왼쪽" );   // 뒤왼쪽  타이어 누적회전수가 최대회전수를 초과하여 펑크시 뒤왼쪽에 최대 회전수명이 14인 KumhoTire로 교체 
			if( result == 4 ) car.backRightTire 	= new KumhoTire		( 17 , "뒤오른쪽" );  // 뒤오른쪽 타이어 누적회전수가 최대회전수를 초과하여 펑크시 뒤오른쪽에 최대 회전수명이 17인 KumhoTire로 교체 
		} // for 
		
	}
}
/*
 Car tire  전체 교체시 힙 메모리 영역 8개 사용?
 자식 클래스 금호 2개, 한국 2개, 부모클래스 4개 -> 총 8개 ;





 Car의  run함수 실행시 
 Tire의 roll 함수 실행(누적회전수 1씩 증가, 누적회전수가 최대회전수를 초과시 false 반환)
 roll 함수 false 반환시 run함수는 stop힘수를 실행 후 각 바퀴 위치를 숫자로 반환 (1,2,3,4)
 반환된 숫자를 result 결과로 받아 해당 위치의 바퀴를 교체 
 
 Tire가 부모클래스
 HankookTire와 KumhoTire는 Tire클래스를 상속받은 자식클래스로 
 Tire의 roll 함수 오버라이딩하어 동일 함수 실행 가능
 
 Tire의 위치에 HankookTire와 KumhoTire 모두 대입 가능 (다형성을 보여주는 예시이다)


*/