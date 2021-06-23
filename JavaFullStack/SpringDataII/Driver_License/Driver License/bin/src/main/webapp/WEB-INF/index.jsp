<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Rahaf
  Date: 1/11/2021
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>All Drivers</title>
</head>
<body>
<center>
    <h1>All Drivers</h1>
    <table class="table table-hover">
        <thead>
        <tr>
            <th scope="col">First Name</th>
            <th scope="col">Last Name</th>
            <th scope="col">License #</th>
            <th scope="col">State </th>
            <th scope="col">Expiration Date</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${person}" var="person">
            <tr>
                <td><a href="/${person.id}">${person.firstName}</a></td>
                <td>${person.lastName}</td>
            <c:forEach items="${license}" var="license">
                <td>${license.number}</td>
                <td>${license.state}</td>
                <td>${license.expirationDate}</td>
            </c:forEach>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/licenses/new">Add New License</a>
    <a href="/persons/new">Add New Person</a>
</center>
</body>
</html>

