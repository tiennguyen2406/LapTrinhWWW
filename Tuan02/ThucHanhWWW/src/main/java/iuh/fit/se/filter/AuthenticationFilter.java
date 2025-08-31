package iuh.fit.se.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpFilter;

import java.io.IOException;
import java.io.PrintWriter;

public class AuthenticationFilter extends HttpFilter implements Filter{
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        String usernameConfig = this.getFilterConfig().getInitParameter("username");
        String passwordConfig = this.getFilterConfig().getInitParameter("password");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if(username.equals(usernameConfig) && password.equals(passwordConfig)){
            chain.doFilter(req,res);
        }else{
            PrintWriter writer = res.getWriter();

            writer.println("Login khong thanh cong! Vui long thu lai");
            writer.close();
        }
    }
}
