<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category Details</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<!--------------------------HEADER----------------------------------------->

<div class="container mt-4">
<!--------------------------CONTAINER----------------------------------------->
<h1 class="text-center">New Product</h1>
<a href="/">Home</a>
<hr/>

<h3>Products:</h3>
<ul>
	<c:forEach var="product" items="${assignedProducts}">
		<li><c:out value="${product.name}"></c:out></li>
	</c:forEach>
</ul>
<hr>
<form action="/categories/${id}" method="post">
	<h4>Add Product:</h4>				
	<select name="productId" id="productId" class="input">
	    <c:forEach var="product" items="${unassignedProducts}">
	    	<option value="${product.id}">${product.name}</option>
	    </c:forEach>
	</select>
	<input class="input" class="button" type="submit" value="Add"/>
</form>

<!-------------------------------------------------------------------------->
</div>
</body>
</html>