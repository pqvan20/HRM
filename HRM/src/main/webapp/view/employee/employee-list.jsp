<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Employee List</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<style>
.displayNone {
	display: none;
}

#searchBar {
	width: 230px;
}
</style>

</head>
<body>
	<jsp:include page="../nav-bar.jsp"></jsp:include>
	<br>

	<a href="<%=request.getContextPath()%>/newEmployee">ADD EMPLOYEE</a>

	<div class="row">
		<div class="container">
			<h3 class="text-center">EMPLOYEE LIST</h3>
			<input type="text" name="searchBar" id="searchBar"
				placeholder="Search for an employee by name" />

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


	<script>

		var list = [];

		var count = 1;
		for (var i = 0; i < ${listEmployee.size()}; i++) {
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
		    
		    for (let i = 0; i < ${listEmployee.size()}; i++) {
		    	
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
