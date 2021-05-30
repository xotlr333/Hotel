<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script type="text/javascript">
function checkNull(){
   var a = document.writeform.title.value;
   var b = document.writeform.name.value;
   var c = document.writeform.password.value;
   var d = document.writeform.content.value;
   if(a==""||a==null){
	   alert("제목누락");
	   writeform.title.focus();
	   return false;
   }else{writeform.name.focus();}
   
   if(b==""||b==null){
	   alert("이름누락");
	   writeform.name.focus();
	   return false;
   }else{writeform.password.focus();}
   
   if(c==""||c==null){
	   alert("비밀번호누락");
	   writeform.password.focus();
	   return false;
   }else{writeform.content.focus();}
   
   if(d==""||d==null){
	   alert("내용누락");
	   writeform.content.focus();
	   return false;
   }
    }
</script>
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
    
<br>
	<form method="post" action="QnAWrite.do" name="writeform">
		<table style="margin-left: auto; margin-right: auto;">
				
				<tr>
				<td><input type="text"  size=134 placeholder="제목을 입력하세요" name="title" id="title" ></td>
				</tr>
				
				<tr>
				<td>
				<input type="text" size=64 placeholder="이름" name="name" id="name">
				<input type="password" size=64 placeholder="비밀번호" name="password" id="password">
				
				</td>
				</tr>
				
				<tr>
				<td bgcolor="lightgrey">
				Q&A 유의사항 <br>
				1. 이름과 비밀번호는 필수 입력사항 <br>
				2. 비밀번호는 숫자로만 입력 <br>
				3. 저장 누르기전 누락확인 필수<br> 
				
				</td>
				</tr>
				
				<tr>
				<td><textarea cols="100" rows="30" name="content" id="content"></textarea></td>
				</tr>		
				
				<tr>
				<td>
				<input type="button" value="누락확인" onClick="checkNull()">
				<input type="submit" value="저장">
				<input type="reset" value="취소" onclick="history.back()">
				</td>
				</tr>
				
		</table>
				
	</form>
</body>
</html>