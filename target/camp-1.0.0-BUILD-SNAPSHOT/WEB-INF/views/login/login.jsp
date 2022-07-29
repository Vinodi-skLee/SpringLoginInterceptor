<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href='../resources/css/App.css' />
</head>

<body>
	<div style='width: 100%; text-align: center; padding-top: 30px'>
		<img src='./img/comment_bg2.jpg' height="500">
		<br></br>
		<form method="post" action="login/loginOk">
			<div>
				<label>아이디  :</label><input type='text' name='userid' />
			</div>
			<div>
				<label>비밀번호 :</label> <input type='password' name='password' />
			</div>
			<br>

			<button type="submit" class="btn btn-primary">로그인</button>
			<button type="button" class="btn btn-primary" onclick="location.href='login/signin'">회원가입</button>
		</form>
		
	</div>
</body>
</html>