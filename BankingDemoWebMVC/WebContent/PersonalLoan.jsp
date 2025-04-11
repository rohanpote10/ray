<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Personal Loans</title>
</head>
<body>
<h2>Personal Loans Page</h2>
<form action="personalLoan">
Full Name:<input type="text" name="fname"><br>
Address:<input type="text" name="addr"><br>
Contact No:<input type="number" name="cno"><br>
EmailID:<input type="email" name="emailID"><br>
Purpose of PL:<input type="text" name="purpose"><br>
Type of Loan:<br>
<input type="radio" name="typeOfLoan" value="SecuredLoan">SecuredLoan  &nbsp&nbsp&nbsp&nbsp
<input type="radio" name="typeOfLoan" value="UnsecuredLoan">UnsecuredLoan  &nbsp&nbsp&nbsp&nbsp<br>
<button value="personalLoanSubmit">Submit</button>
</form>
</body>
</html>