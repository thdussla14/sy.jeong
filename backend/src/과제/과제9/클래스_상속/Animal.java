package 과제.과제9.클래스_상속;

public class Animal {

	// 1. 필드
	String name;
	String species;
	String sex;
	int age;
	
	// 2. 생성자
	public Animal( ) { }

	public Animal(String name, String species, String sex, int age) {
		this.name = name;
		this.species = species;
		this.sex = sex;
		this.age = age;
	}

	// 3. 메소드
	public void move() {
		System.out.println(" 동물은 움직인다.");
	}
	public void eat() {
		System.out.println(" 동물은 먹는다.");
	}
	public void sound() {
		System.out.println(" 동물은 소리낸다.");
	}

}
