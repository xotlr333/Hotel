<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page import="java.io.File"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title> 좋아요 저장</title></head>
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
   // System.out.println("Like INSERT 오라클 연결 성공");
   String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
   CN =DriverManager.getConnection(url,"system", "1234"); 
 }catch(Exception e){System.out.println("likes insert 에러" + e);}


%>

<%
  int code=Integer.parseInt(request.getParameter("code"));
  // System.out.println(code + " insert rcode 나오는지 확인");
 
  msg="update h_review set likes= likes+1, hits= hits-1 where code= " +code;
  ST=CN.createStatement();
  ST.executeUpdate(msg);
//System.out.println("좋아요 성공했습니다");
response.sendRedirect("reviewDetail.do?idx="+code);
%>
 
</body>
</html>






















