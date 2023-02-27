package Day19.Ex1;

import java.awt.Toolkit;

public class Sound extends Thread {
	
	@Override
	public void run() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		for(int i=0 ; i<5; i++) {
			try { Thread.sleep(500);}			// 스레드 0.5초 대기 상태  
			catch (InterruptedException e) {}		
		}// for e
	}// run e
	
}
