package Day13.Ex6;

public class 전사 extends 캐릭터{

	int 체력;
	
	@Override
	void 스킬1() {
		System.out.println("베기");
		super.스킬1();
	}
	@Override
	void 스킬2() {
		System.out.println("찌르기");
		super.스킬2();
	}
	@Override
	void 스킬3() {
		System.out.println("내려치기");
		super.스킬3();
	}
	@Override
	public void A버튼() {
		스킬1();
		
	}
	@Override
	public void B버튼() {
		스킬2();
		
	}
}
