<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>댓글 수정</title></head>
<body>



  <%!
Connection CN;
Statement ST;
PreparedStatement PST;
ResultSet RS;

String msg;
int code, rnum;

%>

<%
try{
   Class.forName("oracle.jdbc.driver.OracleDriver");
   //System.out.println("댓글 수정 오라클 연결 성공");
   String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
   CN =DriverManager.getConnection(url,"system", "1234"); 
 }catch(Exception e){System.out.println("댓글 수정 에러" + e);}


%>




 <%
  code=Integer.parseInt(request.getParameter("rcode"));
  rnum=Integer.parseInt(request.getParameter("rnum"));
  String rname=request.getParameter("rname");
  String rcontent=request.getParameter("rcontent");
  
  //System.out.println("rnum:"+rnum);
  msg="update h_reviewr set rname=?, rcontent=?, rdate=sysdate where rnum=?";
  
  //System.out.println(msg + "댓글 수정 확인");
  
  PST=CN.prepareStatement(msg);
  PST.setString(1, rname);
  PST.setString(2, rcontent);
  PST.setInt(3, rnum);
  PST.executeUpdate();
  
  //System.out.println("댓글수정 성공했습니다");
  response.sendRedirect("reviewDetailR.do?idx="+code);
 %>
</body>
</html>






















