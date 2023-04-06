<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
    <link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>

<p>Your Gold: <c:out value="${gold}"/></p>
<table>
	<tbody>
		<tr>
			<td>
				<h3>Farm</h3>
				<p>(earn 10-20 gold)</p>
				<form action="/" method="post"><input type="submit" name="farm" value="Find Gold!" /></form>
			</td>
			<td>
				<h3>Cave</h3>
				<p>(earn 10-20 gold)</p>
				<form action="/" method="post"><input type="submit" name="cave" value="Find Gold!" /></form>
			</td>			
			<td>
				<h3>House</h3>
				<p>(earn 10-20 gold)</p>
				<form action="/" method="post"><input type="submit" name="house" value="Find Gold!" /></form>
			</td>						
			<td>
				<h3>Quest</h3>
				<p>(earn 10-20 gold)</p>
				<form action="/" method="post"><input type="submit" name="quest" value="Find Gold!" /></form>
			</td>			
		</tr>
	</tbody>
</table>
<h3>Activities:</h3>
<iframe src="/activities/" title="Activities Iframe"></iframe>












</body>
</html>