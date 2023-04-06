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
<!-- -----------------------------FORM--------------------------------------------->
<div class="container mt-4">
	<div class="d-flex justify-content-between">
			<h2>Edit Burger</h2>
			<a href="/" class="btn btn-warning">Go Back</a>
	</div>
		<form:form action="/edit/${travel.id}" mode="put" modelAttribute="travel">
			<div class="mb-3">
				<form:label path="expense" class="form-label" >Expense</form:label>
				<form:errors path="expense" class="text-danger"/>
				<form:input path="expense" class="form-control"/>
			</div>
			<div class="mb-3">
				<form:label path="vendor" class="form-label">Vendor</form:label>
				<form:errors path="vendor" class="text-danger"/>
				<form:input path="vendor" class="form-control"/>
			</div>
			<div class="mb-3">
				<form:label path="amount" class="form-label" >Rating</form:label>
				<form:errors path="amount" class="text-danger"/>
				<form:input path="amount" class="form-control" type="number" />
			</div>
			<div class="mb-3">
				<form:label path="description" class="form-label" >Description</form:label>
				<form:errors path="description" class="text-danger"/>
				<form:textarea path="description" rows="3" class="form-control"/>
			</div>
			<input class="btn btn-primary" type="submit" value="Update" />
		</form:form>
</div>
<!-- -------------------------------------------------------------------------->
</head>
<body>

</body>
</html>