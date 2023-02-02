package Day02;

public class Ex3_연산자 {

	public static void main(String[] args) {
		
		// 1. 부호 / 증감연산자
		int x = +10;
		int y = -10;
		System.out.println("x : "+x);
		System.out.println("y : "+y);
		
		System.out.println("x++ : "+(x++));	// 10
		System.out.println("x : "+x);		// 11
		System.out.println("++x :"+(++x));	// 12
		
		System.out.println("y-- : "+(y--));	//-10
		System.out.println("y : "+y);		//-11
		System.out.println("--y : "+(--y));	//-12
		
		// 2. 산술연산자
		System.out.println("x+y"+(x+y));	// 0
		System.out.println("x-y"+(x-y));	//24
		System.out.println("x*y"+(x*y));	//-144
		System.out.println("5/3"+(5/3));	// int/int => int 이므로 몫만 출력
		System.out.println("5%3"+(5%3));	// 나머지
		
		// 3. 비교연산자
		System.out.println("x==y"+(x==y));	// f
		System.out.println("x!=y"+(x!=y));	// t
		System.out.println("x>y"+(x>y));	// t
		System.out.println("x>=y"+(x>=y));	// t
		System.out.println("x<y"+(x<y));	// f
		System.out.println("x<=y"+(x<=y));	// f
		
		System.out.println("str1.equals(str2) : "+("유재석".equals("유재석")));		// t
		System.out.println("str1.equals(str2) : "+(!"유재석".equals("유재석")));	// f
		
		// 4. 논리연산자
		System.out.println(" 5<x<20 : "+(x>5 && x<20));		// t
		System.out.println(" 5<x<20 : "+(x>5 && x<10));		// f
		System.out.println(" x<=0 x>=20 "+(x<=0||x>=20));	// f
		System.out.println(" x<=0 x>=10 "+(x<=0||x>=10));	// t
		System.out.println("!x==y"+(!(x==y)));				// t
		
		// 5. 대입연산자
		int z = 30;
		z += x; // 30 += 12 => 30+12=42 => z=42
		System.out.println("z += x : "+z);
		z -= x; // 42 -= 12 => 42-12=30 => z=30
		System.out.println("z -= x : "+z);
		z *= x; z /= x ; z %= x; 
		
		// 6. 삼항연산자		조건? 참 : 거짓
		String 결과 = (x>=20) ? "합격":"불합격"; System.out.println(결과);
		
		// 7. 연결연산자
		String 연결문자1 = "유재석"+"10";		// 문자열 + 문자열 			 => 문자열 // "유재석10" 	
		String 연결문자2 = "유재석"+10;			// 문자열 + 숫자열			 => 문자열 // "유재석10" 	
		String 연결문자3 = "유재석"+10+20;		// 문자열 + 숫자열 + 숫자열 	 => 문자열 // "유재석1020" 	
		String 연결문자4 = "유재석"+(10+20);	// 문자열 +(숫자열 + 숫자열)  => 문자열 // "유재석30" 	
		
		
		
		
		
		
		
		
		
		
	} // main e
	
	
}	// class e
