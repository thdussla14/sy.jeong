package 과제.과제6.상속;

public class Car {
	// 1. 필드 [ 변수 , 객체 , 상수 , 배열, 리스트 등 = 메모리 ]
	Tire frontLeftTire 	= 	new Tire(6 , "앞왼쪽"	);	// 차의 앞왼쪽  바퀴에 최대 회전수명 6 인 Tire 장착
	Tire frontRightTire = 	new Tire(2 , "앞오른쪽"	);	// 차의 앞오른쪽 바퀴에 최대 회전수명 2 인 Tire 장착
	Tire backLeftTire 	=  	new Tire(3 , "뒤왼쪽"	);	// 차의 뒤왼쪽  바퀴에 최대 회전수명 3 인 Tire 장착
	Tire backRightTire 	=  	new Tire(4 , "뒤오른쪽"	);	// 차의 뒤오른쪽 바퀴에 최대 회전수명 4 인 Tire 장착
	
	// 3. 메소드 
	int run() {										// 자동차 주행 함수
		System.out.println("[자동차가 달립니다.]");		// "자동차 달립니다." 출력  // 각 위치 Tire 누적회전수가 최대회전수를 초과할시 , 정지 함수 실행과 동시에 숫자 반환
		if( frontLeftTire.roll() 	== false ) { stop(); 	return 1; } // 앞왼쪽  Tire 누적회전수가 최대회전수를 초과할시 , 정지 함수 실행과 동시에 1 반환
		if( frontRightTire.roll() 	== false ) { stop(); 	return 2; } // 앞오른쪽 Tire 누적회전수가 최대회전수를 초과할시 , 정지 함수 실행과 동시에 2 반환
		if( backLeftTire.roll() 	== false ) { stop(); 	return 3; } // 뒤왼쪽  Tire 누적회전수가 최대회전수를 초과할시 , 정지 함수 실행과 동시에 3 반환
		if( backRightTire.roll()	== false ) { stop(); 	return 4; } // 뒤오른쪽 Tire 누적회전수가 최대회전수를 초과할시 , 정지 함수 실행과 동시에 4 반환
		return 0;
	}
	void stop() {System.out.println("[자동차가 멈춥니다.]");} // "자동차가 멈춥니다." 출력
}
