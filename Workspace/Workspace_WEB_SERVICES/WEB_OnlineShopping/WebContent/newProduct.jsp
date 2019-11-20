<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Add new product</h1>

	<form action="ProductController" method="post">

		<input type="hidden" id="action" name="action" value="add" /> 
		
		<br />
		
		<label for="name">Name: </label> 
		<input type="text" id="name" name="name" required />
		
		<br/>

		<label for="description">Description: </label> 
		<input type="text" id="description" name="description"  required />
		
		<br/>

		<label for="price">Price: </label> 
		<input type="text" id="price" name="price" /> 
		
		<br/>
		
		<label for="manufactureDate">Manufacturing date (dd/MM/yyyy): </label> 
		<input type="text" id="manufactureDate" name="manufactureDate" />
		
		<br/>

		<button type="submit">Add product</button>
	</form>
</body>
</html>