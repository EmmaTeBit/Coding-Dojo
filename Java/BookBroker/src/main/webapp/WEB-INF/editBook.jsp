<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Book</title>
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
				<a href="/welcome" class="btn btn-dark">Dashboard</a>
			</div>
		</div>
	</div>
<!--------------------------CONTAINER----------------------------------------->
<div class=" py-5 d-flex justify-content-center">
	<div class="card shadow-2-strong card-registration p-md-5 m-4" style="border-radius: 15px;">
		<div class="card-body p-4 p-md-55">
			<h1 class="text-center h1 fw-bold">Change Book Entry</h1>
			
			<form:form action="/books/edit/${book.id}" modelAttribute="book" class="form" method="post">
		
			<div class="form-row">
				<form:label for="title" path="title">Title:</form:label>
			 	<form:errors path="title" class="error"/>
				<form:input type="text" path="title" class="form-control"/>
			</div>
			
			<div class="form-row">
				<form:label for="author" path="author">Author:</form:label>
				<form:errors path="author" class="error"/>
				<form:input type="text" path="author" class="form-control"/>
			</div>
			
			<div class="form-row">
				<form:label for="thoughts" path="thoughts">Thoughts:</form:label>
				<form:errors path="thoughts" class="error"/>
				<form:textarea path="thoughts" class="form-control"/>
			</div>
			
			<div class="form-row">
				<form:errors path="user" class="error"/>
				<form:input type="hidden" path="user" value="${user.id}" class="form-control"/>
			</div>
			<div class="d-flex justify-content-between mt-2">
				<div class="form-row">
					<input type="submit" value="Update" class="btn btn-dark"/>
				</div>
				<a href="/welcome" class="btn btn-dark">Back</a>
			</div>
			
		</form:form>	
			
		</div>
	</div>
</div>
<!------------------------------------------------------------------->
<!------------------------------------------------------------------>
</section>
</body>
</html>