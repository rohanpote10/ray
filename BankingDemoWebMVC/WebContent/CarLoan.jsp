<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CarLoans</title>
</head>
<body>
<h2>Car Loans Page</h2>
<form action="carLoan">
Employer name:<input type="text" name="employer"><br>
Position: <input type="text" name="position"><br>
Contact:<input type="number" name="contact" placeholder="Without country code"><br>
Address:<input type="text" name="addr"><br>
PancardNo:<input type="text" name="pancard"><br>
Vehicle Details:-<br>
ModelNo:<input type="number" name="model"><br>
Mileage:<input tye="number" name="mileage"><br>
Price:<input type="number" name="price"><br>
Dealership Name:-<br>
Type of Loan:<br>
<input type="radio" name="typeOfLoan" value="SecuredLoan">SecuredLoan  &nbsp&nbsp&nbsp&nbsp
<input type="radio" name="typeOfLoan" value="UnsecuredLoan">UnsecuredLoan  &nbsp&nbsp&nbsp&nbsp<br>
Down-payment Price:<input type="number" name="downPay"><br>
<button value="carLoanSubmit">Submit</button>
</form>
</body>
</html>