<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
//:! c15:jsp:Hello.jsp

<%-- Этот JSP комментарий не появится в сгенерированном html --%>

<%-- Это JSP директива: --%>

<%@ page import="java.util.*"%>

<%-- Эта декларации: --%>

<%!long loadTime = System.currentTimeMillis();
	Date loadDate = new Date();
	int hitCount = 0;%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>hello sample</title>
</head>
<body>
	<%-- 
Следующие несколько строк являются результатом
JSP выражений, вставленных в сгенерированный html;
знак '=' указывает на JSP выражение 
--%>

	<H1>
		Эта страница была загружена
		<%=loadDate%>
	</H1>
	<H1>
		Hello, world! It's
		<%=new Date()%></H1>
	<H2>
		Here's an object:
		<%=new Object()%></H2>
	<H2>
		This page has been up
		<%=(System.currentTimeMillis() - loadTime) / 1000%>
		seconds
	</H2>
	<H3>
		Page has been accessed
		<%=++hitCount%>
		times since
		<%=loadDate%></H3>

	<%-- 
"Скриплет", которые пишет на консоли сервера
и на странице клиента. 
Обратите, что необходимо ставить ';': 
--%>

	<%
		System.out.println("Goodbye");
		out.println("Cheerio");
	%>

</body>
</html>