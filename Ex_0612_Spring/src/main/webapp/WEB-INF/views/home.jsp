<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<!-- EL(Expression Language) : jsp에서 사용하는 스크립트 릿을 없애고 더 간결하게 
     값을 저장하고 불러오기 위한 용도의 표현 언어
     
     EL표기법을 사용하려면 아래 네 가지의 영역 중 한 가지에 저장을 해야한다
     
     1) page영역 : 현재 페이지에서만 값을 공유
     2) request영역 : 지역변수 개념으로 페이지가 닫히면 종료.
                     최대 두 개의 페이지에서 값을 공유
     3) session영역 : 브라우저가 완전히 종료되기 전까지는 값을 유지
                     같은 웹브라우저에서 모두 값을 공유
     4) application영역 : 현재 프로젝트의 브라우저에서 값을 공유 
-->

<%
	//EL표현식 접근방법
	//${표현영역.키값}
	String msg = "안녕";
	request.setAttribute("msg", msg);
	request.setAttribute("msg2", "나는 msg2야");
	
	HttpSession session = request.getSession();
	session.setAttribute("msg", "나는 세션");
%>

<P>  The time on the server is ${serverTime}. </P>
${ hi }<br>
${ requestScope.msg }<br>
${ msg2 }<br>
${ msg }
<!-- 영역생략시 참조 순서
1. pageScope
2. requestScope
3. sessionScope
4. applicationScope -->
</body>
</html>
