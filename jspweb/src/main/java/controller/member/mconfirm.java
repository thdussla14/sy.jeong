package controller.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dao.MemberDao;

@WebServlet("/mconfirm")
public class mconfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public mconfirm() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		// 1. 검사할 id 요청
		String mid = request.getParameter("mid");
		// 2. Dao에게 전달하고 결과 받기
		boolean result = MemberDao.getInstance().idCheck(mid);
		// 3. 결과응답
		response.getWriter().print(result);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
