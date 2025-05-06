<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>:: State Bank of India</title>
    <style>
        :root {
            --primary: #0033A1;
            --accent: #0052cc;
            --bg: #f0f4ff;
            --text: #333;
        }

        body {
            font-family: 'Segoe UI', sans-serif;
            background: linear-gradient(135deg, #c3ecff, #f0f4ff);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }

        .form-container {
            background-color: white;
            padding: 20px;
            border-radius: 16px;
            box-shadow: 0 10px 30px rgba(0, 0, 0, 0.2);
            max-width: 800px;
            width: 100%;
            animation: fadeIn 1s ease;
        }

        h2, h5 {
            text-align: center;
            color: var(--primary);
            margin-bottom: 15px;
        }

        .form-sections {
            display: flex;
            flex-wrap: wrap;
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

        .section h3 {
            margin-top: 0;
            color: var(--primary);
            margin-bottom: 10px;
            font-size: 16px;
        }

        input[type="text"],
        input[type="password"],
        input[type="email"],
        input[type="date"],
        select {
            width: 100%;
            padding: 8px;
            margin-bottom: 8px;
            border: 1px solid #ccc;
            border-radius: 8px;
            font-size: 14px;
            transition: all 0.3s ease;
        }

        input:focus, select:focus {
            border-color: var(--primary);
            outline: none;
            box-shadow: 0 0 5px rgba(0, 51, 161, 0.3);
            background-color: #f0f4ff;
        }

        button {
            width: 100%;
            background: var(--primary);
            border: none;
            padding: 10px;
            font-size: 15px;
            border-radius: 10px;
            color: #fff;
            font-weight: bold;
            cursor: pointer;
            margin-top: 10px;
            transition: all 0.3s ease-in-out;
        }

        button:hover {
            background: var(--accent);
            box-shadow: 0 5px 15px rgba(0, 82, 204, 0.4);
            transform: translateY(-2px);
        }

        .login-link {
            margin-top: 10px;
            text-align: center;
            font-size: 14px;
        }

        .login-link a {
            color: var(--primary);
            text-decoration: none;
            font-weight: bold;
        }

        .login-link a:hover {
            text-decoration: underline;
        }

        @keyframes fadeIn {
            from {opacity: 0; transform: translateY(-20px);}
            to {opacity: 1; transform: translateY(0);}
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>Welcome to SBI</h2>
    <h5>New Account Registration</h5>
    <form action="register" method="post">
        <div class="form-sections">
            <!-- Personal Details Section -->
            <div class="section">
                <h3>Personal Details</h3>
                <input type="text" name="name" placeholder="Full Name" required>
                <input type="date" name="dob" placeholder="Date of Birth" required>
                <input type="text" name="address" placeholder="Address" required>
                <input type="text" name="contact" placeholder="Contact No" required>
                <input type="email" name="email" placeholder="Email ID" required>
                <input type="text" name="pancard" placeholder="PAN Card No" required>
                <input type="text" name="aadhar" placeholder="Aadhar No" required>
            </div>

            <!-- Account Details Section -->
            <div class="section">
                <h3>Account Details</h3>
                <input type="text" name="accno" placeholder="Account No" required>
                <input type="text" name="ifsc" placeholder="IFSC Code" required>
                <input type="text" name="branch" placeholder="Branch" required>
                <select name="acctype" required>
                    <option value="">Select Account Type</option>
                    <option value="Savings">Savings</option>
                    <option value="Current">Current</option>
                    <option value="Fixed Deposit">Fixed Deposit</option>
                </select>
                <input type="text" name="minbal" placeholder="Minimum Balance" required>
                <input type="text" name="username" placeholder="Username(Same as Email ID)" required>
                <input type="password" name="password" placeholder="Password" required>
            </div>
        </div>
        <h2>${message}</h2>
        <h2>${success}</h2>
        <button type="submit">Register</button>
    </form>
    <div class="login-link">
        Already Registered? <a href="Login.jsp">Login</a>
    </div>
</div>

</body>
</html>
