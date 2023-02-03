package Day03;

public class Ex2_반복문 {

	public static void main(String[] args) {
		
		
		// 1. 
		int sum = 0;
		
		sum = sum +1;
		sum = sum +2;
		sum = sum +3;
		sum = sum +4;
		sum = sum +5;
		
		for (int i=1; i<=5 ; i++) { sum = sum + i; }
		// [ i=1 ] => [1<=5 ? true] => [i++ i=2]
		// [ i=2 ] => [2<=5 ? true] => [i++ i=3]
		// [ i=3 ] => [3<=5 ? true] => [i++ i=3]
		// [ i=4 ] => [4<=5 ? true] => [i++ i=3]
		// [ i=5 ] => [5<=5 ? true] => [i++ i=3]
		
		
		// 2. 
		for (int i=1 ; i<=10  ; i++) {System.out.println("i :"+i);}
		
		// 3. 
		int total = 0;
		for (int i=1 ; i<=100 ; i++) {System.out.println("i : "+i);total+=i;}

		System.out.println("총 누적합계 : "+total);
		
		// 4. 0.1 ~ 1.0 사이의 실수 출력
		for (float x = 0.1f ; x<=1.0f; x+=0.1f)
		{System.out.println(x+"");}
		
		// 5. for 중첩 : 구구단
			// 단 : 2 3 4 5 6 7 8 9
			// 곱 : 1 2 3 4 5 6 7 8 9
				// 곱은 단마다 반복!! [ 단 : 8회 곱 : 9회 -> 8*9 : 72회 ]
		for ( int 단 = 2 ; 단<=9 ; 단++)
		{System.out.println(단+"단");
			for( int 곱 = 1; 곱<=9 ; 곱++)
				{
				System.out.println("\t\t"+단+"x"+곱+"="+(단*곱));
				}	// for e
		}	// for e
		
		
		// 6. [p.134] break; 반복문 탈출 return; 함수 종료
		while (true) 
			{int num = (int)((Math.random()*6)+1);
			System.out.println(num);
			if(num==6)
				{System.out.println("while{ } 탈출");
				break; }// 가장 가까운 반복문 탈출
			}
		
		
		// 7. 
			// 이름: for( ) { } 
			// break 이름;
		
		for (char upper = 'A' ; upper <='z'; upper++)
			{System.out.println(upper);
			for(char lower='a' ; lower<='z'; lower++)
				{System.out.println("\t"+lower);
				if(lower =='g') {break;};} // 가장 가까운 반복문 탈출 // 두번째 for만 탈출
			};
		
		for1 : for (char upper = 'A' ; upper <='z'; upper++)
			{System.out.println(upper);
			for2 :for(char lower='a' ; lower<='z'; lower++)
				{System.out.println("\t"+lower);
				if(lower =='g') {break for1;};}// 특정 반복문 탈출
			};
		
		
		// 8. continue
		for ( int i=1 ; i <=10; i++)
			{ if( i%2 != 0 )
				{continue;}	// 가장 가까운 반복문으로 이동
			System.out.println(i+" ");}
			
		forname : for ( int i=1 ; i <=10; i++)
						{ if( i%2 != 0 )
							{continue forname;}	// 특정 반복문으로 이동
						System.out.println(i+" ");}
		
		
		
	}	// main e
	
}	// class e
