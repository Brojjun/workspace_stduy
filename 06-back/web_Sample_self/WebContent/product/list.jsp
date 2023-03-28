<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/include/head.jsp"%>
</head>
<body>
	<%@ include file="/include/nav.jsp"%>

	<%-- 페이지만의 내용 --%>
	<table>
		<tr>
			<th>Code</th>
			<th>Model</th>
			<th>Price</th>
		</tr>
		<c:forEach var="data" items="${products}">
			<tr>
				<td><a href="${root}/product?action=deatil&code=${data.code}">${data.code}</a></td>
				<td>${data.model}</td>
				<td>${data.price}</td>
			</tr>
		</c:forEach>
	</table>
	<%-- --%>
	<%@ include file="/include/footer.jsp"%>