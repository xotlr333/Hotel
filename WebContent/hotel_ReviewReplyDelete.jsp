<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>댓글 삭제</title></head>
<body>



  <%!
Connection CN;
Statement ST;
PreparedStatement PST;
ResultSet RS;

String msg;
int Dcode, Dnum;
%>

<%
try{
   Class.forName("oracle.jdbc.driver.OracleDriver");
   //System.out.println("REPLY 삭제 오라클 연결 성공");
   String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
   CN =DriverManager.getConnection(url,"system", "1234"); 
 }catch(Exception e){System.out.println("삭제 에러" + e);}


%>


<body>
 <%
  Dcode=Integer.parseInt(request.getParameter("rcode"));
  //System.out.println(Dcode);
  Dnum=Integer.parseInt(request.getParameter("rnum"));
  //System.out.println(Dnum);
  msg="delete from h_reviewr where rnum="+Dnum;
  ST=CN.createStatement();
  ST.executeUpdate(msg);
 response.sendRedirect("reviewDetailR.do?idx="+Dcode);
 %>
  
</body>
</html>


















