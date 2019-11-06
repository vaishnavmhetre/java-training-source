<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<b> <%
 	switch (request.getParameter("operation")) {
 	case "add":
 		out.print("Adding ");
 		break;
 	case "subtract":
 		out.print("Subtracting ");
 		break;
 	case "multiply":
 		out.print("Multiplying ");
 		break;
 	case "divide":
 		out.print("Dividing ");
 		break;
 	default:
 		out.print("Unknown operation" + request.getParameter("operation"));
 		break;
 	}
 %></b> <%
 	out.print(request.getParameter("number1") + " and " + request.getParameter("number2") + " results ");
 %>
 
 <b> <%
 	int number1 = Integer.parseInt(request.getParameter("number1"));
 	int number2 = Integer.parseInt(request.getParameter("number2"));
 	
 	switch (request.getParameter("operation")) {
 	case "add":
 		out.print(number1+number2);
 		break;
 	case "subtract":
 		out.print(number1-number2);
 		break;
 	case "multiply":
 		out.print(number1*number2);
 		break;
 	case "divide":
 		out.print(number1/number2);
 		break;
 	default:
 		out.print("UNKNOWN");
 		break;
 	}
 	
 %>
	</b>
</body>
</html>