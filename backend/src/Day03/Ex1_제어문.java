package Day03;

import java.util.Random;

public class Ex1_제어문 {

	public static void main(String[] args) {
		
		// IF형태
			// 1. if(조건식)  실행문;
			// 2. if(조건식) {실행문;  실행문;}
			// 3. if(조건식) {true   실행문;} else {false 실행문;}
			// 4. if(조건식1){true1  실행문;} else if(조건식2) {true2  실행문;} else {false 실행문;} 
			// 5. if(조건식1){if(조건식2) {true2  실행문;}else {false2 실행문;} true1  실행문;} else {false 실행문;} 
		
		// 1. 
		int score = 93;
		
		if(score>=90)
			{System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A입니다.");}
		
		if(score<90)
			{System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B입니다.");}
		
		// 2. 
		if(score>=90)
			{System.out.println("점수가 90보다 큽니다.");
			System.out.println("등급은 A입니다.");}
		else {System.out.println("점수가 90보다 작습니다.");
			System.out.println("등급은 B입니다.");}
		
		// 3. 
		//---------------------------------------------- true 값 1개만 필요 (속도 효율성 우위)
		if(score>=90)
			{System.out.println("점수가 90-100입니다.");
			System.out.println("점수가 A 등급입니다.");}
		else if(score>=80)
			{System.out.println("점수가 80-90입니다.");
			System.out.println("점수가 B 등급입니다.");}
		else if(score>=70)
			{System.out.println("점수가 70-80입니다.");
			System.out.println("점수가 C 등급입니다.");}
		else 
			{System.out.println("점수가 70미만입니다.");
			System.out.println("점수가 D 등급입니다.");}
		//---------------------------------------------- true 값 여러개
		if(score>=90)
			{System.out.println("점수가 90-100입니다.");
			System.out.println("점수가 A 등급입니다.");}
		if(score>=80)
			{System.out.println("점수가 80-90입니다.");
			System.out.println("점수가 B 등급입니다.");}
		if(score>=70)
			{System.out.println("점수가 70-80입니다.");
			System.out.println("점수가 C 등급입니다.");}
		if(score<70)
			{System.out.println("점수가 70미만입니다.");
			System.out.println("점수가 D 등급입니다.");}
		
		// 4.
		//Math 		: 수학 관련 메소들를 제공하는 클래스 
		System.out.println(Math.random());			 //0~1 사이 실수 난수
		System.out.println(Math.random()+1);		 //1~2 사이 실수 난수
		System.out.println((int)Math.random()+1);	 //1~2 사이 정수 난수
		System.out.println((int)(Math.random()*6)+1);//1~6 사이 정수 난수
		
		
				
		// Random 	: 난수 관련 메소드를 제공하는 클래스
		Random random = new Random();
		System.out.println(random.nextInt()) ;		// int 표현 가능 범위 내 난수 생성
		System.out.println(random.nextInt(3));		// 0  ~ 2
		System.out.println(random.nextInt(6)+1);	// 1  ~ 6
		char c1 = (char)(random.nextInt(26)+65);	// 65 ~ 90  A~Z 문자 난수 생성
		char c2 = (char)(random.nextInt(26)+97);	// 97 ~ 122 a~z 문자 난수 생성
		System.out.println(c1);
		System.out.println(c2);
		
		
		int num = (int)(Math.random()*6)+1; 
		
		if(num==1)
			{System.out.println("1번이 나왔습니다.");}
		else if(num==2)
			{System.out.println("2번이 나왔습니다.");}
		else if(num==3)
			{System.out.println("3번이 나왔습니다.");}
		else if(num==4)
			{System.out.println("4번이 나왔습니다.");}
		else if(num==5)
			{System.out.println("5번이 나왔습니다.");}
		else 
			{System.out.println("6번이 나왔습니다.");}
	
		// 5. 
		int score2 = (int) (Math.random()*20)+81;
		System.out.println("점수 : "+score2);
		
		String grade;
		
		if(score2>=90) 
			{if(score>=95) {grade="A+";}else {grade="A";}} 
		else{if(score>=85) {grade="B+";}else {grade="B";}}
		
		System.out.println("학점 : "+grade);
		
		
		

		
	}	// main e
	
}	// class e
