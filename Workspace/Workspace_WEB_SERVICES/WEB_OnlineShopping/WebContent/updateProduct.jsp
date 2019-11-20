<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Update Product ${product.id}</h1>

	<form action="ProductController" method="post">

		<input type="hidden" id="id" name="id" value="${product.id}" /> 
		<input type="hidden" id="action" name="action" value="update" /> 
		
		<label for="newId">ID: </label> 
		<input type="number" disabled="disabled" value="${product.id}" required /> 
		
		<br />
		
		<label for="name">Name: </label> 
		<input type="text" id="name" name="name" value="${product.name}" required />
		
		<br/>

		<label for="description">Description: </label> 
		<input type="text" id="description" name="description" value="${product.name}" required />
		
		<br/>

		<label for="price">Price: </label> 
		<input type="text" id="price" name="price" value="${product.price}" /> 
		
		<br/>
		
		<label for="manufactureDate">Manufacturing date (dd/MM/yyyy): </label> 
		<fmt:formatDate value="${product.manufactureDate}" pattern="dd/MM/yyyy" var="manufactureTranslatedDate"/>
		<input type="text" id="manufactureDate" name="manufactureDate" value="${manufactureTranslatedDate}" />
		
		<br/>

		<button type="submit">Submit</button>
	</form>
</body>
</html>