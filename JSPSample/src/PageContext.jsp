<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- Просмотр атрибутов pageContext--%>
<%-- Обратите внимание, что вы можете включить любое количество кода
внутри тэгов скриплета --%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

http://javatutor.net/books/tiej/jsp
<br><br><br>
	Servlet Name:
	<%=config.getServletName()%><br> Servlet container supports
	servlet version:
	<%
	out.print(application.getMajorVersion() + "." + application.getMinorVersion());
%>
	<br>
	<br>
	<br> Есть три следующие атрибута области видимости:
	<ul>
		<li>- область видимости страницы (scope 1),</li>
		<li>- область видимости запроса (scope 2),</li>
		<li>- область видимости сессии (scope 3 - здесь доступен только
			один элемент - это "My dog", добавленный прямо перед циклом),</li>
		<li>- область видимости приложения (scope 4), основанная на
			объекте ServletContext. Есть один ServletContext на каждое "Web
			приложение" в каждой Java Машине.</li>
	</ul>
	("Web приложение" - это набор сервлетов и содержимого, установленного
	под определенным подмножеством URL'ов Сервера, таких как /catalog. Они
	устанавливаются с помощью конфигурационного файла.) В области видимости
	приложения вы увидите объекты, которые представляют пути для рабочего
	каталога и временного каталога.
	<br>
	<br>
	<br>
	<%
		session.setAttribute("My dog", "Ralph");
		for (int scope = 1; scope <= 4; scope++) {
	%>
	<H3>
		Scope:
		<%=scope%>
	</H3>
	<%
		Enumeration e = pageContext.getAttributeNamesInScope(scope);
			while (e.hasMoreElements()) {
				out.println("\t<li>" + e.nextElement() + "</li>");
			}
		}
	%>

</body>
</html>