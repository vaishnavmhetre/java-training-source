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
		Name:<input type="text" name="name"><br> Username:<input
			type="text" name="username"><br> Password:<input
			type="password" name="password"><br>
		<button type="submit">Register</button>
		<br> Already registered? <a href='login'>Login</a>
	</form>

</body>
</html>