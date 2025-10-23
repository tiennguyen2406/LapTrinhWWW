<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Employee</title>
</head>
<body>
<h2>UPDATE EMPLOYEE</h2>

<form action="/saveEmployee" method="post">
    <input type="hidden" name="id" value="${employee.id}"/>

    First Name: <input type="text" name="firstName" value="${employee.firstName}"/><br/>
    Last Name: <input type="text" name="lastName" value="${employee.lastName}"/><br/>
    Email: <input type="email" name="email" value="${employee.email}"/><br/>
    Date of Birth: <input type="date" name="dateOfBirth" value="${employee.dateOfBirth}"/><br/>
    Phone: <input type="text" name="phone" value="${employee.phone}"/><br/>
    Gender:
    <input type="radio" name="gender" value="Male" ${employee.gender == 'Male' ? 'checked' : ''}/> Male
    <input type="radio" name="gender" value="Female" ${employee.gender == 'Female' ? 'checked' : ''}/> Female<br/>
    Address: <input type="text" name="address" value="${employee.address}"/><br/><br/>
    <input type="submit" value="Update"/>
    <a href="/">Cancel</a>
</form>
</body>
</html>
