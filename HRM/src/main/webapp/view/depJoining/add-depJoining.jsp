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
<link rel="stylesheet" href="css/style.css" />
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/themes/smoothness/jquery-ui.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.8.7/chosen.jquery.min.js"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/chosen/1.8.7/chosen.min.css" />

<style>
</style>
</head>
<body>
	<jsp:include page="../nav-bar.jsp"></jsp:include>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="insertDepJoining" method="post">
					<h3 class="text-center">ADD DEPJOINING</h3>

					<label for="departmentId">Choose a department:</label> <select
						name="departmentId" id="departmentId" class="chosen">
						<c:forEach var="department" items="${listDepartment}">
							<option value="${department.id}">${department.depName}
								(${department.depId})</option>
						</c:forEach>
					</select> <br> <label for="employeeId">Choose a employee:</label> <select
						name="employeeId" id="employeeId" class="chosen">
						<c:forEach var="employee" items="${listEmployee}">
							<option value="${employee.id}">${employee.emName}
								(${employee.emId})</option>
						</c:forEach>
					</select>

					<fieldset class="form-depJoining">
						<label>role</label> <input type="text" class="form-control"
							name="role" required="required">
					</fieldset>

					<div class="col text-center">
						<button type="submit" class="btn btn-success">ADD</button>
					</div>
				</form>
			</div>
		</div>
	</div>

	<script type="text/javascript">
		$(".chosen").chosen();

		document.getElementById("button").addEventListener("click", function() {
			document.querySelector(".popup").style.display = "flex";
		})

		document.querySelector(".close").addEventListener("click", function() {
			document.querySelector(".popup").style.display = "none";
		})
	</script>

</body>
</html>
