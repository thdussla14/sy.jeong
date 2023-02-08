package Day06;

public class Ex2_문자열 {

	
	public static void main(String[] args) {
		
		// 1. 자바 문자열을 사용하는 방법
			// 1. 배열
		char[] 문자열1 = new char[] {'안','녕'};
			// 2. 클래스 [ 객체]
		String 문자열2 = new String ("안녕");
			// 3. 문자리터럴 " "
		String 문자열3 = "안녕";
	
		
		// 2. 
		String strvar1 = "홍길동";
		String strvar2 = "홍길동";
		
		if(strvar1 == strvar2)
		{System.out.println("참조 주소 같음");}
		else {System.out.println("참조 주소 다름");}
		
		
		if(strvar1.equals(strvar2))
		{System.out.println("참조 주소 내부 같음");}
		
		
		String strvar3 = new String( "홍길동" );
		String strvar4 = new String( "홍길동" );
		
		if(strvar3 == strvar4)
		{System.out.println("참조 주소 같음");}
		else {System.out.println("참조 주소 다름");}
		
		
		if(strvar3.equals(strvar4))
		{System.out.println("참조 주소 내부 같음");}
		
		// 3. 
		String hobby  =  "" ;	// "" vs null
		if( hobby.equals("")) {System.out.println(" \"\"의 객체");};
		
		String hobby2  = null ;	// "" vs null
		// if( hobby.equals(null)) {System.out.println(" null 객체의 데이터 확인");};
		if( hobby2 == null) {System.out.println(" null 주소 확인");};
		
		
		// 문자열 관련 api함수
		
		String ssn = "9506241230123";
		
		//.charAt(인덱스)
		char sex = ssn.charAt(6);System.out.println(sex);
		if( sex == '1' || sex == '3') {System.out.println("남자");}
		else {System.out.println("여자");};
		
		//.length()
		int length = ssn.length();
		if(length == 13) {System.out.println("주민번호 자릿수 맞음");}
		else  {System.out.println("주민번호 자릿수 다름");};
		
		//.replace("기존문자","새로운문자")
		String oldStr = "자바 문자열 불변입니다. 자바 문자열은 String 입니다.";
		String newStr = oldStr.replace("자바", "JAVA");
		System.out.println(oldStr);
		System.out.println(newStr);
		
		//.substring(인덱스) vs .split("기준 문자")
		String ssn2 = "880815-1234567";
		System.out.println(ssn2.substring(7));		// 7 인덱스 전 자르기
		System.out.println(ssn2.substring(0,6));	// 0 ~ 6 인덱스 전까지 자르기
		System.out.println(ssn2.split("-"));		// "-" 기준으로 자르면 2조각 / 인덱스 배열 반환
		System.out.println(ssn2.split("-")[0]);		// 1번 조각 확인
		System.out.println(ssn2.split("-")[1]);		// 2번 조각 확인
		
		
		String board = "1, 자바 학습, 참조타입 String을 학습합니다., 홍길동";		
		String[] tokens = board.split(",");	// , 기준 분리 시 4조각
		System.out.println("번호 : "+tokens[0]);
		System.out.println("제목 : "+tokens[1]);
		System.out.println("내용 : "+tokens[2]);
		System.out.println("성명 : "+tokens[3]);
		
		
		// .indexOf("찾을 문자") vs .contains("찾을 문자")		
		String subject = "자바 프로그래밍";
		System.out.println(subject.indexOf("자바"));	 // 찾으면 인덱스	반환
		System.out.println(subject.indexOf("파이썬")); // 없으면 -1 	반환
		System.out.println(subject.contains("자바"));	 // 찾으면 true	반환
		System.out.println(subject.contains("파이썬"));// 없으면 false 	반환
		
	}	// main e

}	// class e

/*
	' ': 문자 	char	기본타입
	" ": 문장열	String	참조타입
	 
	 
	 자바 문자열을 사용하는 방법
	 	1. 배열
	 		 	
	 	2. 클래스
	 		- new 연산자 [ 객체 메모리 생성 ]

	 	String 문자열1 = new String ("안녕");		
	 	String 문자열2 = new String ("안녕");
	 		문자열1 == 문자열2 			// X		// 힙 메모리 주소 별개 	// ==  		스택 영역 비교
	 		문자열1.equals( 문자열2 )	// O true						// equals 	힙 영역 비교			

	 	3. 문자리터럴
	 		- 문자리터럴이 동일한 경우 객체 공유 [ 주소 같다 == ]
	 			 		
	 	String 문자열3 = "안녕";
	 	String 문자열4 = "안녕";					// 힙 메모리 주소 동일
	 		문자열3 == 문자열4 			// O true
	 		문자열3.equals( 문자열4 )	// O true
	 		
	 		
	 	자바 문자열의 함수
			.charAt(인덱스)					: 인덱스 위치의 문자 1개 추출
			.length()						: 문자열의 길이 
			.replace("기존문자","새로운문자") 	: 기존 문자를 새로운 문자로 교체
	 		.substring(인덱스)				: 0 ~ 	인덱스 자르기
	 		.substring(s인덱스, e인덱스)		: s ~ e 인덱스 자르기
	 		.split("자를 기준")				: 기준문자 기준으로 자르기
	 		.indexOf("찾을 문자")				: 찾을 문자의 찾은 인덱스 번호 반환
	 		.contains("찾을 문자")				: 찾을 문자가 존재하면 t/f
	 		.getBytes()						: 
	 		
	 		
	 		
	 		JS								JAVA
	변수  	let 변수명 = 값					자료형 변수명 = 자료형 허용범위 내 값
			* 자료형 자동	설정					* 자료형 수동 설정
	
	배열 		let 배열명 = []					int[] 배열명 = { }
	  		* 여러 자료형 여러개 저장				* 같은 자료형 여러개 저장
	  		let 배열명 = [1,"문자"]			int[] 배열명 = {1,"문자"}
	 		
	 		
	 		
	 		
	 		
	 		
	 		
	 
*/