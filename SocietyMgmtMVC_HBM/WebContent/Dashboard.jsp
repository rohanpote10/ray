<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>::Dashboard</title>
</head>
<h2>Society Members</h2>
<body>
	${resultList}
	<br>
	<form action="Register.jsp">
		<button type="submit">Add New Member</button>
	</form>
</body>
</html>