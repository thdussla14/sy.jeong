package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Dao.MemberDao;
import model.Dto.MemberDto;

@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 세션에 담겨진 회원 아이디 호출
		String mid = (String)request.getSession().getAttribute("login"); 
		
		// 2. 로그인한 회원의 정보 호출 [ 비밀번호 제외 ]
		MemberDto result = MemberDao.getInstance().getMember(mid);		
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(result);
		// 3. 응답
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(json);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		boolean result = MemberDao.getInstance().login(mid,mpw);
		// 로그인 성공시 로그인 세션 만들기
		if(result == true) {
			// request.getSession()			: 서버[톰캣] 내 세션 객체 호출
			// setAttribute("key", value)	: 서버[톰캣] 내 세션 객체에 속성 [데이터] 추가
			request.getSession().setAttribute("login", mid);
		}		
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);	
	}

}
