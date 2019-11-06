
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Welcome to JSP World...<br>
Date on Server is <b><%= new Date() %></b>
<br>
<%! int count = 0; %>
The count is <%= ++count %>
</body>
</html>