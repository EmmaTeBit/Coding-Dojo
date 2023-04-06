<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book Details</title>
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
	<div class="card shadow-2-strong card-registration p-md-5 m-4" style="border-radius: 15px;">
		<div class="card-body">
			<h1 class="fw-bold"><c:out value="${book.title}"/></h1>
			<p>Author: <c:out value="${book.author}"/> </p> <br/>

			<p><c:out value="${book.user.userName}"/> read <c:out value="${book.title}"/> by <c:out value="${book.author}"/> </p>

			<p> Here are <c:out value="${book.user.userName}"/>'s thoughts:</p>
			<hr/>
			<p><c:out value="${book.thoughts}"/></p>
			<hr/>
		</div>
	</div>
<!------------------------------------------------------------------->
</section>
</body>
</html>