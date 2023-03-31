package controller.admin;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.Dao.MemberDao;
import model.Dao.ProductDao;

@WebServlet("/point")
public class Point extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Point() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HashMap<String, Integer> map = ProductDao.getInstantce().getsum();
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonmap = mapper.writeValueAsString(map); System.out.println(jsonmap);
		
		response.setContentType("applicaion/json");
		response.getWriter().print(jsonmap);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String 	mpcomment 	= request.getParameter("mpcomment");					System.out.println(mpcomment);
		int 	mpamount	= Integer.parseInt(request.getParameter("mpamount"));
		int 	mno			= Integer.parseInt(request.getParameter("mno"));
		
		boolean result 		= MemberDao.getInstance().setPoint(mpcomment, mpamount, mno);
		
		response.getWriter().print(result);

	}

}
