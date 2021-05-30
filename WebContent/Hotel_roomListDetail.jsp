<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script></head>


<style type="text/css">
	.title{ font-size: 25pt;}
	.content{ font-size: 20pt;}
	table tr td{padding: 25px; border-bottom: 1px solid #444444;}
	table{    border-top: 1px solid #444444;  border-collapse: collapse; }
	.noborder{border-bottom: 0px;}
	
</style>

</head>
<body>

	<div>
		<jsp:include page="Hotel_top.jsp" flush="false" /> 
    </div>
    
   

    <table align="center" width="500">
    	<tr>
    		<td><div class="title">${roomDetail.number}호 ${roomDetail.name}</div></td>
    	</tr>
    	<tr>
    		<td align="center">
    			<img alt="" src="images/${roomDetail.img}" width="800"> <br><br>
    			<div class="content">${roomDetail.content}</div>
    		</td>
    	</tr>
    	<tr>
    		<td align="center">
    			<font style="font-size: 20pt;"><전망></font> <br><br>
    			<font style="font-size: 15pt;">${roomDetail.view}</font>
    		</td>
    	</tr>
    	<tr>
    		<td align="center">
    			<font style="font-size: 20pt;"><방 면적></font> <br><br>
    			<font style="font-size: 15pt;">${roomDetail.area}</font>
    		</td>
    	</tr>
    	<tr>
    		<td align="right" class="noborder">
    			<input type="button" class="btn btn-dark" onclick="location.href='HotelRoomList.do'" value="목록">
    		</td>
    	</tr>
    </table>
</body>
</html>