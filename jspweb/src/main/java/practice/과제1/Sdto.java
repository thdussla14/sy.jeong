package practice.과제1;

public class Sdto {
	
	private int sno;
	private String sname;
	private String sclass;
	private String stype;
	private String field;
	private String edate;
	private String simg;
	private String ddate;
	private String dcontent;
	
	public Sdto() {
		// TODO Auto-generated constructor stub
	}

	public Sdto(int sno, String sname, String sclass, String stype, String field, String edate, String simg,
			String ddate, String dcontent) {
		super();
		this.sno = sno;
		this.sname = sname;
		this.sclass = sclass;
		this.stype = stype;
		this.field = field;
		this.edate = edate;
		this.simg = simg;
		this.ddate = ddate;
		this.dcontent = dcontent;
	}

	public int getSno() {
		return sno;
	}

	public void setSno(int sno) {
		this.sno = sno;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getSclass() {
		return sclass;
	}

	public void setSclass(String sclass) {
		this.sclass = sclass;
	}

	public String getStype() {
		return stype;
	}

	public void setStype(String stype) {
		this.stype = stype;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getSimg() {
		return simg;
	}

	public void setSimg(String simg) {
		this.simg = simg;
	}

	public String getDdate() {
		return ddate;
	}

	public void setDdate(String ddate) {
		this.ddate = ddate;
	}

	public String getDcontent() {
		return dcontent;
	}

	public void setDcontent(String dcontent) {
		this.dcontent = dcontent;
	}

	@Override
	public String toString() {
		return "Sdto [sno=" + sno + ", sname=" + sname + ", sclass=" + sclass + ", stype=" + stype + ", field=" + field
				+ ", edate=" + edate + ", simg=" + simg + ", ddate=" + ddate + ", dcontent=" + dcontent + "]";
	}
	
	
}
