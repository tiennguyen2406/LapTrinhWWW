<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="iuh.fit.se.bai1.model.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<!DOCTYPE html>
<html lang="vi">
<head>
  <meta charset="UTF-8">
  <title>Kết quả đăng ký</title>
  <style>
    body {
      font-family: Arial, sans-serif;
      background-color: #e0f7fa;
      padding: 20px;
    }

    .container {
      background-color: #ffffff;
      border-radius: 10px;
      padding: 30px;
      max-width: 800px;
      margin: auto;
      box-shadow: 0 0 10px rgba(0,0,0,0.1);
    }

    h2 {
      text-align: center;
      color: #00796b;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-top: 20px;
    }

    td {
      padding: 10px;
      border-bottom: 1px solid #ccc;
    }

    td.label {
      font-weight: bold;
      width: 30%;
      color: #004d40;
    }
  </style>
</head>
<body>
<div class="container">
  <h2>Thông tin đăng ký khóa học</h2>

  <%
    User user = (User) request.getAttribute("user");
    if (user != null) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
  %>
  <table>
    <tr>
      <td class="label">Họ và tên:</td>
      <td><%= user.getLastName() + " " + user.getFirstName() %></td>
    </tr>
    <tr>
      <td class="label">Ngày sinh:</td>
      <td><%= user.getDateOfBirth() != null ? user.getDateOfBirth().format(formatter) : "N/A" %></td>
    </tr>
    <tr>
      <td class="label">Email:</td>
      <td><%= user.getEmail() %></td>
    </tr>
    <tr>
      <td class="label">Số điện thoại:</td>
      <td><%= user.getMobileNumber() %></td>
    </tr>
    <tr>
      <td class="label">Giới tính:</td>
      <td><%= user.isGender() ? "Nam" : "Nữ" %></td>
    </tr>
    <tr>
      <td class="label">Địa chỉ:</td>
      <td><%= user.getAddress() %></td>
    </tr>
    <tr>
      <td class="label">Thành phố:</td>
      <td><%= user.getCity() %></td>
    </tr>
    <tr>
      <td class="label">Mã bưu chính:</td>
      <td><%= user.getPinCode() %></td>
    </tr>
    <tr>
      <td class="label">Tỉnh/Thành:</td>
      <td><%= user.getState() %></td>
    </tr>
    <tr>
      <td class="label">Quốc gia:</td>
      <td><%= user.getCountry() %></td>
    </tr>
    <tr>
      <td class="label">Sở thích:</td>
      <td>
        <%
          List<String> hobbies = user.getHobbies();
        %>
        <%= (hobbies != null && !hobbies.isEmpty()) ? String.join(", ", hobbies) : "Không có" %>
      </td>
    </tr>

    <tr>
      <td class="label">Trình độ học vấn:</td>
      <td>
        <table border="1" cellpadding="5" cellspacing="0" style="border-collapse: collapse; width: 100%;">
          <tr style="background-color: #e0f7fa;">
            <th>STT</th>
            <th>Examination</th>
            <th>Board</th>
            <th>Percentage</th>
            <th>Year of Passing</th>
          </tr>
          <%
            String[] qual = user.getQualification();
            String[] exams = {"Class X", "Class XII", "Graduation", "Masters"};

            for (int i = 0; i < qual.length; i++) {
              String[] parts = qual[i].split(",");
              String board = parts.length > 0 ? parts[0] : "";
              String percent = parts.length > 1 ? parts[1] : "";
              String year = parts.length > 2 ? parts[2] : "";
          %>
          <tr>
            <td><%= i + 1 %></td>
            <td><%= exams[i] %></td>
            <td><%= board %></td>
            <td><%= percent %></td>
            <td><%= year %></td>
          </tr>
          <% } %>
        </table>
      </td>
    </tr>

    <tr>
      <td class="label">Khóa học đăng ký:</td>
      <td><%= user.getCourseAppliesFor() %></td>
    </tr>
  </table>
  <% } else { %>
  <p style="color: red;">Không có dữ liệu người dùng.</p>
  <% } %>
</div>
</body>
</html>