<%--
  Created by IntelliJ IDEA.
  User: mikhail
  Date: 28/12/16
  Time: 11:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="/login" method="post">
Email address:<br>
<input type="text" name="email"><br>
Password:<br>
<input type="text" name="password"><br>
<input type="submit" value="Submit">
${errorMessage}
</form>
</body>
</html>
