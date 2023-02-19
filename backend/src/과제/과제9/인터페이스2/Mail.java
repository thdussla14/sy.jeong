package 과제.과제9.인터페이스2;

public class Mail implements Contact{

	@Override
	public void Send() {
		System.out.println("메일 전송되었습니다.");
		
	}
	@Override
	public void REceive(String content) {
		System.out.println("메일 도착하였습니다.");
		System.out.println("내용 : "+content);
		
	}
}
