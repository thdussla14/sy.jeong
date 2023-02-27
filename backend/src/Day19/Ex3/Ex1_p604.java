package Day19.Ex3;

import java.awt.Toolkit;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex1_p604 {

	public static void main(String[] args) {
		
/*		// 1.
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for ( int i=0 ; i<5 ; i++) {
			toolkit.beep();	// 비프음 소리내기
			
			try { Thread.sleep(1000);}			 
			catch (Exception e) {}	
		}
		
		// 2. 
		while(true) {
			Date date = new Date(); 	//날짜/시간 클래스
			SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss"); // 날짜/시간 꾸미기 
			System.out.println(sdf.format(date));
			try { Thread.sleep(1000);}			// 1 초간 일시정지
			catch (Exception e) {}

		}
*/	
		// 3. 
		SumThread sumThread = new SumThread();
		sumThread.start();						// 계산 시작
		System.out.println(sumThread.getSum()); // 결과 출력 // 불가능 계산이 끝나지 않은 상태에서 출력 먼저 진행 
	
		SumThread sumThread2 = new SumThread();
		sumThread2.start();						// 계산 시작
		try {sumThread2.join();} 				// 현스레드(main) 과 조인
		catch (InterruptedException e) {}
		System.out.println(sumThread2.getSum());
		
		// 4. 
		WorkThread workThreadA = new WorkThread("workThreadA"); // ThreadA 객체 생성
		WorkThread workThreadB = new WorkThread("workThreadB"); // ThreadB 객체 생성
		workThreadA.start();
		workThreadB.start();
		
		try { Thread.sleep(5000);} catch (Exception e) {}		// 5초간 일시정지
		workThreadA.work= false;	// ThreadA 필드 변경 스레드 양보 상태 
		try { Thread.sleep(5000);} catch (Exception e) {}
		workThreadA.work= true;		// ThreadA 필드 변경 스레드 대기 상태 
				
	}
}
