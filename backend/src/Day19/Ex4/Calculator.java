package Day19.Ex4;

public class Calculator {	// 계산기 클래스
	// 필드
	private int memory;
	// get 메소드
	public int getMemory() {return memory;}
	// set 메소드
	public synchronized void setMemory(int memory) {
		this.memory = memory;
		try {Thread.sleep(2000);} catch (Exception e) { }
		System.out.println(Thread.currentThread().getName()+":"+this.memory);
	}

		
	
}
