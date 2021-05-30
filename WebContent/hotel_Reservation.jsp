<%@ page language="java" contentType="text/html; charset=UTF-8"  %>



<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>예약하기</title>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>


<script>
  $( function() {
    var dateFormat = "mm/dd/yy",
      from = $("#from")
        .datepicker({
          defaultDate: "+1w",
          changeMonth: true,
          numberOfMonths: 3,
          dateFormat : "yy/mm/dd"
        })
        .on( "change", function() {
          to.datepicker( "option", "minDate", getDate( this ) );
        }),
      to = $("#to").datepicker({
        defaultDate: "+1w",
        changeMonth: true,
        numberOfMonths: 3,
        dateFormat : "yy/mm/dd"
      })
      .on("change", function() {
        from.datepicker( "option", "maxDate", getDate( this ) );
      });
 
    function getDate( element ) {
      var date;
      try {
        date = $.datepicker.parseDate(dateFormat, element.value );
      } catch( error ) {
        date = null;
      }
 
      return date;
    }
  } );
</script>

<style>
input{ 
       border: 1px solid ;
		   padding: 6px;
       border-radius:3px;
       border-color:#f1f3f5;}
button{
      border: 1px solid ;
      padding:5px;
      border-radius:4px;
      }


</style>

</head>

<body>

<br>

<form name="reservation" action="reservation.do" >
 <div class="container" align="center">
     <table width=860px>
		       
       <tr align="right">
       <td colspan="4">
        <a href="reviewList.do"><input type="button" value="목록" style="background-color:white ; color : #3c3c8c; width:100px; height:38px;"></a>
        <a href="#"><input type="button" value="홈" style="background-color:white ; color : #3c3c8c; width:100px; height:38px; "></a>
       </td>
       </tr>
        
    </table>
  
     <p>


      
   <div>
     <table>
      <tr>
       <td><h4>예약</h4></td>
      </tr>
      <tr>
       <td width="100px"><div style="margin:11px" >check in</div></td>
       <td><input type="text" id="from" name="from"></td>
      </tr>
      <tr>
       <td width="100px"><div style="margin:11px">check out</div></td> 
       <td><input type="text" id="to" name="to">
      </td>
      </tr> 
      <tr>
       <td width="100px"><div style="margin:11px">성인</div></td> 
       <td>
        <select name="adult">
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">7</option>
          <option value="8">8</option>
        </select>
       </td>
      </tr> 
      <tr>
       <td width="100px"><div style="margin:11px">어린이</div></td> 
       <td>
        <select name="children">
          <option value="1">1</option>
          <option value="2">2</option>
          <option value="3">3</option>
          <option value="4">4</option>
          <option value="5">5</option>
          <option value="6">6</option>
          <option value="7">7</option>
          <option value="8">8</option>
        </select>
       </td>
      </tr> 
      <tr>
       <td colspan="7"><hr width="850px" align="center"></td>   
      </tr>
      <tr>
       <td><h4>회원정보</h4></td>
      </tr>
      <tr>
       <td width="100px"><div style="margin:11px">이름</div></td> 
       <td><input type="text" id="name" name="name"></td>
      </tr> 
      <tr>
       <td width="100px"><div style="margin:11px">이메일</div></td> 
       <td><input type="email" id="email" name="email"></td>
      </tr> 
       
       <tr>
        <td width="100px"><div style="margin:11px">전화번호</div></td> 
        <td><input type="text" id="phone" name="phone"></td>
       </tr> 
       <tr>
        <td colspan="7"><hr width="850px" align="center"></td>   
       </tr>
      </table>
     </div>   
       
      <div>
       <button type="submit" style="height:35px; width:430px; background-color:  #3c3c8c; color: white;">등록하기</button>
      </div>    
  </div>  
</form>
</body>
</html>       













