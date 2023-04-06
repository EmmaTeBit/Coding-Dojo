<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Activities</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/css/style.css">


</head>
<body>

<c:forEach var="activity" items="${activities}">
	<c:if test="${activity.contains('earned')}">
		<p style="color:green;"><c:out value="${activity}"></c:out></p>
	</c:if>
	<c:if test="${activity.contains('lost')}">
		<p style="color:red;"><c:out value="${activity}"></c:out></p>
	</c:if>
</c:forEach>








</body>
</html>