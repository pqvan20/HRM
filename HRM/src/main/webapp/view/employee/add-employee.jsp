<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Management</title>
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
.popup {
	background: rgba(0, 0, 0, 0.6);
	width: 100%;
	height: 100%;
	position: absolute;
	top: 0;
	display: none;
	justify-content: center;
	align-items: center;
	text-align: center;
}

.popup-content {
	height: 250px;
	width: 500px;
	background: #fff;
	padding: 20px;
	border-radius: 5px;
	position: relative;
}

input {
	margin: 20px auto;
	display: block;
	width: 50%;
	padding: 8px;
	border: 1px solid gray;
}

.close {
	position: absolute;
	top: -15px;
	right: -15px;
	background: #fff;
	height: 20px;
	width: 20px;
	border-radius: 50%;
	box-shadow: 6px 6px 29px -4px rgba(0, 0, 0, 0.75);
	cursor: pointer;
}
</style>
</head>
<body>
	<jsp:include page="../nav-bar.jsp"></jsp:include>
	<br>
	<a class="button" id="button">Add Job</a>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<form action="insertEmployee" method="post">
					<h3 class="text-center">ADD EMPLOYEE</h3>
					<fieldset class="form-department">
						<label>emId</label> <input type="text" class="form-control"
							name="emId" required="required">
					</fieldset>

					<fieldset class="form-department">
						<label>emName</label> <input type="text" class="form-control"
							name="emName" required="required">
					</fieldset>

					<fieldset class="form-department">
						<label>emGender</label> 
						<input type="radio" value="true" name="emGender" checked>Male 
						<input type="radio" value="false" name="emGender"> Female
					</fieldset>

					<fieldset class="form-department">
						<label>emAddress</label> <input type="text" class="form-control"
							name="emAddress" required="required">
					</fieldset>

					<fieldset class="form-department">
						<label>emPhone</label> <input type="text" class="form-control"
							name="emPhone" required="required">
					</fieldset>

					<fieldset class="form-department">
						<label>emEmail</label> <input type="text" class="form-control"
							name="emEmail" required="required">
					</fieldset>

					<fieldset class="form-department">
						<label>emHiredDate</label> <input type="date" class="form-control"
							name="emHiredDate">
					</fieldset>

					<label for="jobId">Choose a job:</label> <select name="jobId"
						id="jobId" class="chosen">
						<c:forEach var="job" items="${listJob}">
							<option value="${job.id}">${job.jobName}(${job.jobId})</option>
						</c:forEach>
					</select>

					<fieldset class="form-department">
						<label>emSalary</label> <input type="number" class="form-control"
							name="emSalary" required="required">
					</fieldset>

					<div class="col text-center">
						<button type="submit" class="btn btn-success">ADD</button>
					</div>
				</form>
			</div>
		</div>
	</div>


	<div class="popup">

		<div class="popup-content">
			<img src="https://i.imgur.com/4gSGEWX.png" alt="Close" class="close">
			<form action="insertJobOfPopUp" method="post">
				<h3 class="text-center">ADD JOB</h3>
				<fieldset class="form-department">
					<label>jobId</label> <input type="text" class="form-control"
						name="jobId" required="required">
				</fieldset>
				<fieldset class="form-department">
					<label>jobName</label> <input type="text" class="form-control"
						name="jobName" required="required">
				</fieldset>
				<div class="col text-center">
					<button type="submit" class="btn btn-success">ADD</button>
				</div>
			</form>
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
