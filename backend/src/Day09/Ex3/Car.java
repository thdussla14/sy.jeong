package Day09.Ex3;

/*
 	return 메소드의 실행을 강제 종료하고 호출한 곳으로 돌아감
 
 
 
 */
public class Car {
	// 1. 필드
	int gas;
	
	// 2. 생성자
	
	Car(){ }
	Car(int gas){ this.gas = gas; }
	
	// 3. 메소드
	
	//3-1. [간접접근] gas 필드에 데이터 저장 함수
	void setGas(int gas) {
		this.gas = gas;
	}//setGas e
	
	//3-2. gas 여부 확인 함수
	boolean isLeftGas() {
		if(gas == 0) {
			System.out.println("gas가 없습니다.");
			return false;
		}
		System.out.println("gas가 있습니다.");
		return true;
	}//isLeftGas e
	
	//3-3. 
	void run() {
		while(true) {// 무한루프 [ 종료조건 : gas 0이면 return ]
			if(gas > 0) {// 만약 gas가 0보다 크면 
				System.out.println("달립니다.(gas 잔량 : "+gas+")");
				gas--;	// gas 줄이기
			}
			else {
				System.out.println("멈춥니다.(gas 잔량 : "+gas+")");
				return; // 함수 종료 
			}
		}// while e
	}// run e
	
}// class e
