<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page
	import="java.util.*, java.text.*, com.cheer.web.domain.*, com.cheer.web.service.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
</style>
<title>EmpManagerSystem</title>
</head>
<body>

	<%
	    EmpService empService = (EmpService)application.getAttribute("empService");
	    pageContext.setAttribute("empList", empService.getAll());
	%>
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
		<c:forEach var="emp" items="${empList}">
			<tr>
				<td>${emp.empno}</td>
				<td>${emp.ename}</td>
				<td>${emp.job}</td>
				<td>${emp.hiredate}</td>
				<td>${emp.sal}</td>
				<td><a href="servlet/delEmp?empno=${emp.empno}">delete</a></td>
				<td><a href="update.jsp">update</a></td>
			</tr>
		</c:forEach>

	</table>
	<br>
	<div align="center">
		<a href="insert.jsp">InsertInto</a>
	</div>

</body>
</html>