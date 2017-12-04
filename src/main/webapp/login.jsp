<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录页面</title>
</head>
<body>
	<div align="center">
		<form action="servlet/login" method="post">
			<table>
				<tr>
					<td>用户名：<input type="text" name="username"></td>
				</tr>
				<tr>
					<td>&nbsp&nbsp&nbsp密码：<input type="text" name="password"></td>
				</tr>
			</table>
			<input type="submit" value="LoginSystem!">
		</form>
	</div>
</body>
</html>