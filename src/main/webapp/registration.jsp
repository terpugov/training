<%--
  Created by IntelliJ IDEA.
  User: mikhail
  Date: 27/12/16
  Time: 12:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/yourTrainings.jsp" method="post">
    First name:<br>
    <input type="text" name="name"><br>
    Last name:<br>
    <input type="text" name="surname"><br>
    Email address:<br>
    <input type="text" name="email"><br>
    Password:<br>
    <input type="text" name="password"><br>
    <input type="submit" value="Submit">
    ${errorMessage}
</form>
</body>
</html>


