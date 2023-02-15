package Day11.Ex7;

import java.util.ArrayList;

import Day11.Ex6.HankookTire;
import Day11.Ex6.KumhoTire;
import Day11.Ex6.Tire;

public class 실행2 {

	public static void main(String[] args) {
		
		Tire tire = new Tire();
		KumhoTire kumhoTire = new KumhoTire();
		HankookTire hankookTire = new HankookTire();
		
		// 1. 참조타입의 자동 타입 변환	(자식 -> 부모)	
		Tire temp = tire;
			Tire temp2 = kumhoTire;
				Tire temp3 = hankookTire;
					Object temp4 = temp3;
		
		// 2. 참조타입의 강제 타입 변환	(부모 -> 자식)
		Tire tire2 = (Tire)temp4;
			KumhoTire kumhoTire2 = (KumhoTire)tire2;
				HankookTire hankookTire2 = (HankookTire)tire2;
			
		// 3. 매개변수, 리턴타입
		Tire result  = 함수1 (kumhoTire2);	
				   //= kumhoTire;
		KumhoTire result2 = (KumhoTire)함수2((KumhoTire)temp2);		
		
		// 4. 배열, ArrayList
		ArrayList<KumhoTire> kumhoList = new ArrayList<>();
		kumhoList.add(kumhoTire);
		//kumhoList.add(hankookTire);	// 컴파일 에러	형제끼리 포용 x
		//kumhoList.add(tire);			// 컴파일 에러	자식은 부모를 포용 x
		
		ArrayList<Tire> TireList = new ArrayList<>();
		TireList.add(kumhoTire);		// 부모는 자식을 모두 포용 o
		TireList.add(hankookTire);		// 부모는 자식을 모두 포용 o
		TireList.add(tire);				
		
		
	}// main e
	
	public static KumhoTire 함수1(Tire tire) { return new KumhoTire();}
	public static Tire 함수2(KumhoTire kumhoTire) {return new Tire();}
	
}// class e
