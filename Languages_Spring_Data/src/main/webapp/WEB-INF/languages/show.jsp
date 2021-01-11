<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Language Information</title>
</head>
<body>
<center>
    <h1><c:out value="${lang.name}"/></h1>
    <p>Creator: <c:out value="${lang.creator}"/></p>
    <p>Version: <c:out value="${lang.version}"/></p>
    <a href="/languages/${lang.id}/edit">Edit Language</a>
    <form action="/books/${lang.id}" method="post">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="Delete">
    </form>
</center>
</body>
</html>
