package 과제.과제9.인터페이스4;

public class CellPhone implements Bluetooth{

	@Override
	public void Pairing() {
		System.out.println(" 핸드폰 페어링 연결되었습니다. ");
		
	}
	@Override
	public void disconnect() {
		System.out.println(" 핸드폰 페어링 연결 해제되었습니다. ");
		
	}
}
