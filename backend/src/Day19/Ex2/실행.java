package Day19.Ex2;

public class 실행 {

	public static void main(String[] args) {
		
		// 1. Thread 자식 클래스로 멀티 스레드 구현
		A a = new A();
		a.start();
		
		// 2. Thread 자식 클래스의 익명 객체로 구현
		Thread thread = new Thread() { 
		@Override
		public void run() {
			while(true) {			
				System.out.println("[2. 익명 객체 스레드]"+Thread.currentThread());
				try {
					Thread.sleep(1000); // 현 스레드 1초간 일시정지
				}
				catch(Exception e) { }			
			}// while e
		}
		};
		thread.start();
		
		// 3. Runnable 인터페이스 구현 객체로 구현
		B b = new B();
		Thread thread2 = new Thread(b);
		thread2.start();
		
		// 4. Runnable 인터페이스의 익명 객체로 구현
		Thread thread3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(true) {			
					System.out.println("[4. 익명2 객체 스레드]"+Thread.currentThread());
					try {
						Thread.sleep(1000); // 현 스레드 1초간 일시정지
					}
					catch(Exception e) { }			
				}// while e				
			}
		});
		thread3.start();
		
		
		// 5. main 스레드
		while(true) {			
			System.out.println("[5. main 스레드]"+Thread.currentThread());
			try {
				Thread.sleep(1000); // 현 스레드 1초간 일시정지
			}
			catch(Exception e) { }			
		}// while e
		
		
	}// main e
}// class e
