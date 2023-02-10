package Day08.Ex3;

public class Car {
	
	// 1. 필드
	String company = "현대 자동차";
	String model;
	String color;
	int maxspeed;

	
	// 2. 생성자
	
	// 1. 생성자 : 빈생성자 매개변수x
	public Car() { } ;
	// 2. 생성자 : 1개 매개변수
	public Car(String model) {
		this.model = model;
	}
	// 3. 생성자 : 2개 매개변수
	public Car(String model, String color) {
		this.model = model;
		this.color = color;
	}
	// 4. 생성자 : 3개 매개변수
	public Car(String model, String color, int maxspeed) {
		this.model    = model;
		this.color    = color;
		this.maxspeed = maxspeed;
	}	
	// 5. 생성자 : 모든 필드 받는 매개변수
	public Car(String company, String model, String color, int maxspeed) {
		super();
		this.company = company;
		this.model = model;
		this.color = color;
		this.maxspeed = maxspeed;
	}
	// 3. 메소드
	@Override
	public String toString() {
		return "Car [company=" + company + ", model=" + model + ", color=" + color + ", maxspeed=" + maxspeed + "]";
	}
	
}
