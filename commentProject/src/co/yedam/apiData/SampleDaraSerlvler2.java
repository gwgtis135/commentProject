package co.yedam.apiData;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SampleDaraSerlvler
 */
@WebServlet("/SampleDaraSerlvler2")
public class SampleDaraSerlvler2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public SampleDaraSerlvler2() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/json;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		//numberOfRow: 10.
		//pageNo: 2,
		//startDate: '20211001',
		//endDate: '20211010'

		String nor = request.getParameter("nembberOfRow");
		String pn = request.getParameter("pageNo");
		String sd = request.getParameter("startDate");
		String ed = request.getParameter("endDate");

		String hostUrl = "https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=284&returnType=json&serviceKey=jBPKGLe%2B%2F9fbrsxQAkxSuwaxM22BiO8H6XKMZJJnvLHdoi%2FOwLFrsR5YB0w9oufX0ku2N9LgFluqwTyr%2FZhnRA%3D%3D";
//		hostUrl +="&pageNo=" + pn;
//		hostUrl +="&numOfRows=" + nor;
//		hostUrl +="&startCreateDt=" + sd;
//		hostUrl +="&endCreateDt=" + ed;


		

		URL url = new URL(hostUrl);
		HttpURLConnection urlconn = (HttpURLConnection) url.openConnection();
		urlconn.setRequestMethod("GET");
		BufferedReader br = new BufferedReader(new InputStreamReader(urlconn.getInputStream(), "UTF-8"));
		String result = "", line = "";
		while ((line = br.readLine()) != null) {
			result += line;
		}
		response.getWriter().println(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
