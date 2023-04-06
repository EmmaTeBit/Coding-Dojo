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
				<a href="/books/new" class="btn btn-dark">Add New Book</a>
			</div>
		</div>
	</div>
<!--------------------------CONTAINER----------------------------------------->
<div class=" py-5 d-flex justify-content-center">
	<div class="card shadow-2-strong card-registration p-md-5 m-4" style="border-radius: 15px;">
		<div class="card-body p-4 p-md-55">
			<h1 class="text-center h1 fw-bold">Book from everyone's shelves</h1><br />
			<table class="table table-bordered">
					<thead>
						<tr>
							<th>ID</th>
							<th>Title</th>
							<th>Author Name</th>
							<th>Posted By</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="book" items="${books}">
							<tr>
								<td><c:out value="${book.id}"></c:out></td>
								<td><a href="/books/${book.id}"><c:out value="${book.title}"></c:out></a></td>
								<td><c:out value="${book.author}"></c:out></td>
								<td><c:out value="${book.user.userName}"></c:out></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		</div>
	</div>
</div>
<!------------------------------------------------------------------->
</section>
</body>
</html>