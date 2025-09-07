<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="iuh.fit.se.model.User" %>

<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8" />
    <title>Danh sách tài khoản đăng ký</title>
</head>
<body>
<h2>Danh sách tài khoản đã đăng ký</h2>

<%
    List<User> userList = (List<User>) request.getAttribute("userList");
    if (userList == null || userList.isEmpty()) {
%>
<p>Chưa có tài khoản nào được đăng ký.</p>
<%
} else {
%>
<table border="1" cellpadding="5">
    <thead>
    <tr>
        <th>First Name</th><th>Last Name</th><th>Email</th><th>Birthday</th><th>Gender</th>
    </tr>
    </thead>
    <tbody>
    <%
        for (User user : userList) {
    %>
    <tr>
        <td><%= user.getFirstName() %></td>
        <td><%= user.getLastName() %></td>
        <td><%= user.getEmail() %></td>
        <td><%= user.getBirthday() %></td>
        <td><%= user.getGender() %></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<%
    }
%>
</body>
</html>
