package 과제.과제9.클래스_상속3;

public class Flower {

	String name;
	String species;
	
	public Flower() {
		// TODO Auto-generated constructor stub
	}

	public Flower(String name, String species) {
		super();
		this.name = name;
		this.species = species;
	}
	
	public void color() {
		System.out.println(" 꽃은 화려하다. ");
	}
	
	public void floriography() {
		System.out.println(" 꽃말은 다양하다. ");
	}
	
}
