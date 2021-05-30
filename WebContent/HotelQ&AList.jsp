<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
a{
text-decoration:none;
}

input[type=button] { 
width: 30%; background-color: #151515; color: white; padding: 14px 20px; 
margin: 8px 0; border: none; border-radius: 4px; cursor: pointer; }

input[type=submit] { 
width: 10%; background-color: #151515; color: white; padding: 3px 10px; 
margin: 8px 0; border: none; border-radius: 4px; cursor: pointer; }

.table {
      border-collapse: collapse;
      width: 1200px !important;      
    }  
    
    .table th {
      color: #168;
      background: #f0f6f9;
      text-align: center;
    }
    
    .table th, .table td {
      padding: 10px;
      
    }
    
    .table th:first-child, .table td:first-child {
      border-left: 0;
    }
    
    .table th:last-child, .table td:last-child {
      border-right: 0;
    }
    
    .table tr td:first-child{
      text-align: center;
    }
    
    .table caption{caption-side: bottom; display: none;}


</style>
</head>
<body>

	<div>
		<jsp:include page="Hotel_top.jsp" flush="false" /> 
    </div>


		<table border=1  cellspacing=0 align="center" class="table">
		<tr align="center">
   	 <td colspan="5" align="center">
   	 	<font style="font-size:24pt;"> 1:1 문의내역 </font> 
   	  </td>
   </tr>
		<tr>
		<th>번호</th> <th>이름</th> <th>제목</th> <th>작성일</th> <th>답변하기</th>
		</tr>
		
	<c:forEach var="hotel" items="${QnA}">
  		<tr align="center">
    		<td> ${hotel.rn} </td>
    		<td> ${hotel.name} </td>
    		<td> <a href="QnADetail.do?idx=${hotel.hit}"> ${hotel.title} </a> </td>
    		<td> ${hotel.wdate} </td>    
    		<td> <input type="button" value="답변" onclick="location='solution.do?idx=${hotel.hit}'">  </td>
    		
  </tr> 
	</c:forEach>
		<tr align="center">
    <td colspan="7">
      <!-- 이전  1적용안됨 11 21 31-->
      <c:if test="${startpage>10}">
      	<a href="QnAList.do?pageNum=${startpage-10}">[Pre]</a>
      </c:if>
    
      <c:forEach var="i" begin="${startpage}" end="${endpage}" step="1">
 		<c:choose>
 			<c:when test="${i==pageNUM}"><font style="font-size:20pt; color:red">[${i}]</font></c:when>
 			<c:otherwise><a href="QnAList.do?pageNum=${i}${returnpage}"> [${i}] </a></c:otherwise>
 		</c:choose>
      </c:forEach>
      
      <!-- 다음  10 20 30 40적용안됨-->
      <c:if test="${endpage<pagecount}">
       <a href="QnAList.do?pageNum=${startpage+10}${returnpage}">[Next]</a>
      </c:if>
    </td>
  </tr>
  
  <tr align="center">
    <td colspan="7">
    	 <form  name="myform" action="QnAList.do">
            검색:
       <select name="keyfield" onchange="myclear()">
         <option  value="name"  <c:if test="${skey eq 'name'}">selected</c:if> >이름</option>
         <option  value="title"  <c:if test="${skey eq 'title'}">selected</c:if>  >제목</option>  
         <option  value="title" <c:if test="${display eq ' '}">selected</c:if>>---선택하세요---</option>
       </select> 

       <input type="text"  name="keyword" value="${sval}" size="10">
       
       <input type="submit" value="검색">
     </form>   
     <input type="button" value="문의하기" onclick="location='HotelQ&AWrite.jsp'">
    </td>
    
  </tr>
		
		</table>
	
</body>
</html>