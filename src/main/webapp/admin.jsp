<%--
  Created by IntelliJ IDEA.
  User: mikhail
  Date: 30/12/16
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<h1>Add excercise</h1>
<form action="/adminAdd" method="post">
name:<br>
<input type="text" name="name"><br>
description:<br>
<input type="text" name="description"><br>
complexity:<br>
<input type="text" name="complexity"><br>
type:<br>
<input type="text" name="type"><br>
<input type="submit" value="Submit">
</form>
<a href="/adminLogout">logout </a>

</body>
</html>
