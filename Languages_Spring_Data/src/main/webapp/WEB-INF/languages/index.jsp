<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>All Languages</title>
</head>
<body>
<center>
    <h1>All Languages</h1>
    <table class="table table-hover table-dark">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Creator</th>
            <th scope="col">Version</th>
            <th scope="col">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${languages}" var="lang">
            <tr>
                <td>${lang.id}</td>
                <td><a href="/${lang.id}">${lang.name}</a></td>
                <td>${lang.creator}</td>
                <td>${lang.version}</td>
                <td>
                    <a class="btn btn-primary" href="/${lang.id}/edit">Edit</a> |
                    <form action="/${lang.id}" method="post">
                        <input type="hidden" name="_method" value="delete">
                        <input class="btn btn-danger" type="submit" value="Delete">
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <a href="/languages/new">Add New Language</a>
</center>
</body>
</html>
