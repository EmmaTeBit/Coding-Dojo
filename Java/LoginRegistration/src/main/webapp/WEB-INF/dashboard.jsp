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
<section class="vh-100 gradient-custom p-4">
	<div class="container">
<!------------------------------------------------------------------->
		<div class="d-flex justify-content-between">
		<div class="card shadow-2-strong card-registration" style="border-radius: 15px;">
		
			<div class="card-body">
				<h1>Welcome, <c:out value="${user.userName}"/>!</h1>
				<p>This is your dashboard</p>
				<a href="/logout" class="btn btn-dark">Logout</a>
			</div>
			</div>
		</div>







<!------------------------------------------------------------------->
	</div>
</section>
</head>
<body>

</body>
</html>