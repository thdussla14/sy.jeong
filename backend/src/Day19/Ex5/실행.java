package Day19.Ex5;

import java.util.Scanner;

public class 실행 {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		Music music =  new Music(); // 음악 스레드
		Movie movie =  new Movie(); // 영화 스레드
		
		while(true) {
			System.out.print("1. 음악재생/중지   2. 영화재생/중지 :");
			int ch = scanner.nextInt();
			// 1번이 입력되고 음악이 꺼져있으면 재생
			if(ch == 1 && music.stop == false ) {	
				music.start();		// 음악 스레드 시작
				music.stop = true;	// 음악 재생 여부 true
			// 1번이 입력되고 음악이 켜져있으면 중지
			}else if(ch == 1 && music.stop == true ) {	
				music.stop = false; // 음악 재생 여부 false
				music = new Music();
			// 2번이 입력되고 영화가 꺼져있으면 재생
			}else if (ch == 2 && movie.stop == false) {	
				movie.start();
				movie.stop = true;					
			// 2번이 입력되고 영화가 켜져있으면 중지
			}else if (ch == 2 && movie.stop == true) {	
				movie.stop = false;
				movie = new Movie();
			}
		}// while e
		
	}// main e
}// class e
