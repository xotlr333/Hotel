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


@WebServlet("/QnAPreEdit.do")
public class QnAPreEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
        public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	response.setContentType("text/html;charset=UTF-8"); 
   		request.setCharacterEncoding("UTF-8");  
   		PrintWriter  out  = response.getWriter(); 
   		
   		System.out.println("HotelPreEditController.java");
   		
   		
  		int data = Integer.parseInt(request.getParameter("code"));
  		String id = request.getParameter("name");
  		int pwd = Integer.parseInt(request.getParameter("pwd"));
  		
  		QnASQL qs = new QnASQL();
  		QnADTO dtoc = qs.dbConfirm(data);
  		String idc = dtoc.getName();
  		int pwdc = dtoc.getPassword();
  		QnADTO dto = qs.dbDetail(data);
  		
  	   if(id.equals(idc)&&pwd==pwdc) 
      	{ request.setAttribute("dto", dto);
     			RequestDispatcher dis = request.getRequestDispatcher("HotelQ&AEdit.jsp");
     			dis.forward(request, response);
      }else{
  		String msg="회원 정보가 일치하지 않아 수정할 수 없습니다." ;
  		out.print("<script>");
  		out.print("alert('" +msg + "');");
  		out.print("history.go(-2)");
  		out.print("</script>");}
  		
  	}


       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doUser(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doUser(request, response);
	}

}
