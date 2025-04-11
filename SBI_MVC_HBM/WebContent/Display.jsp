<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.model.Accounts" %>>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Display Details</title>
    <% Accounts account = (Accounts) session.getAttribute("accountObj"); %>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap" rel="stylesheet">
    <style>
        :root {
            --primary: #0033A1;
            --accent: #0052cc;
            --bg: #f0f4ff;
            --text: #333;
        }

        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #c3ecff, #f0f4ff);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            animation: fadeIn 1s ease-in-out;
        }

        .container {
            background-color: white;
            padding: 30px 40px;
            border-radius: 16px;
            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.2);
            width: 800px;
            animation: slideIn 1s ease-in-out;
        }

        h2 {
            text-align: center;
            color: var(--primary);
            font-size: 28px;
            font-weight: 600;
            margin-bottom: 10px;
        }

        .greeting {
            text-align: center;
            font-size: 22px;
            font-weight: bold;
            color: var(--primary);
            animation: floatText 2s infinite alternate;
        }

        .form-sections {
            display: flex;
            gap: 15px;
        }

        .section {
            flex: 1;
            background-color: #f9fbff;
            padding: 15px;
            border-radius: 12px;
            box-shadow: inset 0 0 10px rgba(0, 0, 0, 0.03);
            min-width: 280px;
        }

        label {
            font-weight: bold;
            color: var(--primary);
        }

        input {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 14px;
            transition: 0.3s ease;
        }

        input:focus {
            border-color: var(--primary);
            outline: none;
            background-color: #f0f4ff;
        }

        button {
            width: 100%;
            background: var(--primary);
            border: none;
            padding: 12px;
            font-size: 16px;
            border-radius: 10px;
            color: #fff;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease-in-out;
        }

        button:hover {
            background: var(--accent);
            box-shadow: 0 5px 15px rgba(0, 82, 204, 0.4);
            transform: translateY(-2px);
        }

        @keyframes fadeIn {
            from {opacity: 0; transform: translateY(-20px);}
            to {opacity: 1; transform: translateY(0);}
        }

        @keyframes slideIn {
            from {opacity: 0; transform: translateX(-50px);}
            to {opacity: 1; transform: translateX(0);}
        }

        @keyframes floatText {
            from {transform: translateY(0);}
            to {transform: translateY(-5px);}
        }
    </style>
</head>
<body>

<div class="container">
    <h2>Account Details</h2>
    <div class="greeting">Hi, <%=account.getName() %></div>
    <div class="form-sections">
        <!-- Personal Information -->
        <div class="section">
            <label>Date of Birth</label>
            <input type="text" value="<%=account.getDob()%>" readonly>
            <label>Address</label>
            <input type="text" value="<%=account.getAddress()%>" readonly>
            <label>Contact</label>
            <input type="text" value="<%=account.getContact() %>" readonly>
            <label>Email</label>
            <input type="text" value="<%=account.getEmail() %>" readonly>
            <label>PAN Card</label>
            <input type="text" value="<%=account.getPancard() %>" readonly>
            <label>Aadhar</label>
            <input type="text" value="<%=account.getAadhar() %>" readonly>
        </div>

        <!-- Account Information -->
        <div class="section">
            <label>Account No</label>
            <input type="text" value="<%=account.getAccno() %>" readonly>
            <label>IFSC Code</label> 
            <input type="text" value="<%=account.getIfsc() %>" readonly>
            <label>Branch</label>
            <input type="text" value="<%=account.getBranch()%>" readonly>
            <label>Account Type</label>
            <input type="text" value="<%=account.getAcctype() %>" readonly>
            <label>Minimum Balance</label>
            <input type="text" value="<%=account.getMinbal()%>" readonly>
            <label>Username</label>
            <input type="text" value="<%=account.getUsername() %>" readonly>
        </div>
    </div>
    <br>
    <form action="Dashboard.jsp" method="get">
    <button type="submit">Back to Dashboard</button>
</form>
</div>

</body>
</html>
