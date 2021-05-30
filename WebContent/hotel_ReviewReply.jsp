
<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<%@ page import="java.sql.*" %>
<%@ page import="java.net.URLEncoder" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">  

<title>댓글작성</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<style type="text/css"></style>

<script type="text/javascript">
   
    var gnum;
  	  
  	function r_delete(Rdata,rnum){
  	   document.reply.action="hotel_ReviewReplyDelete.jsp?rcode="+Rdata+"&rnum="+rnum;
		   document.reply.method="post";
		   document.reply.submit();
		   }
  	
	  function r_edit(rname,rcontent, rnum){
	    gnum=rnum;
	    reply.r_save.value ="수정";
	    reply.r_name.value =rname;
	    reply.r_content.value=rcontent;
		  
	   }
  
	  function sub(Rdata){
		  var r = reply.r_save.value;
		  var rname =reply.r_name.value;
		  var rcontent =reply.r_content.value;
		  
		  if(r == "저장"){
			  document.reply.action= "hotel_ReviewReplyInsert.jsp?rname="+ encodeURI(rname)+"&rcontent="+encodeURI(rcontent)+"&rcode="+Rdata;
			  document.reply.method="post";
			  document.reply.submit();
			  return false;
			 }else if(r== "수정"){
			  reply.r_save.value = "저장";
			  document.reply.action="hotel_ReviewReplyEdit.jsp?rname="+encodeURI(rname)+"&rcontent="+encodeURI(rcontent)+"&rcode="+Rdata+"&rnum="+gnum;
			  document.reply.method="post";
			  document.reply.submit();
			  return false;
		  } 
    }	   	
</script>
</head>
<body>



<p><p>

 <%!
Connection CN;
Statement ST;
PreparedStatement PST;
ResultSet RS;

String msg;



String Rname, Rcontent, Rdata ;
int Rcode,Rrn, Rnum;
java.util.Date Rdate; 

%>

<%
try{
   Class.forName("oracle.jdbc.driver.OracleDriver");
   //System.out.println("REPLY 오라클 연결 성공");
   String url="jdbc:oracle:thin:@127.0.0.1:1521:XE";
   CN =DriverManager.getConnection(url,"system", "1234"); 
 }catch(Exception e){System.out.println("에러" + e);}


%>

<% 
String Rdata = request.getParameter("Gidx");
//System.out.println(Rdata+ "reply 나오는지 확인");
%>


<p><p>
 <div class="container" align="center"> 
   <table width=800px>

<%
try{
	  msg= "select rownum rn, h.code, r.rnum, r.rname, r.rcontent, r.rdate from h_review h inner join h_reviewr r on h.code=r.rcode and r.rcode= "+Rdata ; 
	  ST=CN.createStatement();
	  RS = ST.executeQuery(msg);
	  //System.out.println(msg);
	  while(RS.next()==true){
		Rrn =RS.getInt("rn");
		Rcode =RS.getInt("code");
		Rnum =RS.getInt("rnum");
		Rname =RS.getString("rname");
		Rcontent =RS.getString("rcontent");
	  Rdate =RS.getDate("rdate");
%> 
		
		<tr style="border: 1px solid; padding: 5px; border-color:#f8f9fa;">
      <td align="center" width="60px"><div class="box1" style="background:#e9ecef; text-align:center;"><%=Rrn%></div></td>
      <td width=400px><%=Rname%></td>
      <td width=1000px><%=Rcontent%></td>
      <td width=200px align="right"><%=Rdate%></td>
      <td width=600px align="right">
       <input type="button" class='bt' onclick="r_edit('<%=Rname%>','<%=Rcontent%>','<%=Rnum%>')" value="수정" style="background-color: white; color : #707270;">
       <input type="button" class='bt' onclick="r_delete('<%=Rcode%>','<%=Rnum%>')" value="삭제" style="background-color: white; color : #707270;">
      </td>
     </tr>
       
<%
}
}catch(Exception ex){System.out.println("reply에러" + ex);}

%>
 
   </table>
	</div>
	<p><p><p>
	
	
<form name="reply">
  <div class="container" align="center">  
     <table >
      <tr>
       <td><input type="hidden" name="Gidx" value="<%=Rdata%>"></td>
       <td><input type="text" placeholder="이름을 입력해주세요." name="r_name" id="rname"></td>
       <td><input type="text" placeholder="내용을 입력해주세요." name="r_content" id="rcontent"></td>
           
       <td rowspan=2 >
		    <input type="button" name="r_save" value="저장" id="rsave" onclick="sub('<%=Rdata%>');" style="background-color: white; color : #707270;" >
		   </td>
      </tr>
     </table>
 </div> 
</form>
    <p><p><p>


</body>
</html>       













