package 과제.과제01;

import java.util.Scanner;

public class 과제1_연산자문제 {
	
	public static void main(String[] args) {
		
		// 문제1
			System.out.println( " |\\_/| \n |q p|  /}\n ( 0 )\"\"\"\\\n |\"^\"`   |\n ||_/=\\\\_| ");
		
		// 문제2
			Scanner Scanner = new Scanner(System.in); 
			
			String 순번  		= Scanner.next();
			String 작성자  	= Scanner.next();		
			String 내용  		= Scanner.next();	
			String 날짜  		= Scanner.next();
			
			System.out.println(" ------------------방문록-----------------\n 순번 | 작성자 |    내용   |  날짜 ");
			System.out.println("  "+순번+"  | "+  작성자 + " | " +  내용 + " | "+ 날짜);
			System.out.println(" ---------------------------------------");
		
		// 문제3
			System.out.print("기본급 : ");
			int 기본급 =  Scanner.nextInt();
			System.out.print("수당 : ");
			int 수당	  =  Scanner.nextInt();
					
			int 실수령액 = 기본급 + 수당 - (int)(기본급*0.1);
			System.out.println(실수령액);
			
		// 문제4
			System.out.print("금액 : ");
		   int 금액 = Scanner.nextInt();
		   
		   int 십만원 = (int)(금액/100000);
			
		   금액 -= (십만원*100000);
		   
		   int 만원 = (int)(금액/10000);
		   
		   금액 -= (int)(만원*10000);
		   
		   int 천원 = (int)(금액/1000);
		   
		   금액 -= (천원*1000);
			
		   int 백원 = (int)(금액/100);
		   
		   System.out.println(" 십만원권 : "+십만원+"장 \n 만원권 : "+만원 +"장 \n 천원권 : "+천원+"장 \n 백원권 : "+백원+"개");
		   
		 // 문제 5
		   System.out.print("문제5 정수 : ");
		   int 정수1 = Scanner.nextInt();
		   
		   boolean 논리 = ((정수1%7)==0);
		   
		   String 결과 = 논리? "o":"x";
		   
		   System.out.println(결과);
		   
		 // 문제 6
		   System.out.print("문제6 정수 : ");
		   int 정수2 = Scanner.nextInt();
		   
		   boolean 논리2 = ((정수2%2)==0);
		   
		   String 결과2 = 논리2? "O":"x";
		   
		   System.out.println(결과2);
		   
		 // 문제 7
		   System.out.print("문제7 정수 : ");
		   int 정수3 = Scanner.nextInt();
		   
		   boolean 논리3 = ((정수3%7)==0);
		   boolean 논리4 = ((정수3%2)==0);
		   
		   String 결과3 = 논리3&&논리4 ? "O":"X";
		   
		   System.out.println(결과3);
		   
		 // 문제 8
		   System.out.print("문제8 정수 : ");
		   int 정수4 = Scanner.nextInt();
		   
		   boolean 논리5 = ((정수4%7)==0);
		   boolean 논리6 = ((정수4%2)==1); 
		   
		   String 결과4 = 논리5||논리6 ? "O":"X";
		   
		   System.out.println(결과4);
		   
		 // 문제 9
		   System.out.print("문제9 정수 2개 : ");
		   int 정수5 = Scanner.nextInt();
		   int 정수6 = Scanner.nextInt();

		   boolean 논리7 = ((정수5-정수6)> 0);
		   
		   int 결과5 = 논리7 ? 정수5 : 정수6 ;
		   
		   System.out.println(결과5);
		   
		// 문제 10   
		   System.out.print("반지름 : ");
		   int 반지름 = Scanner.nextInt();
		   
		   int 원넓이 =(int)(반지름*반지름*3.14);
		   
		   System.out.println(원넓이);
		   
		// 문제 11   
		   System.out.print("문제11 실수 2개 : ");
		   double 실수1 = Scanner.nextDouble();
		   double 실수2 = Scanner.nextDouble();
		   
		   double 결과6  = (실수1/실수2*100);
		   
		   System.out.println(결과6+"%");
		   
		// 문제 12
		   System.out.print("윗변 밑변 높이 : ");
		   int 윗변 = Scanner.nextInt();
		   int 밑변 = Scanner.nextInt();
		   int 높이 = Scanner.nextInt();
		   
		   int 결과7 = (int)((윗변*밑변)*높이/2);
		   
		   System.out.println(결과7);
		   
	   // 문제 13
		   System.out.print("키 : ");
		   int 키 = Scanner.nextInt();
		   
		   float 표준체중 = (float)((키-100)*0.9);
		   
		   System.out.println("표준체중 : "+표준체중);
		   
	   // 문제 14
		   System.out.println("키, 몸무게 : ");
		   int 키2 = Scanner.nextInt();
		   int 체중 = Scanner.nextInt();
		   
		   float BMI = (체중/((키 / 100) * (키 / 100)));
		   
		   System.out.println("BMI : "+BMI);
		   
		// 문제15
		   System.out.println("inch : ");
		   
		   int 인치 = Scanner.nextInt();
		   
		   double 센치 = (인치*2.54);
		   
		   System.out.println(센치+"cm");
		   
		// 문제 16
		   System.out.println("중간고사, 기말고사, 수행평가 ");
		   
		   int 중간 = Scanner.nextInt();
		   int 기말 = Scanner.nextInt();
		   int 수행 = Scanner.nextInt();
		   
		   double 총점 = ((중간*0.3)+(기말*0.3)+(수행*0.4));
		   
		   System.out.printf("총점 : %2.1d",총점);
		   
		// 문제 17
		   
		   int x = 10; 
		   int y = x-- + 5 +--x ;
		   		// y = 10 + 5 + (10-1) = 24
		   	    // x = 8  
		   System.out.printf(" x의 값 : %d , y의값 :  %d ", x, y);
		   
		// 문제 18
		   System.out.println("나이 :");
		   
		   int age = Scanner.nextInt();
		   
		   String 연령대 = age>=40 ? "중년" : age>= 30? " 성인" : age >=10? "학생":"어린이";
		   
		   System.out.println("연령대 : "+연령대);
		   
		// 문제 19
		   System.out.println("국어, 영어, 수학 점수 : ");
		   
		   int 국어 = Scanner.nextInt();
		   int 영어 = Scanner.nextInt();
		   int 수학 = Scanner.nextInt();
		   
		   int total = 국어+영어+수학;
		   float 평균 = (total/3);
		   
		   System.out.printf(" 총점 : %d , 평균 :  %2.1d ", total, 평균);
		   
		   
		 // 문제 20 
		   System.out.println(" ID , PW : ");
		   String ID = Scanner.next();
		   String PW = Scanner.next();
		   
		   boolean 일치1 = (ID == "admin");
		   boolean 일치2 = (PW == "1234" );
		   
		   String 로그인 = 일치1 && 일치2 ? "로그인 성공" : "로그인 실패";
		   
		   System.out.println(로그인);
		   
		 // 문제 21
		   System.out.println("정수 3개");
		 
		   int 정수01 = Scanner.nextInt();
		   int 정수02 = Scanner.nextInt();
		   int 정수03 = Scanner.nextInt();
		   
		   int 큰수1 = 정수01>정수02 ? 정수02>정수03? 정수01 : 정수03: 정수02;
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
					
	} // main e
	

}	// class e
