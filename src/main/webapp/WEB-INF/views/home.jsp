<%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
</body>
</html>
 --%>
 <%@page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

<style>
/* ============================================= */
.left_wrap{
   width:40%; height:480px;
   float:left;
}
.movieSelect{
   height:300px;
   overflow-y: scroll;
   position: relative;
}
.movieSelect ul{
   list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #f1f1f1;
}
.movieSelect li{
   
}
.movieSelect li a{
   padding: 14px 16px;
   display: block;
    color: #000;
    text-align:left;
    text-decoration: none;
    vertical-align: center;
}
.movieSelect li a.active {
    background-color: #4CAF50;
    color: white;
}
.movieSelect li a:HOVER{
    background-color: #555;
    color:white;
}
/* ============================================= */
.slidebar{
   height:60px;
   position: relative;
}
.slidebar ul{
   list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #f1f1f1;
}
.slidebar li{
   float: left;
}
.slidebar li a{
   padding: 10px 10px;
   display: block;
    color: #000;
    text-align: center;
    text-decoration: none;
}
.slidebar li a.active {
    background-color: #4CAF50;
    color: white;
}
.slidebar li a:HOVER{
    background-color: #555;
    color:white;
}
/* ============================================= */
.middle_wrap{
   width:25%; height:480px; padding-left:20px;
   float:left;
}
.time {
   height:420px;
   background-color: #f1f1f1;
}
.time ul{
   list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #f1f1f1;
}
.time li{
   float: none;
}
.time li a{
   padding: 10px 10px;
   display: block;
    color: #000;
    text-align: center;
    text-decoration: none;
}
.time li a.active {
    background-color: #4CAF50;
    color: white;
}
.time li a:HOVER{
    background-color: #555;
    color:white;
}
/* ============================================= */
.right_wrap{
   width:30%; height:450px; padding-left:20px;
   float:left;
}
.con{
   background-color:gray;
   text-align:center;
   color:white;
   width:88%;
   padding:10px;
   margin:10px;
}
.con ul{
   list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
    background-color: #f1f1f1;
}
.con li{
   float: left;
}
.con li a{
   padding: 10px 10px;
   display: block;
    color: #000;
    text-align: center;
    text-decoration: none;
}
.con li a.active {
    background-color: #4CAF50;
    color: white;
}
.con li a:HOVER{
    background-color: #555;
    color:white;
}
/* ============================================= */

</style>

</head>
<body>

<form name="reserve" action="reserveProc.jsp" method="post">
<!-- 왼쪽 랲 -->
<div class="left_wrap">
   <div>
      <h3 class="cap">날짜
      &nbsp;&nbsp;&nbsp;&nbsp;
      <select name="date">
         <option>날짜를 선택해주세요</option>
         <option id="sday0"></option>
         <option id="sday1"></option>
         <option id="sday2"></option>
         <option id="sday3"></option>
         <option id="sday4"></option>
         <option id="sday5"></option>
         <option id="sday6"></option>
      </select></h3>   
   </div>
   
   <div class="slidebar">
      <ul>
         <li></li>
         <li><a href="#" class="" onclick="funDay(0)" id="day0" name="day0"></a></li>
         <li><a href="#" class="" onclick="funDay(1)" id="day1" name="day1"></a></li>
         <li><a href="#" class="" onclick="funDay(2)" id="day2" name="day2"></a></li>
         <li><a href="#" class="" onclick="funDay(3)" id="day3" name="day3"></a></li>
         <li><a href="#" class="" onclick="funDay(4)" id="day4" name="day4"></a></li>
         <li><a href="#" class="" onclick="funDay(5)" id="day5" name="day5"></a></li>
         <li><a href="#" class="" onclick="funDay(6)" id="day6" name="day6"></a></li>
         <li></li>
      </ul>
      
      <script>
         function funDay(element) {
            for(i=0; i<7; i++){
               if(i == element){
                  document.getElementById("day"+element).className = "active";
                  document.getElementById("sday"+element).selected = true;
               }
               else{
                  document.getElementById("day"+i).className = "non-active";
               }
            }
         }
      </script>
      
      <script>
         var dt = new Date();
         var roop = 7;
         var week = new Array('월','화','수','목','금','토','일');
         
         
         for(var i=7-roop; i<roop; i++){
            document.getElementById("day"+i).innerHTML = dt.getDate()+i + "(" + week[i%7] + ")";
         }
         
         for(var i=7-roop; i<roop; i++){
            document.getElementById("sday"+i).innerHTML = dt.getDate()+i + "(" + week[i%7] + ")";
         }
      </script>
   </div>

   <h3 class="cap">영화&nbsp;&nbsp;&nbsp;&nbsp;
   <select name="movieName" >
      <option>영화를 선택해주세요</option>
      <option id="sMovie0">캡틴아메리카 - 시빌워</option>
      <option id="sMovie1">다크 소울3</option>
      <option id="sMovie2">디스 워 오브 마인</option>
   </select></h3>   
   <div class="movieSelect">
      <ul>
         <li><a href="#" class="" onclick="funMovie(0)" id="movie0" name="movie0"><img alt="" src="../images/civilwar.jpg" style="width:150px; height:200px;">캡틴아메리카 - 시빌워</a></li>
         <li><a href="#" class="" onclick="funMovie(1)" id="movie1" name="movie1"><img alt="" src="../images/darksoul3.jpg" style="width:150px; height:200px;">다크 소울3</a></li>
         <li><a href="#" class="" onclick="funMovie(2)" id="movie2" name="movie2"><img alt="" src="../images/thiswarofmine.jpg" style="width:150px; height:200px;">디스 워 오브 마인</a></li>
      </ul>
   </div>
      
      <script>
      function funMovie(element) {
         for(i=0; i<7; i++){
            if(i == element){
               document.getElementById("movie"+element).className = "active";
               document.getElementById("sMovie"+element).selected = true;
            }
            else{
               document.getElementById("movie"+i).className = "non-active";
            }
         }
      }
      </script>
   
