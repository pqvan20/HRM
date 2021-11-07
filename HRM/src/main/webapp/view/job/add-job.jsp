<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Job Management</title>
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
				<form action="insertJob" method="post">
					<h3 class="text-center">ADD JOB</h3>
					<fieldset class="form-group">
						<label>jobId</label> <input type="text" class="form-control"
							name="jobId" required="required">
					</fieldset>
					<fieldset class="form-group">
						<label>jobName</label> <input type="text" class="form-control"
							name="jobName" required="required">
					</fieldset>
					<div class="col text-center">
						<button type="submit" class="btn btn-success">ADD</button>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>
