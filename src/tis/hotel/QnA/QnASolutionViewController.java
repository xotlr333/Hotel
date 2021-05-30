package tis.hotel.QnA;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/solutionview.do")
public class QnASolutionViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
		public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); 
		request.setCharacterEncoding("UTF-8");  
		PrintWriter out = response.getWriter(); 
		
		int data = Integer.parseInt(request.getParameter("idx"));
		QnASQL qs = new QnASQL();
		QnADTO dto = qs.dbDetail(data);
		request.setAttribute("dto", dto);
		
		RequestDispatcher dis = request.getRequestDispatcher("HotelQ&ASolution.jsp");
		dis.forward(request, response);
	}
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doUser(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doUser(request, response);
	}

}
