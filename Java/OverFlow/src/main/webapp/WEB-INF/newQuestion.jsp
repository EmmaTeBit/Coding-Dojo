<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<!------------------------------------------------------------------>
<h1>What is your question?</h1>
<p><a href="/">Dashboard</a></p>
<hr>
<p class="error">${error}</p>

<div>
	<form:form action="/questions/new" modelAttribute="question" class="form" method="post">
	
		<div>
		 	<form:errors path="text" class="error"/>
			<form:label for="text" path="text">Question:</form:label>
			<form:textarea rows="4" path="text"/>
		</div>
		
		<div>
			<label for="tags">Tags:</label>
			<input class="input" name="tags"/>
		</div>
		
		<div class="form-row">
			<input type="submit" value="Submit"/>
		</div>
		
	</form:form>
</div>



<!------------------------------------------------------------------>
</body>
</html>