<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	EL산술연산자<br>
	${ 1 + 1 }<br>
	${ 10 / 3 }<br>
	${ 10 % 3 }<br>
	
	<hr>
	
    EL비교연산자<br>
	${ 3 > 2 } or ${ 3 gt 2 }<br>
	${ 3 < 2 } or ${ 3 lt 2 }<br>
	${ 3 <= 2 } or ${ 3 le 2 }<br>
	${ 3 == 2 } or ${ 3 eq 2 }<br>
	${ 3 != 2 } or ${ 3 ne 2 }<br>
	
	<hr>
	
	EL삼항연산자<br>
	<!-- jsp의 파라미터 : aa.jsp?pa=안녕&age=20 -->
	${ param.pa } / ${ param.age } 
</body>
</html>