</div>

<!-- 오른쪽 랲 -->
<div class="middle_wrap">
   <h3 class="cap">시간   &nbsp;&nbsp;&nbsp;&nbsp;
   <select name="time">
      <option>시간을 선택해주세요</option>
      <option id="sTime0">01:00~03:00</option>
      <option id="sTime1">06:00~08:00</option>
      <option id="sTime2">09:00~11:00</option>
      <option id="sTime3">12:00~14:00</option>
      <option id="sTime4">15:00~17:00</option>
      <option id="sTime5">19:00~21:00</option>
      <option id="sTime6">22:00~24:00</option>
   </select></h3>
   <div class="time">
      <ul>
         <li><a href="#" class="" onclick="funTime(0)" id="time0" name="time0">01:00~03:00</a></li>
         <li><a href="#" class="" onclick="funTime(1)" id="time1" name="time1">06:00~08:00</a></li>
         <li><a href="#" class="" onclick="funTime(2)" id="time2" name="time2">09:00~11:00</a></li>
         <li><a href="#" class="" onclick="funTime(3)" id="time3" name="time3">12:00~14:00</a></li>
         <li><a href="#" class="" onclick="funTime(4)" id="time4" name="time4">15:00~17:00</a></li>
         <li><a href="#" class="" onclick="funTime(5)" id="time5" name="time5">19:00~21:00</a></li>
         <li><a href="#" class="" onclick="funTime(6)" id="time6" name="time6">22:00~24:00</a></li>
      </ul>
   </div>
   
