<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomeLoans</title>
</head>
<body>
<h2>HomeLoansPage</h2>
<form action="homeLoan">
Employer name:<input type="text" name="employer"><br>
Position: <input type="text" name="position"><br>
Contact:<input type="number" name="contact" placeholder="Without country code"><br>
Address:<input type="text" name="addr"><br>
AadharcardNo:<input type="text" name="aadhar"><br>
Property Details:-<br>
Address:<input type="text" name=propAddr><br>
Purchase Price:<input type="number" name="buyPrice"><br>
Type of Loan:<br>
<input type="radio" name="typeOfLoan" value="SecuredLoan">SecuredLoan  &nbsp&nbsp&nbsp&nbsp
<input type="radio" name="typeOfLoan" value="UnsecuredLoan">UnsecuredLoan  &nbsp&nbsp&nbsp&nbsp<br>
Down-payment Price<input type="number" name="downPrice"><br>
<button value="homeLoanSubmit">Submit</button>
</form>
</body>
</html>