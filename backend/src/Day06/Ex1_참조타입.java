package Day06;

public class Ex1_참조타입 {

	public static void main(String[] args) {
	
		
	// 1. p.148	
	int[] arr1;	// int형 배열 선언 [ 스태 영역에 변수 만들기]
	int[] arr2; // int형 배열 선언 [ 스태 영역에 변수 만들기]
	int[] arr3; // int형 배열 선언 [ 스태 영역에 변수 만들기]
	
	
	arr1 = new int[] {1,2,3};	// [힙 영역에 '1','2','3' 메모리 3개]
	arr2 = new int[] {1,2,3};	// [배열은 첫번째 메모리 ('1')주소를 스택영역에 대입]
	arr3 = arr2;				// arr2가 가지고 있던 메모리 주소를 arr3 대입
	
	System.out.println(arr1 == arr2);	//false	// arr1 과 arr2 변수가 같은 배열을 참조하는지 검사
	System.out.println(arr2 == arr3);	//true	//  == 스택 영역에 데이터 비교 // 주소 비교
	
	// 2. 
	int[] intarray = null; 					// int형 배열선언 [스택 영역에 변수 만들기 ]
	//System.out.println(intarray[0]);		// java.lang.NullPointerException 오류 발생 : 힙 영역이 없기 때문에 
	//intarray[0] = 10;						// java.lang.NullPointerException 오류 발생 : 힙 영역이 없기 때문에 저장 불가능
	//System.out.println(intarray.length);	// java.lang.NullPointerException 오류 발생 : 힙 영역이 없기 때문에 길이 불가능
	
	// 3.
	String hobby = "여행";	// 스택 영역에 hobby 이름으로 변수 선언하고 "여행" 힙의 메모리 주소 저장
	hobby = null;			// hobby 변수 null 변경시 힙의 "여행" 메모리 제거
	
	String kind1 = "자동차";	// '자동차' 힙의 메모리 주소를 스택영역 kind1에 저장
	String kind2 = kind1;	// '자동차' 힙의 메모리 주소 kind2에 대입	
	kind1 = null;			// kind1 번지 지우기
	System.out.println(kind2);
	
	}	// main e
	
}	// class e

/*
 
 	스택영역					힙영역	
 	arr1	<---주소대입 --- 	new int [] {1,2,3}		
 	arr2	<---주소대입 --- 	new int [] {1,2,3}		
 	arr3
 
 	* new : 힙영역에 메모리 생성하는 연산자
 	
 	스택영역									힙영역	[별도의 제거 없음]
 	유재석: 안산시 상록구 127번지					안산 ㅇㅇ아파트 : 안산시 상록구 127번지 (이사1)시 쓰레기 => 가비지 컬렉터 제거 대상
 			(이사1)							수원 ㅇㅇ아파트 : 수원시 영통구 721번지 (이사2)시 쓰레기 => 가비지 컬렉터 제거 대상
 	유재석: 수원시 영통구 721번지
 			(이사2)
 	유재석: null
 
 */