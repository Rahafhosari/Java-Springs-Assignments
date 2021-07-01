<%--
  Created by IntelliJ IDEA.
  User: Rahaf
  Date: 1/11/2021
  Time: 11:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="style.css">
    <title>New Ninja</title>
</head>
<body>
<center>
    <h1>New Ninja</h1>
<div class="container">
    <div>
    <form:form action="/ninjas/new" method="post" modelAttribute="ninja">
        <div class="form-group">
            <form:label path="dojo">Dojo</form:label>
            <form:errors path="dojo"/>
            <form:select class="form-control" path="dojo">
                <c:forEach items="${ dojo }" var="dojo">
                    <form:option value="${ dojo.id }">${ dojo.name }</form:option>
                </c:forEach>
            </form:select>
        </div>
        <div class="form-group">
            <form:label path="firstName">First Name</form:label>
            <form:errors path="firstName"/>
            <form:input class="form-control" path="firstName"/>
        </div>
        <div class="form-group">
            <form:label path="lastName">Last Name</form:label>
            <form:errors path="lastName"/>
            <form:input class="form-control" path="lastName"/>
        </div>
        <div class="form-group">
            <form:label path="age">Age</form:label>
            <form:errors path="age"/>
            <form:input type="number" path="age"/>
        </div>
        <input class="btn btn-primary" type="submit" value="Create"/>
    </form:form>
    </div>
    <p><h5><a href="/dojos/new">Show Dojos</a></h5></p>
</div>
</center>
</body>
</html>
