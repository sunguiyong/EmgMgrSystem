<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>InsertEmp</title>
</head>
<body>
	<div align="center">
		<form action="servlet/insertEmp" method="post">
			<table>
				<tr>
					<td>empno:<input type="text" name="empno" ><td>			
				</tr>
				<tr>
					<td>ename:<input type="text" name="ename" ><td>
				</tr>
			</table>
			<input type="submit" name="submit" value="InsertIntoEmp!">
		</form>
	
	</div>
</body>
</html>