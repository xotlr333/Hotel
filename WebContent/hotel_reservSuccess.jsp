<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script type="text/javascript" src="js/jquery.modal.js"></script>
<link href="js/jquery.modal.css" type="text/css" rel="stylesheet" />

<script>
$(document).ready(function(){
	$('#btn_back').on('click', function(){
		$('#form').attr({action:'./hotel_reservDate.jsp', method:'get'}).submit();
	});
		
	$('#btn_next').on('click', function(){
		$('#form').attr({action:'./ReservUserInform.do'}).submit();
	});
	

	setTimeout(function() {
			my_fun();
		}, 10000);
	
	
});
// reserve(tel,name,res_num)와 res_infor(res_num, roomSel, chk_in, chk_out, pwd)
</script>

<style>

.main {
	background: white;
}

.content {	
	width: 700px;
	height: auto; min-height: 540px;
	margin: 0 auto;
}

.lineMap {
	height: 20px;
	display: table;
	color: #000000;
	font-size: 16px;
	vertical-align: middle;
}

#topLine {
	float: right;
	height: 3px;
	background-color: #D8D8D8;
	width: 100%;
}

.subtitle {
	font-size: 40px;
	font-weight: normal;
}

.info_wrap {
	width: 900px;
	margin: auto;	
}

.information {
	height: 560px;
}

.revInfo {
	width: 50%;
    float: left;
    padding: 12px;
}

.revInfo span {
	font-size: 18px;
	font-weight: bold;
}

.payment {
	width: 50%;
    float: left;
    padding: 12px;
}

.payment span {
	font-size: 18px;
	font-weight: bold;
}

td {
	height: 30px;
}

tr td:first-child {
	width: 100px;
	font-size: 15px;
	font-weight: bold;
	
}

a {
	text-decoration:none;
	color: #000000;	
}

ul {
   list-style: none;
   padding-left: 0px;
}

input[type=number] {
	width: 70px;
	height: 25px;
	
}

.price_policy_area {
	margin-top: 30px;
	font-size: 12px;
}

.price_policy_area p strong {
	font-size: 14px;
}

.card {
	width: 100%;
	height: 25px;
}

.use_term {
	width: 150px;
	height: 25px;
}

textarea {
	width: 100%;
	height: 70px;
	resize: none;
}

.btn_wrap {
	display: table;
	width: 100%;
	height: 80px;
}

.btn_set {
	width: 150px;
	height: 50px;
}

.btn_left {
	float: left;
}

.btn_right {
	float: right;
}

.roompick {
border-bottom : 1px solid black; border-top : 1px solid black; border-left : 1px solid black; border-right : 1px solid black; width : 30px; height : 30px;
}

</style>
<title>예약 성공</title>
</head>

	<div>
		<jsp:include page="Hotel_top.jsp" flush="false" /> 
    </div>

<body onload="setTime()">
	<!-- main -->
	<div class="main">
		<div class="content">

			<div class="lineMap">
				<span>홈	</span>
				<span>&nbsp;&nbsp;>&nbsp;&nbsp;예약하기[날짜/객실]</span>
				<span>&nbsp;&nbsp;>&nbsp;&nbsp;정보 입력</span>
				<span>&nbsp;&nbsp;>&nbsp;&nbsp;예약 완료</span>
			</div>
			<hr id="topLine" />
			<div class="info_wrap">                   
				<div class="information">
					<div class="revInfo">
						<span>Hotel</span><br/>
						<span></span><br/><br/>
						<form id="form">
						<table>
							<tr>
								<td>체크인</td>
								<td>:  ${checkin }</td>
							<tr>
							<tr>	
								<td>체크아웃</td>
								<td>: ${checkout}</td>
							<tr>
								<td>객실</td>
								<td>:${roomsel}</td>
							</tr>
							<tr>
								<td>전화번호</td>
								<td>: ${tel}</td>
							</tr>
							<tr>
								<td>이름</td>
								<td>: ${name}</td>
							</tr>
							<tr>
								<td>예약 비밀번호</td>
								<td>: ${pwd}</td>							
							</tr>
							<tr>
								<td><input type="button" onclick="location='Hotel_home.jsp'" value="확인"></td>
							</tr>
						</table>
						</form>
						<br>					
					</div>					
				</div>
							
			</div>
		</div> <!-- content -->
	</div> <!-- main -->
	
</body>
</html>