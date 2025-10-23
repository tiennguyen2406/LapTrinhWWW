<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Employee List</title>
</head>
<body>
<h2>EMPLOYEE LIST</h2>
<a href="/showNewEmployeeForm">Add New Employee</a>
<br/><br/>
<table border="1" cellpadding="5">
    <tr>
        <th>ID</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Gender</th>
        <th>Date of Birth</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Address</th>
        <th>Action</th>
    </tr>
    <c:forEach var="employee" items="${listEmployees}">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.firstName}</td>
            <td>${employee.lastName}</td>
            <td>${employee.gender}</td>
            <td>${employee.dateOfBirth}</td>
            <td>${employee.email}</td>
            <td>${employee.phone}</td>
            <td>${employee.address}</td>
            <td>
                <a href="/showFormForUpdate/${employee.id}">Edit</a> |
                <a href="/deleteEmployee/${employee.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
