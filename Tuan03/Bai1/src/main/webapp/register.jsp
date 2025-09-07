<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="vi">
<head>
    <meta charset="UTF-8">
    <title>Form Đăng Ký Khóa Học</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #b3e0f2;
            margin: 0;
            padding: 0;
        }

        form {
            background-color: #ffffff;
            padding: 30px;
            margin: 50px auto;
            border-radius: 10px;
            width: 80%;
            max-width: 800px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        td {
            padding: 10px;
            vertical-align: top;
        }

        input[type="text"],
        input[type="email"],
        input[type="date"],
        select,
        textarea {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
        }

        textarea {
            resize: vertical;
        }

        input[type="radio"],
        input[type="checkbox"] {
            margin-right: 5px;
        }

        input[type="submit"],
        input[type="reset"] {
            padding: 10px 20px;
            margin: 10px;
            border: none;
            border-radius: 5px;
            background-color: #0288d1;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }

        input[type="submit"]:hover,
        input[type="reset"]:hover {
            background-color: #026aa7;
        }

        h2 {
            text-align: center;
            color: #004d80;
        }

        .qualification-table {
            border: 1px solid #ccc;
            margin-top: 10px;
        }

        .qualification-table th,
        .qualification-table td {
            border: 1px solid #ccc;
            padding: 8px;
            text-align: center;
        }

        .qualification-table th {
            background-color: #e0f7fa;
        }
    </style>
</head>
<body>

<form action="registration-form" name="formDangKy" method="GET">
    <h2>Form Đăng Ký Khóa Học</h2>

    <table>
        <tr>
            <td>First name:</td>
            <td><input type="text" name="firstName" maxlength="30" /></td>
        </tr>
        <tr>
            <td>Last name:</td>
            <td><input type="text" name="lastName" maxlength="30" /></td>
        </tr>
        <tr>
            <td>Date of birth:</td>
            <td><input type="date" name="dob" /></td>
        </tr>
        <tr>
            <td>Email:</td>
            <td><input type="email" name="email" /></td>
        </tr>
        <tr>
            <td>Mobile number:</td>
            <td><input type="text" name="mobile" maxlength="10" /></td>
        </tr>
        <tr>
            <td>Gender:</td>
            <td>
                <input type="radio" name="gender" value="Male" /> Male
                <input type="radio" name="gender" value="Female" /> Female
            </td>
        </tr>
        <tr>
            <td>Address:</td>
            <td><textarea name="address" rows="4" cols="30"></textarea></td>
        </tr>
        <tr>
            <td>City:</td>
            <td><input type="text" name="city" maxlength="30" /></td>
        </tr>
        <tr>
            <td>Pin code:</td>
            <td><input type="text" name="pincode" maxlength="6" /></td>
        </tr>
        <tr>
            <td>State:</td>
            <td><input type="text" name="state" maxlength="30" /></td>
        </tr>
        <tr>
            <td>Country:</td>
            <td><input type="text" name="country" value="India" readonly /></td>
        </tr>
        <tr>
            <td>Hobbies:</td>
            <td>
                <input type="checkbox" name="hobby" value="Drawing" /> Drawing
                <input type="checkbox" name="hobby" value="Singing" /> Singing
                <input type="checkbox" name="hobby" value="Dancing" /> Dancing
                <input type="checkbox" name="hobby" value="Sketching" /> Sketching
                <input type="checkbox" name="hobby" value="Other" /> Others:
                <input type="text" name="otherHobby" />
            </td>
        </tr>
        <tr>
            <td>Qualification:</td>
            <td>
                <table class="qualification-table">
                    <tr>
                        <th>Sl.No.</th>
                        <th>Examination</th>
                        <th>Board</th>
                        <th>Percentage</th>
                        <th>Year of Passing</th>
                    </tr>
                    <tr>
                        <td>1</td>
                        <td>Class X</td>
                        <td><input type="text" name="boardX" maxlength="10" /></td>
                        <td><input type="text" name="percentX" maxlength="5" /></td>
                        <td><input type="text" name="yearX" maxlength="4" /></td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>Class XII</td>
                        <td><input type="text" name="boardXII" maxlength="10" /></td>
                        <td><input type="text" name="percentXII" maxlength="5" /></td>
                        <td><input type="text" name="yearXII" maxlength="4" /></td>
                    </tr>
                    <tr>
                        <td>3</td>
                        <td>Graduation</td>
                        <td><input type="text" name="boardGrad" maxlength="10" /></td>
                        <td><input type="text" name="percentGrad" maxlength="5" /></td>
                        <td><input type="text" name="yearGrad" maxlength="4" /></td>
                    </tr>
                    <tr>
                        <td>4</td>
                        <td>Masters</td>
                        <td><input type="text" name="boardMaster" maxlength="10" /></td>
                        <td><input type="text" name="percentMaster" maxlength="5" /></td>
                        <td><input type="text" name="yearMaster" maxlength="4" /></td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td>Course applies for:</td>
            <td>
                <input type="radio" name="course" value="BCA" /> BCA
                <input type="radio" name="course" value="B.Com" /> B.Com
                <input type="radio" name="course" value="B.Sc" /> B.Sc
                <input type="radio" name="course" value="B.A" /> B.A
            </td>
        </tr>
        <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Submit" />
                <input type="reset" value="Reset" />
            </td>
        </tr>
    </table>
</form>

</body>
</html>
