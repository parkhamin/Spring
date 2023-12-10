<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

 	<script>
 		function send(f){
 			let name = f.name.value;
 			let content = f.content.value;
 			let pwd = f.pwd.value;
 			
 			//유효성 체크
 			if( name == '' ){
 				alert('이름을 입력하세요');
 				return;
 			}
 			
 			if( content == '' ){
 				alert('내용을 입력하세요');
 				return;
 			}
 			
 			if( pwd == '' ){
 				alert('비밀번호를 입력하세요');
 				return;
 			}
 			
 			f.action = "insert.do";
 			f.method = "post";
 			f.submit();//전송
 		}
 	</script>

</head>
<body>
	<form>
		<table border="1" align="center">
			<caption>::: 새 글 작성 :::</caption>
			
			<tr>
				<th>작성자</th>
				<td><input name="name"></td>
			</tr>
			
			<tr>
				<th>내용</th>
				<td><textarea name="content"
				     rows="5" cols="50" style="resize:none;"></textarea></td>
			</tr>
			
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="pwd"></td>
			</tr>
			
			<tr>
				<td colspan="2" align="right">
					<input type="button" value="글쓰기" onclick="send(this.form);">
					<input type="button" value="목록으로" 
					       onclick="location.href='list.do'">
				</td>
			</tr>
			
		</table>
	</form>
</body>
</html>














