<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Registration Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: #f4f4f9;
        }
        .container {
            background: #fff;
            padding: 20px 30px;
            border-radius: 8px;
            box-shadow: 0 0 8px rgba(0,0,0,0.2);
            width: 350px;
        }
        h2 {
            text-align: center;
            margin-bottom: 20px;
        }
        input, select {
            width: 100%;
            padding: 8px;
            margin: 6px 0;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .row {
            display: flex;
            gap: 10px;
        }
        .row input {
            flex: 1;
        }
        .gender {
            margin: 10px 0;
        }
        .btn {
            background: #1877f2;
            color: white;
            border: none;
            padding: 10px;
            width: 100%;
            border-radius: 4px;
            cursor: pointer;
        }
        .btn:hover {
            background: #145dbf;
        }
        .error {
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>User Registration Form</h2>
    <form action="${pageContext.request.contextPath}/register" method="post">
        <div class="row">
            <input type="text" name="firstName" placeholder="First Name" required/>
            <input type="text" name="lastName" placeholder="Last Name" required/>
        </div>
        <input type="email" name="email" placeholder="Your Email" required/>
        <input type="email" name="reEmail" placeholder="Re-enter Email" required/>
        <input type="password" name="password" placeholder="New Password" required/>

        <label>Birthday</label>
        <div class="row">
            <select name="month" required>
                <option value="">Month</option>
                <option value="01">January</option>
                <option value="02">February</option>
                <option value="03">March</option>
                <option value="04">April</option>
                <option value="05">May</option>
                <option value="06">June</option>
                <option value="07">July</option>
                <option value="08">August</option>
                <option value="09">September</option>
                <option value="10">October</option>
                <option value="11">November</option>
                <option value="12">December</option>
            </select>
            <select name="day" required>
                <option value="">Day</option>
                <% for (int i = 1; i <= 31; i++) { %>
                <option value="<%= (i < 10 ? "0"+i : i) %>"><%= i %></option>
                <% } %>
            </select>
            <select name="year" required>
                <option value="">Year</option>
                <% for (int y = 2025; y >= 1900; y--) { %>
                <option value="<%= y %>"><%= y %></option>
                <% } %>
            </select>
        </div>

        <div class="gender">
            <input type="radio" name="gender" value="Female" required/> Female
            <input type="radio" name="gender" value="Male" required/> Male
        </div>

        <button type="submit" class="btn">Sign Up</button>
    </form>

    <div class="error">${error}</div>
</div>
</body>
</html>
