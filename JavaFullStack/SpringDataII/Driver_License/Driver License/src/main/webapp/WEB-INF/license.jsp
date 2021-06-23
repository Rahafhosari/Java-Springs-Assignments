
<%--
  Created by IntelliJ IDEA.
  User: Rahaf
  Date: 1/11/2021
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Create License</title>
</head>
<body>
<center>
<form:form action="/licenses" method="post" modelAttribute="license">
    <div class="form-group">
        <form:label path="person">Person</form:label>
        <form:errors path="person"/>
        <form:select class="form-control" path="person">
            <c:forEach items="${ persons }" var="person">
                <form:option value="${ person.id }">${ person.firstName } ${ person.lastName }</form:option>
            </c:forEach>
        </form:select>
    </div>
    <div class="form-group">
        <form:label path="state">State</form:label>
        <form:errors path="state"/>
        <form:input class="form-control" path="state"/>
    </div>
    <div class="form-group">
        <form:label path="expirationDate">Expiration Date</form:label>
        <form:errors path="expirationDate"/>
        <form:input type="date" class="form-control" path="expirationDate"/>
    </div>
    <input type="submit" value="Create"/>
</form:form>
</center>
</body>
</html>
