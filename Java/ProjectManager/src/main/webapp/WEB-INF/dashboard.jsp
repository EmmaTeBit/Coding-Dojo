<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dashboard</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>

<section class="vh-100 gradient-custom">
<!--------------------------HEADER----------------------------------------->
	<div class="card shadow-2-strong card-registration">
		<div class="d-flex justify-content-between align-items-center card-body p-4 p-md-55">
			<h1 class="fw-bold">Welcome, <c:out value="${user.userName}"/>!</h1>
			<div>
			<div>
				<a href="/logout" class="btn btn-dark center mb-2">Logout</a>
			</div>
			<div>
			</div>
				<a href="/projects/new" class="btn btn-dark">Add New Project</a>
			</div>
		</div>
	</div>
<!--------------------------CONTAINER----------------------------------------->
<div class="d-flex justify-content-evenly">
<div class=" py-5 d-flex justify-content-center">
	<div class="card shadow-2-strong card-registration p-md-5 m-4" style="border-radius: 15px;">
		<div class="card-body p-4 p-md-55">
			<h1 class="text-center h1 fw-bold">All Projects</h1><br />
			<table class="table table-bordered">
					<thead>
						<tr>
							<th>Project</th>
							<th>Team Lead</th>
							<th>Due Date</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="project" items="${projects}">
							<c:if test="${user.id!=project.team.id}">			
							<tr>
								<td><a href="/projects/${project.id}"><c:out value="${project.title}"></c:out></a></td>
								<td><c:out value="${project.user.userName}"></c:out></td>
								<td><c:out value="${project.dueDate}"></c:out></td>
								
								<c:if test="${user==project.user}">
									<td>
										<a href="projects/edit/${project.id}">Edit</a> 
										<a href="projects/delete/${project.id}">delete</a>
									</td>
								</c:if>
								
								<c:if test="${user!=project.user}">
									<td><a href="projects/${project.id}/joinTeam">Join Team</a></td>
								</c:if>								
							</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
		</div>
	</div>
</div>
<!------------------------------------------------------------------->
<div class=" py-5 d-flex justify-content-center">
	<div class="card shadow-2-strong card-registration p-md-5 m-4" style="border-radius: 15px;">
		<div class="card-body p-4 p-md-55">
			<h1 class="text-center h1 fw-bold">Your Projects</h1><br />
			<table class="table table-bordered">
					<thead>
						<tr>
							<th>Project</th>
							<th>Team Lead</th>
							<th>Due Date</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="project" items="${projects}">
							<c:if test="${user.id==project.team.id}">					
							<tr>
								<td><a href="/projects/${project.id}"><c:out value="${project.title}"></c:out></a></td>
								<td><c:out value="${project.user.userName}"></c:out></td>
								<td>EMTPY FOR NOW DATE</td>
								
								
								<c:if test="${user!=project.user}">
									<td><a href="projects/${project.id}/leave">Leave team</a></td>
								</c:if>
							</tr>
							</c:if>
						</c:forEach>
					</tbody>
				</table>
		</div>
	</div>
</div>
</div>

<!------------------------------------------------------------------->
</section>
</body>
</html>