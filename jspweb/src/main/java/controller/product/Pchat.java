package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Dao.MemberDao;
import model.Dao.ProductDao;
import model.Dto.NoteDto;

@WebServlet("/pchat")
public class Pchat extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Pchat() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 제품번호 
		int pno 	= Integer.parseInt(request.getParameter("pno"))	;
		// 요청한 사람 == 로그인 회원
		int mno = MemberDao.getInstance().getMno((String)request.getSession().getAttribute("login"));
		
		ArrayList<NoteDto> list = ProductDao.getInstantce().getnotelist(pno, mno);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonarray = mapper.writeValueAsString(list);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("appication/json");
		response.getWriter().print(jsonarray); System.out.println(jsonarray);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 한글 인코딩
		request.setCharacterEncoding("UTF-8");
		// 쪽지내용
		String ncontent = request.getParameter("ncontent");
		// 제품번호 
		int pno 	= Integer.parseInt(request.getParameter("pno"))	;	
		// 받는사람
		int tomno 	= Integer.parseInt(request.getParameter("tomno"));
		// 보낸사람
		int frommno = MemberDao.getInstance().getMno((String)request.getSession().getAttribute("login"));

		NoteDto dto = new NoteDto(0, ncontent, null, pno, frommno, tomno); System.out.println(dto);

		boolean	result = ProductDao.getInstantce().setnote(dto);
		
		response.getWriter().print(result);
		
	}

}
