<%--
  Created by IntelliJ IDEA.
  User: Rahaf
  Date: 1/16/2021
  Time: 5:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="style.css">
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
<center>
<fieldset>
    <legend><h1>Login</h1></legend>
        <p><c:out value="${error}" /></p>
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
</fieldset>
</center>
</body>
</html>
