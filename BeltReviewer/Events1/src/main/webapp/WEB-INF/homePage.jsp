<%--
  Created by IntelliJ IDEA.
  User: Rahaf
  Date: 1/14/2021
  Time: 12:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
    <h1>Welcome, <c:out value="${loggedUser.email}" /></h1>
    	<h3>Hello Section 3</h3>
    <a href="/logout">Logout</a>
</body>
</html>
