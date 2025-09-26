<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Products</title></head>
<body>
<a href="cart.jsp">View Cart</a>
<hr/>
<c:forEach var="p" items="${products}">
    <div style="float:left; border:1px solid #ccc; margin:10px; padding:10px;">
        <h3>${p.name}</h3>
        <img src="${p.imageUrl}" width="100"/><br/>
        Price: ${p.price}<br/>
        <form action="cart" method="post">
            <input type="hidden" name="id" value="${p.id}"/>
            <input type="number" name="quantity" value="1" min="1"/>
            <button type="submit">Add To Cart</button>
        </form>
    </div>
</c:forEach>
</body>
</html>
