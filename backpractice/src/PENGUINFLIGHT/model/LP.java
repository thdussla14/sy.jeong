package PENGUINFLIGHT.model;

public class LP {
	
	private int lpno;
	private String lpname;
	private int lno;
	private int ano;
	
	public LP() {}

	public LP(int lpno, String lpname, int lno, int ano) {
		super();
		this.lpno = lpno;
		this.lpname = lpname;
		this.lno = lno;
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "LP [lpno=" + lpno + ", lpname=" + lpname + ", lno=" + lno + ", ano=" + ano + "]";
	}

	public int getLpno() {
		return lpno;
	}

	public void setLpno(int lpno) {
		this.lpno = lpno;
	}

	public String getLpname() {
		return lpname;
	}

	public void setLpname(String lpname) {
		this.lpname = lpname;
	}

	public int getLno() {
		return lno;
	}

	public void setLno(int lno) {
		this.lno = lno;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}


	
}
