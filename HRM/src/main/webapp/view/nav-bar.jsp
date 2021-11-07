<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<ul class="nav navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listEmployee">EMPLOYEE
						LIST</a></li>
				<li><a href="<%=request.getContextPath()%>/listJob">JOB
						LIST</a></li>
				<li><a href="<%=request.getContextPath()%>/listDepJoining">DEP-JOINING
						LIST</a></li>
				<li><a href="<%=request.getContextPath()%>/listDepartment">DEPARTMENT
						LIST</a></li>
			</ul>
		</div>
	</nav>
</body>
</html>