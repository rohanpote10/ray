<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Admin Registration</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@400;500;600&display=swap" rel="stylesheet">
    <style>
        :root {
            --primary: #0033A1;
            --accent: #0052cc;
            --bg: #f0f4ff;
            --text: #333;
            --input-bg: #fff;
        }

        body {
            font-family: 'Poppins', sans-serif;
            background: linear-gradient(135deg, #c3ecff, #f0f4ff);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            overflow: hidden;
        }

        .register-container {
            background-color: var(--input-bg);
            padding: 30px 40px;
            border-radius: 16px;
            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.15);
            width: 380px;
            animation: fadeIn 0.8s ease;
        }

        h2 {
            text-align: center;
            color: var(--primary);
            margin-bottom: 25px;
            font-size: 26px;
            font-weight: 600;
        }

        h4 {
            text-align: center;
            color: green;
            margin-bottom: 25px;
            font-size: 26px;
            font-weight: 600;
        }

        h4 { color: green; }
        h5 { color: red; }

        input[type="text"],
        input[type="password"],
        input[type="email"] {
            width: 100%;
            padding: 12px 14px;
            margin-bottom: 18px;
            border: 1px solid #ccc;
            border-radius: 10px;
            font-size: 15px;
            background: var(--input-bg);
            transition: 0.3s ease;
        }

        input:focus {
            border-color: var(--primary);
            background-color: #eef4ff;
            outline: none;
            box-shadow: 0 0 6px rgba(0, 51, 161, 0.3);
            transform: scale(1.02);
        }

        button {
            width: 100%;
            background: var(--primary);
            border: none;
            padding: 12px;
            font-size: 15px;
            border-radius: 10px;
            color: #fff;
            font-weight: 500;
            cursor: pointer;
            margin-top: 5px;
            transition: all 0.3s ease-in-out;
        }

        button:hover {
            background: var(--accent);
            box-shadow: 0 10px 24px rgba(0, 82, 204, 0.4);
            transform: translateY(-2px);
        }

        .login-link {
            text-align: center;
            font-size: 14px;
            margin-top: 18px;
        }

        .login-link a {
            color: var(--primary);
            font-weight: 500;
            text-decoration: none;
        }

        .login-link a:hover {
            text-decoration: underline;
        }

        @keyframes fadeIn {
            0% { opacity: 0; transform: translateY(-30px); }
            100% { opacity: 1; transform: translateY(0); }
        }
    </style>
</head>
<body>

<div class="register-container">
    <h2>Admin Registration</h2>
    <h4>${success}</h4>

    <form action="adminRegister" method="post">
        <input type="text" name="username" placeholder="User ID / Username" required>
        <input type="text" name="name" placeholder="Full Name" required>
        <input type="email" name="email" placeholder="Email ID" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Register</button>
    </form>

    <div class="login-link">
        <a href="Login.jsp">← Back to Login</a>
    </div>
</div>

</body>
</html>
