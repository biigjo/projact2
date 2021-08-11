<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" pageEncoding="utf-8"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<title>Main</title>
</head>
<style>
	#img>table td {
		text-align:center;
	}
</style>
<body>
	<div id=body style="width:1075px;">
		<div id="header">
			<div style="float:left;"><h1>메인페이지</h1></div>
			<div style="margin-left:750px;">
				<br/>
				<br/>
				<b>${dto.name }(${dto.id})님 안녕하세요.</b>
				<button onclick="location.href='logout'">로그아웃</button>
				<br/>
				<b>포인트 : ${dto.point}</b>	
			</div>
		</div>
		<br/>
		<div id="section">
			<h4>구입할 컨텐츠를 선택하세요.</h4>
			<div id="img">
				<table>
					<tr>
						<td id="intro" style="cursor:pointer;">
							<input type="hidden" id="num" value="100000"/><img src="resources/img/Intro_350_408.png" style="width:350px; height:408px;"/></a>
						</td>
						<td>
							<img src="resources/img/Java_350_408.png" style="width:350px; height:408px;"/>
						</td>
						<td>
							<img src="resources/img/Cpp_350_408.png" style="width:350px; height:408px;"/>
						</td>
					</tr>
					<tr>
						<td><p>100,000포인트</p></td>
						<td><p>500,000포인트</p></td>
						<td><p>300,000포인트</p></td>
					</tr>
				</table>
			</div>
			<br/>
			<br/>
			<div id="logo" style="text-align:right;">
				<a>
					<img style="border:1px solid #afafaf;" src="resources/img/korea_it.png"/>
				</a>
			</div>	
		</div>
	</div>
	<script>
		$("#intro").click(function() {
			var point = $("#num").val();
			ajax
		});
	</script>
</body>
</html>