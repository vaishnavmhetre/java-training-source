<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page
	import="com.support.base.context.properties.ContextPropertiesSingletonFactory"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of contacts</title>
<style>
table {
	padding: 3px;
	border-collapse: collapse;
}

th, td {
	padding: 8px;
}
</style>
</head>
<body>

	<sql:setDataSource var="dbDataSource"
		driver="${ContextPropertiesSingletonFactory.getInstance().getProperty('db.driver')}"
		password="${ContextPropertiesSingletonFactory.getInstance().getProperty('db.password')}"
		user="${ContextPropertiesSingletonFactory.getInstance().getProperty('db.username')}"
		url="${ContextPropertiesSingletonFactory.getInstance().getProperty('db.url')}" />

	<sql:query var="listContacts" dataSource="${dbDataSource}">SELECT * FROM `contacts`</sql:query>

	<div align="center">
		<a href="CreateContact.html">Create new contact</a>
		<table border="1">
			<caption>List of contacts</caption>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Number</th>
				<th>Address</th>
				<th colspan="2">Operations</th>
			</tr>
			<c:forEach var="contact" items="${listContacts.rows}">
				<tr>
					<td><a href="ContactInfo.jsp?id=${contact.id}"> <c:out
								value="${contact.id}" />
					</a></td>
					<td><c:out value="${contact.name}" /></td>
					<td><c:out value="${contact.number}" /></td>
					<td><c:out value="${contact.address}" /></td>
					<td><a href="UpdateContact.jsp?id=${contact.id}"> Update </a>
					</td>
					<td><a href="DeleteController?id=${contact.id}"> Delete </a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>