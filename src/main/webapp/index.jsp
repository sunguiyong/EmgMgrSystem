<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page
	import="java.util.*, java.text.*, com.cheer.web.domain.*, com.cheer.web.service.*"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
</style>
<title>EmpManagerSystem</title>
</head>
<body>
	<table border="1" cellspacing="0" align="center">
		<tr>
			<td>员工编号</td>
			<td>员工姓名</td>
			<td>工作</td>
			<td>雇佣日期</td>
			<td>薪水</td>
			<td>删除</td>
			<td>更新</td>
		</tr>

		<%
		    EmpService empService = (EmpService)application.getAttribute("empService");

		    SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		    for (Emp emp : empService.getAll())
		    {
		%>
		<tr>
			<td><%=emp.getEmpno()%></td>
			<td><%=emp.getEname()%></td>
			<td><%=emp.getJob()%></td>
			<td><%=emp.getHiredate() %></td>
			<td><%=emp.getSal()%></td>
			<td><a href="servlet/delEmp?empno=<%=emp.getEmpno()%>">delete</a></td>
			<td><a href="servlet/updateEmp?empno<%=emp.getEmpno()%>">update</a></td>
		</tr>
		<%
		    }
		%>
		
	</table><br>
	<div align="center">
		<a href="/servlet/insertEmp?empno<%=new Emp().getEmpno()%>">insertInto</a>
	</div>
	
</body>
</html>