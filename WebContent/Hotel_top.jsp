<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<style type="text/css">
.margin{margin-top: 120px;}

.wrapper{width: 1170px; margin:0 auto; font-family: sans-serif;}

.top{height: 120px; background-color: #6E6E6E; border: 1px soild #253342;
       position:fixed; width: 100%; z-index: 9999; top:0; left:0;}
       
h1{color:white; width:90px !important; margin:0 auto !important; margin-top: 20px !important; font-size: 40pt !important; font-weight: 600 !important;  }


.menu1{float:left;}
.menu1 li{line-height: 100px; float:left; list-style: none;}
.menu1 a{line-height: 5px !important;  color:white !important;  padding:0 15px; display: block; text-decoration: none;}
.menu1 a:hover{  text-decoration: underline; }

.menu2{float:right;}
.menu2 li{line-height: 100px; float:left; list-style: none; }
.menu2 a{line-height: 5px;  color:white !important; padding:0 15px; display: block; text-decoration: none;}
.menu2 a:hover{ text-decoration: underline; }

</style>



</head>
<body>
<div class="top">
<div class="wrapper">


	<div>
	<h1>Hotel</h1>
	</div>
<nav>
	<ul class="menu1" >
		<li><a href="hotel_reservDate.jsp">예약하기</a></li>
		<li><a href="HotelResList.do">예약확인</a></li>
		<li><a href="QnAList.do">Q&A</a></li>
		
	</ul>
	
</nav>

<nav>
	<ul class="menu2" >
		<li><a href="Hotel_home.jsp">home</a></li>
		<li><a href="HotelRoomList.do">객실소개</a></li>
		<li><a href="reviewList.do">후기&공지사항</a></li>
		
	</ul>
	
</nav>
</div>

</div>

<div class="margin"><br></div>


</body>
</html>