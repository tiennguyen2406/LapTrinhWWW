package iuh.fit.se.servlet;

import iuh.fit.se.dao.DienThoaiDAO;
import iuh.fit.dao.NhaCungCapDAO;
import iuh.fit.se.entity.DienThoai;
import iuh.fit.se.entity.NhaCungCap;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/them")
@MultipartConfig(fileSizeThreshold = 1024 * 1024, // 1MB
        maxFileSize = 10 * 1024 * 1024, // 10MB
        maxRequestSize = 50 * 1024 * 1024)
public class DienThoaiFormServlet extends HttpServlet {
    private DienThoaiDAO dtDao = new DienThoaiDAO();
    private NhaCungCapDAO nccDao = new NhaCungCapDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("dsNCC", nccDao.getAll());
        req.getRequestDispatcher("DienThoaiForm.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String maDT = req.getParameter("maDT");
        String tenDT = req.getParameter("tenDT");
        String namSXStr = req.getParameter("namSX");
        String cauHinh = req.getParameter("cauHinh");
        String maNCC = req.getParameter("maNCC");
        Part hinhAnhPart = req.getPart("hinhAnh");

        int namSX = Integer.parseInt(namSXStr);
        String fileName = hinhAnhPart.getSubmittedFileName();

        // Kiểm tra định dạng hình
        if (!fileName.endsWith(".jpg") && !fileName.endsWith(".jpeg") && !fileName.endsWith(".png")) {
            req.setAttribute("error", "Chi chap nhan hinh .jpg, .jpeg, .png");
            req.getRequestDispatcher("DienThoaiForm.jsp").forward(req, resp);
            return;
        }

        // Lưu ảnh vào thư mục
        String uploadPath = getServletContext().getRealPath("/assets/images");
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) uploadDir.mkdirs();
        hinhAnhPart.write(uploadPath + File.separator + fileName);

        // Lưu vào DB
        NhaCungCap ncc = nccDao.findById(maNCC);
        DienThoai dt = new DienThoai(maDT, tenDT, namSX, cauHinh, fileName, ncc);
        dtDao.insert(dt);

        resp.sendRedirect("danhsach");
    }
}
