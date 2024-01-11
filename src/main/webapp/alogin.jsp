<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="adminlogin" method="post">

Admin Email: <input type="email" name="amail">
<br>
<br>
Admin Password: <input type="password" name="apass">
<br>
<br>
<input type="submit">
</form>
<% String messages=(String) request.getAttribute("messages"); %>
<% if(messages!=null){ %>
<%=messages %>
<%} %>
</body>
</html>