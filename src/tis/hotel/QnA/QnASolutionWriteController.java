package tis.hotel.QnA;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/solutionwrite.do")
public class QnASolutionWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8"); 
   		request.setCharacterEncoding("UTF-8");  //108페이지 인코딩 다른방식으로 기술
   		
   		
		String Gsolution = request.getParameter("solution");
		int Ghit = Integer.parseInt(request.getParameter("hit"));
		System.out.println(Gsolution); //콘솔 고전적인방법
		
		QnASQL  qs = new QnASQL();
		qs.dbSolutionInsert(Gsolution, Ghit);
		response.sendRedirect("QnAList.do");
   		
       }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doUser(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doUser(request, response);
	}

}
