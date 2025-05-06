<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h1>Login Page</h1>
${msg}
<form action="login">
Username:<input type="text" name="uname"><br><br>
Password:<input type="password" name="pass"><br><br>
<button value="submit">Login</button>
</form>
</body>
</html>