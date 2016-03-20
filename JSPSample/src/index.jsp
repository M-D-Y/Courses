<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Sample</title>
</head>
<%!String text = new String("Текст для");%>
<body>
	<H1>
		The time in seconds is:
		<%=System.currentTimeMillis() / 1000%></H1>
	<br>
	<table border="2">
		<tr>
			<td>Hello</td>
			<td><%=new String("world")%></td>
		</tr>
		<tr>
			<td>Дата:</td>
			<td><%=new java.util.Date()%></td>
		</tr>
		<tr>
			<td>Мой текст:</td>
			<%
				text = text + " для примера.";
			%>
			<td><%=text%></td>
		</tr>
		<tr>
			<td>Хост</td>
			<td>
				<%
					out.println(request.getRemoteHost());
				%>
			</td>
		</tr>
	</table>
</body>
</html>