package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class member extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public member() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int 	custno  	= Integer.parseInt((request.getParameter("custno"))) ;	System.out.println(custno);
		String 	custname 	= (request.getParameter("custname"));					System.out.println(custname);
		String 	phone 		= (request.getParameter("phone"));						System.out.println(phone);
		String 	address 	= (request.getParameter("address"));					System.out.println(address);
		String 	joindate 	= (request.getParameter("joindate"));					System.out.println(joindate);
		String 	grade 		= (request.getParameter("grade"));						System.out.println(grade);
		String 	city 		= (request.getParameter("city"));						System.out.println(city);
		
		memberDto dto = new memberDto(custno, custname, phone, address, joindate, grade, city);
		
		System.out.println(dto);
		
		Dao dao = new Dao();
		boolean result = dao.signup(dto);
		
		response.getWriter().print(result);
		
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		int 	custno  	= Integer.parseInt((request.getParameter("custno"))) ;	System.out.println(custno);
		String 	custname 	= (request.getParameter("custname"));					System.out.println(custname);
		String 	phone 		= (request.getParameter("phone"));						System.out.println(phone);
		String 	address 	= (request.getParameter("address"));					System.out.println(address);
		String 	joindate 	= (request.getParameter("joindate"));					System.out.println(joindate);
		String 	grade 		= (request.getParameter("grade"));						System.out.println(grade);
		String 	city 		= (request.getParameter("city"));						System.out.println(city);
		
		memberDto dto = new memberDto(custno, custname, phone, address, joindate, grade, city);
		
		System.out.println(dto);
		
		Dao dao = new Dao();
		boolean result = dao.setMember(dto);

		response.getWriter().print(result);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
