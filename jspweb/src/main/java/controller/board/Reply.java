package controller.board;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Dao.BoardDao;
import model.Dao.MemberDao;
import model.Dto.ReplyDto;

@WebServlet("/boardreply")
public class Reply extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Reply() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int bno = Integer.parseInt(request.getParameter("bno"));		
		int rindex = Integer.parseInt(request.getParameter("rindex"));		
		ArrayList<ReplyDto> list = BoardDao.getInstance().getRlist(bno,rindex);
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonarray = mapper.writeValueAsString(list);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonarray);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		int mno = MemberDao.getInstance().getMno((String)request.getSession().getAttribute("login"));
		int bno = Integer.parseInt(request.getParameter("bno"));		
		String rcontent = request.getParameter("rcontent");
		
		int type =  Integer.parseInt(request.getParameter("type"));
		ReplyDto rdto = null;
		
		if(type == 1) {// 최상위 댓글 작성
			rdto = new ReplyDto(rcontent, 0, mno, bno);
		}else if(type == 2) {// 하위 댓글 작성
			int rindex = Integer.parseInt(request.getParameter("rindex"));
			rdto = new ReplyDto(rcontent, rindex, mno, bno);
		}
		System.out.println(rdto);
		
		boolean result = BoardDao.getInstance().rwrite(rdto);
		
		response.getWriter().print(result);
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
