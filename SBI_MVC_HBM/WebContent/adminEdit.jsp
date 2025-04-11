<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.model.Accounts" %>>
<html>
<head>
    <title>Edit Account</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
            padding: 30px;
        }
        .container {
            background-color: white;
            padding: 25px;
            border-radius: 8px;
            max-width: 500px;
            margin: auto;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        h2 {
            color: #0b4d91;
        }
        label {
            font-weight: bold;
            display: block;
            margin-top: 10px;
        }
        input[type=text], input[type=email] {
            width: 100%;
            padding: 8px;
            margin-top: 5px;
            margin-bottom: 15px;
        }
        input[type=submit] {
            background-color: #0b4d91;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        input[type=submit]:hover {
            background-color: #093d74;
        }
    </style>
</head>
<body>
<h3>${account}</h3>
<% Accounts accountObj=(Accounts) request.getAttribute("account"); %>>
<div class="container">
    <h2>Edit Account Details</h2>
    <form action="updateAccount" method="post">
        <input type="hidden" name="userID" id="userIDField" value="<%= accountObj.getUserID() %>" />

        <label for="name">Name</label>
        <input type="text" name="name" id="name" value="<%= accountObj.getName() %>" required />

        <label for="email">Email</label>
        <input type="email" name="email" id="email" value="<%= accountObj.getEmail() %>" required />

        <label for="branch">Branch</label>
        <input type="text" name="branch" id="branch" value="<%= accountObj.getBranch() %>" required />

        <input type="submit" value="Update Account" />
    </form>
</div>
</body>
</html>
