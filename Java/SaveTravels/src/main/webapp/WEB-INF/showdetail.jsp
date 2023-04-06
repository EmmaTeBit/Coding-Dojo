<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />

</head>
<body>
<div class="container mt-4">

	<h1><c:out value="${travel.expense}"/></h1>
	<p>Vendor: <c:out value="${travel.vendor}"/></p>
	<p>Amount: <c:out value="${travel.amount}"/></p>
	<p>Description: <c:out value="${travel.description}"/></p>
	<a href="/edit/${travel.id}" class="btn btn-primary">Edit</a>
	<a href="/" class="btn btn-warning">Go Back</a>
	
</div>
</body>
</html>