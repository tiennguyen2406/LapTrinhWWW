package iuh.fit.se.model.beans.servlets;

import iuh.fit.se.model.beans.CartBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/CartController")
public class CartController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strAction = request.getParameter("action");

        if (strAction != null && !strAction.isEmpty()) {
            if (strAction.equals("add")) {
                addToCart(request);
            } else if (strAction.equals("Update")) {
                updateCart(request);
            } else if (strAction.equals("Delete")) {
                deleteCart(request);
            }
        }

        response.sendRedirect("ShoppingCart.jsp");
    }

    private void addToCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String strModelNo = request.getParameter("modelNo");
        String strDescription = request.getParameter("description");
        String strPrice = request.getParameter("price");
        String strQuantity = request.getParameter("quantity");

        CartBean cartBean = (CartBean) session.getAttribute("cart");
        if (cartBean == null) {
            cartBean = new CartBean();
            session.setAttribute("cart", cartBean);
        }

        cartBean.addCartItem(strModelNo, strDescription, strPrice, strQuantity);
    }

    private void updateCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String strQuantity = request.getParameter("quantity");
        String strItemIndex = request.getParameter("itemIndex");

        CartBean cartBean = (CartBean) session.getAttribute("cart");
        if (cartBean != null) {
            cartBean.updateCartItem(strItemIndex, strQuantity);
        }
    }

    private void deleteCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String strItemIndex = request.getParameter("itemIndex");

        CartBean cartBean = (CartBean) session.getAttribute("cart");
        if (cartBean != null) {
            cartBean.deleteCartItem(strItemIndex);
        }
    }
}