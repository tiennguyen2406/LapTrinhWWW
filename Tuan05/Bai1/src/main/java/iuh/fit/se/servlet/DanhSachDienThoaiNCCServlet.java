package iuh.fit.se.servlet;

import iuh.fit.se.dao.DienThoaiDAO;
import iuh.fit.dao.NhaCungCapDAO;
import iuh.fit.se.entity.NhaCungCap;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/danhsach")
public class DanhSachDienThoaiNCCServlet extends HttpServlet {
    private NhaCungCapDAO nccDao = new NhaCungCapDAO();
    private DienThoaiDAO dtDao = new DienThoaiDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String maNCC = req.getParameter("mancc");
        if (maNCC != null && !maNCC.isEmpty()) {
            req.setAttribute("dsDT", dtDao.getByNhaCungCap(maNCC));
        } else {
            req.setAttribute("dsDT", dtDao.getAll());
        }
        req.setAttribute("dsNCC", nccDao.getAll());
        req.getRequestDispatcher("DanhSachDienThoaiNCC.jsp").forward(req, resp);
    }
}
