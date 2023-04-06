<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>

	<h1>Fruit Store</h1>
	<div class="container">
		<table class="table table-danger">
		  <thead class="table">
		    <tr>
		      <th scope="col">Name</th>
		      <th scope="col">Price</th>
		    </tr>
		  </thead>
		  <!-- --------Table Data -->
	<c:forEach var="fruits" items="${fruitsFromController}">
		  <tr>
		  	<td>${fruits.name}</td>
		  	<td>${fruits.price}</td>
		  </tr>
	</c:forEach>
	
		</table>
	</div>
	
</body>
</html>