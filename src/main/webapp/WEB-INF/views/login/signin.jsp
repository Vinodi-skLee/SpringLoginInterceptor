<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href='../resources/css/App.css' />
</head>
<body>
	<div class="formstyle">
		<h2 class="form_tit">회원가입</h2>
		<form action="signinok" method="post">
			<table id="signin">
				<tr>
					<td>닉네임</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>아이디</td>
					<td><input type="text" name="userid" /></td>
				</tr>
				<tr>
					<td>비밀번호</td>
					<td><input type="text" name="password" /></td>
				</tr>
				<tr>
					<td><input class="btn btn-primary" type="button" value="돌아가기" onclick="history.back()" />
					<td align="right"><input class="btn btn-primary" type="submit"
						value="등록하기" /></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>