package 과제.과제9.클래스_상속1;

public class 실행 {

	public static void main(String[] args) {
		
		Cocktail cocktail = new Cocktail();
		
		cocktail.mix();
		cocktail.recommend();
		
		cocktail = new Highball();
		
		cocktail.mix();
		cocktail.recommend();
		
		cocktail = new BlackRussian();
		
		cocktail.mix();
		cocktail.recommend();
		
		cocktail = new PinaColada();
	
		cocktail.mix();
		cocktail.recommend();
		
		
		
		
	}// main e
}// class e
