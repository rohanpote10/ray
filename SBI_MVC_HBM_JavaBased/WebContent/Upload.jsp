<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.model.Accounts" %>>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Upload Documents</title>
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
            background: linear-gradient(135deg, #d0e9ff, #f0f4ff);
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            padding: 20px;
        }

        .upload-container {
            background: #ffffff;
            padding: 40px 50px;
            border-radius: 20px;
            box-shadow: 0 20px 40px rgba(0,0,0,0.1);
            max-width: 600px;
            width: 100%;
            animation: fadeIn 1s ease-in-out;
        }

        .upload-container h2 {
            text-align: center;
            color: var(--primary);
            margin-bottom: 30px;
            font-weight: 600;
            font-size: 26px;
        }

        form {
            display: flex;
            flex-direction: column;
            gap: 25px;
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

        input[type="file"] {
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 10px;
            font-family: 'Poppins', sans-serif;
            font-size: 14px;
            background: #f8f8f8;
            cursor: pointer;
        }

        .filename-display {
            margin-top: 8px;
            padding: 10px;
            border: 1px dashed #ccc;
            background: #f9f9f9;
            border-radius: 8px;
            font-size: 13px;
            color: #555;
            word-break: break-word;
        }

        input[type="file"]:focus {
            outline: none;
            border-color: var(--primary);
        }

        .btn-group {
            display: flex;
            justify-content: space-between;
            gap: 15px;
            margin-top: 30px;
        }

        .btn {
            flex: 1;
            background: var(--primary);
            color: #fff;
            padding: 12px;
            border: none;
            border-radius: 12px;
            font-size: 15px;
            font-weight: 500;
            cursor: pointer;
            transition: all 0.3s ease;
            text-align: center;
            box-shadow: 0 6px 12px rgba(0, 51, 161, 0.2);
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
    </style>
</head>
<body>

<div class="upload-container">
    <h2>Upload KYC Documents</h2>
    <% Accounts account = (Accounts) session.getAttribute("accountObj"); %>

    <form action="uploadDocs" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="panCard">Upload PAN Card</label>
            <input type="file" name="pancard" id="panCard" accept=".jpg,.jpeg,.png,.pdf" onchange="showFileName(this, 'panFileName')" required>
            <div class="filename-display" id="panFileName">No file chosen</div>
        </div>

        <div class="form-group">
            <label for="aadharCard">Upload Aadhar Card</label>
            <input type="file" name="aadharcard" id="aadharCard" accept=".jpg,.jpeg,.png,.pdf" onchange="showFileName(this, 'aadharFileName')" required>
            <div class="filename-display" id="aadharFileName">No file chosen</div>
        </div>

        <div class="btn-group">
            <button type="submit" class="btn">Submit</button>
            <a href="Dashboard.jsp" class="btn">Back to Dashboard</a>
        </div>
    </form>
</div>

<script>
    function showFileName(input, displayId) {
        const fileDisplay = document.getElementById(displayId);
        if (input.files.length > 0) {
            fileDisplay.textContent = input.files[0].name;
        } else {
            fileDisplay.textContent = "No file chosen";
        }
    }
</script>

</body>
</html>
