<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.net.URLEncoder" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ReviewNoticeList</title>   

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<style>

input{ 
       border: 2px solid ;
		   padding: 5px;
       border-radius:3px;
       border-color:#f1f3f5;}
     
select{ 
       border: 2px solid ;
		   padding: 5px;
       border-radius:3px;
       border-color:#f1f3f5;}     
     
 
</style>


<script type="text/javascript">
   $(function(){
	    $("#tabs").tabs();
	  } );

   $(function() {
     $( "#accordion" ).accordion({
       collapsible: true,
       heightStyle: "content",
       active : true
     });
   } );
   
</script>






</head>
<body>

	<div>
		<jsp:include page="Hotel_top.jsp" flush="false"/> 
    </div>

  
 <div class="container" align="center">
  <p><p>
    <h4>공지사항 &후기</h4><br>
 
    <div id="tabs">
      <ul>
        <li><a href="#tabs-1">후기</a></li>
        <li><a href="#tabs-2">공지사항</a></li>
      </ul>
       
  
   <div id="tabs-1">              
      <p> 후기 :  ${Stotal}/${Gtotal}건 </p>
     
     <c:forEach var="bean" items="${list}">
     <div style="display:inline-block; margin:13px;" >
       <div><a href="reviewDetail.do?idx=${bean.code}"><img src="${path}/${bean.wimg}" width="250" height="200" style="border-radius: 7px;"></a></div>
        <c:choose>
         <c:when test="${bean.rating eq '1'}">
          <div>★</div>
         </c:when>
         <c:when test="${bean.rating eq '2'}">
          <div>★★</div>
         </c:when>
         <c:when test="${bean.rating eq'3'}">
          <div>★★★</div>
         </c:when>
         <c:when test="${bean.rating eq '4'}">
          <div>★★★★</div>
         </c:when>
         <c:otherwise>
          <div>★★★★★</div>
         </c:otherwise>
        </c:choose>
       
       <div><a href="reviewDetail.do?idx=${bean.code}">${bean.title}</a></div>
        
       <div><img src="./images/hits.png">&nbsp;${bean.hits}&nbsp;<img src="./images/reply.png">&nbsp;${bean.rcnt}&nbsp;<font size="4px">♡</font>&nbsp;${bean.likes}</div>
     </div>
     </c:forEach>   
    
    <table>
     <tr>
      <td>
    
      <%String keyword =(String)request.getAttribute("keyword");
         if(keyword==null || keyword==""){keyword="-";}%>
   
   
       <c:if test="${startpage>10}"><a href="reviewList.do?pageNum=1&keyfield=${keyfield}&keyword=<%=URLEncoder.encode(keyword, "UTF-8")%>#tabs-1">◀</a>
        <a href="reviewList.do?pageNum=${startpage-10}&keyfield=${keyfield}&keyword=<%=URLEncoder.encode(keyword, "UTF-8")%>#tabs-1">◁</a></c:if>
    
       <c:forEach var="i" begin="${startpage}" end="${endpage}">   
      
       <c:choose>
        <c:when test="${i==pageNUM}">
         <a href="reviewList.do?pageNum=${i}&keyfield=${keyfield}&keyword=<%=URLEncoder.encode(keyword, "UTF-8")%>#tabs-1"><b>[${i}]</b></a>
        </c:when>
        <c:otherwise>
         <a href="reviewList.do?pageNum=${i}&keyfield=${keyfield}&keyword=<%=URLEncoder.encode(keyword, "UTF-8")%>#tabs-1">[${i}]</a>
        </c:otherwise>
        </c:choose>
          
       </c:forEach>
    
       <c:if test="${endpage<countpage}"><a href="reviewList.do?pageNum=${startpage+10}&keyfield=${keyfield}&keyword=${keyword}#tabs-1">▷ </a>
       <a href="reviewList.do?pageNum=${countpage}&keyfield=${keyfield}&keyword=${keyword}#tabs-1">▶</a></c:if>
      
      </td>
     </tr>
    </table>
 
     <p><p>
     <div>
      <form name="search" action="reviewList.do">
       <select name="keyfield">
        <option value="">검색필드</option>
        <option value="name" <c:if test="${keyfield eq 'name'}"> selected </c:if>>이름필드</option>
        <option value="title" <c:if test="${keyfield eq 'title'}"> selected </c:if> >제목필드</option>
        <option value="content" <c:if test="${keyfield eq 'content'}"> selected </c:if> >내용필드</option>
       </select> 
            
       <input type="text" name="keyword" value="">
       <input type="submit" value="검색">
      </form>  
     </div>   
       
     <p><p>
      <table width=78% >
		   <tr>
        <td><p style="display:none">hr라인<p></td>
       </tr>
       <tr>
        <td colspan="5" align="right">
         <a href="hotel_ReservationLogin.jsp"><input type="button" value="글쓰기" style="background-color:white ; color : #3c3c8c; width:100px; height:38px;"></a>
         <a href="reviewList.do"><input type="button" value="목록" style="background-color:white ; color : #3c3c8c; width:100px; height:38px;"></a>
        <td>
       </tr>
       <tr>
        <td><p style="display:none">hr라인<p></td>
       </tr>
      </table>
  
    </div>
         
  
   <div id="tabs-2">
  
     <div id="accordion">
       
       <c:forEach var="notice" items="${ndto}"> 
         <h3>${notice.ntitle}</h3>
       <div>
          <div align="right"><p>${notice.ndate}<p></div> 
          <p><img alt="" src="./images/${notice.nimg}"></p>
       </div>
       </c:forEach>
    </div>
   </div>
 
  
  </div>
 
 </div> 

</body>
</html>