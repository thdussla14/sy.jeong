package 과제.과제9.인터페이스1;

public class Daum implements Search {

	@Override
	public void input(String content) {
		System.out.println("Daum 검색창에 ["+content+"] 검색어를 입력합니다.");
		
	}
	@Override
	public void output(String content) {
		System.out.println("Daum에서 ["+content+"]로 검색된 내용을 출력합니다.");
		
	}
	
}