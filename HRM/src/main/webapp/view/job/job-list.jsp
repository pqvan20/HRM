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

<style>
.displayNone {
	display: none;
}
</style>

</head>
<body>
	<jsp:include page="../nav-bar.jsp"></jsp:include>
	<br>

	<a href="<%=request.getContextPath()%>/newJob">ADD JOB</a>

	<div class="row">
		<div class="container">
			<h3 class="text-center">JOB LIST</h3>
			<input type="text" name="searchBar" id="searchBar"
				placeholder="search for a job" />
			<table class="table table-bordered">
				<tr>
					<th>jobId</th>
					<th>jobName</th>
				</tr>
				<c:forEach var="job" items="${listJob}">

					<tr id="${job.id}-${job.jobName}">
						<td><c:out value="${job.jobId}" /></td>
						<td><c:out value="${job.jobName}" /></td>
						<td><a href="editJob?id=<c:out value='${job.id}' />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="deleteJob?id=<c:out value='${job.id}' />">Delete</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="seeJobDetails?id=<c:out value='${job.id}' />">See Details</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

	<script>

		var list = []; 

		var count = 1;
		for (var i = 0; i < ${listJob.size()}; i++) {
			var idName = document.getElementsByTagName('tr')[count].id;
			console.log(idName);
			var index = idName.indexOf("-");
			var id = idName.substring(0, index);
			var name = idName.substring(index + 1, idName.length);
			list.push({ id: id, name: name});
			count++;
		}

		const searchBar = document.getElementById('searchBar');
		searchBar.addEventListener('keyup', (e) => {
		    const searchString = e.target.value.toLowerCase();	
		    
		    for (let i = 0; i < ${listJob.size()}; i++) {
		    	
		    	const display = document.getElementById(list[i].id + "-" + list[i].name);
				
				if(list[i].name.toLocaleLowerCase().includes(searchString)) {
					display.classList.remove("displayNone");
				} 
				else {
					display.classList.add("displayNone");
				}
				}
			});

	</script>

</body>
</html>
