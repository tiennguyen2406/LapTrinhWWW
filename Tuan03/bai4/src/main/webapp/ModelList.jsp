ShoppingCart.jspShoppingCart.jspShoppingCart.jsp<%--
  Created by IntelliJ IDEA.
  User: Hoang Son
  Date: 08/09/2025
  Time: 1:15 CH
  To change this template use File | Settings | File Templates.
--%>
<<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List</title>
    <style>
        body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #f0f2f5; margin: 0; padding: 0; }
        .product-list-container {
            width: 90%;
            max-width: 1200px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
        }
        h1 {
            color: #333;
            text-align: center;
            border-bottom: 2px solid #525D76;
            padding-bottom: 10px;
            margin-bottom: 30px;
        }
        .product-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
            gap: 20px;
        }
        .product-item {
            border: 1px solid #e0e0e0;
            padding: 15px;
            text-align: center;
            border-radius: 8px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.05);
            transition: transform 0.2s;
        }
        .product-item:hover {
            transform: translateY(-5px);
            box-shadow: 0 4px 10px rgba(0,0,0,0.1);
        }
        .product-item img {
            width: 120px;
            height: 120px;
            object-fit: contain;
            margin-bottom: 10px;
        }
        .product-item b {
            display: block;
            font-size: 1.1em;
            color: #525D76;
            margin-bottom: 5px;
        }
        .product-item p {
            color: #666;
            margin: 5px 0;
        }
        .product-item form {
            margin-top: 10px;
        }
        .product-item input[type="text"] {
            width: 40px;
            text-align: center;
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .product-item input[type="submit"] {
            background-color: #525D76;
            color: white;
            border: none;
            padding: 8px 15px;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.2s;
        }
        .product-item input[type="submit"]:hover {
            background-color: #434d61;
        }
        .view-cart-link {
            text-align: right;
            margin-bottom: 20px;
        }
        .view-cart-link a {
            text-decoration: none;
            color: #525D76;
            font-weight: bold;
        }
    </style>
</head>
<body>
<div class="product-list-container">
    <h1>Product List</h1>
    <p class="view-cart-link"><a href="ShoppingCart.jsp">View Cart &raquo;</a></p>
    <div class="product-grid">
        <c:forEach items="${ds}" var="sp">
            <div class="product-item">
                <form name="modelDetail" method="POST" action="<c:url value="/CartController" />">
                    <img src="${sp.imgURL}" alt="${sp.model}"/><br/>
                    <b>${sp.model}</b> <br/>
                    Price: ${sp.price} <br/>
                    <input type="text" size="2" value="1" name="quantity"/><br>
                    <input type="hidden" name="modelNo" value="${sp.id}">
                    <input type="hidden" name="price" value="${sp.price}">
                    <input type="hidden" name="description" value="${sp.model}">
                    <input type="hidden" name="action" value="add">
                    <input type="submit" value="Add To Cart">
                </form>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>