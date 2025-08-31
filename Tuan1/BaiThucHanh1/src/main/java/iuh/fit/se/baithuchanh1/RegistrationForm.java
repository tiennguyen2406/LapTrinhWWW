@WebServlet("/RegistrationForm")
public class RegistrationForm extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String username = request.getParameter("username");
        String email = request.getParameter("email");

        String facebook = request.getParameter("facebook");
        String shortBio = request.getParameter("shortBio");

        out.println("<html>");
        out.println("<head><title>Result Page</title></head>");
        out.println("<body>");
        out.println("<h2>Thông tin bạn đã nhập:</h2>");
        out.println("<p>Họ và tên: " + firstName + " " + lastName + "</p>");
        out.println("<p>Username: " + username + "</p>");
        out.println("<p>Email: " + email + "</p>");
        out.println("<p>Facebook: " + facebook + "</p>");
        out.println("<p>Short Bio: " + shortBio + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
