package practice.day03;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/Product")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Product() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String 	pname = request.getParameter("pname");
		int 	price = Integer.parseInt(request.getParameter("price"));
		ProductDto dto = new ProductDto(0, pname, price);
		boolean result = ProductDao.getInstance().register(dto);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ProductDto> list = ProductDao.getInstance().print();
		
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonarray = objectMapper.writeValueAsString(list);
		
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.getWriter().print(jsonarray);
	}

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int 	pno = Integer.parseInt(request.getParameter("pno"));
		boolean result = ProductDao.getInstance().ondelete(pno);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		int 	pno		= Integer.parseInt(request.getParameter("pno"));
		String 	pname 	= request.getParameter("pname");
		int 	price 	= Integer.parseInt(request.getParameter("price"));
		ProductDto dto 	= new ProductDto(pno, pname, price);

		boolean result = ProductDao.getInstance().onupdate(dto);
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(result);
	}

}
