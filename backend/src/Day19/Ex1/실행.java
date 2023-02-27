package Day19.Ex1;

import java.awt.Toolkit;

public class 실행 {

	// p596
	// main메소드( ) : 메인 thread 싱글스레드
	public static void main(String[] args) {
		
		// -------------싱글스레드-----------------------------------------
		// * 소리가 나고 글씨 출력
		// 1. 소리 코드
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for ( int i=0 ; i<5 ; i++) {
			toolkit.beep();	// 비프음 소리내기
			
			try { Thread.sleep(500);}			// 스레드 0.5초 대기 상태  
			catch (InterruptedException e) {}	
		}
		// 2. 출력 코드
		for( int i=0 ;i<5 ; i++) {
			System.out.println("딩");
			try { Thread.sleep(500);}			// 스레드 0.5초 대기 상태  
			catch (InterruptedException e) {}	
		}
		
		// -------------멀티스레드-----------------------------------------	
		// * 소리와 동시에 글씨 출력
		// Thread thread = new Thread(구현 인터페이스);
		// Thread thread = new Thread(new Runnable(){ } );
			// 익명 구현객체 new Runnable(){ } 
		Thread thread = new Thread(new Runnable() {		
			@Override
			public void run() {
				Toolkit toolkit = Toolkit.getDefaultToolkit();
				for(int i=0 ; i<5; i++) {
					try { Thread.sleep(500);}			// 스레드 0.5초 대기 상태  
					catch (InterruptedException e) {}		
				}// for e
			}// run e
		});// thread e
	
		thread.start();
		
		for( int i=0 ;i<5 ; i++) {
			System.out.println("딩");
			try { Thread.sleep(500);}			// 스레드 0.5초 대기 상태  
			catch (InterruptedException e) {}	
		}
		
		// -------------멀티스레드2-----------------------------------------	
		Thread thread2 = new Sound();
		thread2.start();
		for( int i=0 ;i<5 ; i++) {
			System.out.println("딩");
			try { Thread.sleep(500);}			// 스레드 0.5초 대기 상태  
			catch (InterruptedException e) {}	
		}
		// -------------멀티스레드3-----------------------------------------	
		Runnable runnable = new Sound2();
		Thread thread3 = new Thread(runnable);
		thread3.start();
		for( int i=0 ;i<5 ; i++) {
			System.out.println("딩");
			try { Thread.sleep(500);}			// 스레드 0.5초 대기 상태  
			catch (InterruptedException e) {}	
		}
		
		

	}// main e
	
}// class e
