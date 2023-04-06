<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<!-- -----------------------------FORM--------------------------------------------->
	<div class="container mt-4">

		<h2>Edit Burger</h2>
		<form:form action="/edit/${burger.id}" mode="put" modelAttribute="burger">
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
			<input class="btn btn-primary" type="submit" value="Update" />
		</form:form>
	</div>

<!---------------------------------------------------------------------------->
</body>
</html>