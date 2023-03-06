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
 * Servlet implementation class Ex2
 */
@WebServlet("/Ex2")
public class Ex2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ex2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. DAO 에 데이터 요청 -> 리스트에 받기
		//ArrayList<Object>list = Dao.getInstance().getData();			
		ArrayList<Dto>list = Dao.getInstance().getData2();
		
			// JAVA 객체 와 JS 객체는 체계/형태가 다르다 [ 호환불가 ]
			// 해결 : JAVA 객체를 JS 객체로 변환 [ object -> JSON ]
				// 1. 라이브러리 3개 [ 
		
		ObjectMapper objectmapper = new ObjectMapper();
		String jsonArray = objectmapper.writeValueAsString(list);
		System.out.println(list);
		System.out.println(jsonArray);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 요청시 데이터 한글인코딩
		request.setCharacterEncoding("UTF-8");
		// 2. request.getParameter("매개변수명"); 데이터 가져올때 무조건 String 타입 가져온다. [필요에 따라 형태변환 필요]
		String  data1 = request.getParameter("data1");
		String  data2 = request.getParameter("data2");
		double  data3 = Double.parseDouble(request.getParameter("data3"));
		int	    data4 = Integer.parseInt(request.getParameter("data4")) ;
		String  data5 = request.getParameter("data5");
		String  data6 = request.getParameter("data6");
		String  data7 = request.getParameter("data7");
		boolean data8 = Boolean.parseBoolean(request.getParameter("data8")) ;
		String  data9 = request.getParameter("data9");
		String data10 = request.getParameter("data10");
		// 3-1. DAO에 인수 10개 전달
		// boolean result = Dao.getInstance().setData(data1, data2, data3, data4, data5, data6, data7, data8, data9, data10);
		// 3-2. Dto에 인수10개를 담아 DAO에 Dto 1개를 전달
		Dto dto = new Dto(data1, data2, data3, data4, data5, data6, data7, data8, data9, data10);
		boolean result = Dao.getInstance().setData2(dto);
		// 4. 응답객체 한글 인코딩
		response.setCharacterEncoding("UTF-8");
		// 5. 받은 결과를 JS로 전달
		response.getWriter().print(result);
		
	}

}
