<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Dojo Page</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/css/style.css">
	<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="alert alert-success" role="alert">
	<h1>Customer Name: <c:out value="${first}"/> <c:out value="${last}"/></h1>
    </div>
    <p>Item Name: <c:out value="${item}"/>
    <p>Price: $<c:out value="${price}"/>
    <p>Description: <c:out value="${description}"/>
    <p>Vendor: <c:out value="${vendor}"/>

</body>
</html>