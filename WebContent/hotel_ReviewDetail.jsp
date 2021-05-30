<%@ page language="java" contentType="text/html; charset=UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
   
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<title>후기</title>

<style>

input,button {border: 1px solid ;
		   padding: 6px;
       border-radius:6px;
       border-color:#f1f3f5;}    
</style>

</head>

<body>

	<div>
		<jsp:include page="Hotel_top.jsp"/> 
    </div>


<p><p>
	

<form name="d_form" action="" >
 <div class="container" align="center">
     <table width=860px >  
       <tr align="right">
        <td colspan="4">
         <a href="reviewList.do#tabs-1"><input type="button" value="목록" style="background-color:white ; color : #3c3c8c; width:100px; height:38px;"></a>
         <a href="Hotel_home.jsp"><input type="button" value="홈" style="background-color:white ; color : #3c3c8c; width:100px; height:38px;"></a>
        </td>
       </tr>
     </table>
  
     <p>
     <hr width="860px" align="center" >
      
    <div>
     <table>
      <tr>
        <td><b>${dto.title}</b></td>
        <td align="center">${dto.name}</td> 
        <td align="center"> ${dto.wdate}</td>
        <td align="right">
          <a href="hotel_ReviewEditLogin.jsp?idx=${dto.code}"> <button type="button" style=" background-color: white; color : #707270; border-radius:6px;">수정</button></a>
          <a href="hotel_ReviewDeleteLogin.jsp?idx=${dto.code}"><button type="button" style=" background-color: white; color : #707270; border-radius:6px;">삭제</button></a>
        </td> 
      </tr> 
      
      <tr>
        <td colspan="4"><hr width="850px" align="center"></td>   
      </tr>
       
      <tr>
	      <td colspan="1" ><img src="${path}/${dto.wimg}" width="250" height="200" style="border-radius: 7px"></td>
	      <td colspan="3">${dto.content}</td>     
	    </tr>
     </table>
          
    <hr width="860px" align="center"><p>   
  
    </div>    
      
 </div>  
 </form>
 
 <div>
  <jsp:include page="hotel_ReviewLike.jsp">
  	<jsp:param  name="Gidx" value="${dto.code}"/>
  </jsp:include>   
 </div>
 
<p><p>
 <div>
  <jsp:include page="hotel_ReviewReply.jsp">
 	 <jsp:param  name="Gidx" value="${dto.code}"/>
  </jsp:include>       
 </div>

</body>
</html>       













