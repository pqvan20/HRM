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

			<h3 class="text-center">JOB DETAILS</h3>

			<table class="table table-bordered">
				<tr>
					<th>id</th>
					<td><c:out value="${job.id}" /></td>
				</tr>
				<tr>
					<th>jobId</th>
					<td><c:out value="${job.jobId}" /></td>
				</tr>
				<tr>
					<th>jobName</th>
					<td><c:out value="${job.jobName}" /></td>
				</tr>
			</table>
		</div>
	</div>

	<div class="row">
		<div class="container">
			<h3 class="text-center">EMPLOYEES HAVE THIS JOB</h3>

			<table class="table table-bordered">
				<tr>
					<th>id</th>
					<th>emId</th>
					<th>emName</th>
					<th>emGender</th>
					<th>emAddress</th>
					<th>emPhone</th>
					<th>emEmail</th>
					<th>emHiredDate</th>
					<th>jobId</th>
					<th>emSalary</th>
				</tr>
				<c:forEach var="employee" items="${listEmployee}">


					<tr id="${employee.id}-${employee.emName}"
						class="${employee.emName}${employee.id}">
						<td><c:out value="${employee.id}" /></td>
						<td><c:out value="${employee.emId}" /></td>
						<td><c:out value="${employee.emName}" /></td>
						<td><c:out value="${employee.emGender?'Male':'Female'}" /></td>
						<td><c:out value="${employee.emAddress}" /></td>
						<td><c:out value="${employee.emPhone}" /></td>
						<td><c:out value="${employee.emEmail}" /></td>
						<td><fmt:formatDate value="${employee.emHiredDate}"
								pattern="dd-MM-yyyy" /></td>
						<td><c:out
								value="${employee.job.jobName} (${employee.job.jobId})" /></td>
						<td><c:out value="${employee.emSalary}" /></td>
						<td><a
							href="editEmployee?id=<c:out value='${employee.id}' />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="deleteEmployee?id=<c:out value='${employee.id}' />">Delete</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="seeEmployeeDetails?id=<c:out value='${employee.id}' />">See
								Details</a></td>

					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>