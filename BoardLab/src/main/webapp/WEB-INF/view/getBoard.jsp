<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<header></header>
	
	<main>
		<form action="getBoardList">
		<table border="1">
			<tr>
				<td>제목</td>
				<td><input name="title" type="text" value="${ getboard.title}"/></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${ getboard.writer}</td>
			</tr>
			<tr>
				<td>작성 일자</td>
				<td>${ getboard.regDate }</td>
			</tr>
			<tr>
				<td>조회수</td>
				<td><input type="text" name="hit" value="${ getboard.hit }"></td>
			</tr>
			<tr>
				<td>글 내용</td>
				<td><textarea name="content" cols="40" rows="10">
				${getboard.content}
				</textarea></td>
			</tr>
			<tr>
				<td colspan="2">
				<input type="submit" value="목록">
				</td>
			</tr>
		</table>
		</form>
	</main>
	
	<footer></footer>

</body>
</html>