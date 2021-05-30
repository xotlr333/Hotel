<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>좋아요</title>

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


 <script type="text/javascript">
	  function insertlikes(rdata){
				document.reply.action="hotel_ReviewLikeInsert.jsp?&code="+rdata;
			  document.reply.method="post";
			  document.reply.submit();
    }
 </script>

</head>
<body>

    
 <%!
Connection CN;
Statement ST;
PreparedStatement PST;
ResultSet RS;
String msg;

String Rdata;
int lnum;
%>


<%
try{
   Class.forName("oracle.jdbc.driver.OracleDriver");
  // System.out.println("REPLY 오라클 연결 성공");
   String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
   CN =DriverManager.getConnection(url,"system", "1234"); 
 }catch(Exception e){System.out.println("연결 에러" + e);}

%>
<% 
  Rdata=request.getParameter("Gidx"); 
  //System.out.println(Rdata+ "reply 나오는지 확인");
%>
 
<%
 try{
	  msg= "select likes from h_review where code="+Rdata ; 
    ST=CN.createStatement();
    RS = ST.executeQuery(msg);
    if(RS.next()==true){lnum = RS.getInt("likes");}
  }catch(Exception e){System.out.println("좋아요 에러 :" +e);}
    
%> 
     
 <p>
 <div align="center">
   <button type="button"  onclick="insertlikes('<%=Rdata%>');" style="border: 1px solid #3c3c8c ; padding: 6px; border-radius:6px; height:35px; width:100px; background-color:white ; color: #3c3c8c;">좋아요&nbsp;&nbsp;<%=lnum%></button>
 </div> 
        
</body>
</html>       




