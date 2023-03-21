<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>구구단</h2>

	<%
		int dan = Integer.parseInt(request.getParameter("dan"));

		for (int i = 1; i < 10; i++) {
	%>
	<%=dan + " * " + i + " = " + dan * i + "<br>"%>
	<%
		}
	%>
	
	<%
	for (int i = 1; i < 10; i++) {
		out.println(dan + " * " + i + " = " + (dan * i) + "<br>");
		
	}
	%>
	<div>
	<a href="exam05.jsp">다시하기</a>
	</div>
</body>
</html>