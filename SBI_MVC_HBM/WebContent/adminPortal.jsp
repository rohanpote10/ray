<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page pageEncoding="UTF-8"%>
<%@ page import="com.model.Accounts" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap" rel="stylesheet">

    <script type="text/javascript">
        function EditFunk(uid) {
        	document.mypage.action = "<%=request.getContextPath()%>/adminEdit";
            document.getElementById("userIDField").value = uid;
            document.mypage.submit();
        }

        function deleteFunc(uid) {
            const confirmation = confirm("Are you sure you want to delete this account?");
            if (confirmation) {
                document.mypage.action = "deleteAccount";
                document.getElementById("userIDField").value = uid;
                document.mypage.submit();
            }
        }
    </script>

    <style>
        :root {
            --primary: #0033A1;
            --accent: #0052cc;
            --bg: #f0f4ff;
            --text: #333;
        }

        body {
            font-family: 'Poppins', sans-serif;
            background: var(--bg);
            margin: 0;
            padding: 20px;
            animation: fadeIn 1s ease-in-out;
        }

        .header-bar {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 30px;
        }

        .header-bar h2 {
            color: var(--primary);
            margin: 0;
        }

        .logout-btn {
            background-color: #dc3545;
            color: white;
            padding: 8px 16px;
            border: none;
            border-radius: 6px;
            font-weight: 500;
            cursor: pointer;
        }

        .logout-btn:hover {
            background-color: #c82333;
        }

        .summary-container {
            display: flex;
            justify-content: center;
            gap: 20px;
            margin-bottom: 40px;
            flex-wrap: nowrap;
            overflow-x: auto;
            animation: fadeIn 1s ease-in-out;
        }

        .summary-card {
            background: white;
            border-radius: 16px;
            padding: 25px;
            width: 220px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.1);
            text-align: center;
            transition: transform 0.4s ease, box-shadow 0.4s ease;
            animation: bounceFadeIn 0.9s ease forwards;
        }

        .summary-card h3 {
            color: var(--primary);
            font-size: 18px;
            margin-bottom: 10px;
        }

        .summary-card span {
            font-size: 22px;
            font-weight: 700;
            color: var(--accent);
        }

        .summary-card:hover {
            transform: translateY(-10px) scale(1.02);
            box-shadow: 0 12px 30px rgba(0, 51, 161, 0.2);
        }

        table {
            width: 100%;
            border-collapse: collapse;
            animation: fadeInUp 1s ease-in-out;
        }

        th, td {
            padding: 12px 15px;
            border: 1px solid #ccc;
            text-align: center;
        }

        th {
            background-color: var(--primary);
            color: white;
        }

        td {
            background-color: white;
            transition: background-color 0.3s;
        }

        tr:hover td {
            background-color: #e6f0ff;
        }

        button {
            padding: 6px 12px;
            border: none;
            border-radius: 6px;
            font-weight: 500;
            cursor: pointer;
            transition: 0.3s ease;
        }

        .edit-btn {
            background-color: #28a745;
            color: white;
        }

        .edit-btn:hover {
            background-color: #218838;
        }

        .delete-btn {
            background-color: #dc3545;
            color: white;
        }

        .delete-btn:hover {
            background-color: #c82333;
        }

        @keyframes fadeIn {
            from {opacity: 0;}
            to {opacity: 1;}
        }

        @keyframes fadeInUp {
            from {opacity: 0; transform: translateY(40px);}
            to {opacity: 1; transform: translateY(0);}
        }

        @keyframes bounceFadeIn {
            0% {opacity: 0; transform: scale(0.8) translateY(40px);}
            60% {opacity: 1; transform: scale(1.05) translateY(-5px);}
            100% {transform: scale(1) translateY(0);}
        }
    </style>
</head>
<body>

<!-- Updated header with logout button -->
<div class="header-bar">
    <h2>Admin Dashboard</h2>
    <form action="login.jsp" method="get">
        <button type="submit" class="logout-btn">Logout</button>
    </form>
</div>

<div class="summary-container">
    <div class="summary-card"><h3>Total Accounts</h3><span>${totalAccounts}</span></div>
    <div class="summary-card"><h3>Savings Accounts</h3><span>${savingsAcc}</span></div>
    <div class="summary-card"><h3>Current Accounts</h3><span>${currentAcc}</span></div>
    <div class="summary-card"><h3>FD Accounts</h3><span>${fdAcc}</span></div>
    <div class="summary-card"><h3>Total Balance</h3><span>${balance} Rs.</span></div>
</div>

<%
    List<Accounts> accountList = (List<Accounts>) request.getAttribute("listOfAcc");
%>

<h2>All Users & Accounts</h2>

<form name="mypage" method="get">
    <input type="hidden" name="userID" id="userIDField" />
    <table>
        <tr>
            <th>User ID</th>
            <th>Username</th>
            <th>Name</th>
            <th>Account Number</th>
            <th>Branch</th>
            <th>Gmail</th>
            <th>Balance</th>
            <th>Actions</th>
        </tr>

        <% for (Accounts account : accountList) { %>
        <tr>
            <td><%= account.getUserID() %></td>
            <td><%= account.getUsername() %></td>
            <td><%= account.getName() %></td>
            <td><%= account.getAccno() %></td>
            <td><%= account.getBranch() %></td>
            <td><%= account.getEmail() %></td>
            <td><%= account.getMinbal() %></td>
            <td>
                <button type="button" class="edit-btn" onclick="EditFunk('<%= account.getUserID() %>')">Edit</button>
                <button type="button" class="delete-btn" onclick="deleteFunc('<%= account.getUserID() %>')">Delete</button>
            </td>
        </tr>
        <% } %>
    </table>
</form>

</body>
</html>
