<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
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
    
<form method="post" action="solutionwrite.do">
	<table style="margin-left: auto; margin-right: auto;">
		<tr align="center"> <td colspan="5" align="center">
   	 	<font style="font-size:24pt;"> ${ dto.name }님의 문의내역 </font> </td></tr>
   	 	
   		<tr>	
   		<td><textarea cols="100" rows="15" name="content" id="content"  readonly> ${ dto.content }</textarea>
   		    <input type="hidden" name="hit" value="${dto.hit}">
   		</td>
   		</tr>
   	 	
   	 	<tr align="center"> <td colspan="5" align="center">
   	 	<font style="font-size:24pt;">답변</font> </td></tr>
   	 	
   	 	<tr>	
   		<td><textarea cols="100" rows="15" name="solution" id="solution">${ dto.solution }</textarea></td>
   		</tr>
   	 	
   	 	<tr><td>
   	 	<input type="submit" value="저장">
   	 	<input type="button" value="돌아가기"onclick="location='QnAList.do'">
   	 	</td></tr>
   	 	
   	</table>

</form>
</body>
</html>