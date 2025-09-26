<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>Register</title></head>
<body>
<h2>Register User</h2>
<form action="${pageContext.request.contextPath}/register" method="post">
    First name: <input type="text" name="firstName"/><br/>
    Last name: <input type="text" name="lastName"/><br/>
    Email: <input type="email" name="email"/><br/>
    Password: <input type="password" name="password"/><br/>
    Date of Birth: <input type="date" name="dob"/><br/>
    <button type="submit">Register</button>
</form>
<h2>Register successful!</h2>
<a href="register.jsp">Back to register</a>
<font color="red">${error}</font>
</body>
</html>
