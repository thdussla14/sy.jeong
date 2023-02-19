package 과제.과제9.인터페이스3;

public class 메모장 implements Record {

	@Override
	public void write() {
		System.out.println("일시적 내용은 메모장에 기록합니다.");
		
	}
	@Override
	public void save() {
		System.out.println("메모장에 내용을 저장합니다.");
		
	}
	@Override
	public void view(String content) {
		System.out.println("메모장에 내용을 출력합니다.");
		System.out.println("내용 : "+content);
	}
	
}
