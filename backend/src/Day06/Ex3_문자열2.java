package Day06;

import java.io.FileOutputStream;
import java.util.Scanner;

public class Ex3_문자열2 {

	public static void main(String[] args) throws Exception{
		
		
		while(true)	// 무한 반복
		{
			
		// 1. 문자열 입력받기
		Scanner scanner = new Scanner(System.in);	// 1. 입력 객체		
		System.out.println("문자열 입력해주세요 : ");		
		String input = scanner.nextLine()+"\n";		// 2. 입력 객체가 제공하는 메소드
		System.out.println(input);
		
		// 2. 문자열 파일에 저장 [ 자바외 키보드/파일/네트워크 등 통신시에는 무조건 바이트 단위 ]
			// 주기억장치 -> 보조기억장치 파일 처리	// java 밖으로 이동 file out
			// FileOutputStream("파일경로") : 파일 쓰기 클래스
				// FileOutputStream("파일경로")		 : 파일 새로 쓰기
				// FileOutputStream("파일경로", true)	 : 파일 이어 쓰기
				//.write(바이트 배열) : 
			// 문자열.getBytes() : 해당 문자열을 바이트 배열 반환
		FileOutputStream fout = new FileOutputStream("c:/JAVA/test.txt", true);
		fout.write(input.getBytes()); 
		System.out.println(input.getBytes());
		
		
		
		}	// while e
		
	}	// main e
	
}	// class e
