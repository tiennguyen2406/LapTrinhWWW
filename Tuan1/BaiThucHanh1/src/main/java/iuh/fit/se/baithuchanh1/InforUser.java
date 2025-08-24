package iuh.fit.se.baithuchanh1;

import iuh.fit.se.baithuchanh1.model.User;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Info", value = "/inforUser")
public class InforUser extends HttpServlet {
    private String name;
    private String email;
    @Override
    public void init()throws ServletException{
        ServletContext context = getServletContext();
        name = context.getInitParameter("UserName");
        email = context.getInitParameter("Email");
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Servlet Context Param</h2>");
        out.println("<p>UserName: " + name + "</p>");
        out.println("<p>Email: " + email + "</p>");
    }
}
