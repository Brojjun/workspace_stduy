<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var = "msg" value = "안녕하세요" scope="page" />
	<c:set var = "msg" value = "ㅎㅇㅎㅇ" scope="request" />
	
	<div>${msg}</div>
	<div><c:out value="${msg}" /></div>
	<div><c:out value = "${requestScope.msg}" /></div>
	
</body>
</html>