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
<!--------------------------CONTAINER----------------------------------------->
<h1>Questions Dashboard</h1>

<table>
	<thead>
		<tr>
			<th>Question</th>
			<th>Tags</th>
		</tr>
	</thead>
    <tbody>
		<c:forEach var="question" items="${questions}">
			<tr>
				<td><a href="/questions/${question.id}"><c:out value="${question.text}"></c:out></a></td>
				<td>
					<c:forEach var="tag" items="${question.tags}">
						<span>${tag.subject}<c:if test = "${question.tags.indexOf(tag)<question.tags.size()-1}">, </c:if></span>
					</c:forEach>
				</td>
			</tr>
		</c:forEach>
    </tbody>
</table>
<p class="questionLink"><a href="/questions/new">New Question</a></p>






<!------------------------------------------------------------------>

</body>
</html>