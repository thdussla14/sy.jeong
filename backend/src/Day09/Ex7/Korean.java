package Day09.Ex7;
/*

	final 필드 : 최종 의미
		- 수정 불가 만들기
		- 무조건 초기화가 있어야 한다.
		- 필드에 직접 초기화, 생성자 이용 초기화

	static final 필드 : 상수
		- 수정 불가능, 공유 메모리
		- 상수 이름 : 관례적으로 대문자 사용
 */
public class Korean {
	// 1. final : 수정 불가, 메모리 공유 X
		// 1-1. 필드
		final String nation = "대한민국";
		final String ssn; // final 무조건 초기화 존재
		
		String name;
		
		// 1-2. 생성자
		public Korean(String ssn, String name) {
			this.ssn = ssn;
			this.name = name;
		}
		
		// 1-3. 메소드
		
	// 2. static final : 수정 불가, 메모리 공유 O
		// 2-1. 필드
		static final double EARTH_RADIUS = 6400;
		static final double EARTH_SPACE_AREA;
		static {
			EARTH_SPACE_AREA = 4*Math.PI*EARTH_RADIUS*EARTH_RADIUS;
		}
		// 2-2. 생성자
		// 2-3. 메소드
	
}// class e
