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
	for(int dan = 2; dan < 10; dan++){
		for(int i = 1; i < 10; i++){
	%>
		<%= dan + " * " + i + " = " + dan * i + "<br>" %>
	<%
			}
		}
	 %>
	
	<%-- 
	for(int dan = 2; dam < 10; dan++){
	for(int i = 1; i < 10; i++){
		System.out.println(dan + " * " + i + " = " + dan * i);
		}
	}
	--%>
	
</body>
</html>