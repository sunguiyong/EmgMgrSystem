<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>UpdateEmp</title>
</head>
<body>
	<div align="center">
		<form action="servlet/updateEmp" method="post">
			<table>
				<tr>
					<td>请输入新的empno：<input type="text" name="empno"></td>
				</tr> 
				<tr>
					<td>请输入新的ename：<input type="text" name="ename"></td>
				</tr>
			</table>
			<input type="submit" name="submit" value="UpdateEmp!">
		</form>
	</div>
</body>
</html>