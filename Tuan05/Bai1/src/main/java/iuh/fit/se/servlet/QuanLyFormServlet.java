package iuh.fit.se.servlet;

import iuh.fit.se.dao.DienThoaiDAO;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/xoa")
public class QuanLyFormServlet extends HttpServlet {
    private DienThoaiDAO dtDao = new DienThoaiDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maDT = req.getParameter("maDT");
        if (maDT != null) dtDao.delete(maDT);
        resp.sendRedirect("danhsach");
    }
}
