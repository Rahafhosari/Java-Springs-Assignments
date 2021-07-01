<%--
  Created by IntelliJ IDEA.
  User: Rahaf
  Date: 1/16/2021
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="UTF-8">
    <title>Registration</title>
</head>
<body>
<center>
    <main>
        <fieldset>
            <legend><h1>Register!</h1></legend>
               <!-- <p><form:errors path="user.*"/></p>-->
                <form:form method="POST" action="/" modelAttribute="registration">
                <div class="form-group row">
                    <form:label path="firstName" class="col-form-label">First Name</form:label>
                    <form:input type="text" path="firstName"  class="form-control" placeholder="first name"/>
                </div>
                    <form:errors path = "firstName"/><br>
                <div class="form-group row">
                    <form:label path="lastName" class="col-form-label">Last Name</form:label>
                    <form:input type="text" path="lastName"  class="form-control" placeholder="sur name"/>
                </div>
                    <form:errors path = "lastName"/><br>
                <div class="form-group">
                    <form:label path="city">City</form:label>
                    <form:input class="form-control" path="city" />
                </div>
                    <form:errors path="city"/><br>
                <div class="form-group">
                    <form:label path="state">State</form:label>
                    <form:select path="state">
                        <c:forEach items="${ states }" var="state">
                            <option value="${ state }">${ state }</option>
                        </c:forEach>
                    </form:select>
                </div>
                    <form:errors path="state"/><br>
                <div class="form-group row">
                    <form:label path="email" class="col-form-label">Email</form:label>
                    <form:input type="email" path="email"  class="form-control" placeholder="email"/>
                 </div>
                    <form:errors path = "email"/><br>
                    <p> ** Password must have numbers and letters </p>
                <div class="form-group row">
                    <form:label path="password" class="col-form-label">Password:</form:label>
                    <form:password path="password" class="form-control" placeholder="password"/>
                </div>
                    <form:errors path = "password"/><br>
                <div class="form-group row">
                    <form:label path="passwordConfirmation" class="col-form-label">Password Confirmation:</form:label>
                    <form:password path="passwordConfirmation" class="form-control" placeholder="password confirmation"/>
                </div>
                    <form:errors path = "passwordConfirmation"/><br>
                <input type="submit" value="Register!" class="btn btn-primary"/>
                </form:form>
        </fieldset>
        <fieldset>
            <legend><h1>Login</h1></legend>
            <form method="post" action="/login">
                <div class="form-group row">
                    <label for="email" class="col-form-label">Email</label>
                    <input type="text" id="email" name="email" class="form-control" placeholder="email"/>
                </div>
                <div class="form-group row">
                    <label for="password" class="col-form-label">Password</label>
                    <input type="password" id="password" name="password" class="form-control" placeholder="password"/>
                </div>
                <input type="submit" value="Login!" class="btn btn-primary"/>
            </form>
            <p><c:out value="${error}" /></p>
        </fieldset>
    </main>
</center>
</body>
</html>
