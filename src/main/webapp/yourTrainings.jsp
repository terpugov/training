<%@ page import="ru.inno.training.service.RegistrationService" %>
<%@ page import="ru.inno.training.pojo.Excercise" %>
<%@ page import="ru.inno.training.service.ExcerciseService" %>
<%@ page import="ru.inno.training.service.exceptions.ExcerciseServiceException" %>
<%@ page errorPage="sqlexception.jsp" %>
<%--

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

    </tr>


        <% ExcerciseService excerciseService = new ExcerciseService(); %>

        <% try{for(Excercise excercise: excerciseService.getExcercise()) { %>
    <tr>
        <td> <%=excercise.getName()%> </td>
        <td> <%=excercise.getDescription()%> </td>
        <td> <%=excercise.getExcerciseComplexity()%> </td>
        <td> <%=excercise.getExcerciseType()%> </td>
    </tr>
    <% } } catch (ExcerciseServiceException e){throw e;}%>
</table>
<a href="/logout">logout</a>


</body>
</html>
