<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c-rt"%>
<%@ page import="com.support.base.context.properties.ContextPropertiesSingletonFactory"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Contact details</title>
</head>
<body>
	<c-rt:choose>
		<c-rt:when test="${empty param.id}">
			<h1 style="color: red">Please provide ID to be searched</h1>
		</c-rt:when>
		<c-rt:otherwise>
			<sql:setDataSource var="dbDataSource"
				driver="${ContextPropertiesSingletonFactory.getInstance().getProperty('db.driver')}"
				password="${ContextPropertiesSingletonFactory.getInstance().getProperty('db.password')}"
				user="${ContextPropertiesSingletonFactory.getInstance().getProperty('db.username')}"
				url="${ContextPropertiesSingletonFactory.getInstance().getProperty('db.url')}" />

			<sql:query var="contactDetails" dataSource="${dbDataSource}">
				SELECT * FROM `contacts` WHERE `id`=${param.id};
			</sql:query>
			<div style="padding-left: 2em;">
				<h2>
					Details of ID
					<c:out value="${param.id}" />
				</h2>
				<c:forEach var="contact" items="${contactDetails.rows}">
					<hr>
					<ul>
						<li><b>ID: </b> <c:out value="${contact.id}" /></li>
						<li><b>Name: </b> <c:out value="${contact.name}" /></li>
						<li><b>Number: </b> <c:out value="${contact.number}" /></li>
						<li><b>Address: </b> <c:out value="${contact.address}" /></li>
					</ul>
				</c:forEach>
			</div>
		</c-rt:otherwise>
	</c-rt:choose>
	<a href="ListContacts.jsp">&larr; Back to list</a>
</body>
</html>