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
width: 40%; background-color: #151515; color: white; padding: 14px 20px; 
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
   	 	<td colspan="6" align="center">
   	 		<font style="font-size:24pt;"> 예약확인 </font> 
   	 	</td>
   		</tr>
		<tr>
		<th>번호</th> <th>이름</th> <th>객실</th> <th>Check In</th> <th>Check Out</th> <th>예약취소</th>
		</tr>
		
	<c:forEach var="dto" items="${reslist}">
  		<tr align="center">
    		<td> ${dto.rn} </td>
    		<td> ${dto.name} </td>
    		<td> ${dto.room} </td>
    		<td> ${dto.checkIn} </td>
    		<td> ${dto.checkOut} </td>
    		<td> <input type="button" value="예약취소" onclick="location='HotelResDeleteLogin.jsp?idx=${dto.code}'">  </td>
    		
    		
  </tr> 
	</c:forEach>
		<tr align="center">
    <td colspan="7">
      <!-- 이전  1적용안됨 11 21 31-->
      <c:if test="${startpage>10}">
      	<a href="HotelResList.do?pageNum=${startpage-10}">[Pre]</a>
      </c:if>
    
      <c:forEach var="i" begin="${startpage}" end="${endpage}" step="1">
 		<c:choose>
 			<c:when test="${i==pageNUM}"><font style="font-size:20pt; color:red">[${i}]</font></c:when>
 			<c:otherwise><a href="HotelResList.do?pageNum=${i}${returnpage}"> [${i}] </a></c:otherwise>
 		</c:choose>
      </c:forEach>
      
      <!-- 다음  10 20 30 40적용안됨-->
      <c:if test="${endpage<pagecount}">
       <a href="HotelResList.do?pageNum=${startpage+10}${returnpage}">[Next]</a>
      </c:if>
    </td>
  </tr>
  
  <tr align="center">
    <td colspan="7">
    	 <form  name="myform" action="HotelResList.do">
            검색:
       <select name="keyfield" onchange="myclear()">
         <option  value="name"  <c:if test="${skey eq 'name'}">selected</c:if> >이름</option>
         <option  value="checkIn"  <c:if test="${skey eq 'checkIn'}">selected</c:if>  >Check In</option> 
         <option  value="checkout"  <c:if test="${skey eq 'checkOut'}">selected</c:if>  >Check Out</option> 
         <option  value="name" <c:if test="${display eq ' '}">selected</c:if>>---선택하세요---</option>
       </select> 

       <input type="text"  name="keyword" value="${sval}" size="10">
       
       <input type="submit" value="검색">
     </form>   
    </td>
    
  </tr>
		
		</table>
	
</body>
</html>