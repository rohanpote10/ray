<%@ page import="com.model.Accounts" %>
<%
    Accounts account = (Accounts) session.getAttribute("accountObj");
    String correctPassword = (account != null) ? account.getPassword() : "";
    String username = (account != null) ? account.getUsername() : "";
%>
<!DOCTYPE html>
<html>
<head>
    <title>SBI - Forgot Password</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;600&display=swap" rel="stylesheet">
    <style>
        body {
            background-color: #e6f2ff;
            font-family: 'Poppins', sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .container {
            width: 460px;
            background-color: #ffffff;
            padding: 35px;
            border-radius: 15px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.15);
            animation: slideDown 0.5s ease;
        }

        @keyframes slideDown {
            from { opacity: 0; transform: translateY(-40px); }
            to { opacity: 1; transform: translateY(0); }
        }

        h2 {
            color: #003366;
            text-align: center;
            margin-bottom: 15px;
            font-weight: 600;
        }

        h4 {
            color: green;
            text-align: center;
            margin-bottom: 15px;
            font-weight: 600;
        }

        .form-group {
            margin-bottom: 22px;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: 500;
            color: #333;
        }

        input[type="text"], input[type="password"] {
            width: 100%;
            padding: 12px;
            border-radius: 8px;
            border: 1px solid #ccc;
            font-size: 14px;
            transition: 0.3s;
        }

        input:focus {
            border-color: #0055a5;
            outline: none;
        }

        .btn {
            background-color: #0055a5;
            color: white;
            padding: 12px 0;
            width: 100%;
            border: none;
            border-radius: 25px;
            font-weight: 600;
            font-size: 15px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        .btn:hover {
            background-color: #003f7d;
        }

        .error {
            color: red;
            font-size: 13px;
            margin-top: 5px;
        }

        .success {
            display: none;
            text-align: center;
            margin-top: 20px;
            color: green;
            font-weight: 500;
            font-size: 15px;
            animation: fadeIn 1s ease;
        }

        @keyframes fadeIn {
            from { opacity: 0; }
            to { opacity: 1; }
        }

        #newPasswordSection {
            display: none;
            animation: fadeIn 0.5s ease;
        }

        .login-status {
            text-align: center;
            font-size: 14px;
            color: green;
            margin-bottom: 15px;
        }
    </style>

    <script>
        const correctPassword = "<%= correctPassword %>";
        const hasSession = <%= (account != null) ? "true" : "false" %>;

        function checkOldPassword() {
            const oldPass = document.getElementById("oldPassword").value.trim();
            const errorDiv = document.getElementById("oldPassError");
            const newPasswordSection = document.getElementById("newPasswordSection");

            if (hasSession) {
                if (correctPassword && oldPass === correctPassword) {
                    errorDiv.textContent = "";
                    newPasswordSection.style.display = "block";
                } else {
                    errorDiv.textContent = "Incorrect old password. Please try again.";
                    newPasswordSection.style.display = "none";
                }
            } else {
                // No session: Just allow to proceed (we’ll verify old password server-side)
                errorDiv.textContent = "";
                newPasswordSection.style.display = "block";
            }
        }
    </script>
</head>
<body>
<div class="container">
    <h2>Forgot Password</h2>

    <%-- ✅ Optional Login Status --%>
    <% if (account != null) { %>
        <div class="login-status">
            You are logged in as <strong><%= account.getUsername() %></strong>
        </div>
    <% } %>

    <form action="updatePassword" method="post">
        <h4>${message}</h4>

        <%-- Username Field --%>
        <div class="form-group">
            <label>User ID / Username</label>
            <input type="text" name="username"
                   value="<%= username %>"
                   <%= (username != null && !username.isEmpty() ? "readonly" : "") %>
                   required>
        </div>

        <%-- Old Password Field --%>
        <div class="form-group">
            <label>Old Password</label>
            <input type="password" name="password" id="oldPassword" onkeyup="checkOldPassword()" required>
            <div id="oldPassError" class="error"></div>
        </div>

        <%-- Hidden Input to Mark Session --%>
        <input type="hidden" name="fromSession" value="<%= (account != null) ? "true" : "false" %>">

        <%-- New Password Section --%>
        <div id="newPasswordSection">
            <div class="form-group">
                <label>New Password</label>
                <input type="password" name="newPassword" required>
            </div>
            <button class="btn" type="submit">Update Password</button>
        </div>

        <div id="successMsg" class="success">
            Password updated successfully! Redirecting...
        </div>
    </form>
</div>
</body>
</html>
