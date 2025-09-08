<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
    String lang = (String) session.getAttribute("lang");
    Locale locale = "en".equals(lang) ? new Locale("en", "US") : new Locale("vi", "VN");
    ResourceBundle bundle = ResourceBundle.getBundle("langueges", locale);

    String user = request.getParameter("username");
    String pass = request.getParameter("password");
%>

<html>
<head><meta charset="UTF-8"></head>
<body>
<h2><%= bundle.getString("login.username") %>: <%= user %></h2>
<h2><%= bundle.getString("login.password") %>: <%= pass %></h2>
</body>
</html>
