<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.model.Accounts" %>
<html>
<head>
    <title>Edit Account</title>
    <!-- Google Fonts for a professional look -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(to right, #e0eafc, #cfdef3);
            padding: 40px;
        }
        .container {
            background-color: white;
            padding: 30px;
            border-radius: 12px;
            max-width: 550px;
            margin: auto;
            box-shadow: 0 12px 20px rgba(0,0,0,0.15);
            transition: transform 0.3s ease;
        }
        .container:hover {
            transform: scale(1.02);
        }
        h2 {
            color: #003366;
            text-align: center;
            margin-bottom: 25px;
        }
        label {
            font-weight: 600;
            display: block;
            margin-top: 15px;
            color: #333;
        }
        input[type=text], input[type=email] {
            width: 100%;
            padding: 10px;
            margin-top: 6px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 15px;
            background-color: #f9f9f9;
        }
        input[type=submit] {
            background: #0055aa;
            color: white;
            padding: 12px;
            border: none;
            border-radius: 6px;
            margin-top: 20px;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            width: 100%;
            transition: background 0.3s ease;
        }
        input[type=submit]:hover {
            background: #003f7f;
        }

        /* Success message animation */
        #successMessage {
            display: none;
            background-color: #d4edda;
            color: #155724;
            border: 1px solid #c3e6cb;
            padding: 15px;
            margin-top: 20px;
            border-radius: 6px;
            text-align: center;
            animation: fadeInScale 0.6s ease-in-out forwards;
        }

        @keyframes fadeInScale {
            0% {
                opacity: 0;
                transform: scale(0.9);
            }
            100% {
                opacity: 1;
                transform: scale(1);
            }
        }
    </style>
</head>
<body>

<% Accounts accountObj=(Accounts) request.getAttribute("account"); %>
<div class="container">
    <h2>Edit Account Details</h2>

    <!-- Success message will appear on update -->
    <div id="successMessage">✅ Account details updated successfully!</div>

    <form action="<%=request.getContextPath()%>/updateAccount" method="post" onsubmit="showSuccessMessage()">
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

<script>
    function showSuccessMessage() {
        const message = document.getElementById("successMessage");
        message.style.display = "block";
        setTimeout(() => {
            message.style.display = "none";
        }, 4000); // Hide after 4 seconds
    }
</script>
</body>
</html>
