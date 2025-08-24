package iuh.fit.se.baithuchanh1;

import com.fasterxml.jackson.databind.ObjectMapper;
import iuh.fit.se.baithuchanh1.model.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "Userservlet", value = "/helloUser")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws IOException{
        response.setContentType("text/html");
        User u1 = new User("Nguyen Van Khai Tien",21,"khaitien600@gmail.com");

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(u1);

        response.getWriter().write(json);
    }
}
