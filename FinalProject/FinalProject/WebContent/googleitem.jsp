<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GoogleSearch</title>
</head>
<body>
<form action='${requestUri}' method='get'>
<input type='text' name='keyword' placeholder = 'keyword'/>
<input type='submit' value='submit' />
</form>
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
