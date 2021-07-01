<%--
  Created by IntelliJ IDEA.
  User: Rahaf
  Date: 1/10/2021
  Time: 12:43 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Book Info</title>
</head>
<body>
<h1><c:out value="${bookinfo.title}"/></h1>
<p>Description: <c:out value="${bookinfo.description}"/></p>
<p>Language: <c:out value="${bookinfo.language}"/></p>
<p>Number of pages: <c:out value="${bookinfo.numberOfPages}"/></p>
<a href="/books/${bookinfo.id}/edit">Edit Book</a>
<form action="/books/${bookinfo.id}" method="post">
    <input type="hidden" name="_method" value="delete">
    <input type="submit" value="Delete">
</form>
</body>
</html>
