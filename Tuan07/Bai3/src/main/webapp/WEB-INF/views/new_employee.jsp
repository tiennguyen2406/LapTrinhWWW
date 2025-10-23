<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Employee</title>
</head>
<body>
<h2>ADD NEW EMPLOYEE</h2>

<form action="/saveEmployee" method="post">
    First Name: <input type="text" name="firstName"/><br/>
    Last Name: <input type="text" name="lastName"/><br/>
    Email: <input type="email" name="email"/><br/>
    Date of Birth: <input type="date" name="dateOfBirth"/><br/>
    Phone: <input type="text" name="phone"/><br/>
    Gender:
    <input type="radio" name="gender" value="Male"/> Male
    <input type="radio" name="gender" value="Female"/> Female<br/>
    Address: <input type="text" name="address"/><br/><br/>
    <input type="submit" value="Save"/>
    <a href="/">Cancel</a>
</form>
</body>
</html>
