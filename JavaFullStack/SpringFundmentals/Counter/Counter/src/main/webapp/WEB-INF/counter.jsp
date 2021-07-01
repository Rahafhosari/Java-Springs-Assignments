<%--
  Created by IntelliJ IDEA.
  User: Rahaf
  Date: 1/6/2021
  Time: 10:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Counter</title>
</head>
<body>
    <h2>You've visited <a href="http:/localhost:8080"></a> <c:out value="${sessionScope.count}"/> times.</h2>
    <h2> <a href="/"> Test Another visit? </a> </h2>
    <h2><%=session.getAttribute("count")%></h2>
</body>
</html>
