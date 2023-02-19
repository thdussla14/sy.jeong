package 과제.과제9.클래스_상속2;

public class 실행 {

	public static void main(String[] args) {
		
		Animal animal = new Animal();
		
		animal.move();
		animal.eat();
		animal.sound();
		
		animal = new Tiger();
		
		animal.move();
		animal.eat();
		animal.sound();
		
		animal = new Pigeon();
		
		animal.move();
		animal.eat();
		animal.sound();
		
		animal = new Dolphin();
		
		animal.move();
		animal.eat();
		animal.sound();
		
		
	}// main e
	
}// class e
