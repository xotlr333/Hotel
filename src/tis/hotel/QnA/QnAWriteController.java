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





@WebServlet("/QnAWrite.do")
public class QnAWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); 
		request.setCharacterEncoding("UTF-8");  //108������ ���ڵ� �ٸ�������� ���
		String Gtitle = request.getParameter("title");
		String Gname = request.getParameter("name");
		int Gpassword = Integer.parseInt(request.getParameter("password"));
		String Gcontent = request.getParameter("content");
		System.out.println(Gtitle + " " + Gname + " " + Gpassword +" " +Gcontent); //�ܼ� �������ι��
		
		QnASQL  qs = new QnASQL();
		qs.dbInsert(Gtitle, Gname, Gpassword, Gcontent);
		response.sendRedirect("QnAList.do");
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

}
