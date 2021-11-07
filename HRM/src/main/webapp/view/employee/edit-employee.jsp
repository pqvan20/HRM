<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Edit Employee</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
	<jsp:include page="../nav-bar.jsp"></jsp:include>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="updateEmployee" method="post">
					<h3 class="text-center">UPDATE EMPLOYEE</h3>
					<input type="hidden" name="id"
						value="<c:out value='${employee.id}' />">

					<fieldset class="form-department">
						<label>emId</label> <input type="text"
							value="<c:out value='${employee.emId}'/>" class="form-control"
							name="emId" required="required">
					</fieldset>

					<fieldset class="form-department">
						<label>emName</label> <input type="text"
							value="<c:out value='${employee.emName}'/>" class="form-control"
							name="emName" required="required">
					</fieldset>

					<fieldset class="form-department">
						<label>emGender</label> <br> <input type="radio" value="true"
							name="emGender" checked> Male <input type="radio"
							value="false" name="emGender"> Female
					</fieldset>

					<fieldset class="form-department">
						<label>emAddress</label> <input type="text"
							value="<c:out value='${employee.emAddress}' />"
							class="form-control" name="emAddress" required="required">
					</fieldset>

					<fieldset class="form-department">
						<label>emPhone</label> <input type="text"
							value="<c:out value='${employee.emPhone}' />"
							class="form-control" name="emPhone" required="required">
					</fieldset>

					<fieldset class="form-department">
						<label>emEmail</label> <input type="text"
							value="<c:out value='${employee.emEmail}' />"
							class="form-control" name="emEmail" required="required">
					</fieldset>

					<fieldset class="form-department">
						<label>emHiredDate</label> <input type="date"
							value="<c:out value='${employee.emHiredDate}' />"
							class="form-control" name="emHiredDate" required="required">
					</fieldset>

					<label for="jobId">Choose a car:</label> <select name="jobId"
						id="jobId" class="chosen">
						<c:forEach var="job" items="${listJob}">
							<option value="${job.id}">${job.jobName} (${job.jobId})</option>
						</c:forEach>
					</select>

					<fieldset class="form-department">
						<label>emSalary</label> <input type="text"
							value="<c:out value='${employee.emSalary}' />"
							class="form-control" name="emSalary" required="required">
					</fieldset>

					<div class="col text-center">
						<button type="submit" class="btn btn-success">UPDATE</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
