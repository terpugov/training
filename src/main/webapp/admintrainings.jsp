<%@ page import="ru.inno.training.service.RegistrationService" %>
<%@ page import="ru.inno.training.pojo.Excercise" %>
<%@ page import="ru.inno.training.service.ExcerciseService" %><%--
  Created by IntelliJ IDEA.
  User: mikhail
  Date: 27/12/16
  Time: 22:42
  To change this template use File | Setburpy some description 2 full body low plank some description 2 full body squats some description 2 full bodytings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> YourTraining </title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
        }
    </style>
</head>

<body>


<table style="width:100%">

    <tr>
        <th>Excercise</th>
        <th>Description</th>
        <th>Complexity</th>
        <th>Type</th>
        <th>Edit</th>

    </tr>
    <% ExcerciseService excerciseService = new ExcerciseService(); %>
    <% for(Excercise excercise: excerciseService.getExcercise()) { %>
    <tr>
        <td> <%=excercise.getName()%> </td>
        <td> <%=excercise.getDescription()%> </td>
        <td> <%=excercise.getExcerciseComplexity()%> </td>
        <td> <%=excercise.getExcerciseType()%> </td>
        <td><a href="/delete">delete</a></td>
    </tr>
    <% } %>
</table>
<a href="/adminLogout">logout</a>
<a href="/admin.jsp">admin</a>>


</body>
</html>
