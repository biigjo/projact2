<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8"%>
<html>
<head>
	<title>Login</title>
</head>
<body>
	<h1>로그인</h1>
	<form action="loginAction" method="post">
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
				<td colspan="2"><input style="width:215px;" type="submit" value="로그인"/></td>
			</tr>
			<tr>
				<td colspan="2"><input style="width:215px;" type="button" value="회원가입" onclick="location.href='join'"/></td>
			</tr>
		</table>
	</form>
</body>
</html>
