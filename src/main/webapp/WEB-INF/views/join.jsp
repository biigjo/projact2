<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8"%>
<html>
<head>
	<title>Join</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="joinAction" method="post">
		<table>
			<tr>
				<td>ID : </td>
				<td><input type="text" name="id"/></td>
			</tr>
			<tr>
				<td>PW : </td>
				<td><input type="password" name="pw"/></td>
			</tr>
			<tr>
				<td>Name : </td>
				<td><input type="text" name="name"/></td>
			</tr>
			<tr>
				<td colspan="2"><input style="width:233px;" type="submit" value="작성완료"/></td>
			</tr>
		</table>
	</form>
</body>
</html>