</div>   
         <script>
            function funTime(element) {
               for(i=0; i<7; i++){
                  if(i == element){
                     document.getElementById("time"+element).className = "active";
                     document.getElementById("sTime"+element).selected = true;
                  }
                  else{
                     document.getElementById("time"+i).className = "non-active";
                  }
               }
            }
         </script>
         
         <!-- 로그 텍스트 파일 읽는 코드 -->
         <%
         String flag = request.getParameter("flag");
         String rflag = flag;
         
         String filePath = application.getRealPath("/log/userLog.txt");
         BufferedReader breader = null;
         
         try{
            breader = new BufferedReader(new FileReader(filePath));   
            
            while(true){
               String str = breader.readLine();
               if(str == null){
                  break;
               }
            }
         }catch(Exception e){
            /* out.println(e + " 파일 읽기 실패"); */
         }finally{
            try{
               breader.close();
            }catch(Exception e){
            }
         }
         %>
         
   <div class="right_wrap">
      <h3 class="cap">좌석   &nbsp;&nbsp;&nbsp;&nbsp;
      <input type="text" name="inputSeat" id="inputSeat"></h3>
         
      <div style="text-align:right; background-color: #f1f1f1; overflow-y:scroll; height:380px;">
         <div style="text-align: center; background-color: orange; color:white; height:30px; vertical-align:middle;">
            <h4>스크린</h4>
         </div>
         
         <!----------
              G열 
         ----------->
         <script>
            var flag = new Array();
            for(i=1; i<7; i++)
               flag[i] = false;
            
            function funSeat(col, element) {
               if(flag[element] == false || flag[element] == null){
            	   console.log("col : element : " + col + " : " + element);
                  document.getElementById("seat" + col + element).className = "active";
                  //document.getElementById("inputSeat").value += col + element + "/";
                  flag[element] = true;
                  document.getElementById("inputSeat").value += col + element + "/" + flag[element] ;
               }
               if(flag[element] == true){
                  document.getElementById("seat" + col + element).className = "non-active";
                  document.getElementById("inputSeat").value = "non-active";
                  flag[element] = false;
               }
            }
         </script>   
         <div class="con"><span>G</span>
            <ul>
               <li><a style="background-color:#f1f1f1;">&nbsp;&nbsp;</a></li>
               <li><a href="#" class="" onclick="funSeat('G', 1)" id="seatG1" name="seatG1">1</a></li>
               <li><a href="#" class="" onclick="funSeat('G', 2)" id="seatG2" name="seatG2">2</a></li>
               <li><a style="background-color: #f1f1f1;">&nbsp;&nbsp;</a></li>
               <li><a href="#" class="" onclick="funSeat('G', 3)" id="seatG3" name="seatG3">3</a></li>
               <li><a href="#" class="" onclick="funSeat('G', 4)" id="seatG4" name="seatG4">4</a></li>
               <li><a style="background-color: #f1f1f1;">&nbsp;&nbsp;</a></li>
               <li><a href="#" class="" onclick="funSeat('G', 5)" id="seatG5" name="seatG5">5</a></li>
               <li><a href="#" class="" onclick="funSeat('G', 6)" id="seatG6" name="seatG6">6</a></li>
            </ul>
         </div>
         
         
         <!----------
              F열 
         ----------->      
         <div class="con">F
            <ul>
               <li><a style="background-color: #f1f1f1;">&nbsp;&nbsp;</a></li>
               <li><a href="#" class="" onclick="funSeat(1)" id="seatF1" name="seatF1">1</a></li>
               <li><a href="#" class="" onclick="funSeat(2)" id="seatF2" name="seatF2">2</a></li>
               <li><a style="background-color: #f1f1f1;">&nbsp;&nbsp;</a></li>
               <li><a href="#" class="" onclick="funSeat(3)" id="seatF3" name="seatF3">3</a></li>
               <li><a href="#" class="" onclick="funSeat(4)" id="seatF4" name="seatF4">4</a></li>
               <li><a style="background-color: #f1f1f1;">&nbsp;&nbsp;</a></li>
               <li><a href="#" class="" onclick="funSeat(5)" id="seatF5" name="seatF5">5</a></li>
               <li><a href="#" class="" onclick="funSeat(6)" id="seatF6" name="seatF6">6</a></li>
            </ul>
         </div>
         
         <!----------
              E열 
         ----------->
         <div class="con">E
            <ul>
               <li><a style="background-color: #f1f1f1;">&nbsp;&nbsp;</a></li>
               <li><a href="#" class="" onclick="funSeat(1)" id="seatE1" name="seatE1">1</a></li>
               <li><a href="#" class="" onclick="funSeat(2)" id="seatE2" name="seatE2">2</a></li>
               <li><a style="background-color: #f1f1f1;">&nbsp;&nbsp;</a></li>
               <li><a href="#" class="" onclick="funSeat(3)" id="seatE3" name="seatE3">3</a></li>
               <li><a href="#" class="" onclick="funSeat(4)" id="seatE4" name="seatE4">4</a></li>
               <li><a style="background-color: #f1f1f1;">&nbsp;&nbsp;</a></li>
               <li><a href="#" class="" onclick="funSeat(5)" id="seatE5" name="seatE5">5</a></li>
               <li><a href="#" class="" onclick="funSeat(6)" id="seatE6" name="seatE6">6</a></li>
            </ul>
         </div>
         
         <!----------
              D열 
         ----------->
         <div class="con">D
            <ul>
               <li><a style="background-color: #f1f1f1;">&nbsp;&nbsp;</a></li>
               <li><a href="#" class="" onclick="funSeat(1)" id="seatD1" name="seatD1">1</a></li>
               <li><a href="#" class="" onclick="funSeat(2)" id="seatD2" name="seatD2">2</a></li>
               <li><a style="background-color: #f1f1f1;">&nbsp;&nbsp;</a></li>
               <li><a href="#" class="" onclick="funSeat(3)" id="seatD3" name="seatD3">3</a></li>
               <li><a href="#" class="" onclick="funSeat(4)" id="seatD4" name="seatD4">4</a></li>
               <li><a style="background-color: #f1f1f1;">&nbsp;&nbsp;</a></li>
               <li><a href="#" class="" onclick="funSeat(5)" id="seatD5" name="seatD5">5</a></li>
               <li><a href="#" class="" onclick="funSeat(6)" id="seatD6" name="seatD6">6</a></li>
            </ul>
         </div>
         
         <!----------
              C열 
         ----------->
         <div class="con">C
            <ul>
               <li><a style="background-color: #f1f1f1;">&nbsp;&nbsp;</a></li>
               <li><a href="#" class="" onclick="funSeat(1)" id="seatC1" name="seatC1">1</a></li>
               <li><a href="#" class="" onclick="funSeat(2)" id="seatC2" name="seatC2">2</a></li>
               <li><a style="background-color: #f1f1f1;">&nbsp;&nbsp;</a></li>
               <li><a href="#" class="" onclick="funSeat(3)" id="seatC3" name="seatC3">3</a></li>
               <li><a href="#" class="" onclick="funSeat(4)" id="seatC4" name="seatC4">4</a></li>
               <li><a style="background-color: #f1f1f1;">&nbsp;&nbsp;</a></li>
               <li><a href="#" class="" onclick="funSeat(5)" id="seatC5" name="seatC5">5</a></li>
               <li><a href="#" class="" onclick="funSeat(6)" id="seatC6" name="seatC6">6</a></li>
            </ul>
         </div>
         
         <!----------
              B열 
         ----------->
         <div class="con">B
            <ul>
               <li><a style="background-color: #f1f1f1;">&nbsp;&nbsp;</a></li>
               <li><a href="#" class="" onclick="funSeat(1)" id="seatB1" name="seatB1">1</a></li>
               <li><a href="#" class="" onclick="funSeat(2)" id="seatB2" name="seatB2">2</a></li>
               <li><a style="background-color: #f1f1f1;">&nbsp;&nbsp;</a></li>
               <li><a href="#" class="" onclick="funSeat(3)" id="seatB3" name="seatB3">3</a></li>
               <li><a href="#" class="" onclick="funSeat(4)" id="seatB4" name="seatB4">4</a></li>
               <li><a style="background-color: #f1f1f1;">&nbsp;&nbsp;</a></li>
               <li><a href="#" class="" onclick="funSeat(5)" id="seatB5" name="seatB5">5</a></li>
               <li><a href="#" class="" onclick="funSeat(6)" id="seatB6" name="seatB6">6</a></li>
            </ul>
         </div>
         
         <!----------
              A열 
         ----------->
         <div class="con">A
            <ul>
               <li><a style="background-color: #f1f1f1;">&nbsp;&nbsp;</a></li>
               <li><a href="#" class="" onclick="funSeat(1)" id="seatA1" name="seatA1">1</a></li>
               <li><a href="#" class="" onclick="funSeat(2)" id="seatA2" name="seatA2">2</a></li>
               <li><a style="background-color: #f1f1f1;">&nbsp;&nbsp;</a></li>
               <li><a href="#" class="" onclick="funSeat(3)" id="seatA3" name="seatA3">3</a></li>
               <li><a href="#" class="" onclick="funSeat(4)" id="seatA4" name="seatA4">4</a></li>
               <li><a style="background-color: #f1f1f1;">&nbsp;&nbsp;</a></li>
               <li><a href="#" class="" onclick="funSeat(5)" id="seatA5" name="seatA5">5</a></li>
               <li><a href="#" class="" onclick="funSeat(6)" id="seatA6" name="seatA6">6</a></li>
            </ul>
         </div>
      </div>
      <p style="text-align:right;"><input type="submit" value="예매하기" ></p>
   </div>
</form>

</body>
</html>