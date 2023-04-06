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
	<div class="container mt-4">
		<h1>Edit Book</h1>
		<form:form action="/books/${book.id}" method="post" modelAttribute="book">
		    <input type="hidden" name="_method" value="put">
		   <p>
		        <form:label path="title" class="form-label">Title</form:label>
		        <form:errors path="title" />
		        <form:input path="title" class="form-control"/>
		    </p>
		    <p>
		        <form:label path="description" class="form-label">Description</form:label>
		        <form:errors path="description"/>
		        <form:textarea path="description" class="form-control"/>
		    </p>
		    <p>
		        <form:label path="language" class="form-label">Language</form:label>
		        <form:errors path="language"/>
		        <form:input path="language" class="form-control"/>
		    </p>
		    <p>
		        <form:label path="numberOfPages" class="form-label">Pages</form:label>
		        <form:errors path="numberOfPages"/>     
		        <form:input type="number" path="numberOfPages" class="form-control"/>
		    </p>    
		    <input type="submit" value="Submit" class="btn btn-primary"/>
		</form:form>
	</div>
</body>
</html>