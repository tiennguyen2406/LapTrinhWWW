package iuh.fit.se.bai1;

import iuh.fit.se.bai1.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@WebServlet("/registration-form")
public class RegistrationServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Lấy dữ liệu từ form
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        String dobStr = request.getParameter("dob");
        LocalDate dob = null;
        if (dobStr != null && !dobStr.isEmpty()) {
            dob = LocalDate.parse(dobStr);
        }

        String email = request.getParameter("email");
        String mobileNumber = request.getParameter("mobile");

        String genderStr = request.getParameter("gender");
        boolean gender = "Male".equalsIgnoreCase(genderStr);

        String address = request.getParameter("address");
        String city = request.getParameter("city");

        int pinCode = 0;
        try {
            pinCode = Integer.parseInt(request.getParameter("pincode"));
        } catch (NumberFormatException e) {
            // Handle or log the error if needed
        }

        String state = request.getParameter("state");
        String country = request.getParameter("country");

        String[] hobbiesArray = request.getParameterValues("hobby");
        List<String> hobbies = null;
        if (hobbiesArray != null) {
            hobbies = Arrays.asList(hobbiesArray);
        }

        String[] qualification = new String[4];
        qualification[0] = request.getParameter("boardX") + "," + request.getParameter("percentX") + "," + request.getParameter("yearX");
        qualification[1] = request.getParameter("boardXII") + "," + request.getParameter("percentXII") + "," + request.getParameter("yearXII");
        qualification[2] = request.getParameter("boardGrad") + "," + request.getParameter("percentGrad") + "," + request.getParameter("yearGrad");
        qualification[3] = request.getParameter("boardMaster") + "," + request.getParameter("percentMaster") + "," + request.getParameter("yearMaster");

        String courseAppliesFor = request.getParameter("course");

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setDateOfBirth(dob);
        user.setEmail(email);
        user.setMobileNumber(mobileNumber);
        user.setGender(gender);
        user.setAddress(address);
        user.setCity(city);
        user.setPinCode(pinCode);
        user.setState(state);
        user.setCountry(country);
        user.setHobbies(hobbies);
        user.setQualification(qualification);
        user.setCourseAppliesFor(courseAppliesFor);

        request.setAttribute("user", user);

        RequestDispatcher rd = request.getRequestDispatcher("result-form.jsp");
        rd.forward(request, response);
    }
}
