package practice.과제1;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;


@WebServlet(name = "staffManage", urlPatterns = { "/staff" })
public class staff extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public staff() {
        super();
    }
    // 인사 출력
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 없음
		// Dao로 부터 데이터 받아 저장
		ArrayList<Sdto> list = Dao.getInstance().getStaff();
		// 응답 가능 언어로 인코딩
		ObjectMapper mapper = new ObjectMapper();
		String jsonarray = mapper.writeValueAsString(list);		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("appication/json");
		// 응답
		response.getWriter().print(jsonarray);

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
	// 인사 삭제
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청 받음
		int sno = Integer.parseInt(request.getParameter("sno")); 
		// Dao로 부터 데이터 받아 저장
		boolean result = Dao.getInstance().deleteStaff(sno);
		// 응답
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}

}
