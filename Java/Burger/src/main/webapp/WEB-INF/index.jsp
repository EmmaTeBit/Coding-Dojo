<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="container mt-4 ">
	<h1>Burger Tracker</h1>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Burger Name</th>
				<th>Restaurant Name</th>
				<th>Ratings (out of 5)</th>
				<th>Action</th>


			</tr>
		</thead>
		<tbody>
			<c:forEach var="burger" items="${burgers}">
				<tr>
					<td><c:out value="${burger.name}"/></td>
					<td><c:out value="${burger.restaurant}"/></td>
					<td><c:out value="${burger.rating}"/></td>
					<td class="d-flex justify-content-evenly">
						<a href="edit/${burger.id}" class="btn btn-primary">Edit</a>
						<form action="/burgers/${burger.id}" method="post">
		    				<input type="hidden" name="_method" value="delete">
		   				 	<input type="submit" value="Delete" class="btn btn-danger">
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<br>
<!-- -----------------------------FORM--------------------------------------------->
		<h2>Add new Burger</h2>
		<form:form action="/createBurger" method="post" modelAttribute="burger">
			<div class="mb-3">
				<form:label path="name" class="form-label" >Burger Name</form:label>
				<form:errors path="name" class="text-danger"/>
				<form:input path="name" class="form-control"  />
			</div>
			<div class="mb-3">
				<form:label path="restaurant" class="form-label">Restaurant Name</form:label>
				<form:errors path="restaurant" class="text-danger"/>
				<form:input path="restaurant" class="form-control"/>
			</div>
			<div class="mb-3">
				<form:label path="rating" class="form-label" >Rating</form:label>
				<form:errors path="rating" class="text-danger"/>
				<form:input path="rating" class="form-control" type="number" />
			</div>
			<div class="mb-3">
				<form:label path="notes" class="form-label" >Notes</form:label>
				<form:errors path="notes" class="text-danger"/>
				<form:textarea path="notes" rows="3" class="form-control"/>
			</div>
			<input class="btn btn-primary" type="submit" value="Submit" />
		</form:form>

<!-- -------------------------------------------------------------------------->

</div>


























</body>
</html>