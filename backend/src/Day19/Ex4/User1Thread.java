package Day19.Ex4;

public class User1Thread extends Thread{
	// 필드
	private Calculator calculator;
	// 생성자
	public User1Thread() {
		setName("User1Thread"); // 스레드 이름 변경
	}
	// set 메소드
	public void setCalculator(Calculator calculator) {
		this.calculator = calculator;
	}
	@Override
	public void run() {
		calculator.setMemory(100);
	}	
}
