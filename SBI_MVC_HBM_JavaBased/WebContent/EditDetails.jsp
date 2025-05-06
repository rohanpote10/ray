<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.model.Accounts" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page import="java.time.LocalDateTime" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Details</title>
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
            align-items: flex-start;
            min-height: 100vh;
            padding-top: 40px;
        }

        h5 {
            text-align: center;
            color: green;
            margin-bottom: 30px;
            font-size: 20px;
            font-weight: 500;
            animation: fadeInText 1.2s ease-in;
            align-items: center;
        }

        .edit-container {
            position: relative;
            background: #fff;
            padding: 40px;
            border-radius: 20px;
            box-shadow: 0 20px 40px rgba(0,0,0,0.1);
            width: 90%;
            max-width: 900px;
            animation: fadeIn 1s ease-in;
        }

        .last-updated-label {
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
            animation: fadeSlide 1s ease;
            line-height: 1.4;
        }

        .edit-header {
            margin-bottom: 30px;
        }

        .edit-header h2 {
            color: var(--primary);
            font-size: 26px;
            font-weight: 600;
            margin: 0;
            text-align: center;
        }

        form {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(280px, 1fr));
            gap: 25px 40px;
        }

        .form-group {
            display: flex;
            flex-direction: column;
        }

        label {
            font-weight: 500;
            margin-bottom: 6px;
            color: var(--text);
        }

        input[type="text"],
        input[type="email"],
        input[type="date"] {
            padding: 12px 15px;
            border: 1px solid #ccc;
            border-radius: 10px;
            font-family: 'Poppins', sans-serif;
            font-size: 14px;
            transition: border 0.3s;
        }

        input:focus {
            outline: none;
            border-color: var(--primary);
        }

        .buttons {
            grid-column: span 2;
            display: flex;
            gap: 20px;
            margin-top: 30px;
            justify-content: center;
        }

        .btn {
            background: var(--primary);
            color: white;
            padding: 12px 24px;
            border: none;
            border-radius: 12px;
            font-weight: 500;
            font-size: 15px;
            cursor: pointer;
            transition: all 0.3s ease;
            box-shadow: 0 6px 12px rgba(0, 51, 161, 0.2);
            letter-spacing: 0.5px;
            text-decoration: none;
            text-align: center;
        }

        .btn:hover {
            background: var(--accent);
            transform: translateY(-2px);
            box-shadow: 0 10px 20px rgba(0, 82, 204, 0.25);
        }

        @keyframes fadeIn {
            from {opacity: 0; transform: translateY(20px);}
            to {opacity: 1; transform: translateY(0);}
        }

        @keyframes fadeSlide {
            from {opacity: 0; transform: translateY(-15px);}
            to {opacity: 1; transform: translateY(0);}
        }

        @media (max-width: 768px) {
            .last-updated-label {
                top: 15px;
                right: 15px;
                font-size: 12px;
                padding: 8px 12px;
            }

            .buttons {
                grid-column: span 1;
                flex-direction: column;
                align-items: center;
            }
        }
    </style>
</head>
<body>

<%
    Accounts account = (Accounts) session.getAttribute("accountObj");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a");
    String lastUpdated = account.getLastUpdated() != null ? account.getLastUpdated().format(formatter) : "Not yet updated";
%>

<div class="edit-container">
    <div class="last-updated-label">
        🔄 Last Updated:<br><strong><%= lastUpdated %></strong>
    </div>

    <div class="edit-header">
        <h2>Edit Account Details</h2>
    </div>

    <form action="edit" method="post">
        <div class="form-group">
            <label>Full Name</label>
            <input type="text" name="name" placeholder="<%=account.getName()%>" required>
        </div>

        <div class="form-group">
            <label>DOB</label>
            <input type="date" name="dob" value="<%=account.getDob()%>" required>
        </div>

        <div class="form-group">
            <label>Email ID</label>
            <input type="email" name="email" placeholder="<%=account.getEmail()%>" required>
        </div>

        <div class="form-group">
            <label>Phone Number</label>
            <input type="text" name="phone" placeholder="<%=account.getContact()%>" required>
        </div>

        <h5>${message}</h5>

        <div class="buttons">
            <button type="submit" class="btn">Update Info</button>
            <a href="Upload.jsp" class="btn">Upload Documents</a>
            <a href="Dashboard.jsp" class="btn">Back to Dashboard</a>
        </div>
    </form>
</div>

</body>
</html>
