<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table tr td{padding: 25px;}
	img{  border-radius: 20px;}
	.title{ font-size: 25pt; font-weight: bold; width: 800px; margin-right: auto; margin-left: auto;}
</style>
</head>
<body>

	<div>
		<jsp:include page="Hotel_top.jsp" flush="false" /> 
    </div>

	<div class="title">Room List</div><br>
    <table align="center">
    <tr>
    <c:forEach var="room" items="${roomlist}">
    	
    		<td>
	    		<a href="HotelRoomListDetail.do?idx=${room.number}"><img alt="" src="images/${room.img}"></a> <br>
	    		<font style="font-size:18pt; font-weight: bold; font-family: cursive; margin-left: 15px;">${room.number}호</font> <br>
	    		<font style="font-size:16pt; font-family: cursive; margin-left: 15px;">${room.name}</font>
    		</td>
    <c:if test="${room.rn%2==0}"></tr><tr></c:if>
    	
    </c:forEach>
    </table>
</body>
</html>