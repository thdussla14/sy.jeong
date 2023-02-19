package 과제.과제9.클래스_상속2;

public class Pigeon extends Animal {

	public Pigeon() {
		// TODO Auto-generated constructor stub
	}
	
	public Pigeon(String name, String species, String sex, int age) {
		super(name,species,sex,age);
	}

	@Override
	public void move() {
		System.out.println(" 비둘기는 날개로 날아간다. ");
	}
	@Override
	public void eat() {
		System.out.println(" 비둘기는 곡식을 먹는다. ");
	}
	@Override
	public void sound() {
		System.out.println(" 비둘기는 구구 소리낸다. ");
	}

	
}
