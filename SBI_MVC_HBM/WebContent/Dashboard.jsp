<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.model.Accounts" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap" rel="stylesheet">
    <style>
        :root {
            --primary: #0033A1;
            --accent: #0052cc;
            --bg: #f0f4ff;
            --text: #333;
            --light: #f8f9ff;
        }

        body {
            font-family: 'Poppins', sans-serif;
            margin: 0;
            background: linear-gradient(135deg, #c3ecff, #f0f4ff);
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            animation: fadeIn 1s ease-in;
        }

        .dashboard-container {
            position: relative;
            background: white;
            padding: 40px 50px;
            border-radius: 20px;
            box-shadow: 0 20px 40px rgba(0,0,0,0.1);
            width: 90%;
            max-width: 1000px;
            animation: slideIn 0.8s ease-in-out;
        }

        .account-created-label {
            position: absolute;
            top: 20px;
            right: 30px;
            background-color: #e6f0ff;
            color: #0033A1;
            border: 1px solid #c2d8ff;
            padding: 10px 18px;
            font-size: 13px;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
            font-weight: 500;
            text-align: right;
            animation: fadeSlide 1s ease;
            line-height: 1.4;
        }

        h2 {
            text-align: center;
            color: var(--primary);
            margin-bottom: 30px;
            font-size: 28px;
            font-weight: 600;
        }

        .user-info {
            padding: 25px;
            background: var(--light);
            border: 1px solid #d0d8ff;
            border-radius: 12px;
            margin-bottom: 40px;
            font-size: 16px;
            line-height: 1.6;
        }

        .user-info p {
            margin: 8px 0;
            color: #333;
        }

        .actions {
            display: flex;
            justify-content: space-between;
            gap: 40px;
            flex-wrap: wrap;
            margin-bottom: 40px;
        }

        .left-actions, .right-actions {
            flex: 1;
            display: flex;
            flex-direction: column;
            gap: 20px;
        }

        .action-form {
            width: 100%;
        }

        .action-btn {
            background: var(--primary);
            border: none;
            color: white;
            padding: 14px 20px;
            border-radius: 12px;
            font-weight: 500;
            font-size: 15px;
            cursor: pointer;
            width: 100%;
            transition: all 0.3s ease;
            box-shadow: 0 6px 12px rgba(0, 51, 161, 0.2);
            letter-spacing: 0.5px;
        }

        .action-btn:hover {
            background: var(--accent);
            transform: translateY(-2px);
            box-shadow: 0 10px 20px rgba(0, 82, 204, 0.25);
        }

        .logout-form {
            text-align: center;
        }

        .logout-btn {
            background: #e60000;
            color: #fff;
            padding: 12px 30px;
            font-weight: 600;
            font-size: 15px;
            border: none;
            border-radius: 10px;
            cursor: pointer;
            transition: all 0.3s ease;
            box-shadow: 0 5px 12px rgba(230, 0, 0, 0.2);
            letter-spacing: 0.5px;
        }

        .logout-btn:hover {
            background-color: #cc0000;
            transform: scale(1.03);
        }

        @keyframes slideIn {
            from {opacity: 0; transform: translateY(-20px);}
            to {opacity: 1; transform: translateY(0);}
        }

        @keyframes fadeIn {
            from {opacity: 0;}
            to {opacity: 1;}
        }

        @keyframes fadeSlide {
            from {opacity: 0; transform: translateY(-15px);}
            to {opacity: 1; transform: translateY(0);}
        }

        @media (max-width: 768px) {
            .actions {
                flex-direction: column;
            }

            .left-actions, .right-actions {
                width: 100%;
            }

            .account-created-label {
                right: 15px;
                top: 15px;
                font-size: 12px;
                padding: 8px 12px;
            }
        }
    </style>
</head>
<body>

<%
    Accounts account = (Accounts) session.getAttribute("accountObj");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a");
    String createdOn = account.getCreationDate() != null ? account.getCreationDate().format(formatter) : " ";
%>

<div class="dashboard-container">
    <div class="account-created-label">
        📅 Account Created On:<br><strong><%= createdOn %></strong>
    </div>

    <h2>Welcome to Your Dashboard</h2>

    <div class="user-info">
        <p><strong>Name:</strong> <%= account.getName()%></p>
        <p><strong>Account Type:</strong> <%=account.getAcctype() %></p>
        <p><strong>Account Number:</strong> <%=account.getAccno() %></p>
        <p><strong>Balance:</strong> <%=account.getMinbal()%> ₹</p>
    </div>

    <div class="actions">
        <div class="left-actions">
            <form class="action-form" action="Display.jsp" method="get">
                <button class="action-btn" type="submit">Display Details</button>
            </form>
            <form class="action-form" action="EditDetails.jsp" method="post">
                <button class="action-btn" type="submit">Update Details</button>
            </form>
            <form class="action-form" action="delete" method="post">
                <button class="action-btn" type="submit">Delete User</button>
            </form>
        </div>

        <div class="right-actions">
            <form class="action-form" action="Deposit.jsp" method="post">
                <button class="action-btn" type="submit">Deposit</button>
            </form>
            <form class="action-form" action="Withdraw.jsp" method="post">
                <button class="action-btn" type="submit">Withdraw</button>
            </form>
            <form class="action-form" action="forgotPassword.jsp" method="get">
                <button class="action-btn" type="submit">Change Password</button>
            </form>
        </div>
    </div>

    <div class="logout-form">
        <form action="Login.jsp" method="get">
            <button class="logout-btn" type="submit">Logout</button>
        </form>
    </div>
</div>

</body>
</html>
