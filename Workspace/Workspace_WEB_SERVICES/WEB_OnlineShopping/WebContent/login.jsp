<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="AuthController" method="post">
	<input type="hidden" name="action" value="login"/>
		Username:<input type="text" name="username"><br>
		Password:<input type="password" name="password"><br>
		<button type="submit">Login</button>
		<br> Not registered? <a href='register.jsp'>Register</a>
	</form>

</body>
</html>