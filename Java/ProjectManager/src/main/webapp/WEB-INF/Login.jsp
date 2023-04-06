<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login and Registration</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<section class="vh-100 gradient-custom">
<!--------------------------HEADER----------------------------------------->
	<div class="card shadow-2-strong card-registration">
		<div class="card-body p-4 p-md-55">
			<h1 class="text-center h1 fw-bold">Project Manager</h1>
			<p class="text-center mb-4">A place for teams to manage projects</p>
		</div>
	</div>
<!--------------------------CONTAINER----------------------------------------->
<div class=" py-5 d-flex justify-content-center">
 <!-----------------------CARDBODY------------------------------------------->
	<div class="card shadow-2-strong card-registration p-md-5 m-4" style="border-radius: 15px;">
		<div class="card-body p-4 p-md-55">
			<h1 class="text-center h1 fw-bold">Welcome!</h1>
		<!--------------------------REGISTRATION----------------------------------------->
<form:form action="/register" method="post" modelAttribute="newUser">
	<label class="form-label">Username</label><br />
		<form:errors path="userName" class="error"/>
		<form:input path="userName" class="form-control form-control-lg"/>

	<label class="form-label">Email</label><br />

		<form:errors path="email" class="error"/>
		<form:input path="email" class="form-control form-control-lg"/>

	<label class="form-label">Password</label><br />
		<form:errors path="password" class="error"/>
		<form:input path="password" type="password" class="form-control form-control-lg"/>

	<label class="form-label">Confirm Password</label><br />
		<form:errors path="confirm" class="error"/>
		<form:input path="confirm" type="password" class="form-control form-control-lg"/>
		<input class="btn btn-dark mt-4" type="submit" value="Register"/>
</form:form>
		</div>
	</div>
 	<!-------------------------Login CARDBODY------------------------------------------>
<div class="card shadow-2-strong card-registration p-md-5 m-4" style="border-radius: 15px;">
	<div class="card-body p-4 p-md-5">
		<h1 class="text-center h1 fw-bold mb-4">Login</h1>
		<!--------------------------Login----------------------------------------->
<form:form action="/login" method="post" modelAttribute="newLogin">
	<label class="form-label">Email</label><br />
		<form:errors path="email" class="error"/>
		<form:input path="email" class="form-control form-control-lg"/>

	<label class="form-label">Password</label><br />
		<form:errors path="password" class="error"/>
		<form:input path="password" type="password" class="form-control form-control-lg"/>
		<input class="btn btn-dark mt-4" type="submit" value="Login"/>
</form:form>
	</div>
</div>
<!------------------------------------------------------------------->
	</div>
 </section>
  <!------------------------------------------------------------------->
</body>
</html>