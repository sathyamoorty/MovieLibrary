<%@page import="java.util.Base64"%>
<%@page import="com.java.dto.Moviedto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% Moviedto m=(Moviedto)request.getAttribute("movie");%>
 <form action="update" method="post" enctype="multipart/form-data">
 
 MovieId: <input type="number" name="mid" readonly value="<%= m.getMid() %>">
 <br><br>
 MovieName: <input type="text" name="mname" value="<%= m.getMname() %>">
  <br><br>
 MoviePrice: <input type="number" name="mprice" value="<%= m.getMprice() %>">
  <br><br>
 MovieRating: <input type="number" name="mrate" value="<%= m.getMrating() %>">
  <br><br>
 MovieGenre: <input type="text" name="mgenre" value="<%= m.getMgenre() %>">
  <br><br>
 MovieLang: <input type="text" name="mlang" value="<%= m.getMlang() %>">
  <br><br>
 MovieImg: <input type="file" name="mimage" >
  <br><br>
 <input type="submit">
 <input type="reset">
 
 <% String base64image= new String (Base64.getEncoder().encode(m.getMimage())); %>
 <img  src="data:image/jpeg;base64, <%= base64image %>" height="200px" width="200px" >
 </form>
  
</body>
</html>