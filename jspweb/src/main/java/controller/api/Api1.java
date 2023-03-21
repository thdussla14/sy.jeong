package controller.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Api1")
public class Api1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Api1() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 1. 공공데이터 포털에서 신청한 데이터 가져오기 [ 안산시 전기차 충전소 ]
			// URL 클래스
			// URL url = new URL("URL 주소")
			// 1.  .openStream(); : 해당 객체의 연결된 url 스트림 제공 함수 
		URL url = new URL("https://api.odcloud.kr/api/15090398/v1/uddi:6fe0e3f2-0285-4999-9edf-995afe19a6ea?page=1&perPage=96&serviceKey=BfP86px%2BpQ0jnkgJQI4pTC4vZ5s%2FfIEcv8qV9zv7bXgmJzqVizTFx4lo1c8P54CXOnRL7F3AxUU%2B%2BaBXSzRpHA%3D%3D");
		
		// 2. 해당 URL의 데이터 [ 스트림(바이트) ] 읽어오기 위한 스트림 객체 생성
		// InputStream intputstream = url.openStream(); 
		// => intputstream.read(); => byte[] array = new byte[100000]; => 바이트 배열로 읽어옴 => 디코딩 메소드 제공 X 
		// InputStreamReader reader = new InputStreamReader( url.openStream(), "UTF-8"); 
		// => reader.read(array);  => char[] array = new char[100000]; => char 배열로 읽어옴 => 디코딩 메소드 제공 O
		BufferedReader bf = new BufferedReader(new InputStreamReader( url.openStream(), "UTF-8"));
		// => bf.readLine();       => 모든 배열을 읽은 후 문자열 String 반환
		
			// * 
			// byte[] array1 = new byte[100000];
			// char[] array2 = new char[100000];
		
		// 3. 바이트 읽어오기 메소드 실행 
		// intputstream.read(array1);
		// reader.read(array2);
		String result = bf.readLine();
		System.out.println(result);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
