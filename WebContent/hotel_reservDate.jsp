<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="/BH_Project/main/css/main.css">
<link rel="stylesheet" type="text/css" href="/BH_Project/main/css/topMenu.css">
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<link href="js/jquery.modal.css" type="text/css" rel="stylesheet" />
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript" src="js/jquery.modal.js"></script>

<script>
$(document).ready(function(){
	var startDate = "";
	var endDate = "";
		
	$("#datepicker").datepicker({
		dateFormat: 'yy/m/dd',
		minDate: new Date(),
		numberOfMonths: [1, 2],
		onSelect: function(dateText, inst) {
			var dateAsString = dateText;
		    if (startDate == "") {//첫 클릭 시
		    	startDate = dateAsString;
		    	$('input[name=checkIn]').val(startDate);
		    	$('input[name=checkOut]').val("");
		    } else {
		    	if (endDate == "") {//두번째 클릭 시
		    		if (new Date(startDate) > new Date(dateAsString)) {
		    			var temp = startDate;
				    	startDate = dateAsString;
				    	$('input[name=checkIn]').val(startDate);
				    	endDate = startDate;
				    	$('input[name=checkOut]').val(temp);
		    		} else if (new Date(startDate) < new Date(dateAsString)) {
		    			//체크아웃이 체크인 보다 앞에 있을 때
		    			endDate = dateAsString;
			    		$('input[name=checkOut]').val(endDate);
		    		}		    		
		    	} else {//체크인 체크아웃이 둘 다 선택되어 있을 시
		    		startDate = dateAsString;
					$('input[name=checkIn]').val(startDate);
					endDate = "";
					$('input[name=checkOut]').val("");
		    	}
			}
		}
	});
	
	$('#button').on('click', function(){
		if ($('input[name=checkIn]').val() == "") {//체크인이 선택 안되어있을 시 오류출력
			f_checkIn();
		} else if ($('input[name=checkOut]').val() == "") {//체크아웃이 선택 안되어있을 시 오류출력
			f_checkOut();
		} else {
			$('#form').submit();//문제가 없을 시 form(다음 페이지로) 
		}
	});
	
	$(function() {//체크인 미선택 오류
		function my_fun(){
			modal({
				type: 'error',
				title: '오류',
				text: '체크아웃을 선택해주십시오.',
				callback: function(result) {
					//확인눌렀을때
				}
			});
		} f_checkOut = my_fun; 
	});
	
	$(function() {//체크아웃 미선택 오류
		function my_fun(){
			modal({
				type: 'error',
				title: '오류',
				text: '체크인을 선택해주십시오.',
				callback: function(result) {
					//확인눌렀을때
				}
			});
		} f_checkIn = my_fun; 
	});
	
	$(function() {//방 미선택 오류
		function my_fun(){
			modal({
				type: 'error',
				title: '오류',
				text: '방을 선택해주시오.',
				callback: function(result) {
					//확인눌렀을때
				}
			});
		} f_roomSel = my_fun; 
	});
});

</script>

<style>

.ui-datepicker {
    height: 300px;
    padding: 0.2em 0.2em 0;
    width: 600px;
    font-size: 17px;
}

.ui-datepicker select.ui-datepicker-year {
	width: 40%;
} 

.subtitle {
	<!-- 맨 위 제목 -->
	font-size: 40px;
	font-weight: normal;
}

.lineMap {
	<!-- 제목 밑 하이퍼텍스트 -->
	height: 20px;
	display: table;
	color: #000000;
	font-size: 16px;
	vertical-align: middle;
}

#topLine {
	<!-- 윗 라인 색갈 -->
	float: right;
	height: 3px;
	background-color: #D8D8D8;
	width: 100%;
}

.reservationBox {
	<!-- 컨텐트 박스 크기 -->
	width: 700px;
	height: 700px;
	padding: 10px 0 10px 0;
	margin: auto;
}

.calendar {
	display: table;
	width: 600px;
	height: 400px;
	margin-left: 20px;
	float: left;
	text-align: center;
}

#datepicker {
	display: table-cell;
	vertical-align: middle;
}

.select {
	display: table;
	width: 260px;
	height: 400px;
	float: none;
	text-align: center;
}

.sel_container{
	display: table-cell;
	vertical-align: middle;
}

.sel_wrap {
	height: 200px;
	text-align: center;
}

.txt_box {
	width: 150px;
	height: 30px;
}


#button {
	width: 150px;
	height: 50px;
}

a {
	text-decoration:none;
	color: #000000;
}

.sel_wrap table th {
	width: 70px;
	height: 50px;
	font-size: 15px;
}

.radiotable tr td{padding: 10px;}

</style>
<title>예약하기[날짜/객실]</title>
</head>
<body>

	<div>
		<jsp:include page="Hotel_top.jsp" flush="false" /> 
    </div>

			

			<div class="lineMap">
				홈페이지	
				<span>&nbsp;&nbsp;>&nbsp;&nbsp;예약[날짜]</span>
			</div>                       
	        
	        <hr id="topLine" />
	        
	        <div class="reservationBox">
	        
			<!-- 오류없이 다음 클릭 시 이동-->
				<form id="form" action="./hotel_reservUserInform.jsp" method="get">
				
			<!-- 날자 선택 -->
					<div class="calendar">
						<div id="datepicker"></div> 
					</div>
    			
					<div class="select">
						<div class="sel_container">
							<div class="sel_wrap">
								<table>
									<tr>
										<th>체크인</th>
										<td><input type="text" class="txt_box" name="checkIn" size="10" readonly="readonly"></td>
									</tr>
									<tr>
										<th>체크아웃</th>
										<td><input type="text" class="txt_box" name="checkOut" size="10" readonly="readonly"></td>
									</tr>
								</table>
							</div>
						</div>
					</div> <!-- select -->
					<!-- 객실 정보 -->
					<table class="radiotable" style = "text-align : center;">
						<tr>
						<td>
							<input type='radio' name='roomSel' value='101호' checked/> 
						</td>
						<td>
							<input type='radio' name='roomSel' value='102호' />
						</td>
						<td>
							<input type='radio' name='roomSel' value='201호' />
						</td>
						<td>
							<input type='radio' name='roomSel' value='202호' /> 
						</td>
						<td>
							<input type='radio' name='roomSel' value='301호' />
						</td>
						<td>
							<input type='radio' name='roomSel' value='302호' />
						</td>
						<td width = "250" rowspan = "3" style="text-align:center;">
							<input type="button" class="button" id="button" value="다음">
						</td>
						</tr>
						<tr>
						<td><img src='images/r_101.PNG' width = "100" height="100"></td>
						<td><img src='images/r_102.PNG' width = "100" height="100"></td>
						<td><img src='images/r_201.PNG' width = "100" height="100"></td>
						<td><img src='images/r_202.PNG' width = "100" height="100"></td>
						<td><img src='images/r_301.PNG' width = "100" height="100"></td>
						<td><img src='images/r_302.PNG' width = "100" height="100"></td>
						</tr>
						<tr>
						<td>101호</td>
						<td>102호</td>
						<td>201호</td>
						<td>202호</td>
						<td>301호</td>
						<td>302호</td>
						
						</tr>
					</table>
				</form>	
			</div> <!-- reservation -->
				
			<hr />

</body>
</html>