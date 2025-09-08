<%--
  Created by IntelliJ IDEA.
  User: Hoang Son
  Date: 08/09/2025
  Time: 1:15 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<jsp:useBean id="cart" scope="session" class="iuh.fit.se.model.beans.CartBean" />
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Shopping Cart</title>
  <style>
    body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #f0f2f5; margin: 0; padding: 0; }
    .cart-container {
      width: 90%;
      max-width: 900px;
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
    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
    }
    th, td {
      border: 1px solid #e0e0e0;
      padding: 12px;
      text-align: left;
    }
    th {
      background-color: #525D76;
      color: white;
      font-weight: bold;
    }
    tr:nth-child(even) {
      background-color: #f9f9f9;
    }
    input[type="text"] {
      width: 40px;
      text-align: center;
      padding: 5px;
      border: 1px solid #ccc;
      border-radius: 4px;
    }
    .action-btn {
      background-color: #f4f4f4;
      border: 1px solid #ccc;
      padding: 5px 10px;
      border-radius: 4px;
      cursor: pointer;
    }
    .action-btn[value="Update"] {
      background-color: #8db5e6;
      color: #fff;
      border: none;
    }
    .action-btn[value="Delete"] {
      background-color: #e68d8d;
      color: #fff;
      border: none;
    }
    .action-btn:hover {
      opacity: 0.9;
    }
    .total-row {
      text-align: right;
      font-size: 1.2em;
      font-weight: bold;
    }
    .total-row td {
      border-top: 2px solid #525D76;
    }
    .product-list-link {
      text-align: left;
      margin-bottom: 20px;
    }
    .product-list-link a {
      text-decoration: none;
      color: #525D76;
      font-weight: bold;
    }
  </style>
</head>
<body>
<div class="cart-container">
  <h1>Shopping Cart</h1>
  <p class="product-list-link"><a href="DSSP">&laquo; Product List</a></p>
  <table>
    <thead>
    <tr>
      <th>Model Description</th>
      <th>Quantity</th>
      <th>Unit Price</th>
      <th>Total</th>
    </tr>
    </thead>
    <tbody>
    <c:if test="${cart.lineItemCount == 0}">
      <tr>
        <td colspan="4" style="text-align: center;">Cart is currently empty.</td>
      </tr>
    </c:if>
    <c:forEach var="cartItem" items="${cart.cartItems}" varStatus="counter">
      <form name="item" method="POST" action="CartController">
        <tr>
          <td>
            <b>${cartItem.strPartNumber}</b><br/>
              ${cartItem.strModelDescription}
          </td>
          <td>
            <input type='text' name="quantity" value="${cartItem.iQuantity}" size='2'>
            <input type='hidden' name='itemIndex' value='${counter.count}'>
            <input type="submit" name="action" value="Update" class="action-btn">
            <input type="submit" name="action" value="Delete" class="action-btn">
          </td>
          <td>${cartItem.dblUnitCost}</td>
          <td>${cartItem.dblTotalCost}</td>
        </tr>
      </form>
    </c:forEach>
    <c:if test="${cart.lineItemCount > 0}">
      <tr class="total-row">
        <td colspan="3" style="text-align: right;">Subtotal:</td>
        <td><b>${cart.orderTotal}</b></td>
      </tr>
    </c:if>
    </tbody>
  </table>
</div>
</body>
</html>