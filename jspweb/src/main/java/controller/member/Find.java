package controller.member;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dao.MemberDao;

@WebServlet("/find")
public class Find extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Find() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 입력받은 타입 요청 // 1 : 아이디 찾기 2: 비밀번호 찾기
		String type   = request.getParameter("type");
		String result = null;
		
		if(type.equals("1")) {
			String memail = request.getParameter("memail");
			result = MemberDao.getInstance().findid(memail);
		}else if(type.equals("2")) {
			String mid	  = request.getParameter("mid");
			String memail = request.getParameter("memail");
			
			// 난수 목록
			String ranStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
			// 임시비밀번호 만들기
			String updatepw = "";
				// 1. 12자리수
				for(int i=0; i<10;i++) {
					Random random = new Random();
					// ranStr의 0 ~ 마지막인덱스 -> 난수 인덱스
					int ran = random.nextInt(ranStr.length());
					// 해당 인덱스의 문자1개 
					updatepw += ranStr.charAt(ran);	
				}			
			result = MemberDao.getInstance().findpw(mid, memail,updatepw);	
		}		
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
