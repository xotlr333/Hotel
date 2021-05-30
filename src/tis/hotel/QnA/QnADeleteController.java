package tis.hotel.QnA;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tis.hotel.HotelReviewDTO;



@WebServlet("/Q&Adelete.do")
public class QnADeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); 
		request.setCharacterEncoding("UTF-8");  
		PrintWriter  out  = response.getWriter(); 
		
		int data = Integer.parseInt(request.getParameter("code"));
		String id = request.getParameter("name");
		int pwd = Integer.parseInt(request.getParameter("pwd"));
		
		QnASQL qs = new QnASQL();
		QnADTO dtoc = qs.dbConfirm(data);
		String idc = dtoc.getName();
		int pwdc = dtoc.getPassword();
		
	   if(id.equals(idc)&&pwd==pwdc) 
    	{ qs.dbDelete(data);
	    response.sendRedirect("QnAList.do");
    }else{
		String msg="ȸ�� ������ ��ġ���� �ʾ� ������ �� �����ϴ�." ;
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
