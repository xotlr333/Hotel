package tis.hotel.QnA;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/QnAEdit.do")
public class QnAEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); 
		request.setCharacterEncoding("UTF-8");  //108페이지 인코딩 다른방식으로 기술
		PrintWriter  out  = response.getWriter(); 
		
		System.out.println("QnAEditController.java");
		out.println("QnAEditController.java");
		String Gtitle = request.getParameter("title");
		String Gname = request.getParameter("name");
		int Ghit = Integer.parseInt(request.getParameter("hit"));
		int Gpassword = Integer.parseInt( request.getParameter("password"));  
		
		String Gcontent = request.getParameter("content");
		
		System.out.println(Gtitle + " " + Gname + " " + Gpassword +" " +Gcontent ); 		
		
    //순수자바문서 GuestSQL.java접근 dbEdit함수호출		
		QnASQL  qs = new QnASQL();
		QnADTO dto = new QnADTO();
		dto.setTitle(Gtitle);
		dto.setName(Gname);
		dto.setHit(Ghit);
		dto.setContent(Gcontent);
		qs.dbEdit(dto); //순수자바SQL문장처리=비지니스처리단 ==>스프링은 sql문장을 xml문서
		response.sendRedirect("QnAList.do");
	}//end

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}//end

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}//end

}//class END================================================================================================================