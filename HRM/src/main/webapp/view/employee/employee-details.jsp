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

			<h3 class="text-center">EMPLOYEE DETAILS</h3>

			<table class="table table-bordered">
				<tr>
					<th>emId</th>
					<td><c:out value="${employee.id}" /></td>
				</tr>
				<tr>
					<th>emId</th>
					<td><c:out value="${employee.emId}" /></td>
				</tr>
				<tr>
					<th>emName</th>
					<td><c:out value="${employee.emName}" /></td>
				</tr>
				<tr>
					<th>emGender</th>
					<td><c:out value="${employee.emGender?'Male':'Female'}" /></td>
				</tr>
				<tr>
					<th>emAddress</th>
					<td><c:out value="${employee.emAddress}" /></td>
				</tr>
				<tr>
					<th>emPhone</th>
					<td><c:out value="${employee.emPhone}" /></td>
				</tr>
				<tr>
					<th>emEmail</th>
					<td><c:out value="${employee.emEmail}" /></td>
				</tr>
				<tr>
					<th>emHiredDate</th>
					<td><fmt:formatDate value="${employee.emHiredDate}"
							pattern="dd-MM-yyyy" /></td>
				</tr>
				<tr>
					<th>Job</th>
					<td><c:out
							value="${employee.job.jobName} (${employee.job.jobId})" /></td>
				</tr>
				<tr>
					<th>Salary</th>
					<td><c:out value="${employee.emSalary}" /></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>