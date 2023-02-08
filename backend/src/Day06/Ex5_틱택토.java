package Day06;

import java.util.Random;
import java.util.Scanner;

public class Ex5_틱택토 {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		// 1. 배열 선언 : 자료형타입[] 배열명 = {데이터1, 데이터2, 데이터3}
		// * 게임판 9칸 문자열 선언
		String[] 게임판 = {"[ ]","[ ]","[ ]",
						 "[ ]","[ ]","[ ]",
						 "[ ]","[ ]","[ ]" };

		// 승리판단 결과 
		boolean 결과 = false ; // 결과가 없을 경우
		
		
		
		
	game: while(true)	// 무한반복 [ 종료조건 : 승리 판단 있을 경우 ]
		{ 		 
		 //--배열내 데이터 호출 / 게임판 출력-------------------------------//
			
			for( int i=0; i<게임판.length ; i++)
			{System.out.print(게임판[i]);
				// * 3칸 마다 줄바꿈 처리
					if( i % 3 == 2 ) {System.out.println();}
			}	// for e
			
		//--플레이어 알두기--------------------------------------------//
		 while(true)
			{System.out.println("위치[0~8] 선택 : ");
			 int 위치 = scanner.nextInt();
			 
			// 유효성 검사 

			if(위치<0 || 위치>8) 
				{System.err.println("[알림] 허용 범위 내 숫자를 입력해주세요.");continue;}

			if(!게임판[위치].equals("[ ]")) 
				{System.err.println("[알림] 이미 알이 존재하는 구역입니다.");continue;}		

		 	게임판[위치]="[O]";break;
			}	// while2 e
			
		 	// [무승부] 결과가 존재하면 게임 끝
		 	if(결과 == true) {break;}
	 
		//--컴퓨터 알두기--------------------------------------------//	
		 while(true)	
			{
			 Random random = new Random();	// 난수와 관련된 메소드 제공
			int 위치 = random.nextInt(9);
			if(!게임판[위치].equals("[ ]")) {continue;}			
			게임판[위치]="[X]";break;
			}	// while3 e
		 
		 	// [무승부] 결과가 존재하면 게임 끝
		 	if(결과 == true) {break;}
		 
		//--승리자 판단 ---------------------------------------------//
		 // 무승부	:  알 9개
		 // 가로		:  0 1 2 || 3 4 5 || 6 7 8 ||
		 // 세로		:  0 3 6 || 1 4 7 || 2 5 8 ||
		 // 대각선	:  0 4 8 || 2 4 6 || 

		 // 가로 승리
		 for (int i=0 ; i<=6 ; i+=2)	
		 {if(!게임판[i].equals("[ ]") && 게임판[i].equals(게임판[i+1]) && 게임판[i+1].equals(게임판[i+2])) 
		 	{System.out.println("[결과] : "+게임판[i]); break game;}}
		 			 	
		//if(게임판[i].equals("[ ]") && 게임판[0].equals(게임판[1]) && 게임판[1].equals(게임판[2])) { }
		//if(게임판[i].equals("[ ]") && 게임판[3].equals(게임판[4]) && 게임판[4].equals(게임판[5])) { }
		//if(게임판[i].equals("[ ]") && 게임판[6].equals(게임판[7]) && 게임판[7].equals(게임판[8])) { }
		
		
		// 세로 승리
		 for (int i=0 ; i<=2 ; i++)	
		 {if(!게임판[i].equals("[ ]") && 게임판[i].equals(게임판[i+2]) && 게임판[i+2].equals(게임판[i+4])) 
		 	{System.out.println("[결과] : "+게임판[i]);break game; }}
		 		 
		//if(게임판[i].equals("[ ]") && 게임판[0].equals(게임판[3]) && 게임판[3].equals(게임판[6])) { }
		//if(게임판[i].equals("[ ]") && 게임판[1].equals(게임판[4]) && 게임판[4].equals(게임판[7])) { }
		//if(게임판[i].equals("[ ]") && 게임판[2].equals(게임판[5]) && 게임판[5].equals(게임판[8])) { }		
		
	 	
		 // 대각선 승리
		 if(!게임판[0].equals("[ ]") && 게임판[0].equals(게임판[4]) && 게임판[4].equals(8)) {System.out.println("[결과] : "+게임판[0]); break game;}
		 if(!게임판[2].equals("[ ]") && 게임판[2].equals(게임판[4]) && 게임판[4].equals(6)) {System.out.println("[결과] : "+게임판[2]); break game;} 
		 
		 
		 // 무승부
		 int 빈자리수 = 0; 
		 for ( int i=0 ; i<게임판.length ; i++)
		 	{ if( 게임판[i].equals("[ ]")) {빈자리수++;}}
		 if(빈자리수 == 0) { 결과 = true; System.out.println("[결과] : 무승부");}
		 
		 
		 
		}	// while e	* 게임 끝
	}	// main e
}	// class e
