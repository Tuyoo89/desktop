<%--
  Created by IntelliJ IDEA.
  User: Azizbek
  Date: 2/7/2022
  Time: 11:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Log in</title>
</head>
<body>

    <h1>Welcome to Telegram</h1>
    <h2>Please, enter your phone number</h2>

    <form action="login" method="get">
        <label for="phone_number">Phone number</label>
        <input type="text" id="phone_number"  name="phone_number">
        <input type="submit" value="submit">
    </form>

</body>
</html>
