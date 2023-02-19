package 과제.과제9.클래스_상속1;

public class Cocktail {

	// 1. 필드
	String name;
	int alcohol_content;
	int year_manufacture;
	
	
	// 2. 생성자
	public Cocktail() {
		// TODO Auto-generated constructor stub
	}

	public Cocktail(String name, int alcohol_content, int year_manufacture) {
		super();
		this.name = name;
		this.alcohol_content = alcohol_content;
		this.year_manufacture = year_manufacture;
	}

	// 3. 메소드
	public void mix() {
		System.out.println(" 칵테일은 여러 술을 섞어 만든 혼합주입니다.");
	}
	public void recommend() {
		System.out.println(" 칵테일과 어울리는 안주는 초콜릿입니다. ");
	}
	
	
}// class e
