<%--
  Created by IntelliJ IDEA.
  User: Rahaf
  Date: 1/10/2021
  Time: 12:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Book Info</title>
</head>
<body>
<h1><c:out value="${bookInfo.title}"/></h1>
<p>Description: <c:out value="${bookInfo.description}"/></p>
<p>Language: <c:out value="${bookInfo.language}"/></p>
<p>Number of pages: <c:out value="${bookInfo.numberOfPages}"/></p>
<a href="/books/${bookInfo.id}/edit">Edit Book</a>
<form action="/books/${bookInfo.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>
</body>
</html>
