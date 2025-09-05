package iuh.fit.se.bai3;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "messageServlet", value = "/message")
public class MessageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException, IOException
    {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");out.println("<title>MessageServlet</title>");
            out.println("</head>");out.println("<body>");
        out.println("<h1>" + req.getAttribute("message")+
                "</h1>");
        out.println("</body>");out.println("</html>");
        out.close();
    }
    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException, IOException
    {
        this.doGet(req, resp);
    }
}
