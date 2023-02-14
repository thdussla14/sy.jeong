package 과제.과제4_싱글톤;

import 과제.과제4_싱글톤.view.Front;

public class Start {

	public static void main(String[] args) {
		
		Front.getInstance().index();
		
		
	}// main e
}// class e


/*
	M : 데이터 모델링 [ 저장하고자하는 데이터들의 설계 ]  
	V : 입 출력 
	C : 제어 / 비지니스 로직 / 기능
	
	예) 회워가입
		V : 아이디, 비밀번호 입력
		C : 입력받은 데이터를 유효성검사 후 저장
		M : 컨트롤이 데이털를 저장할때 사용하는 모델링
		
	* DTO : 데이터 전송을 위해 생성되는 객체 / 비즈니스 로직이 아닌 데이터만 저장	
	* DTO 기법을 사용하면 중요한 정보를 노출시키지 않고 두 시스템(API와 서버 등) 간 통신을 원활하게 촉진 가능
	
	// 1. 회원가입
		// 인수 : id, pw, confirmpw , name, phone
		// 반환 : 0 [성공] 1 [패스워드 실패]	
	// 2. 로그인
		// 인수 : id, pw
		// 반환 : i [회원번호] -1 [비밀번호 불일치] -2 [아이디 불일치] 
	// 3. 아이디찾기
		// 인수 : name, phone
		// 반환 : id or  null
	// 4. 비밀번호찾기
		// 인수 : id, phone
		// 반환 : pw or null	
	// 5. 글쓰기
		// 인수 : id, title, content
		// 반환 : true [성공] false [실패]	
	// 6. 글출력
		// 인수 : X [추후 페이징처리, 검색처리시 인수 O]
		// 반환 : 모든 글이 담긴 ArrayList<board>	
	// 7. 글상세
		// 인수 : id, 글번호
		// 반환 : 글 하나 board	
	// 8. 글삭제
		// 인수 : id, 글번호
		// 반환 : true [성공] false [실패]	
		// * 조회수 증가
	// 9. 글수정
		// 인수 : id, 글번호, newtitle, newcontent
		// 반환 : true [성공] false [실패]	
	// 10. 로그아웃
		// 인수 : X [추후 페이징처리, 검색처리시 인수 O]
		// 반환 : true [성공] false [실패]
	
*/


