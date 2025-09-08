<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%
    String lang = request.getParameter("lang");
    Locale locale;
    if ("en".equals(lang)) {
        locale = new Locale("en", "US");
        session.setAttribute("lang", "en");
    } else {
        locale = new Locale("vi", "VN");
        session.setAttribute("lang", "vi");
    }

    ResourceBundle bundle = ResourceBundle.getBundle("langueges", locale);
%>

<html>
<head><meta charset="UTF-8"></head>
<body>
<form action="index.jsp" method="get">
    <%= bundle.getString("lang.select") %>
    <input type="radio" name="lang" value="vi" <%= "vi".equals(session.getAttribute("lang")) ? "checked" : "" %>> <%= bundle.getString("lang.vi") %>
    <input type="radio" name="lang" value="en" <%= "en".equals(session.getAttribute("lang")) ? "checked" : "" %>> <%= bundle.getString("lang.en") %>
    <input type="submit" value="<%= bundle.getString("lang.choose") %>">
</form>

<form action="login.jsp" method="post">
    <%= bundle.getString("login.username") %>:
    <input type="text" name="username"><br>
    <%= bundle.getString("login.password") %>:
    <input type="password" name="password"><br>
    <input type="submit" value="<%= bundle.getString("login.button") %>">
</form>
</body>
</html>
