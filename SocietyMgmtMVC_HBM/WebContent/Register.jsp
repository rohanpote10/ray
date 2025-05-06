<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Registration</title>
</head>
<h1>Add new member !!!</h1>
<body>
	<form action="register">
	<h3>${errorMessage}</h3>
		Name:<input type="text" name="memberName"><br> Flat No:<input
			type="text" name="flatNo"><br> UserName:<input
			type="text" name="username" placeholder="Name with FlatNo"><br>
		Password:<input type="text" name="password"><br>
		<button value="submit">Register</button>
		<h3>${message}</h3>
	</form>
</body>
</html>