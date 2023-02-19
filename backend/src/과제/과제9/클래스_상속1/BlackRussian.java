package 과제.과제9.클래스_상속1;

public class BlackRussian extends Cocktail{
	
	public BlackRussian() {
		// TODO Auto-generated constructor stub
	}
	public BlackRussian (String name, int alcohol_content, int year_manufacture) {
		super(name, alcohol_content, year_manufacture);
	}
	
	@Override
	public void mix() {
		System.out.println(" BlackRussian은 보드카에 커피 리큐어를 섞어만든 혼합주입니다.");
	}
	@Override
	public void recommend() {
		System.out.println(" BlackRussian과 어울리는 안주는 치즈나쵸입니다. ");
	}
	
}
