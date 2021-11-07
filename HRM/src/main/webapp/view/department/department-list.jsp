<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html>
<head>
<title>Department Management</title>
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

	<a href="<%=request.getContextPath()%>/newDepartment">ADD
		DEPARTMENT</a>

	<div class="row">
		<div class="container">
			<h3 class="text-center">DEPARTMENT LIST</h3>
			<input type="text" name="searchBar" id="searchBar"
				placeholder="search for an department" />

			<table class="table table-bordered">
				<tr>
					<th>id</th>
					<th>depId</th>
					<th>depName</th>
				</tr>
				<c:forEach var="department" items="${listDepartment}">


					<tr id="${department.id}-${department.depName}">
						<td><c:out value="${department.id}" /></td>
						<td><c:out value="${department.depId}" /></td>
						<td><c:out value="${department.depName}" /></td>
						<td><a
							href="editDepartment?id=<c:out value='${department.id}' />">Edit</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="deleteDepartment?id=<c:out value='${department.id}' />">Delete</a>
							&nbsp;&nbsp;&nbsp;&nbsp; <a
							href="seeDepartmentDetails?id=<c:out value='${department.id}' />">See
								Details</a></td>

					</tr>
				</c:forEach>
			</table>
		</div>
	</div>


	<script>

		var list = []; 

		var count = 1;
		for (var i = 0; i < ${listDepartment.size()}; i++) {
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
		    
		    for (let i = 0; i < ${listDepartment.size()}; i++) {
		    	
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
