<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html>

<head>
	<title> Save Task</title>
	
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
		
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
				
</head>


<body>

	<div id="wrapper">
		<div id="header">
			<h2>Task Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Customer</h3>
		
		<form:form action="saveTask" modelAttribute="task" method="POST">
		
		<!-- need to associate this data with customer id -->
		<form:hidden path="id"/>
		
			<table>
				<tbody>
					<tr>
						<td><label> Task name:</label></td>
						<td><form:input path="name" /></td>
					</tr>
					
					<tr>
						<td><label> Priority level:</label></td>
						<td><form:input path="priority" /></td>
					</tr>
						
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class=save></td>
					</tr>									
				</tbody>
			</table>
		</form:form>
		
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/task/list">Back to List</a>
		</p>
	</div>
</body>



</html>