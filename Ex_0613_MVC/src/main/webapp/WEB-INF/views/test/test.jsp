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
	<p>${ ip }님 환영합니다.</p>
	
	<ul>
		<c:forEach var="g" items="${ list }">
			<li>${ g }</li>
		</c:forEach>
	</ul>
</body>
</html>