package 과제.과제9.클래스_상속1;

public class PinaColada extends Cocktail{

	public PinaColada() {
		// TODO Auto-generated constructor stub
	}
	public PinaColada (String name, int alcohol_content, int year_manufacture) {
		super(name, alcohol_content, year_manufacture);
	}
	
	@Override
	public void mix() {
		System.out.println(" PinaColada는 럼에 파인애플 주스와 코코넛 밀크를 섞어만든 혼합주입니다.");
	}
	@Override
	public void recommend() {
		System.out.println(" PinaColada와 어울리는 안주는 매운떡볶이입니다. ");
	}
	
}
