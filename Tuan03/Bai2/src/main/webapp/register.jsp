<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Register Account</title>
</head>
<body>
<h2>User Registration Form</h2>

<form action="register" method="post">
    <input type="text" name="firstName" placeholder="First Name" required />
    <input type="text" name="lastName" placeholder="Last Name" required /><br/><br/>

    <input type="email" name="email" placeholder="Your Email" required /><br/><br/>
    <input type="email" name="confirmEmail" placeholder="Re-enter Email" required /><br/><br/>

    <input type="password" name="password" placeholder="New Password" required /><br/><br/>

    Birthday:
    <select name="month">
        <option value="">Month</option>
        <option value="01">Jan</option>
        <option value="02">Feb</option>
        <option value="03">Mar</option>
        <!-- các tháng khác -->
    </select>
    <select name="day">
        <option value="">Day</option>
        <option value="01">1</option>
        <option value="02">2</option>
        <option value="03">3</option>
        <!-- các ngày khác -->
    </select>
    <select name="year">
        <option value="">Year</option>
        <option value="2000">2000</option>
        <option value="2001">2001</option>
        <!-- các năm khác -->
    </select><br/><br/>

    Gender:
    <input type="radio" name="gender" value="Female" /> Female
    <input type="radio" name="gender" value="Male" /> Male<br/><br/>

    <input type="submit" value="Sign Up" />
</form>

</body>
</html>
