<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- JSTL : JavaScript Tag Library
	 for, if 등 반복문이나 제어문 등을 jsp 내부에서 사용할 수 있도록 하는 기능 -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	과일목록
	
	<hr>
	
	<c:forEach var="f" items="${ fru }">
		${ f }<br>
	</c:forEach>
	
	<hr>
	
	친구목록<br>
	<table border="1">
		<c:forEach var="f" items="${ flist }">
			<tr>
				<td>${ f }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>