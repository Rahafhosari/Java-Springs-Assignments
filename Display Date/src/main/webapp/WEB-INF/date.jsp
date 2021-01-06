
<%--
  Created by IntelliJ IDEA.
  User: Rahaf
  Date: 1/6/2021
  Time: 11:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript" src="js/app.js"></script>
    <title>Date</title>
</head>
<body>
<div class="date">
    <fieldset>
        <legend><h3>The Date is</h3></legend>
        <p> <b>${displayDate}</b> </p>
        <!-- or  <c:out value="${displayDate}"/> -->
    </fieldset>
</div>
</body>
</html>
