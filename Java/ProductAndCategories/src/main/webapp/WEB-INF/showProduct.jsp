<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Details</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<!--------------------------HEADER----------------------------------------->

<div class="container mt-4">
<!--------------------------CONTAINER----------------------------------------->
<h1 class="text-center">${product.name}</h1>
<a href="/">Home</a>
<hr/>

<h3>Categories:</h3>
<ul>
	<c:forEach var="category" items="${assignedCategories}">
		<li><c:out value="${category.name}"></c:out></li>
	</c:forEach>
</ul>
<hr>
<form action="/products/${id}" method="post">
	<h4>Add Category:</h4>				
	<select name="categoryId" id="categoryId" class="input">
	    <c:forEach var="category" items="${unassignedCategories}">
	    	<option value="${category.id}">${category.name}</option>
	    </c:forEach>
	</select>
	<input class="input" class="button" type="submit" value="Add"/>
</form>

<!-------------------------------------------------------------------------->
</div>
</body>
</html>