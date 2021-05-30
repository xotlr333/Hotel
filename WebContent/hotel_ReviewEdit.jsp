<%@ page language="java" contentType="text/html; charset=UTF-8"  %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <title>후기 수정</title>

 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
 <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
 <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
 <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>



<style>
.radio{display: inline;}
input{ 
       border: 1px solid ;
		   padding: 6px;
       border-radius:3px;
       border-color:#f1f3f5;}
       
       
textarea{

	  border: 2px solid ;
		padding: 8px;
		filter: alpha(opacity=100);
		opacity: 1;
		border-radius: 5px;
		border-color:  #f1f3f5;
		
		}

button{
      border: 1px solid;
      padding:5px;
      border-radius:4px;
      }


</style>


<script type="text/javascript">
Gflag=false;

function checkNull(){
	var a= e_form.title.value;
	var b= e_form.name.value;
	var c= e_form.pwd.value;
	var d= e_form.content.value;
	
	if(a==null || a==""){alert("제목을 입력해주세요");
  e_form.title.focus();
  return false;
  }else{e_form.name.focus();}
  
  if(b==null || b==""){alert("이름을 입력해주세요");
  e_form.name.focus();
  return false;
  }else{e_form.pwd.focus();}
  
  if(c==null || c==""){alert("비밀번호을 입력해주세요");
  e_form.pwd.focus();
  return false;
  }
  
  if(d==null || d==""){alert("내용을 입력해주세요");
  e_form.content.focus();
  return false;
  }
  
  Gflag=true;
  document.e_form.submit();
  
}

</script>

</head>
<body>

<br>

<form name="e_form" method="post" enctype="multipart/form-data" action="reviewEditInsert.do" >
 <div class="container" align="center">
    <table width=860px>
		 <tr align="right">
      <td colspan="4">
       <a href="reviewList.do"><input type="button" value="목록" style="background-color:white ; color :  #3c3c8c; width:100px; height:38px;"></a>
       <a href="#"><input type="button" value="홈" style="background-color:white ; color :  #3c3c8c; width:100px; height:38px; "></a>
      </td>
     </tr>   
    </table>
  
    <h4>이용후기</h4><p>
    <hr width="860px" align="center">
      
    <div>
     <table>
      <tr>
       <td colspan="2">
        <input type="hidden" name="code" id="code" value="${dto.code}" >
       </td>
      </tr>
      <tr>
       <td width="100px"><div style="margin:11px" >제 목</div></td>
       <td>
        <input type="text" placeholder="제목을 입력해주세요." name="title" id="title" value="${dto.title}" >
       </td>
      </tr>
      <tr>
       <td width="100px"><div style="margin:11px">글쓴이</div></td> 
       <td>
        <input type="text" placeholder="이름을 입력해주세요" name="name" id="name" value="${dto.name}">
       </td> 
      </tr>
      <tr>
       <td width="100px"><div style="margin:11px">비밀번호</div></td> 
       <td>
        <input type="password" placeholder="비밀번호 입력해주세요" name="pwd" id="pwd" value="${dto.pwd}" >
       </td>
      </tr> 
      <tr>
	     <td colspan="2">
	      <textarea style="resize: none; " name="content" cols="95" rows="10" class="textarea"  placeholder="내용을 입력해주세요.">${dto.content}</textarea>
	     </td>
	    </tr>
	    <tr>
	     <td width="100px"><div style="margin:11px">만족도</div></td>
       <td>
         <label for=""></label>
           <input type="radio" id="rating" name="rating" value="1" style="padding-right:20px;">☆
           <label for=""></label>
           <input type="radio" id="rating" name="rating" value="2" style="padding-right:20px;">☆☆
           <label for=""></label>
           <input type="radio" id="rating" name="rating" value="3" style="padding-right:20px;" checked>☆☆☆
           <label for=""></label>
           <input type="radio" id="rating" name="rating" value="4" style="padding-right:20px;">☆☆☆☆
           <label for=""></label>
           <input type="radio" id="rating" name="rating" value="5" style="padding-right:20px;">☆☆☆☆☆
       </td>
      </tr>
	    <tr>
       <td colspan="2">
        <input type="file" name="file1" id="file1" style="display: none;"> 
        <input type="text" name="file2" id="file2" placeholder="파일을 선택하세요">
        <img src="./images/select_icon.png" name="find" id="find" border="0" onclick="document.all.file1.click(); document.all.file2.value=document.all.file1.value" style="cursor:hand;">
       </td>
      </tr>
     </table>

     <br><hr width="860px" align="center"><p>   
 
     <p>
     <div>
       <button type="reset" style="height:35px; width:430px; background-color: white; color :  #3c3c8c; ">취소하기</button>
       <button type="button" style="height:38px; width:430px; background-color:  #3c3c8c; color: white;" onclick="checkNull()">등록하기</button>
     </div>        
          
   </div> 
 </div>               
</form>
</body>
</html>       













