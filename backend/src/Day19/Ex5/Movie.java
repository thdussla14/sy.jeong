package Day19.Ex5;

public class Movie extends Thread {
	
	public boolean stop = false; // 작동스위치
	
	@Override
	public void run() {
		while(stop) {
			System.out.println("--영화 재생중--");
			try {Thread.sleep(1000);}
			catch(Exception e) { }
		}
	}
}
