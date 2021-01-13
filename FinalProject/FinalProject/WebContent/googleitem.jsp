<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TravelGoGo 搜尋</title>
<style type="text/css">
    .searchName{
      position: absolute;
      font-weight: 500;
      font-size: 42px;
      font-family:sans-serif;
      top: 4%;
      right: 80%;
    }
    .search {
      position: absolute;
      display:inline-block;
      top: 5%;
      right: 77%;
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
      width: 450px;
      height: 32px;
      text-indent: 35px;
      border-radius: 10px;
      border-color: #BEBEBE;
    }
    .searchBtn{
      position: absolute;
      top: 5.5%;
      right: 34%;
      border: 0;
      border-radius: 5px;
      width: 80px;
      height: 30px;
      color: #3C3C3C
    }
</style>
</head>
<body>
<label class="searchName">
    TravelGoGo
  </label>
	<form action='${requestUri}' method='get'>
	<link rel="stylesheet"
          href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
          integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU"
          crossorigin="anonymous">
    <label class="search">
      <input type="text" name='keyword' placeholder='keyword'/>
    </label>
    <input class="searchBtn" type="submit" value="Search" />
    </form>
    <br><br><br><br>
<%
String[][] orderList = (String[][]) request.getAttribute("sortedQuery");
for(int i =0 ; i < orderList.length;i++){%>
	<a href='<%= orderList[i][1] %>'><%= orderList[i][0] %></a><br>
	<%=orderList[i][2]%>
	<br><br>	
<%
}
%>
</body>
</html>