<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>DepJoining Management</title>
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
				<form action="updateDepJoining" method="post">
					<h3 class="text-center">UPDATE DEPARTMENT</h3>
					<input type="hidden" name="id"
						value="<c:out value='${depJoining.id}' />"> 
						<label for="departmentId">Choose a department:</label> <select
						name="departmentId" id="departmentId" class="chosen">
						<c:forEach var="department" items="${listDepartment}">
							<option value="${department.id}">${department.depName} (${department.depId})</option>
						</c:forEach>
					</select> 
					<label for="employeeId">Choose a employee:</label> <select
						name="employeeId" id="employeeId" class="chosen">
						<c:forEach var="employee" items="${listEmployee}">
							<option value="${employee.id}">${employee.emName} (${employee.emId})</option>
						</c:forEach>
					</select>

					<fieldset class="form-depJoining">
						<label>role</label> <input type="text" class="form-control"
							name="role" required="required">
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
