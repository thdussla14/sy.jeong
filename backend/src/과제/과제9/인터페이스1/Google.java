package 과제.과제9.인터페이스1;

public class Google implements Search {

	@Override
	public void input(String content) {
		System.out.println("Google 검색창에 ["+content+"] 검색어를 입력합니다.");
		
	}
	@Override
	public void output(String content) {
		System.out.println("Google에서 ["+content+"]로 검색된 내용을 출력합니다.");
		
	}
	
}
