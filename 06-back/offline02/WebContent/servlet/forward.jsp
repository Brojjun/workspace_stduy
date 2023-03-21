<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@
page import="java.util.Date" 
 %>
 
<%
	String msg = (String)request.getAttribute("msg");
	Date date = (Date)request.getAttribute("time");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>공유된 메세지 : <%= msg %></h2>
	<h2>공유된 시간 : <%= date %></h2>
</body>
</html>