<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task</title>
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
				<a href="/dashboard" class="btn btn-dark">Dashboard</a>
			</div>
		</div>
	</div>
<!--------------------------CONTAINER----------------------------------------->
	<div class="card shadow-2-strong card-registration p-md-5 m-4" style="border-radius: 15px;">
		<div class="card-body">
			<h1 class="fw-bold"><c:out value="${project.title}"/></h1>
			<p>Project Lead: <c:out value="${project.user.userName}"/></p>
			<p>Description: <c:out value="${project.description}"/> </p> <br/><hr />
<!------------------------------------------------------------------->
 		<form:form action="/tasks" modelAttribute="task" class="form" method="post">		
<%-- 			<div class="form-row">
				<form:label for="task" path="title">Add a task for this team:</form:label>
			 	<form:errors path="task" class="error"/>
				<form:textarea path="task" type="text" class="form-control"/>
			</div> --%>

			<div class="d-flex justify-content-between mt-2">
				<div class="form-row">
					<input type="submit" value="Add Task" class="btn btn-dark"/>
				</div>
				<a href="/dashboard" class="btn btn-dark">Cancel</a>
			</div>			
		</form:form>
<!------------------------------------------------------------------->
		
	<h3>Task:</h3>
	<c:forEach var="task" items="${task}">
		<td><c:out value="${task.user.userName}"></c:out></td>
	</c:forEach>
<!------------------------------------------------------------------->
		
		</div>
	</div>
</section>
</body>
</html>