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
width: 30%; background-color: #151515; color: white; padding: 14px 20px; 
margin: 8px 0; border: none; border-radius: 4px; cursor: pointer; }

input[type=button] { 
width: 30%; background-color: #151515; color: white; padding: 14px 20px; 
margin: 8px 0; border: none; border-radius: 4px; cursor: pointer; }

input[type=submit] { 
width: 30%; background-color: #151515; color: white; padding: 14px 20px; 
margin: 8px 0; border: none; border-radius: 4px; cursor: pointer; }



</style>
</head>
<body>

	<div>
		<jsp:include page="Hotel_top.jsp" flush="false" /> 
    </div>

<form name="editform" action="QnAEdit.do">
		<table style="margin-left: auto; margin-right: auto;">
	<tr align="center">
   	 <td colspan="5" align="center">
   	 	<font style="font-size:24pt;color:blue"> ${dto.name}님의 문의수정 </font> 
   	  </td>
   </tr>
				<tr>
				<td><input type="text"  size=134 placeholder="제목을 입력하세요" name="title" id="title" value="${dto.title}"></td>
				</tr>
				
				<tr>
				<td>
				<input type="text" size=64 placeholder="이름" name="name" id="name" value="${dto.name}" readonly>
				<input type="password" size=64 placeholder="비밀번호" name="password" id="password" value="${dto.password}" readonly><br>
				<input type="hidden" name="hit" value="${dto.hit}">
				</td>
				</tr>
				
				<tr>
				<td bgcolor="lightgrey">
				Q&A 수정시 유의사항 <br>
				1.  제목은 필수 입력사항<br>
				2.  이름과 비밀번호는 변경불가<br>
				
				</td>
				</tr>
				
				<tr>
				<td><textarea cols="100" rows="15" name="content" id="content" > ${dto.content}</textarea></td>
				</tr>		
				
				<tr>
				<td>
				<input type="submit" value="수정완료">
				<input type="reset" value="취소" onclick="history.back()">
				</td>
				</tr>
				
		</table>
				
	</form>
</body>
</html>