package Day13.Ex5;

public class Car {

	// 필드 
	Tire tire1 = new HankookTire();			 // 만일 펑크시 한국/금호 타이어 호환 가능 = 다형성 o
	Tire tire2 = new HankookTire();			 // Tire
	
	//HankookTire tire1 = new HankookTire(); // 가능하나 만일 펑크시 한국타이어로만 교체 가능 = 다형성 x
	//KumhoTire   tire1 = new KumhoTire();   // 가능하나 만일 펑크시 금호타이어로만 교체 가능 = 다형성 x
	
	// 메소드
	void run() {
		tire1.roll();
		tire2.roll();
	}
	
}
