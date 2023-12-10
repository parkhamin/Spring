<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

	<script src="/ajax/resources/js/httpRequest.js"></script>
	<!-- <script src="${pageContext.request.contextPath}/resources/js/httpRequest.js"></script> -->
	
	<script>
		function del(idx){
			//idx -> 삭제하고싶은 회원의 번호
			if( !confirm("정말로 삭제 하시겠습니까?") ){
				return;
			}
			
			let url = "member_del.do";
			let param = "idx=" + idx;
			sendRequest(url, param, resultFn, "GET");
		}
		
		//콜백메서드
		function resultFn(){
			
			if( xhr.readyState==4 && xhr.status == 200 ){
				
				let data = xhr.responseText;

				if( data == "1" ){
					alert("삭제성공");
				}else{
					alert("삭제실패");
				}
				
				location.href="list.do";
				
			}
			
		}
	</script>

</head>
<body>
	<table border="1" align="center">
		<caption>회원 목록</caption>
		
		<tr>
			<td colspan="6" align="center">
				<input type="button" value="가입하기" onclick="location.href='member_insert_form.do'">
			</td>
		</tr>
		
		<tr>
			<th>회원번호</th>
			<th>이름</th>
			<th>아이디</th>
			<th>비밀번호</th>
			<th colspan="2">주소</th>
		</tr>
		
		<c:forEach var="vo" items="${ list }">
			<tr>
				<td>${vo.idx }</td>
				<td>${vo.name }</td>
				<td>${vo.id }</td>
				<td>${vo.pwd }</td>
				<td>${vo.addr }</td>
				
				<td>
					<input type="button" value="삭제" onclick="del('${vo.idx}')"/>
				</td>				
			</tr>
		</c:forEach>
		
	</table>
</body>
</html>
















