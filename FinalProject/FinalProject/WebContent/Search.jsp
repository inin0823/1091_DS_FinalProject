<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TravelGoGo</title>
<style type="text/css">
    .searchName{
      position: absolute;
      font-weight: 500;
      font-size: 50px;
      font-family:sans-serif;
      top: 28%;
      right: 40%;
    }
    .search {
      position: absolute;
      display:inline-block;
      top: 47%;
      right: 74%;
    }
    .search:before {
      font-family: "Font Awesome 5 Free";
      font-weight: 900;
      content: "\f002";
      font-size: 20px;
      position: absolute;
      left: 9px;
      top: 20px;
      transform: translateY(-50%);
      z-index: 10;
    }
    .search input {
      line-height: 24px;
      position: absolute;
      width: 600px;
      height: 32px;
      text-indent: 35px;
      border-radius: 10px;
      border-color: #BEBEBE;
    }
    .searchBtn{
      position: absolute;
      top: 58%;
      right: 47%;
      border: 0;
      border-radius: 5px;
      width: 80px;
      height: 30px;
      color: #3C3C3C
    }
    .car{
      top: 80%;
      position:absolute;
      width: 100px;
      height: 100px;
      animation-name:car;
      animation-duration:5s;
      animation-iteration-count: infinite;
      z-index: 2;
    }
    .light{
      position: absolute;
      width: 50px;
      height: 90px;
      right: 1%;
      bottom: 10%;
      z-index: 3;
    }
    .road{
      position: absolute;
      background-color: black;
      width: 99%;
      height: 80px;
      bottom: 0%;
    }
    .line{  position: absolute; background-color: white; width: 60px; height: 13px; bottom: 5%; left: 10%;  }
    .line2{  position: absolute; background-color: white; width: 60px; height: 13px; bottom: 5%; left: 19%;  }
    .line3{  position: absolute; background-color: white; width: 60px; height: 13px; bottom: 5%; left: 28%;  }
    .line4{  position: absolute; background-color: white; width: 60px; height: 13px; bottom: 5%; left: 37%;  }
    .line5{  position: absolute; background-color: white; width: 60px; height: 13px; bottom: 5%; left: 46%;  }
    .line6{  position: absolute; background-color: white; width: 60px; height: 13px; bottom: 5%; left: 55%;  }
    .line7{  position: absolute; background-color: white; width: 60px; height: 13px; bottom: 5%; left: 64%;  }
    .line8{  position: absolute; background-color: white; width: 60px; height: 13px; bottom: 5%; left: 73%;  }
    .line9{  position: absolute; background-color: white; width: 60px; height: 13px; bottom: 5%; left: 82%;  }

    @keyframes car{
      from{
        left:0;
      }
      to{
        left:1120px;
      }
    }
  </style>
  </head>
  <body>
    <img src="pucca.png" class="car">
    <img src="traffic-light.png" class="light">
    <label class="searchName">
      TravelGoGo
    </label>
    <link rel="stylesheet"
          href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
          crossorigin="anonymous">
    <form action='${requestUri}' method='get'>
    <label class="search">
      <input type="text" name='keyword' placeholder='keyword'/>
    </label>
    <input class="searchBtn" type="submit" value="Search" />
    </form>
    <div class="road"></div>
    <div class="line"></div>
    <div class="line2"></div>
    <div class="line3"></div>
    <div class="line4"></div>
    <div class="line5"></div>
    <div class="line6"></div>
    <div class="line7"></div>
    <div class="line8"></div>
    <div class="line9"></div>
</body>
</html>