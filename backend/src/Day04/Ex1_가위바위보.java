package Day04;	// 현재 클래스의 패키지 위치

import java.util.Random;
import java.util.Scanner;	// 해당 클래스를 사용하기 위한 패키지로부터 클래스 가져오기

public class Ex1_가위바위보 {

		public static void main(String[] args) {
			
			// for ( int i=0 ; true ; i++){System.out.println("무한루프");}
			
			// while (true) {System.out.println("무한루프");}
			
			// 3-1. 입력 객체; [클래스 위에 import java.util.Scanner; 필수!!!]
			Scanner scanner = new Scanner(System.in);			
			
			// 8. 변수의 사용범위 : 지역변수의 특징 { } 밖으로 못나감
				// * while 안에서 선언된 변수는 반복될때마다 초기화 [누적 X]
			int pwin = 0; int cwin = 0; int play = 0;	
			
			// 1. 무한루프 [종료조건 : ]
			while(true)					
			{	// 2. 출력 : syso + 자동완성
				System.out.println("가위(0) 바위(1) 보(2) 종료(3) : ");
				// 3. 입력 : Scanner 클래스 -> Scanner 객체 필요 !!
				// 4. 저장 [변수]
				byte player = scanner.nextByte(); // 입력받은 데이터 byte 형으로 가져오기
				System.out.println("player 낸수 : "+player);
				
				// 5. 제어문 [흐름 제어 - 경우의 수(정상입력(0 ~ 2) , 종료(3)]
				if(player==3)
					{System.out.println("--종료"); 
					if(pwin>cwin) {System.out.println("player 최종승리");}
					if(pwin<cwin) {System.out.println("com 최종승리");}
					else {System.out.println("최종 무승부");}
					break;	} // 반복문 탈출
			
				// 6. 난수 생성 [ 1. Math 클래스 2. Random 클래스 ]
				Random random = new Random();
				int com = random.nextInt(3);	// 0 ~ 2 사이의 int 형 난수 생성		
				System.out.println("com 낸수 : "+com);
				
				// 7. 승리 판단 
					// [player 이기는 수  	1. p: 0 c:2 or	2. p:1 c:0 	or	3. p:2 c:1]
					// [com    이기는 수  	1. p: 0 c:1 or	2. p:1 c:2 	or	3. p:2 c:0]
					// [무승부          	1. p: 0 c:0 or	2. p:1 c:1 	or	3. p:2 c:2]
				if ((player == 0 && com == 2)||(player == 1 && com == 0)||(player == 2 && com == 1)) 
					{System.out.println(">>>>player winner");pwin++;}
				else if ((player == com)) {System.out.println(">>>> draw");}
				else {System.out.println(">>>> com winner");cwin++;}
				
				// * 플레이 수 증가 
				play++;
				
			}	// while e
			
		}	// main e
	
}	// class e

/*
 	* 예제에서 중요한 코드
  		1. 승리자 판단
  		2. 지역변수 특징
  		3. Scanner 클래스, Random 클래스
  
 */
































