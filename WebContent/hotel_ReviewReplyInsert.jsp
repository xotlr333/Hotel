<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="java.net.URLDecoder" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">  
<title> 후기 댓글 저장</title>
</head>


<body>

<%!
Connection CN;
Statement ST;
PreparedStatement PST;
ResultSet RS;

String msg;
%>

<%
try{
   Class.forName("oracle.jdbc.driver.OracleDriver");
   //System.out.println("INSERT 오라클 연결 성공");
   String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
   CN =DriverManager.getConnection(url,"system", "1234"); 
  }catch(Exception e){System.out.println("에러" + e);}


%>

<%
 String rname =request.getParameter("rname");
 String rcontent =request.getParameter("rcontent");
 

  //System.out.println("rname :" + rname);
 //System.out.println("rcontent :" + rcontent);
  
  
  int rcode=Integer.parseInt(request.getParameter("rcode"));
 // System.out.println(rcode + " insert rcode 나오는지 확인");
  msg="insert into h_reviewr values(hr_seq.nextval,?,?,?,sysdate)" ;
  //System.out.println("INSERT msg:" +msg);
  PST=CN.prepareStatement(msg);
  PST.setString(1, rname);
  PST.setString(2, rcontent);
  PST.setInt(3, rcode);
  


PST.executeUpdate();

//System.out.println("댓글저장 성공했습니다");
response.sendRedirect("reviewDetailR.do?idx="+rcode);
%>
 
 
 
 

</body>
</html>






















