<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*"%>
<%!int colorIdx = 0;
	Random random = new Random();
	String[] colors = { "black", "aqua", "blue", "fuchsia", "gray", "green", "lime", "maroon", "navy", "olive",
			"purple", "red", " ", "silver", "teal", "white", "yellow" };%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>FontColor</title>
</head>
<body>

	<%
		//System.out.println("colorIdx=" + colorIdx + ", colors.length=" + colors.length);
		++colorIdx;
		if (colorIdx >= colors.length)
			colorIdx = 0; //colorIdx = random.nextInt(colorIdx);
	%>
	<font color="black"> Случайный цвет: <%=colorIdx%> <font
		color="<%=colors[colorIdx]%>">Этот текст набран случайным
			цветом</font> <%
 	
 %>
</body>
</html>