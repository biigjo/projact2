<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8"%>
<html>
<head>
	<title>Admin</title>
</head>
<style>
	table, tr, td {
		border:1px solid #afafaf;
		border-collapse: collapse;
		margin:auto;
		width:600px;
		text-align:center;
	}
	
</style>
<body>
	<div id="body" style="width:800px;">
		<div id="header">
			<h1 style="float:left;">회원관리</h1>
			<button style="margin-left:600px;">로그인</button>
		</div>
		<br/>
		<br/>
		<br/>
		<br/>
		<div id="section">
			<table>
				<tr>
					<td><b>ID</b></td>
					<td><b>PW</b></td>
					<td><b>Name</b></td>
					<td><b>Point</b></td>
					<td><b>수정</b></td>
					<td><b>삭제</b></td>
				</tr>
				<c:forEach var="alllist" items="${list}">
					<tr>
						<td><c:out value="${alllist.id}"/></td>
						<td><c:out value="${alllist.pw}"/></td>
						<td><c:out value="${alllist.name}"/></td>
						<td><c:out value="${alllist.point}"/></td>
						<td><button onclick="location.href='change'">수정</button></td>
						<td><button onclick="location.href='delete'">삭제</button></td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div id="section2">
			<h1>스케줄러관리</h1>
			<button onclick="location.href='start'">스케줄러(20초마다 포인트1 증가)실행 시작</button>
			<button onclick="location.href='end'">스케줄러 실행 종료</button>
		</div>
	</div>
</body>
</html>
