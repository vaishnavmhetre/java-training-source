<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of contacts</title>
</head>
<body>
	<sql:setDataSource driver="com.mysql.cj.jdbc.Driver"
		url="jdbc:mysql://localhost:3306/allianz?serverTimezone=UTC"
		user="root" password="" />
	<sql:query var="listContacts">SELECT * FROM `contacts`</sql:query>

	<div align="center">
		<table border="1">
			<caption>List of contacts</caption>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Number</th>
				<th>Address</th>
			</tr>
			<c:forEach var="contact" items="${listContacts.rows}">
				<tr>
					<td><c:out value="${contact.id}" /></td>
					<td><c:out value="${contact.name}" /></td>
					<td><c:out value="${contact.number}" /></td>
					<td><c:out value="${contact.address}" /></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>