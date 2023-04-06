<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Details</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
<!--------------------------CONTAINER----------------------------------------->
<h1>${question.text}</h1>
<p><a href="/">Dashboard</a></p>
<h3 class="in-line">
Tags:
<c:forEach var="tag" items="${question.tags}">
	<button type="button"><c:out value="${tag.subject}"></c:out></button>
</c:forEach>
</h3>

<div class="answerContainer">
	<div class="flex">
		<h3>Answers:</h3>
		<c:forEach var="answer" items="${question.answers}">
			<ul>
				<li><c:out value="${answer.text}"></c:out></li>
			</ul>	
		</c:forEach>
	</div>
	
	<div class="flex">
		<form:form action="/questions/${question.id}/answers/new" modelAttribute="answer" class="form" method="post">
		
			<div>
			 	<form:errors path="text" class="error"/>
				<form:label for="text" path="text">Answer:</form:label>
				<form:textarea rows="4" path="text"/>
			</div>
			
			<div class="form-row">
				<input type="submit" value="Answer it!"/>
			</div>
			
		</form:form>
	</div>
</div>













<!------------------------------------------------------------------>

</body>
</html>