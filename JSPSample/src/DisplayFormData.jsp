<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
//:! c15:jsp:DisplayFormData.jsp
<%-- Извлечение данных из HTML формы. --%>
<%-- Эта JSP также генерирует форму. --%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<H1>DisplayFormData</H1>
	<H3>
		<%
			Enumeration flds = request.getParameterNames();
			if (!flds.hasMoreElements()) { // Нет полей
		%>
		<form method="POST" action="DisplayFormData.jsp">
			<%
				for (int i = 0; i < 10; i++) {
			%>
			Field<%=i%>: <input type="text" size="20" name="Field<%=i%>"
				value="Value<%=i%>"><br>
			<%
				}
			%>
			<INPUT TYPE=submit name=submit value="Submit">
		</form>
		<%
			} else {
				while (flds.hasMoreElements()) {
					String field = (String) flds.nextElement();
					String value = request.getParameter(field);
		%>

		<li><%=field%> = <%=value%></li>

		<%
			}
			}
		%>
	</H3>
</body>
</html>