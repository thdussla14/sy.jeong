package Day19.Ex3;
						// Thread 클래스 상속
public class WorkThread extends Thread {
	// 1. 필드					
	public boolean work = true;
	// 2. 생성자
	public WorkThread(String name) {
		setName(name);// Thread 이름 변경
	}
	// 3. 메소드
		// Thread 클래스의 run 메소드 재정의
	@Override
	public void run() {
		while(true) {
			if(work) {
				System.out.println(getName()+" : 작업처리 ");
			}else {
				Thread.yield(); // Thread 양보
			}
		}
	}
	
	
}
