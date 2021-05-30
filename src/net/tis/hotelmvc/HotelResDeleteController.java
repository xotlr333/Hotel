package net.tis.hotelmvc;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.tis.hotel.HotelDTO;
import net.tis.hotel.HotelReviewDTO;
import net.tis.hotel.HotelReviewSQL;
import net.tis.hotel.HotelSQL;




@WebServlet("/ResDelete.do")
public class HotelResDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    protected void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		response.setContentType("text/html;charset=UTF-8"); 
  		request.setCharacterEncoding("UTF-8");  
  		PrintWriter  out  = response.getWriter(); 
  		
  		int data = Integer.parseInt(request.getParameter("code"));
  		String id = request.getParameter("name");
  		int pwd = Integer.parseInt(request.getParameter("pwd"));
  		
  		HotelSQL sql = new HotelSQL();
  		HotelDTO dtoc = sql.dbConfirm(data);
  		String idc = dtoc.getName();
  		int pwdc = dtoc.getPwd();
  		
  	   if(id.equals(idc)&&pwd==pwdc) 
      	{ sql.dbDelete(data);
  	    response.sendRedirect("HotelResList.do");
      }else{
  		String msg="ȸ�� ������ ��ġ���� �ʾ� ��������� �� �����ϴ�." ;
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
