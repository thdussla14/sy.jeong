package controller.admin;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dto.MemberDto;

@WebServlet("/email")
public class Email extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Email() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 받을 회원 이메일 
		String memail = request.getParameter("memail"); System.out.println(memail);		
		
		//간이 우편 전송 프로토콜(Simple Mail Transfer Protocol) // 메일 서버(네이버,구글,다음)에게 우편 전송
		// 2. 인증코드 만들기
		String auth = "";
		for(int i=0 ; i<6 ; i++) {		
			Random random = new Random();			
			auth += random.nextInt(10);  // 0~9 사이 정수 생성					
		}
		System.out.println(auth);
		
		// 2. 인증코드와 받는 사람의 이메일에게 보내기 
		boolean result = new MemberDto().sendEmail(memail, auth);
		// 3. 메일전송 성공시 인증코드 보내기 / 메일전송 실패시 false 반환
		if(result) {		
			response.getWriter().print(auth);
		}else {	
			response.getWriter().print(result);}
		
	}

}
