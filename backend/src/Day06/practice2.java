package Day06;

import java.util.Random;
import java.util.Scanner;

public class practice2 {

	public static void main(String[] args) {
		
		
		Scanner scanner = new Scanner(System.in);
		
		// 게임판 출력------------------------------------------------------------------------------
		String[] 게임판 = {"[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]","[ ]"};
		
	game : while(true) {
			
			for (int i=0 ; i<게임판.length ; i++)
				{if(i%3==2) {System.out.print(게임판[i]+"\n");}
				else {System.out.print(게임판[i]);}
				}

			// 플레이어 알두기-----------------------------------------------------------------------
			while(true) {
				System.out.println("[0~8] 알두기 선택 : ");
				int 위치 = scanner.nextInt();
				if (위치<0 || 위치>8)
					{System.out.println("[알림]허용 범위내 숫자를 선택해주세요.");continue;}
				if (!게임판[위치].equals("[ ]"))
					{System.out.println("[알림]이미 알이 존재하는 구역입니다.");continue;}
				게임판[위치]= "[O]";break;
			}
			
			// 승부 판단---------------------------------------------------------------------------
			// 가로 승리
			for( int i=0 ; i<=6 ; i+=2)
			 	{if(!게임판[i].equals("[ ]")&&게임판[i].equals(게임판[i+1])&&게임판[i+1].equals(게임판[i+2]))
			 		{ System.out.println("게임 승리"+게임판[i]);break game;}}
			// 세로 승리
			for( int i=0 ; i<=2; i++)
				{if(!게임판[i].equals("[ ]")&&게임판[i].equals(게임판[i+2])&&게임판[i+2].equals(게임판[i+4]))
					{ System.out.println("게임 승리"+게임판[i]);break game;}}
			// 대각선 승리
			if(!게임판[0].equals("[ ]")&&게임판[0].equals(게임판[4])&&게임판[4].equals(게임판[8]))
				{ System.out.println("게임 승리"+게임판[0]);break game;}
			if(!게임판[2].equals("[ ]")&&게임판[2].equals(게임판[4])&&게임판[4].equals(게임판[6]))
				{ System.out.println("게임 승리"+게임판[0]);break game;}
			// 무승부
			int 빈자리=0; 
			for(int i=0; i<게임판.length ; i++) {if(게임판[i].equals("[ ]")) {빈자리++;}} 
			if(빈자리==0) {System.out.println("무승부");break game;}
			
			
			// 컴퓨터 알두기------------------------------------------------------------------------
			while(true) {
				Random random = new Random();
				int 위치 = random.nextInt(9);
				if (!게임판[위치].equals("[ ]")){continue;}
				게임판[위치]= "[X]";break;
			}
			
			
			// 승부 판단---------------------------------------------------------------------------
			// 가로 승리
			for( int i=0 ; i<=6 ; i+=2)
			 	{if(!게임판[i].equals("[ ]")&&게임판[i].equals(게임판[i+1])&&게임판[i+1].equals(게임판[i+2]))
			 		{ System.out.println("게임 승리"+게임판[i]);break game;}}
			// 세로 승리
			for( int i=0 ; i<=2; i++)
				{if(!게임판[i].equals("[ ]")&&게임판[i].equals(게임판[i+2])&&게임판[i+2].equals(게임판[i+4]))
					{ System.out.println("게임 승리"+게임판[i]);break game;}}
			// 대각선 승리
			if(!게임판[0].equals("[ ]")&&게임판[0].equals(게임판[4])&&게임판[4].equals(게임판[8]))
				{ System.out.println("게임 승리"+게임판[0]);break game;}
			if(!게임판[2].equals("[ ]")&&게임판[2].equals(게임판[4])&&게임판[4].equals(게임판[6]))
				{ System.out.println("게임 승리"+게임판[0]);break game;}
			// 무승부 
			빈자리=0; 
			for(int i=0; i<게임판.length ; i++) {if(게임판[i].equals("[ ]")) {빈자리++;}} 
			if(빈자리==0) {System.out.println("무승부");break game;}			


		}	//while e 
	}	// main e
}	// class e
