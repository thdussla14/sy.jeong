package Day06;

public class Ex4_배열 {

	public static void main(String[] args) {
		
		// 배열 선언 및 초기화?
		String[] season = {"Spring","Summer","Fall","Winter"};
		
		// 배열 호출
		System.out.println("배열호출 : "+season);
		System.out.println("season[0] : "+season[0]);
		System.out.println("season[1] : "+season[1]);
		System.out.println("season[2] : "+season[2]);
		System.out.println("season[3] : "+season[3]);
		// System.out.println("season[4] : "+season[4]); //java.lang.ArrayIndexOutOfBoundsException 오류 발생 : 인덱스 없음
		
		// 데이터 변경
		season[1] = "여름";
		System.out.println("season[1] : "+season[1]);
		
		// 반복과 배열 관계
		for( int i=0 ; i<season.length ; i++)
		{System.out.println(i+" : "+season[i]);}
		
		
		// 1. 선언
		
		int[] scores = {83,90,87};
		int sum = 0;
		for(int i=0 ; i<scores.length ; i++)
		{sum += scores[i];};
		
		System.out.println("총합 : "+sum);
		
		
		// int형 변수 3개를 저장할 수 있는 배열 생성
		int[] arr1 = new int[3]; 
		for( int i=0 ; i<arr1.length ; i++)
			{ System.out.println(arr1[i]); };
		
		arr1[0] =10 ;arr1[1] =20 ;arr1[2] =30 ;
		for( int i=0 ; i<arr1.length ; i++)
			{ System.out.println(arr1[i]); };
		
		double[] arr2 = new double[3];
		for( double value : arr2 ){	System.out.println(value); };
			
		arr2[0] = 0.1; arr2[1] = 0.2; arr2[2] = 0.3;
		for( double value : arr2 ){	System.out.println(value); };
		
		String[] arr3 = new String[3];
		for(String value: arr3) {System.out.println(value);}
		
		arr3[0] = "1월"; arr3[1] = "2월"; arr3[2] = "3월";
		for(String value: arr3) {System.out.println(value);}
		
		
		
	}	// main e

}	// class e


/*
 * 
 	변수 : 데이터 1개 		스택 영역
 	배열 : 데이터 여러개		힙 영역
 
 - 	JS					vs				JAVA
	다른 타입								같은 타입
	가변 길이 								고정 길이
	
 - 	let 배열명 = [ ]						자료형 [] 배열명 = {	}

 - 	for(let 변수 in 배열명){ }				for(자료형 변수 : 배열명) { }
	for(let 변수 of 배열명){ }
	배열명.forEach((o)=>{ })
	배열명.map((o)=>{ return 반환값; })



 - 	// 선언 //
 	1. 자료형타입[] 배열명 = {허용범위 데이터1, 허용범위 데이터2, 허용범위 데이터3	}
	2. 자료형타입[] 배열명 = new 자료형타입[길이]

	초기값
	- int[] scores = new int[3]
	자료형 : int int int
	데이터 : 0	0	0
	인덱스 : 0	1	2
	- String[] scores = new String[3]
	자료형 : String 	String 	String
	데이터 : null		null	null	
	인덱스 : 0		1		2	

 - // 호출 //
 	배열명 : 첫번째 값의 주소값
  	배열명 [인덱스] : 해당 인덱스에 위치한 데이터
  	
 - // 변경 //  	
  	배열명[인덱스] = 새로운 데이터

 - // 배열의 길이 //
 	배열명.length = 4
 		   인덱스 = 0~3
   
   
   

 */




