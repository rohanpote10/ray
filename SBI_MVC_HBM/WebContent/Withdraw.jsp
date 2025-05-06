<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.model.Accounts" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Withdraw Money</title>
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
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            overflow: hidden;
        }

        .withdraw-container {
            background: #fff;
            padding: 40px 50px;
            border-radius: 20px;
            box-shadow: 0 20px 40px rgba(0,0,0,0.1);
            width: 90%;
            max-width: 450px;
            animation: fadeInContainer 1s ease forwards;
            transform: translateY(50px);
            opacity: 0;
        }

        h2 {
            text-align: center;
            color: var(--primary);
            margin-bottom: 30px;
            font-size: 26px;
            font-weight: 600;
            animation: slideInDown 0.6s ease-in-out;
        }

        h5 {
            text-align: center;
            color: red;
            margin-bottom: 30px;
            font-size: 20px;
            font-weight: 500;
            animation: fadeInText 1.2s ease-in;
        }
        h6 {
            text-align: center;
            color: green;
            margin-bottom: 30px;
            font-size: 20px;
            font-weight: 500;
            animation: fadeInText 1.2s ease-in;
        }

        .form-group {
            margin-bottom: 25px;
            animation: slideInUp 0.8s ease-in-out;
        }

        label {
            font-weight: 500;
            display: block;
            margin-bottom: 8px;
            color: var(--text);
        }

        input[type="number"] {
            width: 100%;
            padding: 12px 16px;
            border-radius: 10px;
            border: 1px solid #ccc;
            font-size: 15px;
            font-family: 'Poppins', sans-serif;
            transition: border-color 0.3s, transform 0.3s;
        }

        input[type="number"]:focus {
            outline: none;
            border-color: var(--primary);
            transform: scale(1.02);
        }

        .submit-btn, .back-btn {
            background: var(--primary);
            color: white;
            padding: 14px 20px;
            border: none;
            border-radius: 12px;
            font-weight: 500;
            font-size: 16px;
            cursor: pointer;
            width: 100%;
            transition: all 0.3s ease;
            box-shadow: 0 6px 12px rgba(0, 51, 161, 0.2);
            letter-spacing: 0.5px;
            margin-top: 15px;
            animation: pulseBtn 2s infinite;
        }

        .submit-btn:hover, .back-btn:hover {
            background: var(--accent);
            transform: translateY(-2px);
            box-shadow: 0 10px 20px rgba(0, 82, 204, 0.25);
        }

        @keyframes fadeInContainer {
            to {
                transform: translateY(0);
                opacity: 1;
            }
        }

        @keyframes slideInDown {
            0% {
                transform: translateY(-50px);
                opacity: 0;
            }
            100% {
                transform: translateY(0);
                opacity: 1;
            }
        }

        @keyframes slideInUp {
            0% {
                transform: translateY(30px);
                opacity: 0;
            }
            100% {
                transform: translateY(0);
                opacity: 1;
            }
        }

        @keyframes fadeInText {
            from {
                opacity: 0;
                transform: scale(0.95);
            }
            to {
                opacity: 1;
                transform: scale(1);
            }
        }

        @keyframes pulseBtn {
            0% {
                box-shadow: 0 0 0 0 rgba(0, 51, 161, 0.4);
            }
            70% {
                box-shadow: 0 0 0 10px rgba(0, 51, 161, 0);
            }
            100% {
                box-shadow: 0 0 0 0 rgba(0, 51, 161, 0);
            }
        }
    </style>
</head>
<body>

<div class="withdraw-container">
<% Accounts account = (Accounts) session.getAttribute("accountObj"); %>
    <h2>Withdraw Money</h2>
    <form action="withdraw" method="post">
        <div class="form-group">
            <label for="amount">Enter Amount (₹)</label>
            <input type="number" id="amount" name="amount" min="1" step="1" placeholder="Available Balance: <%=account.getMinbal() %>"required>
        </div>
        <h5>${success}</h5>
        <h6>${message}</h6>
        <button class="submit-btn" type="submit">Withdraw</button>
    </form>

    <form action="Dashboard.jsp" method="get">
        <button class="back-btn" type="submit">Back to Dashboard</button>
    </form>
</div>

</body>
</html>
