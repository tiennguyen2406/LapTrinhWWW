<%@ page import="java.util.*,iuh.fit.se.dao.*,iuh.fit.se.model.*" %>
<%
    Map<String,Integer> cart = (Map<String,Integer>) session.getAttribute("cart");
    ProductDao dao = new ProductDaoImpl();
%>
<html>
<head><title>Cart</title></head>
<body>
<h2>Your Cart</h2>
<%
    if (cart == null || cart.isEmpty()) {
%>
<p>Cart is currently empty</p>
<%
} else {
    double total = 0;
%>
<table border="1" cellpadding="5">
    <tr><th>Model</th><th>Quantity</th><th>Unit Price</th><th>Total</th></tr>
    <%
        for (String id : cart.keySet()) {
            Product p = dao.findById(id);
            int qty = cart.get(id);
            double sub = qty * p.getPrice();
            total += sub;
    %>
    <tr>
        <td><%=p.getId()%> - <%=p.getName()%></td>
        <td><%=qty%></td>
        <td>$<%=p.getPrice()%></td>
        <td>$<%=sub%></td>
    </tr>
    <% } %>
    <tr><td colspan="3">Subtotal</td><td>$<%=total%></td></tr>
</table>
<%
    }
%>
<a href="products">Back to Products</a>
</body>
</html>
