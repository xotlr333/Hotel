<%@ page language="java" contentType="text/html; charset=UTF-8"  %>



<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <title>예약확인</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

<style>

input{ border: 1px solid ;
		   padding: 6px;
       border-radius:3px;
       border-color:#f1f3f5;}
          
button{border: 1px solid;
      padding:5px;
      border-radius:4px;}
      
</style>

</head>
<body>

<br>

<form name="reserconfirm" action="reviewList.do" >
  <div class="container" align="center">
     <table width=860px>
		       
       <tr align="right">
        <td colspan="4">
         <a href="reviewList.do"><input type="button" value="목록" style="background-color:white ; color :#3c3c8c; width:100px; height:38px;"></a>
         <a href="#"><input type="button" value="홈" style="background-color:white ; color : #3c3c8c; width:100px; height:38px; "></a>
        </td>
       </tr>
        
     </table>
  
     <p>
    
  <div>
    <table>
      <tr>
       <td><h4>예약확인</h4></td>
      </tr>
      <tr>
       <td width="100px"><div style="margin:11px" >check in</div></td>
       <td>${from}</td>
      </tr>
      
      <tr>
       <td width="100px"><div style="margin:11px">check out</div></td> 
       <td>${to}</td>
      </tr> 
       
      <tr>
       <td width="100px"><div style="margin:11px">성인</div></td> 
       <td>${adult}</td>
      </tr> 
         
      <tr>
       <td width="100px"><div style="margin:11px">어린이</div></td> 
       <td>${children}</td>
      </tr> 
        
      <tr>
       <td colspan="7"><hr width="850px" align="center"></td>   
      </tr>
        
      <tr>
       <td><h4>회원정보</h4></td>
      </tr>
    
      <tr>
       <td width="100px"><div style="margin:11px">이름</div></td> 
       <td>${name}</td>
      </tr> 
       
      <tr>
       <td width="100px"><div style="margin:11px">이메일</div></td> 
       <td>${email}</td>
      </tr> 
       
      <tr>
       <td width="100px"><div style="margin:11px">전화번호</div></td> 
       <td>${phone}</td>
      </tr> 
      
      <tr>
       <td colspan="7"><hr width="850px" align="center"></td>   
      </tr>
     </table>
    </div>   
       
    <div>
      <button type="submit" style="height:35px; width:430px; background-color:  #3c3c8c; color: white;">확인</button>
    </div>    
          
 </div>  
       
  
   
</form>
</body>
</html>       













