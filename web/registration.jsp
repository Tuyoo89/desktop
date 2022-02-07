<%--
  Created by IntelliJ IDEA.
  User: Azizbek
  Date: 2/8/2022
  Time: 12:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>

    <h1>Sorry, this account does not exist</h1>
    <h2>Please register into the system</h2>

    <form action="user" method="post">
        <label for="username">Username</label>
        <input type="text" id="username" name="username">
        <label for="phone_number">Phone number</label>
        <input type="text" id="phone_number" name="phone_number">
        <label for="about">About yourself</label>
        <input type="text" id="about" name="about">
        <input type="submit" name="register">
    </form>

</body>
</html>
