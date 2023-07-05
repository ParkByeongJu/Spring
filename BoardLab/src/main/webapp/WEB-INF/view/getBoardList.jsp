<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<header></header>
	
	<main>
		<table border="1">
			<tr>
				<td>No.</td><td>TITLE</td><td>WRITER</td><td>DATE</td><td>HIT</td>
			</tr>
			<c:forEach var="board" items="${ boardList }">
				<tr>
					<td>${ board.seq }</td>
				<td> <a href="getBoard.do?seq=${ board.seq }"> ${ board.title }</a></td> 
					<td>${ board.writer }</td>
					<td>${ board.regDate }</td>
					<td>${ board.hit }</td>
				</tr>
			</c:forEach>
		</table>	
	</main>
	
	<footer></footer>

</body>
</html>