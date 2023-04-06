<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<!--------------------------HEADER----------------------------------------->

<div class="container mt-4">
<!--------------------------CONTAINER----------------------------------------->
<h1 class="text-center">Home Page</h1>
<a href="/products/new">New Product</a><br />
<a href="categories/new">New Category</a>
<hr />
<table class="table table-bordered text-center">
	<thead >
		<tr>
			<th>Product</th>
			<th>Categories</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>
				<ul>
					<c:forEach var="product" items="${products}">
						<li><a href="products/<c:out value="${product.id}"/>"> <c:out value="${product.name}"/> $<c:out value="${product.price}"/></a></li>
					</c:forEach>
				</ul>
			</td>
			<td>
				<ul>
					<c:forEach var="category" items="${categories}">
						<li><a href="categories/<c:out value="${category.id}"/>"><c:out value="${category.name}"/></a></li>
					</c:forEach>
				</ul>
			</td>
		</tr>
	</tbody>

</table>












<!-------------------------------------------------------------------------->

</div>
</body>
</html>