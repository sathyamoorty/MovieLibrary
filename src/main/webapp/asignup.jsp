<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Details</title>

<style type="text/css">

     #adminlog{
         
          width: 350px;
          text-align: center;
          height: 200px;
          position:absolute;
          left: 380px;
          top: 150px;
          border: 1px solid black; 
          padding: 50px;
          background-color:silver;
          border-radius: 20px;
     }

</style>


</head>
<body>
	<div id="adminlog">
		<form action="adminsign" method="post">
			Admin Id: <input type="number" name="aid"><br> <br>
			Admin Name: <input type="text" name="aname"><br> <br>
			Admin Contact: <input type="tel" name="aphno"><br>
			<br> Admin Mail: <input type="email" name="amail">
			<br> <br> Admin Password: <input type="password"
				name="apass"> <br> <br> <input type="submit">
		</form>
	</div>
</body>
</html>