package 과제.과제9;

import 과제.과제9.클래스_상속1.BlackRussian;
import 과제.과제9.클래스_상속1.Cocktail;
import 과제.과제9.클래스_상속1.Highball;
import 과제.과제9.클래스_상속1.PinaColada;
import 과제.과제9.클래스_상속2.Animal;
import 과제.과제9.클래스_상속2.Dolphin;
import 과제.과제9.클래스_상속2.Pigeon;
import 과제.과제9.클래스_상속2.Tiger;
import 과제.과제9.클래스_상속3.Cyclamen;
import 과제.과제9.클래스_상속3.Flower;
import 과제.과제9.클래스_상속3.FrenchMarigold;
import 과제.과제9.클래스_상속3.Rose;

public class 클래스상속_실행 {

	public static void main(String[] args) {
		
		// 클래스상속 예제 1) ----------------------------------------------------------------------------------//
		System.out.println("-----클래스상속 예제 1)---------------------------");
		
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
		
		// 클래스상속 예제 2) ----------------------------------------------------------------------------------//
		System.out.println("-----클래스상속 예제 2)---------------------------");
		
		Animal animal = new Animal();		
		animal.move();
		animal.eat();
		animal.sound();
		
		animal = new Tiger();		
		animal.move();
		animal.eat();
		animal.sound();
		
		animal = new Pigeon();		
		animal.move();
		animal.eat();
		animal.sound();
		
		animal = new Dolphin();		
		animal.move();
		animal.eat();
		animal.sound();
		
		// 클래스상속 예제 3) ----------------------------------------------------------------------------------//
		System.out.println("-----클래스상속 예제 3)---------------------------");
				
		Flower flower = new Flower();	
		flower.color();
		flower.floriography();
		
		flower = new Rose();	
		flower.color();
		flower.floriography();
		
		flower = new Cyclamen();		
		flower.color();
		flower.floriography();
		
		flower = new FrenchMarigold();
		flower.color();
		flower.floriography();

	}// main e
}
