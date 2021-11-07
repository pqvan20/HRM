<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Details</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="../nav-bar.jsp"></jsp:include>
	<br>
	<div class="row">
		<div class="container">

			<h3 class="text-center">DEPARTMENT DETAILS</h3>

			<table class="table table-bordered">
				<tr>
					<th>id</th>
					<td><c:out value="${department.id}" /></td>
				</tr>
				<tr>
					<th>depId</th>
					<td><c:out value="${department.depId}" /></td>
				</tr>
				<tr>
					<th>depName</th>
					<td><c:out value="${department.depName}" /></td>
				</tr>
			</table>
		</div>
	</div>

	<div class="row">
		<div class="container">
			<h3 class="text-center">EMPLOYEES IN THE SAME DEPARTMENT</h3>
			<table class="table table-bordered">
				<tr>
					<th>id</th>
					<th>department</th>
					<th>employee</th>
					<th>role</th>
				</tr>
				<c:forEach var="depJoining" items="${listDepJoining}">


					<tr id="${depJoining.id}-${depJoining.department.depName}">
						<td><c:out value="${depJoining.id}" /></td>
						<td><a
							href="seeDepartmentDetails?id=<c:out value='${depJoining.department.id}' />">
								<c:out
									value="${depJoining.department.depName} (${depJoining.department.depId}) " />
						</a></td>
						<td><a
							href="seeEmployeeDetails?id=<c:out value='${depJoining.employee.id}' />">
								<c:out
									value="${depJoining.employee.emName} (${depJoining.employee.emId})" />
						</a></td>
						<td><c:out value="${depJoining.role}" /></td>


						<td><a
							href="editDepJoining?id=<c:out value='${depJoining.id}' />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="deleteDepJoining?id=<c:out value='${depJoining.id}' />">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>