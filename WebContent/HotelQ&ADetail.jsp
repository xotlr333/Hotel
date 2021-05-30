<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
input[type=text], select {
 width: 100%;  padding: 12px 20px; margin: 8px 0; display: inline-block; 
 border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box;}

input[type=password] {
width: 100%;  padding: 12px 20px; margin: 8px 0; display: inline-block; 
border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box;}

textarea {
width: 100%;  padding: 12px 20px; margin: 8px 0; display: inline-block; 
border: 1px solid #ccc; border-radius: 4px; box-sizing: border-box;}

input[type=reset] { 
width: 20%; background-color: #151515; color: white; padding: 14px 20px; 
margin: 8px 0; border: none; border-radius: 4px; cursor: pointer; }

input[type=button] { 
width: 20%; background-color: #151515; color: white; padding: 14px 20px; 
margin: 8px 0; border: none; border-radius: 4px; cursor: pointer; }

input[type=submit] { 
width: 20%; background-color: #151515; color: white; padding: 14px 20px; 
margin: 8px 0; border: none; border-radius: 4px; cursor: pointer; }



</style>
</head>
<body>
<body> 

	<div>
		<jsp:include page="Hotel_top.jsp" flush="false" /> 
    </div>

   	<form method="post" action="QnAEdit.do">
		<table style="margin-left: auto; margin-right: auto;">
				<tr align="center">
   	 <td colspan="5" align="center">
   	 	<font style="font-size:24pt;color:blue"> ${dto.name}님의 문의내역 </font> 
   	  </td>
   </tr>
				<tr>
				<td><input type="text"  size=134 name="title" id="title" value="${ dto.title }" readonly></td>
				</tr>
				
				<tr>
				<td>
				<input type="text" size=64 name="name" id="name" value="${ dto.name }" readonly>
				<input type="password" size=64 name="password" id="password" value="${ dto.password }" readonly><br>
				</td>
				</tr>
				
				<tr>
				<td bgcolor="lightgrey">
				Q&A 유의사항 <br>
				1. 이름과 비밀번호는 필수 입력사항 <br>
				2. 최대한 실명으로 입력 <br>
				3. 비밀번호는 숫자만 이용하여 8자리까지 입력<br>
				</td>
				</tr>
				
				<tr>
				<td><textarea cols="100" rows="15" name="content" id="content"  readonly> ${dto.content}</textarea></td>
				</tr>
				
				
				
				<tr>
				<td>
				<input type="button" value="목록으로" onclick="location='QnAList.do'">
				<input type="button" value="문의수정" onclick="location='HotelQ&AEditLogin.jsp?idx=${dto.hit}'">
				<input type="button" value="문의답변 보러가기" onclick="location='solutionview.do?idx=${dto.hit}'">
				<input type="button" value="삭제" onclick="location='HotelQ&ADeleteLogin.jsp?idx=${dto.hit}'">
				</td>
				</tr>
				
		</table>
				
	</form>
   	
</body>
</html>