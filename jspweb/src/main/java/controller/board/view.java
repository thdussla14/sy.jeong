package controller.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dao.BoardDao;

@WebServlet("/board/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public view() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int type = Integer.parseInt(request.getParameter("type")); 
		int bno  = Integer.parseInt(request.getParameter("bno"));  System.out.println(type + bno);
		
		/*
			- 하루 한번씩 조회수/좋아요수/싫어요수 증가 가능
			- 회원별 vs pc별
			- 세션 사용
		 */

		// PC 네트워크 식별자 [ip]
			// 1. java에서 현재 요청한 클라이언트의 ip 확인
		 	String ip = request.getRemoteAddr();					System.out.println(ip);
		 	
		 	// 4. 만약에 기존 세션이 없으명 증가 / 있으면 증가 불가 
		 	Object o = request.getSession().getAttribute(type + ip + bno);
		 	if(o==null) {
			 	// 2. 세션 생성 	[ type + ip + bno ] 
			 	request.getSession().setAttribute(type + ip + bno, 1 );
			 	// 3. 세션 생명주기 [ 생명주기 지나면 자동으로 메모리 삭제 / 초단위 ] 
			 		// 1. 서버끄기 2. 서버재가동 3. MaxInactiveInterval 설정 시간 초과
			 		// 4. invalidate()
			 	request.getSession().setMaxInactiveInterval(24*60*60); // 하루  24*60*60
				BoardDao.getInstance().bIncrease(type,bno);
		 	}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
