<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
</head>
<body>
<form action="register">
First Name:<input type="text" name="fname"><br>
LastName:<input type="text" name="lname"><br>
Address:<input type="text" name="addr"><br>
Contact No:<input type="number" name="cno"><br>
Gender:<input type="text" name="gender"><br>
EmailID:<input type="email" name="emailID"><br>
Pincode:<input type="text" name="pincode"><br>
AadharCardNo:<input type="text" name="aadharNo"><br>
PancardNo:<input type="text" name="pNo"><br>
Account Type : 
<input type="checkbox" name="savingsAcc" value="Yes"> Savings  &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp <br>
Minimum Balance:<input type="number" name="minBal"><br>
<button value="submit"> Create Account</button>
</form>
</body>
</html>