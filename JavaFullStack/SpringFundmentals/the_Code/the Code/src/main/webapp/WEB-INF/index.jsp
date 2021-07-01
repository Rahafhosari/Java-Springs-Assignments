<%--
  Created by IntelliJ IDEA.
  User: Rahaf
  Date: 1/5/2021
  Time: 4:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/thecodeStyle.css">
    <script type="text/javascript" src="js/app.js"></script>
    <title>The Code</title>
</head>
<body>
<c:out value="${error}"/>
<fieldset>
    <legend><h1> What is the code?</h1></legend>
    <form action="/checkCode" method="post">
        <input type="text" name="code">
        <input class="button" type="submit" value="Try Code">
    </form>
</fieldset>
</body>
</html>
