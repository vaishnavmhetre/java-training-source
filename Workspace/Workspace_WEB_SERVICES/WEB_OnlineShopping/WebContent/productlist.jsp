<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="customdateformatter" prefix="cdf"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products List</title>
</head>
<style>
table {
	border: 1px solid #000;
	border-collapse: collapse;
}

td, th {
	border: 1px solid #000;
	padding: 5px;
}

tr.header-row {
	background-color: #000;
	color: #fff;
	border-color: #000 !important;
}

tr.header-row>th {
	border-left: 1px solid #fff;
	border-right: 1px solid #fff;
}

tr.header-row>th:first-child {
	border-left: 1px solid #000 !important;
}

th.header-row>th:last-child {
	border-right: 1px solid #000 !important;
}
</style>
<body>
	<a href="newProduct.jsp">Add new product</a>
	<table>
		<tr class="header-row">
			<th>ID</th>
			<th>Name</th>
			<th>Description</th>
			<th>Price</th>
			<th>Manufacturing Date</th>
			<th>Categories</th>
			<th colspan="2">Action</th>
		</tr>
		<c:forEach items="${products}" var="product">
			<tr>
				<td style="font-weight: bold;">${product.id}</td>
				<td>${product.name}</td>
				<td>${product.description}</td>
				<td>${product.price}</td>
				<%-- <td><fmt:formatDate value="${product.manufactureDate}"
						pattern="dd/MM/yyyy" /></td> --%>
				<td><cdf:format date="${product.manufactureDate}"
						pattern="dd/MM/yyyy" /></td>
				<td><c:forEach items="${product.categories}" var="category">
					<c:out value="${category.code}"></c:out> |
				</c:forEach></td>
				<td><a href="ProductController?action=edit&id=${product.id}">Update</a></td>
				<td><a href="ProductController?action=delete&id=${product.id}"
					style="color: red;">Delete</a></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>