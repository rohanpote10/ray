<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
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
        }

        .login-container {
            background-color: white;
            padding: 30px 40px;
            border-radius: 16px;
            box-shadow: 0 20px 40px rgba(0, 0, 0, 0.2);
            width: 350px;
            animation: fadeIn 1s ease;
        }

        h2 {
            text-align: center;
            color: var(--primary);
            margin-bottom: 25px;
            font-size: 24px;
            font-weight: 600;
        }
        
         h5 {
            text-align: center;
            color: red;
            margin-bottom: 25px;
            font-size: 24px;
            font-weight: 600;
        }

        input[type="email"],
        input[type="password"] {
            width: 100%;
            padding: 12px 14px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 10px;
            font-size: 15px;
            transition: all 0.3s ease;
            font-family: 'Poppins', sans-serif;
        }

        input:focus {
            border-color: var(--primary);
            outline: none;
            background-color: #f0f4ff;
            box-shadow: 0 0 5px rgba(0, 51, 161, 0.3);
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
            transition: all 0.3s ease-in-out;
            font-family: 'Poppins', sans-serif;
        }

        button:hover {
            background: var(--accent);
            box-shadow: 0 8px 20px rgba(0, 82, 204, 0.4);
            transform: translateY(-2px);
        }

        .register-link {
            text-align: center;
            margin-top: 20px;
            font-size: 14px;
            font-family: 'Poppins', sans-serif;
        }

        .register-link a {
            color: var(--primary);
            text-decoration: none;
            font-weight: bold;
        }

        .register-link a:hover {
            text-decoration: underline;
        }

        @keyframes fadeIn {
            from {opacity: 0; transform: translateY(-20px);}
            to {opacity: 1; transform: translateY(0);}
        }
    </style>
</head>
<body>

<div class="login-container">
    <h2>Login</h2>
    <h2>${loginMessage}</h2>
    <h5>${message}</h5>
    <form action="login" method="post">
        <input type="email" name="email" placeholder="Email ID" required>
        <input type="password" name="password" placeholder="Password" required>
        <button type="submit">Login</button>
    </form>
    <div class="register-link">
        New user? <a href="Register.jsp">Register Here</a>
    </div>
</div>

</body>
</html>
