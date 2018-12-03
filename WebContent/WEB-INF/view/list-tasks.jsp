<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>List Customers</title>
	
	<!-- reference our style sheet -->
	
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Task Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
		
		<!-- put new button: Add Task -->
		<input type="button" value="Add Task"
			onclick="window.location.href='showFormForAdd'; return false;"
			class="add-button"
			/>
		
		<!--  add out html table here -->
		
			<table>
				<tr>
					<th>Task Name</th>
					<th>Priority Level</th>
					<th>Action</th>
				</tr>
				
				<!--  loop over and print our customers -->
				<c:forEach var="tempTask" items="${tasks}">
					<!-- construct an "update" link with task id -->
					<c:url var="updateLink" value="/task/showFormForUpdate">
						<c:param name="taskId" value="${tempTask.id}" />
					</c:url>
					
					<!-- construct an "delete" link with task id -->					
					<c:url var="deleteLink" value="/task/delete">
						<c:param name="taskId" value="${tempTask.id}" />
					</c:url>
					<tr>
						<td> ${tempTask.name}</td>
						<td> ${tempTask.priority}</td>					
						<td>
							<!-- display the update link -->
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
								onclick="if(!(confirm('Are you sure you want to delete this task?'))) return false">Delete</a>
						</td>
						
					</tr>
				
				</c:forEach>
			
			</table>
		
		
		
		</div>
	</div>

</body>

</html>