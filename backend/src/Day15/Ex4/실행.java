package Day15.Ex4;

public class 실행 {

	
	public static void main(String[] args) {
		
		// 1.----------------------------------------------------------------------
		System.out.println("출력");	// 콘솔에 출력
		System.err.println("에러");	// 콘솔에 빨간 글씨로 출력
		
		int value  = 100;			// int 에  100  대입 가능
		//int value2 = "100";			// int 에 "100" 대입 불가능
			// 문자열 -> 기본타입 변환
		int value3 = Integer.parseInt("100");
		
		try { // try { } 에 예외[오류]가 발생할 것 같은 코드 [*경험]
			int value4 = Integer.parseInt("1xx");
		}
		catch (Exception e) {
			System.err.println("에러 내용");
			System.out.println(e.getMessage());
		}
		
		// 2.----------------------------------------------------------------------
		
		int speed = 0;
		int keyCode = 0;
		
		while(true) {
			
			if( keyCode != 13 && keyCode != 10) {	// 엔터 코드 10,13
				if(keyCode == 49) {					// 숫자 1의 코드 49
					speed++;
				}
				else if (keyCode == 50) {			// 숫자 2의 코드 50
					speed--;
				}
				else if (keyCode == 51) {			// 숫자 3의 코드 51
					//break;
					//System.exit(0);				// 0 : 정상 종료 , 1/-1 : 비정상종료  -> 강제 프로세스 종료 비권장
				}
				System.out.println("현재속도 : "+speed);
				System.out.println("1. 증속 2. 감속 3. 중지");
			}
			try{
				keyCode = System.in.read();	// 입력받아 코드로 반환 [*예외처리 필수]
			}
			catch (Exception e) {
				
			}
		}
		
		
		
	}// main e
	
}// class e
