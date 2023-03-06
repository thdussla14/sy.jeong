package practice.day02;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class Student
 */
@WebServlet("/Student")
public class Student extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<StudentDto> list = Dao.getInstance().print();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonArray = objectMapper.writeValueAsString(list);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		String 	name 	= request.getParameter("sdata1");
		String 	phone	= request.getParameter("sdata2");
		double 	height	= Double.parseDouble(request.getParameter("sdata3")) ;
		int 	age		= Integer.parseInt(request.getParameter("sdata4")) ;
		String	date	= request.getParameter("sdata5");
		String	sex		= request.getParameter("sdata6");
		boolean agree	= Boolean.parseBoolean(request.getParameter("sdata7"));
		String	live	= request.getParameter("sdata8");
		String	introduce= request.getParameter("sdata9");
		System.out.println(agree);
		StudentDto sdto = new StudentDto(name, phone, height, age, date, sex, agree, live, introduce);

		boolean result = Dao.getInstance().register(sdto);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}

}
