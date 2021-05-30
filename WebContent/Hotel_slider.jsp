<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="utf-8">
<head>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

<title>  </title>
<script>
$(function(){
    $('.bxslider').bxSlider({
    mode: 'fade',
    captions: true,
    slideWidth: 1000
    });
});
</script>

<style> 

body {
   margin: 20px auto;
   padding: 0;   
   width: 1000px;
   align-content: center;
   
}

</style>
</head>

<body>
    <div class="bxslider">
        <div><a href="#"><img src="images/slider1.PNG" title="Floating Cinema 따듯한 야외 온수풀에서  즐기는 로맥틱 시네마"></a></div>
        <div><img src="images/slider2.PNG" title="Art Healing Time 그림을 그리며 봄날의 힐링 타임을 즐겨보시기 바랍니다"></div>
        <div><img src="images/slider3.PNG" title="Play Music 따스한 봄바람을 타고 울려 퍼지는 감미로운 보이스의 풀사이드 공연이 펼쳐집니다"></div>
    </div>
</body>
</html>