<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Book</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>
	<div class="container mt-4">
		<h1>New Book</h1>
		<form:form action="/books" method="post" modelAttribute="book">
			<div class="mb-3">
				<form:label class="form-label" path="title">Title</form:label>
				<form:errors path="title" class="text-danger"/>
				<form:input class="form-control" path="title" />
			</div>
			<div class="mb-3">
				<form:label class="form-label" path="description">Description</form:label>
				<form:errors path="description" class="text-danger"/>
				<form:input class="form-control" path="description" />
			</div>
			<div class="mb-3">
				<form:label class="form-label" path="language">Language</form:label>
				<form:errors path="language" class="text-danger"/>
				<form:input class="form-control" path="language" />
			</div>
			<div class="mb-3">
				<form:label class="form-label" path="numberOfPages">Number of Pages</form:label>
				<form:errors path="numberOfPages" class="text-danger"/>
				<form:input class="form-control" path="numberOfPages" type="number"/>
			</div>
			<input class="btn btn-primary" type="submit" value="Submit" />
		</form:form>
	
	</div>
	

















</body>
</html>