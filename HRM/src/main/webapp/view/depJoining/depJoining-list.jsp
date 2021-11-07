<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>DepJoining Management</title>
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

	<a href="<%=request.getContextPath()%>/newDepJoining">ADD
		DEPJOINING</a>

	<div class="row">
		<div class="container">
			<h3 class="text-center">DEPJOINING LIST</h3>
			<input type="text" name="searchBar" id="searchBar"
				placeholder="search for an depJoining" />

			<table class="table table-bordered">
				<tr>
					<th>id</th>
					<th>department</th>
					<th>employee</th>
					<th>role</th>
				</tr>
				<c:forEach var="depJoining" items="${listDepJoining}">


					<tr
						id="${depJoining.id}-${depJoining.department.depName}">
						<td><c:out value="${depJoining.id}" /></td>
						<td>
						<a href="seeDepartmentDetails?id=<c:out value='${depJoining.department.id}' />">
						<c:out value="${depJoining.department.depName} (${depJoining.department.depId}) " />
						</a>
						</td>
						<td>
						<a href="seeEmployeeDetails?id=<c:out value='${depJoining.employee.id}' />">
						<c:out value="${depJoining.employee.emName} (${depJoining.employee.emId})" />
						</a>
						</td>
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


	<script>

		var list = []; 

		var count = 1;
		for (var i = 0; i < ${listDepJoining.size()}; i++) {
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
		    
		    for (let i = 0; i < ${listDepJoining.size()}; i++) {
		    	
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
