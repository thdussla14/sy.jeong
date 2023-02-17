package 과제.과제9.클래스_상속;

public class Tiger extends Animal{

	public Tiger(String name, String species, String sex, int age) {
		super(name,species,sex,age);
	}

	@Override
	public void move() {
		System.out.println(" 호랑이는 4발로 움직인다. ");
	}
	@Override
	public void eat() {
		System.out.println(" 호랑이는 고기를 먹는다. ");
	}
	@Override
	public void sound() {
		System.out.println(" 호랑이는 어흥 소리낸다. ");
	}

}
