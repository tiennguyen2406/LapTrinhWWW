package iuh.fit.se.servlet;

import iuh.fit.se.dao.ProductDao;
import iuh.fit.se.dao.ProductDaoImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    private ProductDao productDao = new ProductDaoImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
        if (cart == null) cart = new HashMap<>();

        String id = req.getParameter("id");
        int qty = Integer.parseInt(req.getParameter("quantity"));

        cart.put(id, cart.getOrDefault(id, 0) + qty);
        session.setAttribute("cart", cart);

        resp.sendRedirect("cart.jsp");
    }
}
