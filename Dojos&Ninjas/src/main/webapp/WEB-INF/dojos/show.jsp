<%--
  Created by IntelliJ IDEA.
  User: Rahaf
  Date: 1/11/2021
  Time: 11:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>Dojo Page</title>
</head>
<body>
    <h2>${dojo.name}</h2>
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">Age</th>
        </tr>
        </thead>
        <tbody>
<%--        <c:forEach items="${dojo}" var="dojo">--%>
            <tr>
                <td>${dojo.ninja.firstName}</td>
                <td>${dojo.ninja.lastName}</td>
                <td>${dojo.ninja.age}</td>
            </tr>
<%--        </c:forEach>--%>
        </tbody>
    </table>
</body>
</html>
