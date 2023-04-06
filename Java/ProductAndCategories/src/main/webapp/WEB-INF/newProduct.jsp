<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Product</title>
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

<form:form action="/products/new" method="post" modelAttribute="product">
	
	<table>
		<thead>
			<tr>
				<td>Name:</td>
				<td>
					<form:errors path="name"/>
					<form:input path="name"/>
				</td>
			</tr>
			<tr>
				<td>Description:</td>
				<td>
					<form:errors path="description"/>
					<form:input path="description"/>
				</td>
			</tr>
			<tr>
				<td>Price:</td>
				<td>
					<form:errors path="price"/>
					<form:input path="price"/>
				</td>
			</tr>
			<tr>
				<td><input type="Submit" value="submit" /> </td>
			</tr>
		</thead>
	
	</table>

</form:form>

<!-------------------------------------------------------------------------->

</div>
</body>
</html>