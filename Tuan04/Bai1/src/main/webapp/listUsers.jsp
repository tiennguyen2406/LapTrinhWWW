<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List, iuh.fit.se.model.User" %>
<html>
<head><title>User List</title></head>
<body>
<h2>List of Users</h2>
<table border="1" cellpadding="5">
    <tr>
        <th>ID</th><th>Name</th><th>Email</th><th>Birthday</th><th>Gender</th>
    </tr>
    <%
        List<User> users = (List<User>) request.getAttribute("users");
        for (User u : users) {
    %>
    <tr>
        <td><%= u.getId() %></td>
        <td><%= u.getFirstName() + " " + u.getLastName() %></td>
        <td><%= u.getEmail() %></td>
        <td><%= u.getBirthday() %></td>
        <td><%= u.getGender() %></td>
    </tr>
    <% } %>
</table>
<a href="register.jsp">Add New User</a>
</body>
</html>
