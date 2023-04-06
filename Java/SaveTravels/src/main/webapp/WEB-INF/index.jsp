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
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<div class="container mt-4 mb-4">
	<h1>Save Travels</h1>
	<table class="table table-bordered">
		<thead>
			<tr>
				<th>Expense</th>
				<th>Vendor</th>
				<th>Amount</th>
				<th>Action</th>


			</tr>
		</thead>
		<tbody>
			<c:forEach var="travel" items="${travels}">
				<tr>
					<td>
					<a href="/travels/<c:out value="${travel.id}"></c:out>">
					<c:out value="${travel.expense}"/>
					</a>
					
					
					</td>
					
					<td><c:out value="${travel.vendor}"/></td>
					<td>$<fmt:formatNumber type="number" minFractionDigits="2" value="${travel.amount}"/></td>
					<td class="d-flex justify-content-evenly">
						<a href="edit/${travel.id}" class="btn btn-primary">Edit</a>
						<form action="/travels/${travel.id}" method="post">
		    				<input type="hidden" name="_method" value="delete">
		   				 	<input type="submit" value="Delete" class="btn btn-danger">
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<br>
<!-- -----------------------------FORM--------------------------------------------->
		<h2>Add an Expense</h2>
		<form:form action="/createTravel" method="post" modelAttribute="travel">
			<div class="mb-3">
				<form:label path="expense" class="form-label" >Expense Name</form:label>
				<form:errors path="expense" class="text-danger"/>
				<form:input path="expense" class="form-control"  />
			</div>
			<div class="mb-3">
				<form:label path="vendor" class="form-label">Vendor</form:label>
				<form:errors path="vendor" class="text-danger"/>
				<form:input path="vendor" class="form-control"/>
			</div>
			<div class="mb-3">
				<form:label path="amount" class="form-label" >Amount</form:label>
				<form:errors path="amount" class="text-danger"/>
				<form:input path="amount" class="form-control" type="number" step="0.01" min="0" />
			</div>
			<div class="mb-3">
				<form:label path="description" class="form-label" >Description</form:label>
				<form:errors path="description" class="text-danger"/>
				<form:textarea path="description" rows="3" class="form-control"/>
			</div>
			<input class="btn btn-primary" type="submit" value="Submit" />
		</form:form>

<!-- -------------------------------------------------------------------------->

</div>


























</body>
</html>