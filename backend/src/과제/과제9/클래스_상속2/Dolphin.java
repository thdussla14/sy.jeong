package 과제.과제9.클래스_상속2;

public class Dolphin extends Animal{

	
	
	public Dolphin() {
		
	}
	
	public Dolphin(String name, String species, String sex, int age) {
		super(name,species,sex,age);
	}

	@Override
	public void move() {
		System.out.println(" 돌고래는 지느러미로 수영한다. ");
	}
	@Override
	public void eat() {
		System.out.println(" 돌고래는 물고기를 먹는다. ");
	}
	@Override
	public void sound() {
		System.out.println(" 돌고래는 끼이 소리낸다. ");
	}

	
}