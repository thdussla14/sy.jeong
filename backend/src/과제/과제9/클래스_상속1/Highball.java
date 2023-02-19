package 과제.과제9.클래스_상속1;

public class Highball extends Cocktail {


	public Highball() {
		// TODO Auto-generated constructor stub
	}
	public Highball (String name, int alcohol_content, int year_manufacture) {
		super(name, alcohol_content, year_manufacture);
	}
	
	@Override
	public void mix() {
		System.out.println(" Highball은 위스키에 탄산수를 섞어만든 혼합주입니다.");
	}
	@Override
	public void recommend() {
		System.out.println(" Highball과 어울리는 안주는 꼬치구이입니다. ");
	}
	
	
}
