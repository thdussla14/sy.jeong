package model.Dto;

public class MpointDto {

	private int 	mpno;
    private String	mpcomment;
    private int 	mpamount;	
    private String 	mpdate;		
    private int 	mpmno;
    
    public MpointDto() { }

	public MpointDto(int mpno, String mpcomment, int mpamount, String mpdate, int mpmno) {
		super();
		this.mpno = mpno;
		this.mpcomment = mpcomment;
		this.mpamount = mpamount;
		this.mpdate = mpdate;
		this.mpmno = mpmno;
	}

	@Override
	public String toString() {
		return "PointDto [mpno=" + mpno + ", mpcomment=" + mpcomment + ", mpamount=" + mpamount + ", mpdate=" + mpdate
				+ ", mpmno=" + mpmno + "]";
	}

	public int getMpno() {
		return mpno;
	}

	public void setMpno(int mpno) {
		this.mpno = mpno;
	}

	public String getMpcomment() {
		return mpcomment;
	}

	public void setMpcomment(String mpcomment) {
		this.mpcomment = mpcomment;
	}

	public int getMpamount() {
		return mpamount;
	}

	public void setMpamount(int mpamount) {
		this.mpamount = mpamount;
	}

	public String getMpdate() {
		return mpdate;
	}

	public void setMpdate(String mpdate) {
		this.mpdate = mpdate;
	}

	public int getMpmno() {
		return mpmno;
	}

	public void setMpmno(int mpmno) {
		this.mpmno = mpmno;
	}
    
	
    
}
