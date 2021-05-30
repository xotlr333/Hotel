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




@WebServlet("/QnAList.do")
public class QnAListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void doUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8"); 
		request.setCharacterEncoding("UTF-8");  //108������ ���ڵ� �ٸ�������� ���
		PrintWriter  out  = response.getWriter(); 
		QnASQL qs = new QnASQL();
		int Gtotal = qs.getTotal() ;
		
		String pnum="", skey="", sval="", returnpage="", sqry="" ;
		int pageNUM;
		int start, end, startpage, endpage, pagecount, tmp;
		String display="";
		
		skey=request.getParameter("keyfield"); //skey="�˻��ʵ�"; ~where name like  Ȥ�� ~where title like  Ȥ�� ~where email like    
		sval=request.getParameter("keyword"); //sval="�˻�Ű����"; ~where �˻��ʵ� like '%�˻�Ű����%'  
		if(skey==null || skey=="" || sval=="" || sval==null || skey.equals("") || sval.equals("")) {
			  skey="title";  display=" ";
			  sval=""; 
		}
		
		int GGtotal=qs.getSearchTotal(skey, sval); //2-24-������ �߰�GGtotal���ٴ� Searchtotal����
		//returnpage="guestList.do?pageNum=3&keyfield=name&keyword=b"; //3������ title�ʵ�  p�˻���  ��ȸ
		returnpage="&keyfield="+skey+"&keyword="+sval; //3������ title�ʵ�  p�˻���  ��ȸ
		
		pnum=request.getParameter("pageNum");
		if(pnum=="" || pnum==null){pnum="1"; }
		pageNUM=Integer.parseInt(pnum); //[11]~[17Ŭ��]~[20]Ŭ����ȣ  ������17
		start=(pageNUM-1)*10+1; //161=pageNUM*10-9
		end=(pageNUM*10); //170=start+9
		
		if(GGtotal%10==0){ pagecount=GGtotal/10; }
		else{pagecount=(GGtotal/10)+1; }
		
		tmp=(pageNUM-1)%10;
		startpage=pageNUM-tmp; 
		endpage=startpage+9;
		//�ѷ��ڵ嵥���Ͱ��� 316�� ������������ 32�ε�  [31]~[40]ǥ�ø� [31][32] 
		if(endpage>pagecount) {endpage=pagecount;}
		
		ArrayList<QnADTO> QnA = qs.dbSelectAll(start, end, skey, sval);  //������,����,�����ʵ�,�˻�Ű����
		request.setAttribute("QnA", QnA);
		request.setAttribute("Gtotal", Gtotal);   //��ü����
		request.setAttribute("GGtotal", GGtotal); //��ȸ����
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("pagecount", pagecount);
		
		request.setAttribute("pageNUM", pageNUM); //[7]����7 
		request.setAttribute("skey", skey);
		request.setAttribute("sval", sval);
		request.setAttribute("returnpage", returnpage);
		request.setAttribute("display", display);
		
		RequestDispatcher dis = request.getRequestDispatcher("HotelQ&AList.jsp");
		dis.forward(request, response);
		
		
		
		
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doUser(request, response);
	}

}
