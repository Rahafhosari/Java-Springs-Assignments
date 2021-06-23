<%--
  Created by IntelliJ IDEA.
  User: Rahaf
  Date: 1/11/2021
  Time: 11:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Create Driver</title>
</head>
<body>
<center>
<h2> Add a New Person </h2>
<form:form action="/persons" method="post" modelAttribute="person">
    <div class="form-group">
        <form:label path="firstName">First Name</form:label>
        <form:errors path="firstName"/>
        <form:input path="firstName" type="text" class="form-control" id="firstName" placeholder="first name"/>
    </div>
    <div class="form-group">
        <form:label path="lastName">Last Name</form:label>
        <form:errors path="lastName"/>
        <form:input path="lastName" type="text" class="form-control" id="lastName" placeholder="last name"/>
    </div>
    <input type="submit" value="Create"/>
</form:form>
</center>
</body>
</html>
