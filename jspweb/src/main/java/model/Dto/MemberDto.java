package model.Dto;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MemberDto {

	private int 	mno; 
    private String	mid;
    private String	mpwd;
    private String	mimg;
    private String	memail;
    private int 	mpoint; // DB에 없는 필드 추가
    
    // 1. 이메일 전송 메소드 [ 받는 사람 이메일 , 보낼 내용 HTML ] 
    public boolean sendEmail( String toEmail, String contentHTML ) {		
    	
    	// 1. 보내는 사람의 정보
    	String fromEmail = ""; // 메일 주소 
    	String Emailpw	 = ""; // 계정 비밀번호 
    	
    	// 2. 호스팅 설정 [구글 기준] 
    	Properties properties = new Properties();
    	properties.put("mail.smtp.host", "smtp.naver.com");			// "smtp.gmail.com"
    	properties.put("mail.smtp.port",  587 );
    	properties.put("mail.smtp.auth",  true);
    	properties.put("mail.smtp.ssl.protocols",  "TLSv1.2" );
    	
    	// 3. 인증처리 [ Session : import javax.mail.Session; ]
    	Session session = Session.getDefaultInstance(properties, new Authenticator() {
    		// 패스워드 인증 함수 오버라이딩
    		@Override
    		protected PasswordAuthentication getPasswordAuthentication() {
    			return new PasswordAuthentication(fromEmail,Emailpw) ;
    		}
		});
    	
    	// 4. 메일 보내기 
    	try {
    		// 1. smtp 가 보낼 수 있는 표준 형식 [포멧]
    		MimeMessage message = new MimeMessage(session);
    		message.setFrom(new InternetAddress(fromEmail));
    		message.addRecipients(Message.RecipientType.BCC.TO, toEmail);
    		// 내용구성
    		message.setSubject("Ezen community 회원가입 메일 인증코드");
    		message.setText(contentHTML);
    		// 전송
    		Transport.send(message);
    		
    		return true;	// 메일 전송 성공 
    	}catch (Exception e) { System.out.println(e);}
    	return false;		// 메일 전송 실패 
	}

    public MemberDto() { }

	public MemberDto(int mno, String mid, String mpwd, String mimg, String memail) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpwd = mpwd;
		this.mimg = mimg;
		this.memail = memail;
	}

	public MemberDto(int mno, String mid, String mpwd, String mimg, String memail, int mpoint) {
		super();
		this.mno = mno;
		this.mid = mid;
		this.mpwd = mpwd;
		this.mimg = mimg;
		this.memail = memail;
		this.mpoint = mpoint;
	}

	@Override
	public String toString() {
		return "MemberDto [mno=" + mno + ", mid=" + mid + ", mpwd=" + mpwd + ", mimg=" + mimg + ", memail=" + memail
				+ ", mpoint=" + mpoint + "]";
	}

	public int getMpoint() {
		return mpoint;
	}

	public void setMpoint(int mpoint) {
		this.mpoint = mpoint;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	public String getMpwd() {
		return mpwd;
	}

	public void setMpwd(String mpwd) {
		this.mpwd = mpwd;
	}

	public String getMimg() {
		return mimg;
	}

	public void setMimg(String mimg) {
		this.mimg = mimg;
	}

	public String getMemail() {
		return memail;
	}

	public void setMemail(String memail) {
		this.memail = memail;
	}
	
	
}
